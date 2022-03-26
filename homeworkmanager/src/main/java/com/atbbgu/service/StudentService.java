package com.atbbgu.service;

import com.atbbgu.domain.StuToGroup;
import com.atbbgu.domain.Student;
import com.atbbgu.domain.StudyGroup;

import java.util.List;

public interface StudentService {
    public Student login(Student student);

    public int regist(Student student);

    public boolean isExists(String account);

    public int fillInfo(Student student);

    public int createStudyGroup(StudyGroup studyGroup);

    public int addStuToGroup(StuToGroup stuToGroup);

    public List<StudyGroup> findGroups(String account);

}
