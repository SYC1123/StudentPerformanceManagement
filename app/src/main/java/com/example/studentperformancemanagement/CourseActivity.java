package com.example.studentperformancemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.studentperformancemanagement.Helper.AddCourseNetWorkHelper;
import com.example.studentperformancemanagement.Helper.ChanegCourseInfoNetWorkHelper;
import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Interface.IAddCourse;
import com.example.studentperformancemanagement.Interface.IChangeCourse;
import com.example.studentperformancemanagement.classes.Course;

public class CourseActivity extends AppCompatActivity implements IChangeCourse<String>, IAddCourse<String> {
    private EditText mCourse_id;
    private EditText mCourse_name;
    private EditText mCourse_credit;
    private EditText mCourse_place;
    private EditText mCourse_capacity;
    private EditText mCourse_time, mGrade, mTea, murl;
    private Button mSure;
    private ChanegCourseInfoNetWorkHelper chanegCourseInfoNetWorkHelper;
    private AddCourseNetWorkHelper addCourseNetWorkHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        bindViews();
        Intent intent = getIntent();
        final boolean flag = intent.getBooleanExtra("flag", false);//true加课
        chanegCourseInfoNetWorkHelper = new ChanegCourseInfoNetWorkHelper(this);
        addCourseNetWorkHelper=new AddCourseNetWorkHelper(this);
        if (!flag) {//改课
            Course course = (Course) intent.getSerializableExtra("course");
            mCourse_id.setText(course.getCourse_Id() + "");
            mCourse_name.setText(course.getCourse_name());
            mCourse_credit.setText(course.getCourse_credit() + "");
            mCourse_place.setText(course.getCourse_place());
            mCourse_capacity.setText(course.getCourse_capacity() + "");
            mCourse_time.setText(course.getCoure_time());
            mGrade.setText(course.getCourse_grade() + "");
            mTea.setText(course.getTeacher_id());
            mCourse_id.setEnabled(false);
            murl.setEnabled(false);
        }
        mSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    String id = mCourse_id.getText().toString();
                    String name = mCourse_name.getText().toString();
                    String credit = mCourse_credit.getText().toString();
                    String place = mCourse_place.getText().toString();
                    String capacity = mCourse_capacity.getText().toString();
                    String time = mCourse_time.getText().toString();
                    String grade = mGrade.getText().toString();
                    String tea = mTea.getText().toString();
                    chanegCourseInfoNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "change:" + id
                            + "&" + tea + "&" + name + "&" + grade + "&" + credit + "&" + place + "&" + capacity + "&" + time, CourseActivity.this);
                } else {
                    String id = mCourse_id.getText().toString();
                    String name = mCourse_name.getText().toString();
                    String credit = mCourse_credit.getText().toString();
                    String place = mCourse_place.getText().toString();
                    String capacity = mCourse_capacity.getText().toString();
                    String time = mCourse_time.getText().toString();
                    String grade = mGrade.getText().toString();
                    String tea = mTea.getText().toString();
                    String url = murl.getText().toString();
                    addCourseNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "add:" + id
                            + "&" + tea + "&" + name + "&" + grade + "&" + credit + "&" + place + "&" +
                            capacity + "&" + time + "&" + url, CourseActivity.this);
                }
            }
        });
    }

    private void bindViews() {

        mCourse_id = (EditText) findViewById(R.id.course_id);
        mCourse_name = (EditText) findViewById(R.id.course_name);
        mCourse_credit = (EditText) findViewById(R.id.course_credit);
        mCourse_place = (EditText) findViewById(R.id.course_place);
        mCourse_capacity = (EditText) findViewById(R.id.course_capacity);
        mCourse_time = (EditText) findViewById(R.id.course_time);
        mSure = (Button) findViewById(R.id.sure);
        mGrade = findViewById(R.id.course_grade);
        mTea = findViewById(R.id.teacher_id);
        murl = findViewById(R.id.url);
    }

    @Override
    public void onSucceed(String res) {
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onFaild(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onaddSucceed(String res) {
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onaddFaild(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
}
