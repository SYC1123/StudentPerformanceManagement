package com.example.studentperformancemanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;
    private RadioGroup group;
    private RadioButton mdept,mteacher,mstu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("登录");
        bindViews();
        mstu.setChecked(true);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag=group.getCheckedRadioButtonId();
                if(flag==R.id.dept){
                    Intent intent = new Intent(LoginActivity.this, DeptActivity.class);
                    startActivity(intent);
                }else if(flag==R.id.teacher){
                    Intent intent = new Intent(LoginActivity.this, TeacherActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void bindViews() {

        mTextView = (TextView) findViewById(R.id.textView);
        mAccount = (EditText) findViewById(R.id.account);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        group=findViewById(R.id.radioGroup);
        mdept=findViewById(R.id.dept);
        mteacher=findViewById(R.id.teacher);
        mstu=findViewById(R.id.student);
    }


}
