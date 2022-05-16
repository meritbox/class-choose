package com.dbcourse.classchoose.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.DTO.ClazzTeacherDTO;
import com.dbcourse.classchoose.entity.DTO.GradeDTO;
import com.dbcourse.classchoose.entity.Grade;
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
 * @since 2022-05-08
 */
@Repository
public interface GradeMapper extends BaseMapper<Grade> {
    IPage<GradeDTO> getAll(Page<GradeDTO> page);

    List<Grade> selectAllBySno(String sno);

    @Select("select count(*) from grade")
    int getTotal();

//    List<Grade> getByTnoTerm(Page<GradeDTO> page,String tno, String term);

    List<GradeDTO> getByTnoTermCno(Page<GradeDTO> page,String tno,String term,String cno);

    @Select("select count(*) from grade " +
            "where grade.tno = #{tno} and grade.term = #{term} and grade.cno = #{cno}")
    int getTotalClazzMember(String tno,String term,String cno);

    List<ClazzTeacherDTO> getClazzTeacher(String tno,String term);
}
