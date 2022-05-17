package com.dbcourse.classchoose;

import com.dbcourse.classchoose.entity.Student;
import com.dbcourse.classchoose.mapper.StudentMapper;
import com.dbcourse.classchoose.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

public class md5Test {
    @Autowired
    static StudentMapper studentMapper;
    @Autowired
    static StudentService studentService;

    public static void main(String[] args) {

        String no = "19122172";
        String md5 = DigestUtils.md5DigestAsHex(no.getBytes());
        System.out.println(md5);
//        Student student = studentService.getById(no);
//        student.setPassword(md5);
//        studentMapper.updateById(student);
        System.out.println(DigestUtils.md5DigestAsHex("19122173".getBytes(StandardCharsets.UTF_8)));

    }
}
