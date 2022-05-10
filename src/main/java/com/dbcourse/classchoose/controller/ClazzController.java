package com.dbcourse.classchoose.controller;


import com.dbcourse.classchoose.entity.Clazz;
import com.dbcourse.classchoose.service.ClazzService;
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
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    ClazzService clazzService;

    @GetMapping("/getAll")
    public List<Clazz> getAll(){
        return clazzService.list();
    }
}

