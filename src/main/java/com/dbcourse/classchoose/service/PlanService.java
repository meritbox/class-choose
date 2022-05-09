package com.dbcourse.classchoose.service;

import com.dbcourse.classchoose.entity.Plan;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shawn
 * @since 2022-05-08
 */
public interface PlanService extends IService<Plan> {

    List<Plan> getAll();
}
