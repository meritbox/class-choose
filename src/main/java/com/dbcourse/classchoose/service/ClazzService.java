package com.dbcourse.classchoose.service;

import com.dbcourse.classchoose.entity.Clazz;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dbcourse.classchoose.entity.DTO.ClazzDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shawn
 * @since 2022-05-08
 */
public interface ClazzService extends IService<Clazz> {
    List<ClazzDTO> getAll();
}
