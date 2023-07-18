package com.example.english.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`group`")
public class Group {
    @Id
    @Column(name = "gr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int groupId;

    @Column(name = "gr_name")
    String groupName;

    @Column(name = "gr_description")
    String groupDescription;

    public int getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    @Override
    public String toString() {
        return "Group [groupId=" + groupId + ", groupName=" + groupName + ", groupDescription=" + groupDescription
                + "]";
    }

    public Group() {
    }

    public Group(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    
}
