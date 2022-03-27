package com.atbbgu.service.impl;


import com.atbbgu.domain.StudyGroup;
import com.atbbgu.mapper.StudyGroupMapper;
import com.atbbgu.service.StudyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudyGroupServiceImpl implements StudyGroupService {

    @Autowired
    private StudyGroupMapper studyGroupMapper;

    public boolean isExists(String groupId){
        if(studyGroupMapper.selectByGroupId(groupId)==null){
            //如果为空说明没有通过该id找到学习小组，返回false
            return false;
        }
        return true;
    }

    public StudyGroup selectByAny(StudyGroup studyGroup){
        return studyGroupMapper.selectByAny(studyGroup);
    }

    public StudyGroup selectGroupWithStudents(String groupId){
        return studyGroupMapper.selectGroupWithStudents(groupId);
    }

    public List<StudyGroup> selectAllGroups(){
        return studyGroupMapper.selectAllGroups();
    }
}
