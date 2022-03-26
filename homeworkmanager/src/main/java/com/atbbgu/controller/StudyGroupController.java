package com.atbbgu.controller;

import com.atbbgu.domain.StudyGroup;
import com.atbbgu.service.impl.StudyGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/groups")
public class StudyGroupController {

    @Autowired
    private StudyGroupServiceImpl studyGroupService;

    @RequestMapping("/enterGroup")
    public ModelAndView enterGroup(StudyGroup studyGroup, ModelAndView modelAndView){
        StudyGroup currentGroup=studyGroupService.selectByAny(studyGroup);
        modelAndView.addObject("currentGroup",currentGroup);

        modelAndView.setViewName("grouPages/groupmain");
        return modelAndView;
    }

}
