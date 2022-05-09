package com.dbcourse.classchoose.controller;

import com.dbcourse.classchoose.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ClazzService clazzService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    GradeService gradeService;

    @Autowired
    PlanService planService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

//    @GetMapping("/clazzInfo")
//    public List<>

}
