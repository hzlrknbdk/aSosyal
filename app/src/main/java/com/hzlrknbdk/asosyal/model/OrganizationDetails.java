package com.hzlrknbdk.asosyal.model;

public class OrganizationDetails {

    private String organizationName, organizer, city, date, image, school, place, clock;

    public OrganizationDetails() {
    }

    public OrganizationDetails(String organizationName, String organizer, String city, String date, String image, String school, String place, String clock) {
        this.organizationName = organizationName;
        this.organizer = organizer;
        this.city = city;
        this.date = date;
        this.image = image;
        this.school = school;
        this.place = place;
        this.clock = clock;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
