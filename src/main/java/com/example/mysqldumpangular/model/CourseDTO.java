package com.example.mysqldumpangular.model;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    private Integer id;
    private String description;
    private String longDescription;
    private String iconUrl;
    private int lessonsCount;
    private String category;
    private int seqNo;
    private String url;
    private int price;
    private String courseListIcon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getCourseListIcon() {
        return courseListIcon;
    }

    public void setCourseListIcon(String courseListIcon) {
        this.courseListIcon = courseListIcon;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getLessonsCount() {
        return lessonsCount;
    }

    public void setLessonsCount(int lessonsCount) {
        this.lessonsCount = lessonsCount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
