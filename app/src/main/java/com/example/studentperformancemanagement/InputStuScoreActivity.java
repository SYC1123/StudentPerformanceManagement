package com.example.studentperformancemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Helper.InputScoreNetWorkHelper;
import com.example.studentperformancemanagement.Interface.IInputScore;
import com.example.studentperformancemanagement.classes.GradeRatio;

public class InputStuScoreActivity extends AppCompatActivity implements IInputScore<String> {
    private EditText mUsual;
    private EditText mExp;
    private EditText mMid;
    private EditText mFina;
    private Button mInput;
    private InputScoreNetWorkHelper inputScoreNetWorkHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_stu_score);
        Intent intent=getIntent();
        final GradeRatio ratio=(GradeRatio)intent.getSerializableExtra("ratio");
        final String stu_id=intent.getStringExtra("stu_id");
        final String course_id=intent.getStringExtra("course_id");
        bindViews();
        inputScoreNetWorkHelper=new InputScoreNetWorkHelper(this);
        mInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mUsual.getText().toString().equals("")||mExp.getText().toString().equals("")||
                        mMid.getText().toString().equals("")||mFina.getText().toString().equals("")){
                    Toast.makeText(InputStuScoreActivity.this, "输入成绩！", Toast.LENGTH_SHORT).show();
                }else {
                    double usual=Double.parseDouble(mUsual.getText().toString())*ratio.getUsual();
                    double exp=Double.parseDouble(mExp.getText().toString())*ratio.getExp();
                    double mid=Double.parseDouble(mMid.getText().toString())*ratio.getMid();
                    double fina=Double.parseDouble(mFina.getText().toString())*ratio.getFina();
                    double grade=usual+exp+mid+fina;
                    inputScoreNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT,"input_score:"+stu_id+"&"+course_id+"&"+grade,InputStuScoreActivity.this);
                }
            }
        });
    }
    private void bindViews() {

        mUsual = (EditText) findViewById(R.id.usual);
        mExp = (EditText) findViewById(R.id.exp);
        mMid = (EditText) findViewById(R.id.mid);
        mFina = (EditText) findViewById(R.id.fina);
        mInput = (Button) findViewById(R.id.input);
    }


    @Override
    public void onSucceed(String res) {
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
        finish();
    }
}
