package com.dbcourse.classchoose.service.impl;

import com.dbcourse.classchoose.entity.DTO.LoginBody;
import com.dbcourse.classchoose.entity.Teacher;
import com.dbcourse.classchoose.mapper.TeacherMapper;
import com.dbcourse.classchoose.service.TeacherService;
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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public int login(LoginBody loginBody) {
        String username = loginBody.getUsername();
        String password = loginBody.getPassword();
        Teacher teacher = teacherMapper.selectById(username);
        return (teacher.getPassword().equals(password))? 1 : 0;
    }

    @Override
    public int updatePwd(LoginBody loginBody) {
        String username = loginBody.getUsername();;
        String password = loginBody.getPassword();
        Teacher teacher = teacherMapper.selectById(username);
        teacher.setPassword(password);
        return teacherMapper.updateById(teacher);
    }
}
