package com.example.user.hoemworkprojack.bean;

public class WelcomeBean {

    /**
     * title : Lccnet 專題班
     * images : http://app.code-edit.com/zh/images/logo.gif
     * content : Android 中壢班 專題製作
     */

    private String title;
    private String images;
    private String content;



    public WelcomeBean() {
    }

    public WelcomeBean(String title, String images, String content) {
        this.title = title;
        this.images = images;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
