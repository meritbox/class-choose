package com.dbcourse.classchoose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.Department;
import com.dbcourse.classchoose.mapper.DepartmentMapper;
import com.dbcourse.classchoose.service.DepartmentService;
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
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentMapper departmentMapper;

    @GetMapping("/getPage/{pageIndex}/{pageSize}")
    public List<Department> getAll(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        return departmentMapper.getAll(new Page<>(pageIndex,pageSize)).getRecords();
    }

    @GetMapping("/getTotal")
    public int getTotal(){ return departmentMapper.getTotal();}

    @PostMapping("/add")
    public boolean add(@RequestBody Department department){return departmentMapper.add(department)>0;}

    @PostMapping("/updateDepartment")
    public boolean updateDepartment(@RequestBody Department department){ return departmentMapper.updateById(department)>0;}

    @GetMapping("/delete/{dno}")
    public boolean delete(@PathVariable("dno") String dno){return departmentMapper.deleteById(dno)>0;}
}

