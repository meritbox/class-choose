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
    public class Department implements Serializable {

    private static final long serialVersionUID=1L;

    private String dno;

    private String dname;


}
