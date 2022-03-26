package com.atbbgu.service.impl;

import com.atbbgu.domain.StuToGroup;
import com.atbbgu.domain.Student;
import com.atbbgu.domain.StudyGroup;
import com.atbbgu.mapper.StudentMapper;
import com.atbbgu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student login(Student student){
        return studentMapper.selectByUsernameAndPassword(student);
    }

    public int regist(Student student){
        return studentMapper.addStudent(student);
    }

    public boolean isExists(String account){
        if(studentMapper.isExists(account)==null){
            return false;
        }
        return true;
    }

    public int fillInfo(Student student){
        return studentMapper.updateInfo(student);
    }

    public int createStudyGroup(StudyGroup studyGroup){
        return studentMapper.createStudyGroup(studyGroup);
    }

    public int addStuToGroup(StuToGroup stuToGroup){
        return studentMapper.addStuToGroup(stuToGroup);
    }

    public List<StudyGroup> findGroups(String account){
        return studentMapper.findMyStudyGroup(account);
    }
}
