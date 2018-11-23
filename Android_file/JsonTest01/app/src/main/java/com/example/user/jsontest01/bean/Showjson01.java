package com.example.user.jsontest01.bean;

public class Showjson01 {
    private int id;
    private String name;
    private double price;
    private String path;


    public Showjson01() {

    }

    public Showjson01(int id, String name, double price, String path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.path = path;
    }

    @Override
    public String toString() {
        return "Showjson01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", path='" + path + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
