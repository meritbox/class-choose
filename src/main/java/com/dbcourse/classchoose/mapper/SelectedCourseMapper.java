package com.dbcourse.classchoose.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.DTO.GradeDTO;
import com.dbcourse.classchoose.entity.DTO.TeacherCourseDTO;
import com.dbcourse.classchoose.entity.DTO.TimeTableRecord;
import com.dbcourse.classchoose.entity.SelectedCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shawn
 * @since 2022-05-11
 */
@Repository
public interface SelectedCourseMapper extends BaseMapper<SelectedCourse> {

    IPage<TeacherCourseDTO> findTeacherCourseRecord(Page<TeacherCourseDTO> page);

    List<GradeDTO> selectBySno(String Sno);

    int insertCourse(String sno,String cno,String term,String tno);

    @Select("select count(*) from selected_course")
    int getTotal();

    @Select("select selected_course.cno cno, p.cname cname, p.time time " +
            "from selected_course left join plan p on selected_course.cno = p.cno " +
            "where selected_course.sno = #{sno}")
    List<TimeTableRecord> getRecordBySno(String sno);

    IPage<GradeDTO> getByTnoTermCno(Page<GradeDTO> page, String tno, String term, String cno);

    @Select("select count(*) from selected_course where tno = #{tno} and term = #{term} and cno = #{cno}")
    int getTotalClazzMember(String tno,String term,String cno);
}
