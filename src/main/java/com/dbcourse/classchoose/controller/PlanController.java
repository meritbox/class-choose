package com.dbcourse.classchoose.controller;


import com.dbcourse.classchoose.entity.Plan;
import com.dbcourse.classchoose.service.PlanService;
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
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    PlanService planService;

    @GetMapping("/getAll")
    public List<Plan> getAll(){
        return planService.list();
    }


}

