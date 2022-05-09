package com.dbcourse.classchoose.service;

import com.dbcourse.classchoose.entity.LoginBody;
import com.dbcourse.classchoose.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dbcourse.classchoose.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
    Teacher findBytno(String tno);


}
