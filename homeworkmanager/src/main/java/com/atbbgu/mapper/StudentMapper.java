package com.atbbgu.mapper;


import com.atbbgu.domain.StuToGroup;
import com.atbbgu.domain.Student;
import com.atbbgu.domain.StudyGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface StudentMapper {
    @Select("select id,stu_id,username,`account`,`password`,stu_class,realname " +
            "from students where `account`=#{account} and `password`=#{password}")
    @Results({
            @Result(id = true,property="id",column="stu_id"),
            @Result(property="stuId",column="stu_id"),
            @Result(property = "username",column="username"),
            @Result(property = "account",column="account"),
            @Result(property = "password",column="password"),
            @Result(property = "stuClass",column="stu_class"),
            @Result(property = "realName",column = "realname")

    })
    Student selectByUsernameAndPassword(Student student);


    //查看是否该账号是否已存在
    @Select("select * from students where `account`=#{account}")
    @Results({
            @Result(id = true,property="id",column="stu_id"),
            @Result(property="stuId",column="stu_id"),
            @Result(property = "username",column="username"),
            @Result(property = "account",column="account"),
            @Result(property = "password",column="password"),
            @Result(property = "stuClass",column="stu_class"),
            @Result(property = "realName",column="realname")
    })
    Student isExists(String account);

    //注册插入新用户到数据库，返回受影响的条目数
    @Insert("insert into students(`account`,`password`) values(#{account},#{password})")
    int addStudent(Student student);


    /*id INT PRIMARY KEY AUTO_INCREMENT,
    stu_id VARCHAR(17),
    username VARCHAR(16),
	`account` VARCHAR(16),
	`password` VARCHAR(16),
    stu_class VARCHAR(10)*/
    //个人信息更新
    @Update("update students set stu_id=#{stuId},username=#{username},stu_class=#{stuClass},realname=#{realName}" +
            " where `account`=#{account}")
    @Results({
            @Result(id = true,property="id",column="id"),
            @Result(property="stuId",column="stu_id"),
            @Result(property = "username",column="username"),
            @Result(property = "account",column="account"),
            @Result(property = "password",column="password"),
            @Result(property = "stuClass",column="stu_class"),
            @Result(property = "realName",column="realname")
    })
    int updateInfo(Student student);

    //创建学习小组
    @Insert("insert into study_groups(group_id,group_name,master_account,master_username) " +
            "values(#{groupId},#{groupName},#{masterAccount},#{masterUsername})")
    @Results({
            @Result(id = true,property = "id",column="id"),
            @Result(property="groupId",column="group_id"),
            @Result(property="groupName",column="group_name"),
            @Result(property="masterAccount",column = "master_account"),
            @Result(property="masterUsername",column="master_username")
    })
    int createStudyGroup(StudyGroup studyGroup);

    //创建学生和学习组的关系
    @Insert("insert into stu_to_group(`account`,group_id) values(#{account},#{groupId})")
    @Results({
            @Result(id = true,property="id",column="id"),
            @Result(property="account",column="account"),
            @Result(property="groupId",column="group_id")
    })
    int addStuToGroup(StuToGroup stuToGroup);

    //查看已加入的学习小组
    @Select("SELECT * FROM study_groups " +
            "WHERE group_id IN (" +
            "SELECT group_id " +
            "FROM stu_to_group " +
            "WHERE `account`=#{account}" +
            ")")
    @Results({
            @Result(id = true,property = "id",column="id"),
            @Result(property = "groupId",column="group_id"),
            @Result(property = "groupName",column = "group_name"),
            @Result(property = "masterAccount",column = "master_account"),
            @Result(property = "masterUsername",column = "master_username")
    })
    List<StudyGroup> findMyStudyGroup(String account);
}
