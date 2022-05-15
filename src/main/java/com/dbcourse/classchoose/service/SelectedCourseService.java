package com.dbcourse.classchoose.service;

import com.dbcourse.classchoose.entity.SelectedCourse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shawn
 * @since 2022-05-11
 */
public interface SelectedCourseService extends IService<SelectedCourse> {
    int deleteById(Integer id);
    //        退课并且所退课程人数-1

    int chooseClass(String sno,String pno);

    String[][] handleTimetableRecordTime(String sno);
}
