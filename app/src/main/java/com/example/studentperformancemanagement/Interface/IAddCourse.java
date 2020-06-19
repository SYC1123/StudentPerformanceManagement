package com.example.studentperformancemanagement.Interface;

public interface IAddCourse<C> {
    void onaddSucceed(C res);
    void onaddFaild(C err);
}
