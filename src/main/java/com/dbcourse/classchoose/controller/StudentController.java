package com.dbcourse.classchoose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.DTO.GradeDTO;
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

    @GetMapping("/getPage/{pageIndex}/{pageSize}")
    public List<StudentDTO> getAll(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        return studentMapper.getAll(new Page<>(pageIndex,pageSize)).getRecords();
    }

    @GetMapping("/getTotal")
    public int getTotal(){return studentMapper.getTotal();}

    @PostMapping("/add")
    public boolean add(@RequestBody Student student){return studentMapper.add(student)>0;}

    @PostMapping("/updateStudent")
    public boolean updateStudent(@RequestBody Student student){return studentMapper.updateById(student)>0;}

    @GetMapping("/delete/{sno}")
    public boolean delete(@PathVariable("sno") String sno){return studentMapper.deleteById(sno)>0;}

    @GetMapping("/getSname/{sno}")
    public String getSname(@PathVariable("sno") String sno){return studentMapper.getSname(sno);}

    @PostMapping("/updatePwd")
    public int updatePwd(@RequestBody LoginBody loginBody){return studentService.updatePwd(loginBody);}

    @GetMapping("/getGPABySno/{sno}")
    public double getGPABySno(@PathVariable("sno") String sno){return studentMapper.selectById(sno).getGpa();}

}


