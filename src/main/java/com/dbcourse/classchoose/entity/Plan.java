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
    public class Plan implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId(value = "pno", type = IdType.AUTO)
    private String pno;

    private String cno;

    private String cname;

    private String tno;

    private String time;

    private String term;

    private String location;

    private Integer credit;

    private String dno;

    private Integer capacity;

    private Integer curNum;


}
