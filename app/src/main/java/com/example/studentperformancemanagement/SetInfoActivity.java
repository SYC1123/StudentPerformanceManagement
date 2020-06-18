package com.example.studentperformancemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.studentperformancemanagement.Helper.ChangeStuInfoNetWorkHelper;
import com.example.studentperformancemanagement.Helper.ChangeTeaInfoNetWorkHelper;
import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Helper.SaveStudentHelper;
import com.example.studentperformancemanagement.Helper.SaveTeacherHelper;
import com.example.studentperformancemanagement.Interface.ISetStuInfo;
import com.example.studentperformancemanagement.Interface.ISetTeaInfo;
import com.example.studentperformancemanagement.classes.Student;
import com.example.studentperformancemanagement.classes.Teacher;

public class SetInfoActivity extends AppCompatActivity implements ISetStuInfo<String>, ISetTeaInfo<String> {
    private EditText mTel;
    private EditText mPassword;
    private Button mSure;
    private ChangeStuInfoNetWorkHelper changeStuInfoNetWorkHelper;
    private ChangeTeaInfoNetWorkHelper changeTeaInfoNetWorkHelper;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_info);
        bindViews();
        changeStuInfoNetWorkHelper = new ChangeStuInfoNetWorkHelper(this);
        changeTeaInfoNetWorkHelper = new ChangeTeaInfoNetWorkHelper(this);
        final boolean stu = SaveStudentHelper.getIslogin(this, "data", "stuislogin");
        if (stu) {
            Student student = SaveStudentHelper.getUser(this, "data", "stuuser");
            mTel.setText(student.getStudent_tel());
            mPassword.setText(student.getStudent_password());
            id = student.getStudent_id();
        } else {
            Teacher teacher = SaveTeacherHelper.getUser(this, "data", "teauser");
            mTel.setText(teacher.getTeacher_tel());
            mPassword.setText(teacher.getTeacher_password());
            id = teacher.getTeacher_id();
        }
        mSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = mTel.getText().toString();
                String password = mPassword.getText().toString();
                if (tel.equals("") || password.equals("")) {
                    Toast.makeText(SetInfoActivity.this, "请输入信息！", Toast.LENGTH_SHORT).show();
                } else {
                    if (stu) {
                        changeStuInfoNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "stu_change:" + tel + "&" + password + "&" + id, SetInfoActivity.this);
                    } else {
                        changeTeaInfoNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "tea_change:" + tel + "&" + password + "&" + id, SetInfoActivity.this);
                    }
                }
            }
        });
    }

    private void bindViews() {

        mTel = (EditText) findViewById(R.id.tel);
        mPassword = (EditText) findViewById(R.id.password);
        mSure = (Button) findViewById(R.id.sure);
    }


    @Override
    public void succeed(String res) {
        Toast.makeText(this, res.toString(), Toast.LENGTH_SHORT).show();
        SaveStudentHelper.saveNotlogin(this, "data", "stuislogin");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void teaSucceed(String res) {
        Toast.makeText(this, res.toString(), Toast.LENGTH_SHORT).show();
        SaveTeacherHelper.saveNotlogin(this, "data", "teaislogin");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
