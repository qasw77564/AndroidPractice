package com.example.user.jsontest01.bean;

import java.io.File;
import java.util.List;

public class FileInfo {

    private int code;
    private List<FileBean> list;

    @Override
    public String toString() {
        return "FileInfo{" +
                "code=" + code +
                ", list=" + list +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<FileBean> getList() {
        return list;
    }

    public void setList(List<FileBean> list) {
        this.list = list;
    }

    public static class FileBean {
        /*
         "0":{
            "aid":"606",
            "author":"chen",
            "coins":350,
            "copyright":"Copy",
            "create":"2018-04-13 21:34"}
        * */
        private String aid;
        private String author;
        private int coins;
        private String copyright;
        private String create;

        @Override
        public String toString() {
            return "FileBean{" +
                    "aid='" + aid + '\'' +
                    ", author='" + author + '\'' +
                    ", coins=" + coins +
                    ", copyright='" + copyright + '\'' +
                    ", create='" + create + '\'' +
                    '}';
        }

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getCoins() {
            return coins;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCreate() {
            return create;
        }

        public void setCreate(String create) {
            this.create = create;
        }
    }
}
