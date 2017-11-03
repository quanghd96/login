package com.quang.models.entity;

import java.util.Date;

public class User {
    private String hoten;
    private Date ngaysinh;
    private String quequan;
    private String username;
    private String password;

    public User() {
    }

    public User(String hoten, Date ngaysinh, String quequan, String username, String password) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
        this.username = username;
        this.password = password;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
