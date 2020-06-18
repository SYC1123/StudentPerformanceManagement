package com.example.studentperformancemanagement.classes;

public class GradeItem {
    private double grade;//成绩
    private String name;//课名
    private String credit;//学分

    public GradeItem(String name, String credit, double grade) {
        this.grade = grade;
        this.name = name;
        this.credit = credit;
    }

    public String getCredit() {
        return credit;
    }

    public double getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
}
