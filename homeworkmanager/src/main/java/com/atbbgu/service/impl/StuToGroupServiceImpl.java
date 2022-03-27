package com.atbbgu.service.impl;

import com.atbbgu.domain.StuToGroup;
import com.atbbgu.mapper.StuToGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuToGroupServiceImpl {

    @Autowired
    private StuToGroupMapper stuToGroupMapper;

    public int addStuToGroup(StuToGroup stuToGroup){
        return stuToGroupMapper.addStuToGroup(stuToGroup);
    }

    public boolean isJoin(StuToGroup stuToGroup){
        if(stuToGroupMapper.selectByAccountAndGroupId(stuToGroup)==null){
            return false;
        }
        return true;
    }
}
