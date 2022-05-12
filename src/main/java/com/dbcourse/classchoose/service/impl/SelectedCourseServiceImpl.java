package com.dbcourse.classchoose.service.impl;

import com.dbcourse.classchoose.entity.Plan;
import com.dbcourse.classchoose.entity.SelectedCourse;
import com.dbcourse.classchoose.mapper.PlanMapper;
import com.dbcourse.classchoose.mapper.SelectedCourseMapper;
import com.dbcourse.classchoose.service.SelectedCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public int deleteById(Integer id) {
        SelectedCourse selectedCourse = selectedCourseMapper.selectById(id);
        int i = selectedCourseMapper.deleteById(id);
        if(i<=0) return 0;
        Plan plan = planMapper.selectByCnoTnoTerm(selectedCourse.getCno(),selectedCourse.getTno(),selectedCourse.getTerm());
        plan.setCurNum(plan.getCurNum()-1);
        return planMapper.updateById(plan);

    }
}
