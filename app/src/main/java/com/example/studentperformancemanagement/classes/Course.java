package com.example.studentperformancemanagement.classes;

public class Course {
    private String course_name;//课程名
    private int imageId;//图片
    private String course_nature;//是否必修
    private int course_credit;//学分
    private String course_Id;//课号
    private String course_place;//上课地点
    private int course_capacity;//课程容量
    private int course_restCapacity;//剩余数量
    private int coure_time;//学时

    public Course(String course_name, int imageId, int course_credit) {
        this.imageId = imageId;
        this.course_name = course_name;
        this.course_credit = course_credit;
    }

    public int getImageId() {
        return imageId;
    }

    public String getCourse_name() {
        return course_name;
    }

    public int getCourse_credit() {
        return course_credit;
    }
}
