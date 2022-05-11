package com.dbcourse.classchoose.mapper;

import com.dbcourse.classchoose.entity.DTO.PlanDTO;
import com.dbcourse.classchoose.entity.Plan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shawn
 * @since 2022-05-08
 */
@Repository
public interface PlanMapper extends BaseMapper<Plan> {
    List<PlanDTO> getAll();
    int insertPlan(Plan plan);
}
