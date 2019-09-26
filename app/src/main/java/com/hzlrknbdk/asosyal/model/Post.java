package com.hzlrknbdk.asosyal.model;

public class Post {

    private String profileImage, name, date, place, organizationName, organizationContent, organizationImage, category;

    public Post() {
    }

    public Post(String profileImage, String name, String date, String place, String organizationName, String organizationContent, String organizationImage, String category) {
        this.profileImage = profileImage;
        this.name = name;
        this.date = date;
        this.place = place;
        this.organizationName = organizationName;
        this.organizationContent = organizationContent;
        this.organizationImage = organizationImage;
        this.category = category;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationContent() {
        return organizationContent;
    }

    public void setOrganizationContent(String organizationContent) {
        this.organizationContent = organizationContent;
    }

    public String getOrganizationImage() {
        return organizationImage;
    }

    public void setOrganizationImage(String organizationImage) {
        this.organizationImage = organizationImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
