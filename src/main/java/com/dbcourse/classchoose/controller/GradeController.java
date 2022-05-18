package com.dbcourse.classchoose.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dbcourse.classchoose.entity.DTO.ClazzTeacherDTO;
import com.dbcourse.classchoose.entity.DTO.GradeDTO;
import com.dbcourse.classchoose.entity.DTO.gradeAvg;
import com.dbcourse.classchoose.entity.Grade;
import com.dbcourse.classchoose.mapper.GradeMapper;
import com.dbcourse.classchoose.service.GradeService;
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
 * @since 2022-05-08
 */
@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @Autowired
    GradeMapper gradeMapper;

    @GetMapping("/getPage/{pageIndex}/{pageSize}")
    public List<GradeDTO> getAll(@PathVariable("pageIndex") int pageIndex, @PathVariable("pageSize") int pageSize){
        return gradeMapper.getAll(new Page<>(pageIndex,pageSize)).getRecords();
    }

    @GetMapping("/getTotal")
    public int getTotal(){return gradeMapper.getTotal();}

    @GetMapping("/getByTnoTermCno")
    public List<GradeDTO> getByTnoTermCno(@RequestParam int pageIndex,
                                          @RequestParam int pageSize,
                                          @RequestParam String tno,
                                          @RequestParam String term,
                                          @RequestParam String cno){
        return gradeMapper.getByTnoTermCno(new Page<>(pageIndex,pageSize),tno,term,cno);
    }

    @GetMapping("/getTotalClazzMember")
    public int getTotalClazzMember(@RequestParam String tno,
                                   @RequestParam String term,
                                   @RequestParam String cno){
        return gradeMapper.getTotalClazzMember(tno,term,cno);
    }

    @GetMapping("/getByTnoTerm")
    public List<ClazzTeacherDTO> getClazzByTnoTerm(@RequestParam String tno,
                                                   @RequestParam String term){
        return gradeMapper.getClazzTeacher(tno,term);
    }

    @GetMapping("/getByTerm/{term}/{pageIndex}/{pageSize}")
    public List<GradeDTO> getByTerm(@PathVariable("term") String term,@PathVariable("pageIndex") int pageIndex,
                                    @PathVariable("pageSize") int pageSize){
        return gradeMapper.getByTerm(term,new Page<>(pageIndex,pageSize)).getRecords();
    }

    @GetMapping("/getByTermTotal/{term}")
    public int getByTermTotal(@PathVariable("term") String term){
        return gradeMapper.getByTermTotal(term);
    }

    @GetMapping("/getAvgGrade/{cno}")
    public List<gradeAvg> getAvgGrade(@PathVariable("cno") String cno){ return gradeMapper.getAvgGrade(cno);}


    @GetMapping("/getGradeBySno/{sno}/{pageIndex}/{pageSize}")
    public List<GradeDTO> getGradeBySno(@PathVariable("sno") String sno,@PathVariable("pageIndex") int pageIndex,
                                        @PathVariable("pageSize") int pageSize) {
        return gradeMapper.getBySno(sno,new Page<>(pageIndex,pageSize)).getRecords();
    }

    @GetMapping("/getGradeBySnoTotal/{sno}")
    public int getGradeBySnoTotal(@PathVariable("sno") String sno){return gradeMapper.getGradeBySnoTotal(sno);}
}

