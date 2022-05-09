package com.dbcourse.classchoose.service.impl;

import com.dbcourse.classchoose.entity.Plan;
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


    @Override
    public List<Plan> getAll() {
        return null;
    }
}
