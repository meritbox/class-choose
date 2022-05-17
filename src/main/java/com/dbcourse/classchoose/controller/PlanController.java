package com.dbcourse.classchoose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @GetMapping("/getPage/{pageIndex}/{pageSize}")
    public List<PlanDTO> getAll(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        return planMapper.getAll(new Page<>(pageIndex,pageSize)).getRecords();
    }

    @GetMapping("/getTotal")
    public int getTotal(){ return planMapper.getTotal();}

    @PostMapping("/addPlan")
    public int addPlan(@RequestBody PlanBody planBody){
        return planService.addPlan(planBody);
    }

    @GetMapping("/deletePlan/{pno}")
    public boolean deletePlan(@PathVariable("pno") String pno){
        return planMapper.deleteById(pno)>0? true:false;
    }

    @GetMapping("/updateCapacity/{pno}/{capacity}")
    public boolean updateCapacity(@PathVariable("pno") String pno,@PathVariable("capacity") Integer capacity){
        return planService.updateCapacity(pno, capacity)>0;
    }

    @GetMapping("/getByTerm/{term}/{pageIndex}/{pageSize}")
    public List<PlanDTO> getByTerm(@PathVariable("term") String term,@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        return planMapper.getAllByTerm(term,new Page<>(pageIndex,pageSize)).getRecords();
    }

    @GetMapping("/getByTermTotal/{term}")
    public int getByTermTotal(@PathVariable("term") String term){ return planMapper.getByTermTotal(term);}

    @GetMapping("/getByTno/{tno}")
    public List<PlanDTO> getByTno(@PathVariable("tno") String tno){return planMapper.getByTno(tno);}

    @GetMapping("/getBySearch/{cnamelike}")
    public List<PlanDTO> getBySearch(@PathVariable("cnamelike") String cnamelike){return planMapper.getBySearch(cnamelike);}
}

