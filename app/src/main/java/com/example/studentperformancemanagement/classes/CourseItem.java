package com.example.studentperformancemanagement.classes;

public class CourseItem {
    private String name;//课程名
    private int imageId;//图片
    private int score;//学分
    private int courseId=0;//课号
    private int befcourseId;//前导课号
    private int requiredCourse;//是否专业课
    private int capacity;//课程容量
    private int remain;//剩余数量

    public CourseItem(String name, int imageId, int score) {
        this.imageId = imageId;
        this.name = name;
        this.score = score;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
