package com.atbbgu.domain;

//学生和学习组的关系类

public class StuToGroup {
    /*id INT PRIMARY KEY AUTO_INCREMENT,
     `account` VARCHAR(16),
    group_id VARCHAR(11)*/

    private Integer id;
    private String account;
    private String groupId;

    public StuToGroup() {
    }

    public StuToGroup(Integer id, String account, String groupId) {
        this.id = id;
        this.account = account;
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "StuToGroup{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
