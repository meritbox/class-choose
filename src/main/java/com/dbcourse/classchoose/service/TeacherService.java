package com.dbcourse.classchoose.service;

import com.dbcourse.classchoose.entity.DTO.LoginBody;
import com.dbcourse.classchoose.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shawn
 * @since 2022-05-08
 */
public interface TeacherService extends IService<Teacher> {
    int login(LoginBody loginBody);

    int updatePwd(LoginBody loginBody);
}
