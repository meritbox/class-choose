package com.dbcourse.classchoose.controller;


import com.dbcourse.classchoose.entity.DTO.PlanBody;
import com.dbcourse.classchoose.entity.DTO.PlanDTO;
import com.dbcourse.classchoose.entity.Plan;
import com.dbcourse.classchoose.mapper.PlanMapper;
import com.dbcourse.classchoose.service.PlanService;
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
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    PlanService planService;

    @Autowired
    PlanMapper planMapper;

    @GetMapping("/getAll")
    public List<PlanDTO> getAll(){
        return planMapper.getAll();
    }

    @PostMapping("/addPlan")
    public boolean addPlan(@RequestBody PlanBody planBody){
        return planService.addPlan(planBody)>0? true:false;
    }

    @GetMapping("/deletePlan/{pno}")
    public boolean deletePlan(@PathVariable("pno") String pno){
        return planMapper.deleteById(pno)>0? true:false;
    }
}

