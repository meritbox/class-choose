package com.dbcourse.classchoose.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.DTO.PlanDTO;
import com.dbcourse.classchoose.entity.Plan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
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
    IPage<PlanDTO> getAll(Page<PlanDTO> page);
    int insertPlan(Plan plan);
    Plan selectByCnoTnoTerm(String cno,String tno,String term);
    @Select("select count(*) from plan")
    int getTotal();

    List<Plan> selectAllByTerm(String term);
    List<PlanDTO> getAllByTerm(String term);
}
