package com.atbbgu.service;

import com.atbbgu.domain.StuToGroup;



public interface StuToGroupService {
    int addStuToGroup(StuToGroup stuToGroup);

    boolean isJoin(StuToGroup stuToGroup);
}
