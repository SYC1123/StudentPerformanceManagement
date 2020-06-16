package com.example.studentperformancemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SetInfoActivity extends AppCompatActivity {
    private EditText mTel;
    private EditText mPassword;
    private Button mSure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_info);
        bindViews();
    }
    private void bindViews() {

        mTel = (EditText) findViewById(R.id.tel);
        mPassword = (EditText) findViewById(R.id.password);
        mSure = (Button) findViewById(R.id.sure);
    }
}
