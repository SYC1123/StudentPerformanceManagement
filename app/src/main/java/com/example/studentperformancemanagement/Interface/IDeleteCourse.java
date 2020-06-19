package com.example.studentperformancemanagement.Interface;

public interface IDeleteCourse<C> {
    void ondelSucceed(C res);
    void onFailed(C err);

}
