package com.dbcourse.classchoose.service.impl;

import com.dbcourse.classchoose.entity.DTO.LoginBody;
import com.dbcourse.classchoose.entity.Student;
import com.dbcourse.classchoose.mapper.StudentMapper;
import com.dbcourse.classchoose.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shawn
 * @since 2022-05-08
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {


    @Autowired
    StudentMapper studentMapper;

    @Override
    public int login(LoginBody loginBody) {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();
        Student student = studentMapper.selectById(username);
        return (student.getPassword().equals(password))? 1 : 0;
    }

    @Override
    public Student findBysno(String sno) {
        return studentMapper.selectById(sno);
    }

    @Override
    public int updatePwd(LoginBody loginBody) {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();
        Student student = studentMapper.selectById(username);
        student.setPassword(password);
        return studentMapper.updateById(student);
    }
}
