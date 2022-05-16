package com.dbcourse.classchoose.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.DTO.StudentDTO;
import com.dbcourse.classchoose.entity.Student;
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
public interface StudentMapper extends BaseMapper<Student> {
    IPage<StudentDTO> getAll(Page<StudentDTO> page);

    int add(Student student);

    @Select("select count(*) from student")
    int getTotal();

    @Select("select sname from student where sno = #{sno}")
    String getSname(String sno);
}
