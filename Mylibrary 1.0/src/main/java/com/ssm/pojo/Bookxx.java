package com.ssm.pojo;

public class Bookxx {
    private  Integer bookid;
    private String bookname;
    private String detail;
    private  Integer bookcount;

    public Integer getBookcount() {
        return bookcount;
    }

    public Integer getBookid() {
        return bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public String getDetail() {
        return detail;
    }

    public void setBookcount(Integer bookcount) {
        this.bookcount = bookcount;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Bookxx{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", detail='" + detail + '\'' +
                ", bookcount=" + bookcount +
                '}';
    }
}
