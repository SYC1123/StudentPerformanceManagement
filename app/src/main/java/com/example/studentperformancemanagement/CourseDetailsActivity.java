package com.example.studentperformancemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CourseDetailsActivity extends AppCompatActivity {
    private ImageView mImage1;
    private ImageView mImage2;
    private Button mReservation;
    private TextView mCoursename;
    private TextView mScore;
    private TextView mBefcourse;
    private TextView mRequiredCourse;
    private TextView mCapacity;
    private TextView mId;
    private ImageView mImageView;
    private TextView mRemain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        bindViews();
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        boolean flag=intent.getBooleanExtra("flag",false);
        if(flag){
            mReservation.setVisibility(View.INVISIBLE);
        }
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
    private void bindViews() {

        mImage1 = (ImageView) findViewById(R.id.image1);
//        mImage2 = (ImageView) findViewById(R.id.image2);
        mReservation = (Button) findViewById(R.id.reservation);
        mCoursename = (TextView) findViewById(R.id.coursename);
        mScore = (TextView) findViewById(R.id.score);
        mBefcourse = (TextView) findViewById(R.id.befcourse);
        mRequiredCourse = (TextView) findViewById(R.id.requiredCourse);
        mCapacity = (TextView) findViewById(R.id.capacity);
        mId = (TextView) findViewById(R.id.id);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mRemain = (TextView) findViewById(R.id.remain);
    }

}
