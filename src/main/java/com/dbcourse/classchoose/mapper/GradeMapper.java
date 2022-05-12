package com.dbcourse.classchoose.mapper;

import com.dbcourse.classchoose.entity.DTO.GradeDTO;
import com.dbcourse.classchoose.entity.Grade;
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
public interface GradeMapper extends BaseMapper<Grade> {
    List<GradeDTO> getAll();
    List<Grade> selectAllBySno(String sno);

}
