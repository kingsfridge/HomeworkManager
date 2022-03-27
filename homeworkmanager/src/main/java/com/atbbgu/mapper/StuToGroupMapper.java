package com.atbbgu.mapper;

import com.atbbgu.domain.StuToGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StuToGroupMapper {
    //创建学生和学习组的关系
    @Insert("insert into stu_to_group(`account`,group_id) values(#{account},#{groupId})")
    @Results({
            @Result(id = true,property="id",column="id"),
            @Result(property="account",column="account"),
            @Result(property="groupId",column="group_id")
    })
    int addStuToGroup(StuToGroup stuToGroup);

    //检查关系是否已存在
    @Select("select id,`account`,group_id from stu_to_group where `account`=#{account} and group_id=#{groupId}")
    @Results({
            @Result(id = true,property="id",column="id"),
            @Result(property="account",column="account"),
            @Result(property="groupId",column="group_id")
    })
    StuToGroup selectByAccountAndGroupId(StuToGroup stuToGroup);
}
