package com.example.studentperformancemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.studentperformancemanagement.classes.Course;
import com.example.studentperformancemanagement.classes.GradeRatio;

public class SetScoreRatioActivity extends AppCompatActivity {
    private Button mSure;
    private EditText mUsual_ratio;
    private EditText mExp_ratio;
    private LinearLayout mLinearLayout;
    private EditText mMidterm_ratio;
    private EditText mFinal_ratio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_score_ratio);
        bindViews();
        Intent intent=getIntent();
        final Course course= (Course) intent.getSerializableExtra("course");
        mSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int usual=Integer.parseInt(mUsual_ratio.getText().toString());
                int exp=Integer.parseInt(mExp_ratio.getText().toString());
                int mid=Integer.parseInt(mMidterm_ratio.getText().toString());
                int fina=Integer.parseInt(mFinal_ratio.getText().toString());
                if(usual+exp+mid+fina!=100){
                    Toast.makeText(SetScoreRatioActivity.this, "请输入正确的成绩比例", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent=new Intent(SetScoreRatioActivity.this,InputScoreActivity.class);
                    GradeRatio gradeRatio=new GradeRatio((float)usual/100,(float)exp/100,(float)mid/100,(float)fina/100);
                    Log.d("asdfgh", gradeRatio.toString()+"setnS: "+usual+exp+mid+fina);
                    intent.putExtra("ratio",gradeRatio);
                    intent.putExtra("course",course);
                    startActivity(intent);
                }
            }
        });
    }
    private void bindViews() {

        mSure = (Button) findViewById(R.id.sure);
        mUsual_ratio = (EditText) findViewById(R.id.usual_ratio);
        mExp_ratio = (EditText) findViewById(R.id.exp_ratio);
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mMidterm_ratio = (EditText) findViewById(R.id.midterm_ratio);
        mFinal_ratio = (EditText) findViewById(R.id.final_ratio);
    }
}
