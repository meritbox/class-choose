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

    @Override
    public int addPlan(PlanBody planBody) {
        Plan plan = new Plan();
        Clazz clazz = clazzMapper.selectById(planBody.getCno());
        plan.set(planBody);
        plan.setCname(clazz.getCname());
        plan.setDno(clazz.getDno().toString());
        //发现clazz里的dno是int，plan和department里是String
        plan.setCredit(clazz.getCredit());
        plan.setCurNum(0);
        return planMapper.insertPlan(plan);
    }

    @Override
    public int updateCapacity(String pno, Integer capacity) {
        Plan plan = new Plan();
        plan = planMapper.selectById(pno);
        plan.setCapacity(capacity);
        return planMapper.updateById(plan);
    }
}
