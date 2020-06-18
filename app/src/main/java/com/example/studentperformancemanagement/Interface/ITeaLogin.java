package com.example.studentperformancemanagement.Interface;

public interface ITeaLogin<C> {
    void onteaSucceed(C response);
    void onteaFalied(C errStr);
}
