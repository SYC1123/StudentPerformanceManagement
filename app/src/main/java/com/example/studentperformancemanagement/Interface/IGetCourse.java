package com.example.studentperformancemanagement.Interface;

public interface IGetCourse<C> {
    void onGetSucceed(C res);
    void onGetFailed(C err);
}
