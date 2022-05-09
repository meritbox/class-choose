package com.dbcourse.classchoose.service;

import com.dbcourse.classchoose.entity.DTO.LoginBody;
import com.dbcourse.classchoose.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shawn
 * @since 2022-05-08
 */
public interface StudentService extends IService<Student> {
    int login(LoginBody loginBody);
}
