package com.example.studentperformancemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.studentperformancemanagement.Helper.CheckChooseFlagNetWorkHelper;
import com.example.studentperformancemanagement.Helper.ChooseCourseNetWorkHelper;
import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Helper.SaveStudentHelper;
import com.example.studentperformancemanagement.Helper.SaveTeacherHelper;
import com.example.studentperformancemanagement.Interface.ICheckChooseflag;
import com.example.studentperformancemanagement.Interface.IChooseCourse;
import com.example.studentperformancemanagement.classes.Course;
import com.example.studentperformancemanagement.classes.Student;
import com.example.studentperformancemanagement.classes.Teacher;

public class CourseDetailsActivity extends AppCompatActivity implements ICheckChooseflag<Integer>, IChooseCourse<String> {
    private ImageView mImage1;
    private Button mReservation;
    private TextView mCoursename;
    private TextView mScore;//学分
    private TextView mcoursetime;
    private TextView mRequiredCourse;
    private TextView mCapacity;
    private TextView mId;
    private ImageView mImageView;
    private TextView mRemain, mPlace, mTea;
    private CheckChooseFlagNetWorkHelper checkChooseFlagNetWorkHelper;
    private ChooseCourseNetWorkHelper chooseCourseNetWorkHelper;
    private String id;
    private int grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        bindViews();
        final boolean stu = SaveStudentHelper.getIslogin(this, "data", "stuislogin");
        if (stu) {
            Student student = SaveStudentHelper.getUser(this, "data", "stuuser");
            id = student.getStudent_id();
            grade = student.getStudent_grade();
        }
        checkChooseFlagNetWorkHelper = new CheckChooseFlagNetWorkHelper(this);
        chooseCourseNetWorkHelper = new ChooseCourseNetWorkHelper(this);
        Intent intent = getIntent();
        final Course course = (Course) intent.getSerializableExtra("course");
        boolean flag = intent.getBooleanExtra("flag", false);
        if (flag) {
            mReservation.setVisibility(View.INVISIBLE);
        }
        checkChooseFlagNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "check:", this);
        Log.d("22222", "onCreate: " + course.toString());
        mCoursename.setText(course.getCourse_name());
        mScore.setText(course.getCourse_credit() + "");
        mcoursetime.setText(course.getCoure_time() + "");
        mCapacity.setText(course.getCourse_capacity() + "");
        mRemain.setText(course.getCourse_restCapacity() + "");
        mId.setText(course.getCourse_Id());
        mPlace.setText(course.getCourse_place());
        mTea.setText(course.getTeacher_name());
        Glide.with(CourseDetailsActivity.this)
                .load(course.getImageId())
                .into(mImage1);
        mReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(mRemain.getText().toString()) == 0) {
                    Toast.makeText(CourseDetailsActivity.this, "当前课程已经人满，不可再选", Toast.LENGTH_SHORT).show();
                } else {
                    chooseCourseNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "choose_course:" + course.getCourse_Id() + "&" + id + "&" + grade+"&"+mRemain.getText(), CourseDetailsActivity.this);
                }
            }
        });
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    private void bindViews() {

        mImage1 = (ImageView) findViewById(R.id.image1);
//        mImage2 = (ImageView) findViewById(R.id.image2);
        mReservation = (Button) findViewById(R.id.reservation);
        mCoursename = (TextView) findViewById(R.id.coursename);
        mScore = (TextView) findViewById(R.id.score);
        mcoursetime = (TextView) findViewById(R.id.coursetime);
        mRequiredCourse = (TextView) findViewById(R.id.requiredCourse);
        mCapacity = (TextView) findViewById(R.id.capacity);
        mId = (TextView) findViewById(R.id.id);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mRemain = (TextView) findViewById(R.id.remain);
        mPlace = findViewById(R.id.place);
        mTea = findViewById(R.id.teaname);
    }

    @Override
    public void onSucceed(Integer response) {
        if (response != 1) {
            mReservation.setText("目前无法选课");
            mReservation.setEnabled(false);
        } else {
            mReservation.setText("选课");
            mReservation.setEnabled(true);
        }
    }

    @Override
    public void chooseSucceed(String res) {
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.putExtra("key", true);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("key", false);
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}
