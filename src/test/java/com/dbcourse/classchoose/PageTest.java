package com.dbcourse.classchoose;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.Clazz;
import com.dbcourse.classchoose.mapper.ClazzMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/page")
public class PageTest {
    @Autowired
    ClazzMapper clazzMapper;

    @GetMapping("/test")
    public List<Clazz> testPage(){
        Page<Clazz> clazzPage = new Page<>(1,10);;
        Page<Clazz> page = new LambdaQueryChainWrapper<>(clazzMapper)
                .page(clazzPage);
        return page.getRecords();
    }
}
