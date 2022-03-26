package com.atbbgu.domain;

import java.util.List;

public class StudyGroup {
    private Integer id;
    private String groupId;
    private String groupName;
    private String masterAccount;
    private String masterUsername;
    private List<Student> members;

    public StudyGroup() {
    }

    public StudyGroup(Integer id, String groupId, String groupName, String masterAccount, String masterUsername, List<Student> members) {
        this.id = id;
        this.groupId = groupId;
        this.groupName = groupName;
        this.masterAccount = masterAccount;
        this.masterUsername = masterUsername;
        this.members = members;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMasterAccount() {
        return masterAccount;
    }

    public void setMasterAccount(String masterAccount) {
        this.masterAccount = masterAccount;
    }

    public String getMasterUsername() {
        return masterUsername;
    }

    public void setMasterUsername(String masterUsername) {
        this.masterUsername = masterUsername;
    }

    public List<Student> getMembers() {
        return members;
    }

    public void setMembers(List<Student> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", masterAccount='" + masterAccount + '\'' +
                ", masterUsername='" + masterUsername + '\'' +
                ", members=" + members +
                '}';
    }
}
