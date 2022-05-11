package com.dbcourse.classchoose.mapper;

import com.dbcourse.classchoose.entity.DTO.StudentDTO;
import com.dbcourse.classchoose.entity.Student;
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
public interface StudentMapper extends BaseMapper<Student> {
    List<StudentDTO>getAll();
    int add(Student student);
}
