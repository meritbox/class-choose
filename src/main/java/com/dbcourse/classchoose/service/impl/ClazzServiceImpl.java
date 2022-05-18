package com.dbcourse.classchoose.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.Clazz;
import com.dbcourse.classchoose.entity.DTO.ClazzDTO;
import com.dbcourse.classchoose.mapper.ClazzMapper;
import com.dbcourse.classchoose.service.ClazzService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shawn
 * @since 2022-05-08
 */
@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {
    @Autowired
    ClazzMapper clazzMapper;

    @Override
    public IPage<ClazzDTO> getAll(Page<ClazzDTO> page) {
        return clazzMapper.getAll(page);
    }

    @Transactional
    @Override
    public int deleteById(String cno) {
        return clazzMapper.deleteById(cno);
    }
}
