package com.example.user.jsontest01.bean;

public class DataBaseConnctionJson {
    @Override
    public String toString() {
        return "DataBaseConnctionJson{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_pass='" + user_pass + '\'' +
                '}';
    }

    /**
     * id : 1
     * name : ERCC
     * user_name : ercc@mgail.com
     * user_pass : 123456
     */

    private String id;
    private String name;
    private String user_name;
    private String user_pass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }
}
