package com.hzlrknbdk.asosyal.model;

public class CourseDetails {

    private String workplaceName, time, courseType, price, city;

    public CourseDetails() {
    }

    public CourseDetails(String workplaceName, String time, String courseType, String price, String city) {
        this.workplaceName = workplaceName;
        this.time = time;
        this.courseType = courseType;
        this.price = price;
        this.city = city;
    }

    public String getWorkplaceName() {
        return workplaceName;
    }

    public void setWorkplaceName(String workplaceName) {
        this.workplaceName = workplaceName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
