package com.dbcourse.classchoose;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.dbcourse.classchoose.mapper")
public class ClassChooseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassChooseApplication.class, args);
    }

}
