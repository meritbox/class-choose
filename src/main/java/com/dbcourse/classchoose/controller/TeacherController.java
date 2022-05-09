package com.dbcourse.classchoose.controller;


import com.dbcourse.classchoose.entity.LoginBody;
import com.dbcourse.classchoose.entity.Teacher;
import com.dbcourse.classchoose.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/login")
    public int login(@RequestBody LoginBody loginBody){ return teacherService.login(loginBody);}

    @GetMapping("/findBytno/{tno}")
    public Teacher findBytno(@PathVariable("tno") String tno){ return teacherService.findBytno(tno);}
}

