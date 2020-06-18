package com.example.studentperformancemanagement.classes;

import java.io.Serializable;

public class Student implements Serializable {
    private String student_id;//学号
    private String student_name;//姓名
    private String student_password;//密码
    private String student_tel;//电话
    private String student_sex;//性别
    private int student_grade;//学年
    private String student_collegename;//学院
    private String major_id;//专业号

    @Override
    public String toString() {
        return "Student{" +
                "student_id='" + student_id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_password='" + student_password + '\'' +
                ", student_tel='" + student_tel + '\'' +
                ", student_sex='" + student_sex + '\'' +
                ", student_grade=" + student_grade +
                ", student_collegename='" + student_collegename + '\'' +
                ", major_id='" + major_id + '\'' +
                '}';
    }

    public Student(String student_id, String student_name) {
        this.student_id = student_id;
        this.student_name = student_name;
    }

    public Student(String student_id, String student_name, String student_password, String student_tel, String student_sex, int student_grade, String student_collegename, String major_id) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_password = student_password;
        this.student_tel = student_tel;
        this.student_sex = student_sex;
        this.student_grade = student_grade;
        this.student_collegename = student_collegename;
        this.major_id = major_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public void setStudent_tel(String student_tel) {
        this.student_tel = student_tel;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public void setStudent_grade(int student_grade) {
        this.student_grade = student_grade;
    }

    public void setStudent_collegename(String student_collegename) {
        this.student_collegename = student_collegename;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_password() {
        return student_password;
    }

    public String getStudent_tel() {
        return student_tel;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public int getStudent_grade() {
        return student_grade;
    }

    public String getStudent_collegename() {
        return student_collegename;
    }

    public String getMajor_id() {
        return major_id;
    }
}
