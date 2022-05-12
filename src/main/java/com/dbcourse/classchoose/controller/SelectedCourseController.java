package com.dbcourse.classchoose.controller;


import com.dbcourse.classchoose.entity.DTO.GradeDTO;
import com.dbcourse.classchoose.entity.DTO.TeacherCourseDTO;
import com.dbcourse.classchoose.entity.SelectedCourse;
import com.dbcourse.classchoose.mapper.SelectedCourseMapper;
import com.dbcourse.classchoose.service.SelectedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    SelectedCourseService selectedCourseService;

    @GetMapping("/getAll")
    public List<TeacherCourseDTO> getAll(){
        return selectedCourseMapper.findTeacherCourseRecord();
    }

    @GetMapping("/findMyClass/{sno}")
    public List<GradeDTO> findMyClass(@PathVariable("sno") String sno){ return selectedCourseMapper.selectBySno(sno);}

    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id){ return selectedCourseService.deleteById(id)>0;}

    @GetMapping("/chooseClass/{sno}/{pno}")
    public int chooseClass(@PathVariable("sno") String sno,@PathVariable("pno") String pno){ return selectedCourseService.chooseClass(sno,pno);}
}

