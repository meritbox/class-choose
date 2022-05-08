package com.dbcourse.classchoose.entity;

import java.io.Serializable;
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
    public class Teacher implements Serializable {

    private static final long serialVersionUID=1L;

    private String tno;

    private String tname;

    private String sex;

    private String dno;

    private String password;


}
