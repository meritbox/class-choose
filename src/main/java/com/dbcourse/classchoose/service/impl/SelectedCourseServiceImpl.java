package com.dbcourse.classchoose.service.impl;

import com.dbcourse.classchoose.entity.DTO.GradeDTO;
import com.dbcourse.classchoose.entity.DTO.TimeTableRecord;
import com.dbcourse.classchoose.entity.Grade;
import com.dbcourse.classchoose.entity.Plan;
import com.dbcourse.classchoose.entity.SelectedCourse;
import com.dbcourse.classchoose.mapper.GradeMapper;
import com.dbcourse.classchoose.mapper.PlanMapper;
import com.dbcourse.classchoose.mapper.SelectedCourseMapper;
import com.dbcourse.classchoose.service.SelectedCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shawn
 * @since 2022-05-11
 */
@Service
public class SelectedCourseServiceImpl extends ServiceImpl<SelectedCourseMapper, SelectedCourse> implements SelectedCourseService {
    @Autowired
    SelectedCourseMapper selectedCourseMapper;

    @Autowired
    PlanMapper planMapper;

    @Autowired
    GradeMapper gradeMapper;

    private static final Map<String,Integer> weekdayChineseToInt = new HashMap<String,Integer>(){
        {
            put("周一",0);
            put("周二",1);
            put("周三",2);
            put("周四",3);
            put("周五",4);
        }
    };


    @Override
    public int deleteById(Integer id) {
        SelectedCourse selectedCourse = selectedCourseMapper.selectById(id);
        int i = selectedCourseMapper.deleteById(id);
        if(i<=0) return 0;
        Plan plan = planMapper.selectByCnoTnoTerm(selectedCourse.getCno(),selectedCourse.getTno(),selectedCourse.getTerm());
        plan.setCurNum(plan.getCurNum()-1);
        return planMapper.updateById(plan);
    }

    @Override
    public int chooseClass(String sno, String pno) {
        //获取该学期的课
        List<GradeDTO> gradeDTOS = selectedCourseMapper.selectBySno(sno);

        Plan plan = planMapper.selectById(pno);

        //判断时间是否冲突
        String time = plan.getTime();
        String time2[] = time.split(" ");
        int newclassbegin = Integer.parseInt(time2[1].split("-")[0]);
        int newclassend = Integer.parseInt(time2[1].split("-")[1]);
        for (int i = 0;i < gradeDTOS.size();i++){

            String timetemp[] = planMapper.selectByCnoTnoTerm(gradeDTOS.get(i).getCno(),
                                                              gradeDTOS.get(i).getTno(),
                                                              gradeDTOS.get(i).getTerm())
                                                              .getTime()
                                                              .split(" ");

            if(timetemp[0].equals(time2[0])) {//周几冲突
                int classbegin = Integer.parseInt(timetemp[1].split("-")[0]);
                int classend = Integer.parseInt(timetemp[1].split("-")[1]);
                if ((newclassbegin <= classend && newclassbegin >= classbegin)
                        ||( newclassend >= classbegin && newclassbegin <= classbegin)){
                    return -1;//时间冲突
                }
            }
        }

        //判断以前是否选过该课
        List<Grade> grades = gradeMapper.selectAllBySno(sno);
        for(int i = 0;i<grades.size();i++){
            if(grades.get(i).getCno().equals(planMapper.selectById(pno).getCno())){
                return -2;//已修过该课
            }
        }

        //选课已满判断
        if(plan.getCurNum() >= plan.getCapacity()){ return -3; }

        selectedCourseMapper.insertCourse(sno,plan.getCno(),plan.getTerm(),plan.getTno());
        plan.setCurNum(plan.getCurNum()+1);
        planMapper.updateById(plan);
        return 1;
    }

    @Override
    public String[][] handleTimetableRecordTime(String sno) {
        List<TimeTableRecord> records = selectedCourseMapper.getRecordBySno(sno);
        String[][] timeTable = new String[5][12];
        for(int i = 0 ; i < 5; i++) {
            for(int j = 0 ; j < 12; j++){
                timeTable[i][j] = "";
            }
        }

        for(TimeTableRecord t: records){
            String time = t.getTime();
            String clazzPair = t.getCno() + "-" + t.getCname();
            String[] s = time.split(" ");
            Integer weekDay = weekdayChineseToInt.get(s[0]);
            String[] dayTime = s[1].split("-");
            Integer start = Integer.parseInt(dayTime[0]);
            Integer end = Integer.parseInt(dayTime[1]);

            for(int i = start - 1; i < end; i++){
                timeTable[weekDay][i] = clazzPair;
            }
        }

        return timeTable;
    }

    @Override
    public int updateGrade(String sno, String cno, String tno, int rate, int usualGrade, int finalGrade) {
        SelectedCourse selectedCourse = selectedCourseMapper.getBySnoTnoCno(sno,tno, cno);
        selectedCourse.setUsualGrade(usualGrade);
        selectedCourse.setFinalGrade(finalGrade);
        selectedCourse.setTotalGrade((int) (usualGrade*(1D-0.01*rate)+0.01*rate*finalGrade));
        selectedCourseMapper.updateById(selectedCourse);
        return gradeMapper.insert(new Grade(selectedCourse));
    }
}
