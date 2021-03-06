package com.dbcourse.classchoose.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.DTO.GradeDTO;
import com.dbcourse.classchoose.entity.DTO.TeacherCourseDTO;
import com.dbcourse.classchoose.entity.SelectedCourse;
import com.dbcourse.classchoose.mapper.SelectedCourseMapper;
import com.dbcourse.classchoose.service.SelectedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shawn
 * @since 2022-05-11
 */
@RestController
@RequestMapping("/selectedCourse")
public class SelectedCourseController {
    @Autowired
    SelectedCourseMapper selectedCourseMapper;

    @Autowired
    SelectedCourseService selectedCourseService;

    @GetMapping("/getPage/{pageIndex}/{pageSize}")
    public List<TeacherCourseDTO> getAll(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        return selectedCourseMapper.findTeacherCourseRecord(new Page<>(pageIndex,pageSize)).getRecords();
    }

    @GetMapping("/getTotal")
    public int getTotal(){return selectedCourseMapper.getTotal();}

    @GetMapping("/findMyClass/{sno}")
    public List<GradeDTO> findMyClass(@PathVariable("sno") String sno){ return selectedCourseMapper.selectBySno(sno);}

    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id){ return selectedCourseService.deleteById(id)>0;}

    @GetMapping("/chooseClass/{sno}/{pno}")
    public int chooseClass(@PathVariable("sno") String sno,@PathVariable("pno") String pno){ return selectedCourseService.chooseClass(sno,pno);}


    @GetMapping("/timeTable")
    public String[][] getTimeTableBySno(@RequestParam String sno){
        return selectedCourseService.handleTimetableRecordTime(sno);
    }

    @GetMapping("/getByTnoTermCno")
    public List<GradeDTO> getByTnoTermCno(@RequestParam int pageIndex,
                                           @RequestParam int pageSize,
                                           @RequestParam String tno,
                                           @RequestParam String term,
                                           @RequestParam String cno){
        return selectedCourseMapper.getByTnoTermCno(new Page<>(pageIndex,pageSize),tno,term,cno).getRecords();
    }

    @GetMapping("/getTotalClazzMember")
    public int getTotalClazzMember(@RequestParam String tno,
                                   @RequestParam String term,
                                   @RequestParam String cno){
        return selectedCourseMapper.getTotalClazzMember(tno,term,cno);
    }

    @GetMapping("/updateGrade")
    public boolean updateGrade(@RequestParam String sno,
                               @RequestParam String cno,
                               @RequestParam String tno,
                               @RequestParam int rate,
                               @RequestParam int usualGrade,
                               @RequestParam int finalGrade){
        return selectedCourseService.updateGrade(sno,cno,tno,rate,usualGrade,finalGrade)>0;
    }

    @GetMapping("/getSumBySno/{sno}")
    public int getSumBySno(@PathVariable("sno") String sno){return selectedCourseService.getSumBySno(sno);}

    @GetMapping("/getNumBySno/{sno}")
    public int getNumBySno(@PathVariable("sno") String sno){return selectedCourseService.getNumBySno(sno);}
}

