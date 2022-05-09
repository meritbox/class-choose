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
    public class Clazz implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId(value = "cno", type = IdType.AUTO)
    private String cno;

    private String cname;

    private Integer credit;

    private Integer dno;


}
