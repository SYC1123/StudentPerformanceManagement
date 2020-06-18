package com.example.studentperformancemanagement.classes;

import java.io.Serializable;

public class Teacher implements Serializable {
    private String teacher_id;//教工号
    private String teacher_name;//姓名
    private String teacher_password;//密码
    private String teacher_tel;//电话
    private String teacher_sex;//性别
    private String teacher_collegename;//学院
    private String major_id;//专业号

    public Teacher(String teacher_id, String teacher_name, String teacher_password, String teacher_tel, String teacher_sex, String teacher_collegename, String major_id) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_password = teacher_password;
        this.teacher_tel = teacher_tel;
        this.teacher_sex = teacher_sex;
        this.teacher_collegename = teacher_collegename;
        this.major_id = major_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }

    public void setTeacher_tel(String teacher_tel) {
        this.teacher_tel = teacher_tel;
    }

    public void setTeacher_sex(String teacher_sex) {
        this.teacher_sex = teacher_sex;
    }

    public void setTeacher_collegename(String teacher_collegename) {
        this.teacher_collegename = teacher_collegename;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public String getTeacher_password() {
        return teacher_password;
    }

    public String getTeacher_tel() {
        return teacher_tel;
    }

    public String getTeacher_sex() {
        return teacher_sex;
    }

    public String getTeacher_collegename() {
        return teacher_collegename;
    }

    public String getMajor_id() {
        return major_id;
    }
}
