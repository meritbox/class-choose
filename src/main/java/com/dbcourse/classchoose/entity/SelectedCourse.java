package com.dbcourse.classchoose.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author shawn
 * @since 2022-05-11
 */
  @Data
  @EqualsAndHashCode(callSuper = false)
    public class SelectedCourse implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String sno;

    private String cno;

    private String term;

    private String tno;

    private Integer usualGrade;

    private Integer finalGrade;

    private Integer totalGrade;


}
