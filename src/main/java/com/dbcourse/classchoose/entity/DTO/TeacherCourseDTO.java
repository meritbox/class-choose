package com.dbcourse.classchoose.entity.DTO;

import lombok.Data;

@Data
public class TeacherCourseDTO {
    private String sno;
    private String sname;
    private String cno;
    private String cname;
    private String term;
    private int usualGrade;
    private int finalGrade;
    private int totalGrade;
}
