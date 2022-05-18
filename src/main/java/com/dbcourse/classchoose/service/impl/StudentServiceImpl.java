package com.dbcourse.classchoose.service.impl;

import com.dbcourse.classchoose.entity.DTO.LoginBody;
import com.dbcourse.classchoose.entity.Student;
import com.dbcourse.classchoose.mapper.StudentMapper;
import com.dbcourse.classchoose.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

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

    @Transactional
    @Override
    public int login(LoginBody loginBody) {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        Student student = studentMapper.selectById(username);
        return (student.getPassword().equals(md5))? 1 : 0;
    }

    @Override
    public Student findBysno(String sno) {
        return studentMapper.selectById(sno);
    }

    @Transactional
    @Override
    public int updatePwd(LoginBody loginBody) {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        Student student = studentMapper.selectById(username);
        student.setPassword(md5);
        return studentMapper.updateById(student);
    }
}
