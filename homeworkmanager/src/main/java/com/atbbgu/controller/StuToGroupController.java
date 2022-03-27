package com.atbbgu.controller;

import com.atbbgu.domain.StuToGroup;
import com.atbbgu.domain.StudyGroup;
import com.atbbgu.service.impl.StuToGroupServiceImpl;
import com.atbbgu.service.impl.StudyGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/stuToGroup")
public class StuToGroupController {

    @Autowired
    private StuToGroupServiceImpl stuToGroupService;

    @Autowired
    private StudyGroupServiceImpl studyGroupService;

    @RequestMapping("/joinGroup")
    public ModelAndView joinGroup(ModelAndView modelAndView, StuToGroup stuToGroup,
                                  @RequestParam("tempGroupId") String grouId){

        modelAndView.setViewName("grouPages/groupmain");
        //判断学生是否已在小组内
        if(stuToGroupService.isJoin(stuToGroup)){
            //刷新小组数据
            StudyGroup currentGroup=studyGroupService.selectGroupWithStudents(grouId);
            modelAndView.addObject("currentGroup",currentGroup);
            //如果已在小组内,返回提示字符串,不跳转页面
            modelAndView.addObject("msg","已在小组内");
            return modelAndView;
        }
        //如果不在小组内,则添加学生小组关系
        modelAndView.addObject("msg","加入成功");
        stuToGroupService.addStuToGroup(stuToGroup);
        //刷新小组数据
        StudyGroup currentGroup=studyGroupService.selectGroupWithStudents(grouId);
        modelAndView.addObject("currentGroup",currentGroup);
        return modelAndView;
    }
}
