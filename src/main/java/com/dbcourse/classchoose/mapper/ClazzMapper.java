package com.dbcourse.classchoose.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.Clazz;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dbcourse.classchoose.entity.DTO.ClazzDTO;
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
public interface ClazzMapper extends BaseMapper<Clazz> {

    IPage<ClazzDTO> getAll(Page<ClazzDTO> page);

    int insertClazz(Clazz clazz);

    @Select("select count(*) from clazz")
    int getTotal();

    @Select("select credit from clazz where cno = #{cno}")
    int getCreditByCno(String cno);

    List<ClazzDTO> getBySearch(String cnameLike);
}
