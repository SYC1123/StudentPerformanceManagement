package com.example.studentperformancemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class CourseActivity extends AppCompatActivity {
    private EditText mCourse_id;
    private EditText mCourse_name;
    private EditText mCourse_credit;
    private Switch mCourse_nature;
    private EditText mCourse_place;
    private EditText mCourse_capacity;
    private EditText mCourse_time;
    private Button mSure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        bindViews();
        Intent intent=getIntent();
        int id=intent.getIntExtra("courseid",0);
        boolean flag=intent.getBooleanExtra("flag",false);//true加课
        if (!flag){//加课
            mCourse_id.setText(id+"");
            mCourse_id.setEnabled(false);
        }
    }
    private void bindViews() {

        mCourse_id = (EditText) findViewById(R.id.course_id);
        mCourse_name = (EditText) findViewById(R.id.course_name);
        mCourse_credit = (EditText) findViewById(R.id.course_credit);
        mCourse_nature = (Switch) findViewById(R.id.course_nature);
        mCourse_place = (EditText) findViewById(R.id.course_place);
        mCourse_capacity = (EditText) findViewById(R.id.course_capacity);
        mCourse_time = (EditText) findViewById(R.id.course_time);
        mSure = (Button) findViewById(R.id.sure);
    }

}
