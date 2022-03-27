package com.atbbgu.service;

import com.atbbgu.domain.StudyGroup;

import java.util.List;

public interface StudyGroupService {
    public boolean isExists(String groupId);

    public StudyGroup selectByAny(StudyGroup studyGroup);

    public StudyGroup selectGroupWithStudents(String grouId);

    public List<StudyGroup> selectAllGroups();
}
