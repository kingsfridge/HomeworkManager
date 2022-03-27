package com.atbbgu.mapper;

import com.atbbgu.domain.Student;
import com.atbbgu.domain.StudyGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudyGroupMapper {

    //根据组id查找
    @Select("select * from study_groups where group_id=#{groupId}")
    StudyGroup selectByGroupId(String groupId);

    /*private Integer id;
    private String groupId;
    private String groupName;
    private String masterAccount;
    private String masterUsername;
    private List<Student> members;*/


    //动态sql
    @Select("<script>" +
            "select * from study_groups " +
            "<where> " +
            "<if test='id!=null'> and id=#{id} </if> " +
            "<if test='groupId!=null'> and group_id=#{groupId} </if> " +
            "<if test='masterAccount!=null'> and master_account=#{masterAccount} </if> " +
            "<if test='masterUsername!=null'> and master_username=#{masterUsername} </if>" +
            "</where>" +
            "</script>")
    @Results({
            @Result(id = true,property="id",column = "id"),
            @Result(property = "groupId",column = "group_id"),
            @Result(property = "groupName",column = "group_name"),
            @Result(property = "masterUsername",column="master_username"),
            @Result(property="masterAccount",column = "master_account")
    })
    StudyGroup selectByAny(StudyGroup studyGroup);


    //根据组id选出学习组(携带学生)一对多
    @Select("select * from study_groups where group_id=#{groupId}")
    @Results({
            @Result(id = true,property="id",column = "id"),
            @Result(property = "groupId",column = "group_id"),
            @Result(property = "groupName",column = "group_name"),
            @Result(property = "masterUsername",column="master_username"),
            @Result(property="masterAccount",column = "master_account"),
            @Result(property = "members",column = "group_id",javaType = List.class,
                    many = @Many(select = "com.atbbgu.mapper.StudentMapper.selectStusForGroup"))
    })
    StudyGroup selectGroupWithStudents(String groupId);

    //选择所有
    @Select("select id,group_id,group_name,master_username,master_account from study_groups")
    @Results({
            @Result(id = true,property="id",column = "id"),
            @Result(property = "groupId",column = "group_id"),
            @Result(property = "groupName",column = "group_name"),
            @Result(property = "masterUsername",column="master_username"),
            @Result(property="masterAccount",column = "master_account")
    })
    List<StudyGroup> selectAllGroups();
}
