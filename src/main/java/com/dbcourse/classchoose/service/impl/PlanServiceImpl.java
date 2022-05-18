package com.dbcourse.classchoose.service.impl;

import com.dbcourse.classchoose.entity.Clazz;
import com.dbcourse.classchoose.entity.DTO.PlanBody;
import com.dbcourse.classchoose.entity.Plan;
import com.dbcourse.classchoose.mapper.ClazzMapper;
import com.dbcourse.classchoose.mapper.PlanMapper;
import com.dbcourse.classchoose.service.PlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shawn
 * @since 2022-05-08
 */
@Service
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan> implements PlanService {

    @Autowired
    PlanMapper planMapper;

    @Autowired
    ClazzMapper clazzMapper;


    @Override
    public List<Plan> getAll() {
        return null;
    }

    @Transactional
    @Override
    public int addPlan(PlanBody planBody) {
        Plan plan = new Plan();
        Clazz clazz = clazzMapper.selectById(planBody.getCno());
        plan.set(planBody);

        //判断时间是否有交集(弱智算法）
        List<Plan> plans = planMapper.selectAllByTerm(planBody.getTerm());
        String time = plan.getTime();
        String time2[] = time.split(" ");//time[0]为星期几，time[1]为课程时间
        int newclassbegin = Integer.parseInt(time2[1].split("-")[0]);
        int newclassend = Integer.parseInt(time2[1].split("-")[1]);
        for(int i=0;i<plans.size();i++){
            String timetemp[] =  plans.get(i).getTime().split(" ");
            if(time2[0].equals(timetemp[0])){
                int classbegin = Integer.parseInt(timetemp[1].split("-")[0]);
                int classend = Integer.parseInt(timetemp[1].split("-")[1]);
                if ((newclassbegin <= classend && newclassbegin >= classbegin)
                        ||( newclassend >= classbegin && newclassbegin <= classbegin)) {
                    //到此说明时间上有交集
                    //老师冲突
                    if (planBody.getTno().equals(plans.get(i).getTno())) { return -1; }
                    //地点冲突
                    if(planBody.getLocation().equals(plans.get(i).getLocation())){ return -2;}
                }
            }
        }

        plan.setCname(clazz.getCname());
        plan.setDno(clazz.getDno().toString());
        //发现clazz里的dno是int，plan和department里是String
        plan.setCredit(clazz.getCredit());
        plan.setCurNum(0);
        return planMapper.insertPlan(plan);
    }

    @Transactional
    @Override
    public int updateCapacity(String pno, Integer capacity) {
        Plan plan = new Plan();
        plan = planMapper.selectById(pno);
        plan.setCapacity(capacity);
        return planMapper.updateById(plan);
    }
}
