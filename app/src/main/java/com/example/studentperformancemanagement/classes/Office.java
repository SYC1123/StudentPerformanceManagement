package com.example.studentperformancemanagement.classes;

import java.io.Serializable;

public class Office implements Serializable {
    private String office_id;//教工号
    private String office_password;//密码
    private String office_collegename;//学院名

    public Office(String office_id, String office_password, String office_collegename) {
        this.office_id = office_id;
        this.office_password = office_password;
        this.office_collegename = office_collegename;
    }

    public void setOffice_id(String office_id) {
        this.office_id = office_id;
    }

    public void setOffice_password(String office_password) {
        this.office_password = office_password;
    }

    public void setOffice_collegename(String office_collegename) {
        this.office_collegename = office_collegename;
    }

    public String getOffice_id() {
        return office_id;
    }

    public String getOffice_password() {
        return office_password;
    }

    public String getOffice_collegename() {
        return office_collegename;
    }
}
