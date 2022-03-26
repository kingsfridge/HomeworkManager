package com.atbbgu.domain;

import java.util.List;

//学生bean
public class Student {
    /*id INT PRIMARY KEY AUTO_INCREMENT,
    stu_id VARCHAR(17),
    username VARCHAR(16),
	`account` VARCHAR(16),
	`password` VARCHAR(16),
    stu_class VARCHAR(10)*/
    private int id;
    private String stuId;
    private String username;
    private String account;
    private String password;
    private String stuClass;
    private String realName;
    private List<StudyGroup> studyGroups;

    public Student() {
    }

    public Student(int id, String stuId, String username, String account, String password, String stuClass, String realName) {
        this.id = id;
        this.stuId = stuId;
        this.username = username;
        this.account = account;
        this.password = password;
        this.stuClass = stuClass;
        this.realName = realName;
    }

    public Student(int id, String stuId, String username, String account, String password, String stuClass, String realName, List<StudyGroup> studyGroups) {
        this.id = id;
        this.stuId = stuId;
        this.username = username;
        this.account = account;
        this.password = password;
        this.stuClass = stuClass;
        this.realName = realName;
        this.studyGroups = studyGroups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<StudyGroup> getStudyGroups() {
        return studyGroups;
    }

    public void setStudyGroups(List<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuId='" + stuId + '\'' +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", realName='" + realName + '\'' +
                ", studyGroups=" + studyGroups +
                '}';
    }
}
