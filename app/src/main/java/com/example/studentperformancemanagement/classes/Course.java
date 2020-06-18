package com.example.studentperformancemanagement.classes;

import java.io.Serializable;

public class Course implements Serializable {
    private String course_name;//课程名
    private String imageId;//图片
    private String course_nature;//是否必修
    private int course_credit;//学分
    private String course_Id;//课号
    private String course_place;//上课地点
    private int course_capacity;//课程容量
    private int course_restCapacity;//剩余数量
    private int coure_time;//学时
    private String course_grade;//开课学年

    public Course(String course_name, String imageId, int course_credit) {
        this.imageId = imageId;
        this.course_name = course_name;
        this.course_credit = course_credit;
    }

    public Course(String course_name, String imageId,  int course_credit, String course_Id, String course_place, int course_capacity, int course_restCapacity, int coure_time) {
        this.course_name = course_name;
        this.imageId = imageId;
        this.course_credit = course_credit;
        this.course_Id = course_Id;
        this.course_place = course_place;
        this.course_capacity = course_capacity;
        this.course_restCapacity = course_restCapacity;
        this.coure_time = coure_time;
    }

    public String getImageId() {
        return imageId;
    }

    public String getCourse_name() {
        return course_name;
    }

    public int getCourse_credit() {
        return course_credit;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public void setCourse_nature(String course_nature) {
        this.course_nature = course_nature;
    }

    public void setCourse_credit(int course_credit) {
        this.course_credit = course_credit;
    }

    public void setCourse_Id(String course_Id) {
        this.course_Id = course_Id;
    }

    public void setCourse_place(String course_place) {
        this.course_place = course_place;
    }

    public void setCourse_capacity(int course_capacity) {
        this.course_capacity = course_capacity;
    }

    public void setCourse_restCapacity(int course_restCapacity) {
        this.course_restCapacity = course_restCapacity;
    }

    public void setCoure_time(int coure_time) {
        this.coure_time = coure_time;
    }

    public void setCourse_grade(String course_grade) {
        this.course_grade = course_grade;
    }

    public String getCourse_nature() {
        return course_nature;
    }

    public String getCourse_Id() {
        return course_Id;
    }

    public String getCourse_place() {
        return course_place;
    }

    public int getCourse_capacity() {
        return course_capacity;
    }

    public int getCourse_restCapacity() {
        return course_restCapacity;
    }

    public int getCoure_time() {
        return coure_time;
    }

    public String getCourse_grade() {
        return course_grade;
    }
    private String teacher_name;

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
}
