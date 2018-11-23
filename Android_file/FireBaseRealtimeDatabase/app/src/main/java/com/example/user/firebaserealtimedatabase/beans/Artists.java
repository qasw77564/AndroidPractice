package com.example.user.firebaserealtimedatabase.beans;


public class Artists {
    String artists_id;
    String artists_name;
    String artists_type;

   public Artists (){

   }
    public Artists(String artists_id, String artists_name, String artists_type) {
        this.artists_id = artists_id;
        this.artists_name = artists_name;
        this.artists_type = artists_type;
    }


    public String getArtists_id() {
        return artists_id;
    }

    public void setArtists_id(String artists_id) {
        this.artists_id = artists_id;
    }

    public String getArtists_name() {
        return artists_name;
    }

    public void setArtists_name(String artists_name) {
        this.artists_name = artists_name;
    }

    public String getArtists_type() {
        return artists_type;
    }

    public void setArtists_type(String artists_type) {
        this.artists_type = artists_type;
    }





}
