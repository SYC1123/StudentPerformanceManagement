package com.example.studentperformancemanagement.Interface;

public interface IOfficeLogin<C> {
    void onofficeSucceed(C response);
    void onofficeFalied(C errStr);
}
