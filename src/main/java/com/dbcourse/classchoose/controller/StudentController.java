package com.dbcourse.classchoose.controller;


import com.dbcourse.classchoose.entity.DTO.LoginBody;
import com.dbcourse.classchoose.entity.DTO.StudentDTO;
import com.dbcourse.classchoose.entity.Student;
import com.dbcourse.classchoose.mapper.StudentMapper;
import com.dbcourse.classchoose.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentMapper studentMapper;

    @PostMapping("/login")
    public int login(@RequestBody LoginBody loginBody){
        return studentService.login(loginBody);
    }

    @GetMapping("/getAll")
    public List<StudentDTO> getAll(){
        return studentMapper.getAll();
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Student student){return studentMapper.add(student)>0;}

    @PostMapping("/updateStudent")
    public boolean updateStudent(@RequestBody Student student){return studentMapper.updateById(student)>0;}

    @GetMapping("/delete/{sno}")
    public boolean delete(@PathVariable("sno") String sno){return studentMapper.deleteById(sno)>0;}
}

