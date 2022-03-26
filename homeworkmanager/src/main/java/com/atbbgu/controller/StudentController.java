package com.atbbgu.controller;


import com.atbbgu.domain.StuToGroup;
import com.atbbgu.domain.Student;
import com.atbbgu.domain.StudyGroup;
import com.atbbgu.service.StudentService;
import com.atbbgu.service.impl.StudyGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/students")
public class StudentController {
    //自动注入对象
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudyGroupServiceImpl studyGroupService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello world";
    }

    //登录
    @RequestMapping("/login")
    public ModelAndView login(String account, String password, HttpSession session,ModelAndView modelAndView){
        Student student=new Student();
        student.setAccount(account);
        student.setPassword(password);
        Student currentStudent=studentService.login(student);
        if(currentStudent==null){
            modelAndView.addObject("msg","账号或密码错误!");
            modelAndView.setViewName("index");
            return modelAndView;
        }
        //获取已加入的学习小组存入当前学生中
        List<StudyGroup> studyGroups=studentService.findGroups(currentStudent.getAccount());
        currentStudent.setStudyGroups(studyGroups);

        //登录之后，学生用户存进session域
        session.setAttribute("student",currentStudent);
        modelAndView.setViewName("stuPages/stuIndex");
        return modelAndView;
    }
    //注册
    @RequestMapping("/regist")
    public ModelAndView regist(String account,String password,ModelAndView modelAndView){
        //先检测数据库中是否已有账号
        boolean isExists=studentService.isExists(account);
        if(isExists){
            modelAndView.addObject("msg","用户已存在");
            modelAndView.setViewName("stuPages/regist");
            return modelAndView;
        }

        //注册用户到数据库
        Student student=new Student();
        student.setAccount(account);
        student.setPassword(password);
        studentService.regist(student);

        //设置页面并保存账号值到登录界面
        modelAndView.addObject("account",account);
        modelAndView.setViewName("stuPages/regSuccessfully");
        return modelAndView;
    }

    //修改学生信息
    @RequestMapping("/updateInfo")
    public ModelAndView updateInfo(Student student,ModelAndView modelAndView,HttpSession session){
        //从session域取出当前登录学生
        Student student1=(Student)session.getAttribute("student");
        //更新session域学生信息
        student1.setStuClass(student.getStuClass());
        student1.setStuId(student.getStuId());
        student1.setUsername(student.getUsername());
        student1.setRealName(student.getRealName());
        //更新数据库信息
        studentService.fillInfo(student1);

        modelAndView.setViewName("stuPages/stuIndex");
        return modelAndView;
    }

    //创建学习组
    @RequestMapping("/createStudyGroup")
    public ModelAndView createStudyGroup(ModelAndView modelAndView, HttpSession session, StudyGroup studyGroup){
        //1,填充学习组的创建者信息
        //获取当前登录的学生
        Student currentStudent=(Student)session.getAttribute("student");
        studyGroup.setMasterUsername(currentStudent.getUsername());//设置创建者用户名
        studyGroup.setMasterAccount(currentStudent.getAccount());//设置创建者账号


        //2,通过group_id查看学习小组是否存在
        if(studyGroupService.isExists(studyGroup.getGroupId())){
            modelAndView.setViewName("stuPages/createStudyGroup");
            modelAndView.addObject("msg","该小组id已被注册!");
            return modelAndView;
        }
        //3,将学习组信息存入数据库
        studentService.createStudyGroup(studyGroup);


        //4,建立学习组与学生的关系
        StuToGroup stuToGroup=new StuToGroup();
        stuToGroup.setGroupId(studyGroup.getGroupId());
        stuToGroup.setAccount(currentStudent.getAccount());
        studentService.addStuToGroup(stuToGroup);

        //更新session域数据
        List<StudyGroup> studyGroups=studentService.findGroups(currentStudent.getAccount());
        currentStudent.setStudyGroups(studyGroups);

        //5,页面跳转
        modelAndView.setViewName("stuPages/creSuccessfully");
        return modelAndView;
    }

}
