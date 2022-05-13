package com.dbcourse.classchoose.service.impl;

import com.dbcourse.classchoose.entity.DTO.GradeDTO;
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

import java.util.ArrayList;
import java.util.List;

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
}
