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
    private String coure_time;//上课时间
    private String course_grade;//开课学年
    private String teacher_id;//教师id

    public Course(String course_name, int course_credit, String course_Id, String course_place, int course_capacity, int course_restCapacity, String coure_time, String course_grade, String teacher_id) {
        this.course_name = course_name;
        this.course_credit = course_credit;
        this.course_Id = course_Id;
        this.course_place = course_place;
        this.course_capacity = course_capacity;
        this.course_restCapacity = course_restCapacity;
        this.coure_time = coure_time;
        this.course_grade = course_grade;
        this.teacher_id = teacher_id;
    }

    public Course(String course_name, int course_credit, String course_Id) {
        this.course_name = course_name;
        this.course_credit = course_credit;
        this.course_Id = course_Id;
    }

    public Course(String course_name, String imageId, int course_credit, String course_Id, String course_place, int course_capacity, int course_restCapacity, String coure_time) {
        this.course_name = course_name;
        this.imageId = imageId;
        this.course_credit = course_credit;
        this.course_Id = course_Id;
        this.course_place = course_place;
        this.course_capacity = course_capacity;
        this.course_restCapacity = course_restCapacity;
        this.coure_time = coure_time;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_name='" + course_name + '\'' +
                ", imageId='" + imageId + '\'' +
                ", course_nature='" + course_nature + '\'' +
                ", course_credit=" + course_credit +
                ", course_Id='" + course_Id + '\'' +
                ", course_place='" + course_place + '\'' +
                ", course_capacity=" + course_capacity +
                ", course_restCapacity=" + course_restCapacity +
                ", coure_time=" + coure_time +
                ", course_grade='" + course_grade + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                '}';
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
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

    public void setCoure_time(String coure_time) {
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

    public String getCoure_time() {
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
