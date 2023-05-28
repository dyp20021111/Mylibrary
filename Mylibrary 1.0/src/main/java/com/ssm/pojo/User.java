package com.ssm.pojo;

import java.util.List;

public class User {
    private Integer userid;
    private String username;
    private String account;
    private String password;
    private Integer permission;
    private String detail;
    private List<Bookxx> books;
    private List<User> user;

    public String getAccount() {
        return account;
    }

    public List<Bookxx> getBooks() {
        return books;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public Integer getPermission() {
        return permission;
    }

    public Integer getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setBooks(List<Bookxx> books) {
        this.books = books;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                ", detail='" + detail + '\'' +
                ", books=" + books +
                ", user=" + user +
                '}';
    }
}
