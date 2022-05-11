package com.dbcourse.classchoose.controller;


import com.dbcourse.classchoose.entity.DTO.LoginBody;
import com.dbcourse.classchoose.entity.DTO.TeacherDTO;
import com.dbcourse.classchoose.entity.Teacher;
import com.dbcourse.classchoose.mapper.TeacherMapper;
import com.dbcourse.classchoose.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    TeacherMapper teacherMapper;

    @PostMapping("/login")
    public int login(@RequestBody LoginBody loginBody){
        return teacherService.login(loginBody);
    }

    @GetMapping("/getAll")
    public List<TeacherDTO> getAll(){
        return teacherMapper.getAll();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Teacher teacher){ return teacherMapper.add(teacher)>0;}

    @PostMapping("/updateTeacher")
    public boolean updateTeacher(@RequestBody Teacher teacher){return teacherMapper.updateById(teacher)>0;}

    @GetMapping("/delete/{tno}")
    public boolean delete(@PathVariable("tno") String tno){return teacherMapper.deleteById(tno)>0;}

}

