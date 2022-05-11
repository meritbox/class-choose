package com.dbcourse.classchoose.mapper;

import com.dbcourse.classchoose.entity.DTO.TeacherCourseDTO;
import com.dbcourse.classchoose.entity.SelectedCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shawn
 * @since 2022-05-11
 */
@Repository
public interface SelectedCourseMapper extends BaseMapper<SelectedCourse> {

    List<TeacherCourseDTO> findTeacherCourseRecord();
}
