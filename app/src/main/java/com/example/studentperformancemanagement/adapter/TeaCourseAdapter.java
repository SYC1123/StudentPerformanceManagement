package com.example.studentperformancemanagement.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.studentperformancemanagement.classes.Course;

import java.util.List;

public class TeaCourseAdapter  extends ArrayAdapter<Course> {
    private int resourceId;

    public TeaCourseAdapter(Context context, int resourceid, List<Course> objects) {
        super(context, resourceid, objects);
        resourceId = resourceid;
    }

}
