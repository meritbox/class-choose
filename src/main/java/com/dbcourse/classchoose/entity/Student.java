package com.dbcourse.classchoose.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author shawn
 * @since 2022-05-08
 */
  @Data
  @EqualsAndHashCode(callSuper = false)
    public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "sno", type = IdType.AUTO)
    private String sno;

    private String sname;

    private String sex;

    private String dno;

    private Double gpa;

    private String password;


}
