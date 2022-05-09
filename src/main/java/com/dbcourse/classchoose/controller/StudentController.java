package com.dbcourse.classchoose.controller;


import com.dbcourse.classchoose.entity.LoginBody;
import com.dbcourse.classchoose.entity.Student;
import com.dbcourse.classchoose.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shawn
 * @since 2022-05-08
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/login")
    public int login(@RequestBody LoginBody loginBody){
        return studentService.login(loginBody);
    }

    @GetMapping("/findBysno/{sno}")
    public Student findBysno(@PathVariable("sno") String sno){ return studentService.findBysno(sno);}

}

