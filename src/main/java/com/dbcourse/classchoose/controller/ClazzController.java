package com.dbcourse.classchoose.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.Clazz;
import com.dbcourse.classchoose.entity.DTO.ClazzDTO;
import com.dbcourse.classchoose.mapper.ClazzMapper;
import com.dbcourse.classchoose.service.ClazzService;
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
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    ClazzService clazzService;

    @Autowired
    ClazzMapper clazzMapper;


    @GetMapping("/getPage/{pageIndex}/{pageSize}")
    public List<ClazzDTO> getAll(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        return clazzService.getAll(new Page<>(pageIndex,pageSize)).getRecords();
    }

    @GetMapping("/getTotal")
    public int getTotal(){
        return clazzMapper.getTotal();
    }

    @PostMapping("/updateClazz")
    public boolean updateClazz(@RequestBody Clazz clazz){
        int i = clazzMapper.updateById(clazz);
        return (i > 0)? true: false;
    }

    @GetMapping("/delete/{cno}")
    public boolean delete(@PathVariable("cno") String cno){
        int i = clazzMapper.deleteById(cno);
        return (i > 0)? true: false;
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Clazz clazz){
        System.out.println(clazz);
        int i = clazzMapper.insertClazz(clazz);
        return (i > 0)? true: false;
    }
}

