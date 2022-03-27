package com.atbbgu.controller;

import com.atbbgu.domain.StudyGroup;
import com.atbbgu.service.impl.StudyGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/groups")
public class StudyGroupController {

    @Autowired
    private StudyGroupServiceImpl studyGroupService;

    @RequestMapping("/enterGroup")
    public ModelAndView enterGroup(String groupId, ModelAndView modelAndView){
        StudyGroup currentGroup=studyGroupService.selectGroupWithStudents(groupId);
        modelAndView.addObject("currentGroup",currentGroup);

        modelAndView.setViewName("grouPages/groupmain");
        return modelAndView;
    }

    @RequestMapping("/findGroups")
    public ModelAndView findGroups(ModelAndView modelAndView){
        List<StudyGroup> currentGroups=studyGroupService.selectAllGroups();

        //将全部学习小组存入request域中
        modelAndView.addObject("allGroups",currentGroups);

        //设置页面
        modelAndView.setViewName("/grouPages/findGroups");
        return modelAndView;
    }

}
