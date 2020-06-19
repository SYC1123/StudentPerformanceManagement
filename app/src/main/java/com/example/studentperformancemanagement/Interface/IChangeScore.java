package com.example.studentperformancemanagement.Interface;

public interface IChangeScore<C> {
    void onSucceed(C res);
    void onFaild(C err);
}
