package com.dbcourse.classchoose.controller;


import com.dbcourse.classchoose.entity.DTO.TeacherCourseDTO;
import com.dbcourse.classchoose.mapper.SelectedCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shawn
 * @since 2022-05-11
 */
@RestController
@RequestMapping("/selectedCourse")
public class SelectedCourseController {
    @Autowired
    SelectedCourseMapper selectedCourseMapper;

    @GetMapping("/getAll")
    public List<TeacherCourseDTO> getAll(){
        System.out.println(selectedCourseMapper.findTeacherCourseRecord().get(0));
        return selectedCourseMapper.findTeacherCourseRecord();
    }
}

