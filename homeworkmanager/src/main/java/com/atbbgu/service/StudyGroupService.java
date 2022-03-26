package com.atbbgu.service;

import com.atbbgu.domain.StudyGroup;

public interface StudyGroupService {
    public boolean isExists(String groupId);

    public StudyGroup selectByAny(StudyGroup studyGroup);
}
