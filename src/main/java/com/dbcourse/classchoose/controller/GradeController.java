package com.dbcourse.classchoose.controller;


import com.dbcourse.classchoose.entity.DTO.GradeDTO;
import com.dbcourse.classchoose.entity.Grade;
import com.dbcourse.classchoose.mapper.GradeMapper;
import com.dbcourse.classchoose.service.GradeService;
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
 * @since 2022-05-08
 */
@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @Autowired
    GradeMapper gradeMapper;

    @GetMapping("/getAll")
    public List<GradeDTO> getAll(){
        return gradeMapper.getAll();
    }
}

