package com.example.english.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;

@Entity
@Transactional
@Data
@Table(name = "user")
public class User {
    @Id
    @Column(name = "us_id")
    // @OneToMany(mappedBy = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

    @Column(name = "us_username")
    String username;

    @Column(name = "us_password")
    String password;

    @Column(name = "us_fullname")
    String fullname;

    @Column(name = "us_email")
    String email;

    @Column(name = "us_phone")
    String phone;

    @Column(name = "us_address")
    String address;

    @Column(name = "gr_id")
    int groupId;

    @Column(name = "us_status")
    int status;

    @Column(name = "us_created_date", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false, insertable = false)
    LocalDateTime  createdDate;

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime  getCreatedDate() {
        return createdDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreatedDate(LocalDateTime  createdDate) {
        this.createdDate = createdDate;
    }
    
    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", fullname=" + fullname
                + ", email=" + email + ", phone=" + phone + ", address=" + address + ", groupId=" + groupId
                + ", status=" + status + ", createdDate=" + createdDate + "]";
    }

    public User() {
    }

    public User(String username, String password, String fullname, String email, String phone, String address,
            int groupId, int status, LocalDateTime createdDate) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.groupId = groupId;
        this.status = status;
        this.createdDate = createdDate;
    }

    public void setId(int id) {
        this.userId = id;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "us_id")
    private List<Log> logs;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "us_id")
    private List<Result> results;
}
