package com.example.studentperformancemanagement.Interface;

public interface IChangeCourse<C> {
    void onSucceed(C res);
    void onFaild(C err);
}
