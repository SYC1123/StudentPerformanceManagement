package com.example.studentperformancemanagement.classes;

public class GradeItem {
    private int grade;
    private String name;
    private int score;

    public GradeItem(String name, int score, int grade) {
        this.grade = grade;
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
