package com.example.taehyungkim.listviewcontact;


public class list_item {

    private int profile_image;
    private String name;
    private String phonenum;
    private String email;

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public list_item(int profile_image, String name, String phonenum, String email) {
        this.profile_image = profile_image;
        this.name = name;
        this.phonenum = phonenum;
        this.email = email;
    }
}
