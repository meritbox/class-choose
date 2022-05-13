package com.dbcourse.classchoose.entity.DTO;

import lombok.Data;

@Data
public class GradeDTO {
    private Integer id;

    private String sno;

    private String sname;

    private String cno;

    private String cname;

    private String term;

    private String tno;

    private String tname;

    private Integer usualGrade;

    private Integer finalGrade;

    private Integer totalGrade;

    //新增
    private Integer credit;
}
