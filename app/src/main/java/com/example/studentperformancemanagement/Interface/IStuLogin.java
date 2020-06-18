package com.example.studentperformancemanagement.Interface;

public interface IStuLogin<C> {
    void onSucceed(C response);
    void onFalied(C errStr);
}
