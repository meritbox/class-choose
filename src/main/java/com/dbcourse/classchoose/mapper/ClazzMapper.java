package com.dbcourse.classchoose.mapper;

import com.dbcourse.classchoose.entity.Clazz;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dbcourse.classchoose.entity.DTO.ClazzDTO;
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
public interface ClazzMapper extends BaseMapper<Clazz> {
    List<ClazzDTO> getAll();
    int insertClazz(Clazz clazz);
}
