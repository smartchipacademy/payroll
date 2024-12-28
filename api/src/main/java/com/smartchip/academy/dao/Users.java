package com.smartchip.academy.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "userid")
    private String userid;

    @Column (name = "name")
    private String name;

    @Column (name = "mobilenumber")
    private String mobilenumber;

    @Column (name = "email")
    private String email;

    @Column (name = "password")
    private String password;

    @Column (name = "recentvideo")
    private String recentvideo;

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    @Column(name = "role_id")
    private int roleId;
    @Column(name = "login_type")
    private String loginType;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecentvideo() {
        return recentvideo;
    }

    public void setRecentvideo(String recentvideo) {
        this.recentvideo = recentvideo;
    }


}
