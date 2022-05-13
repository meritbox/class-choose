package com.dbcourse.classchoose.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.DTO.TeacherDTO;
import com.dbcourse.classchoose.entity.Teacher;
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
public interface TeacherMapper extends BaseMapper<Teacher> {
    IPage<TeacherDTO> getAll(Page<TeacherDTO> page);
    int add(Teacher teacher);
    @Select("select count(*) from teacher")
    int getTotal();
}
