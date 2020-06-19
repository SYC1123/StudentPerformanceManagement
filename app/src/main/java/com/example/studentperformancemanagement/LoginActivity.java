package com.example.studentperformancemanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Helper.OfficeLoginNetWorkHelper;
import com.example.studentperformancemanagement.Helper.SaveOfficeHelper;
import com.example.studentperformancemanagement.Helper.SaveStudentHelper;
import com.example.studentperformancemanagement.Helper.SaveTeacherHelper;
import com.example.studentperformancemanagement.Helper.StuLoginNetWorkHelper;
import com.example.studentperformancemanagement.Helper.TeaLoginNetWorkHelper;
import com.example.studentperformancemanagement.Interface.IOfficeLogin;
import com.example.studentperformancemanagement.Interface.IStuLogin;
import com.example.studentperformancemanagement.Interface.ITeaLogin;
import com.example.studentperformancemanagement.classes.Office;
import com.example.studentperformancemanagement.classes.Student;
import com.example.studentperformancemanagement.classes.Teacher;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements IStuLogin<String>, IOfficeLogin<String>, ITeaLogin<String> {
    private TextView mTextView;
    private EditText mAccount;
    private EditText mPassword;
    private Button mLogin;
    private RadioGroup group;
    private RadioButton mdept, mteacher, mstu;
    private StuLoginNetWorkHelper helper;
    private OfficeLoginNetWorkHelper officeLoginNetWorkHelper;
    private TeaLoginNetWorkHelper teaLoginNetWorkHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("登录");
        bindViews();
        helper = new StuLoginNetWorkHelper(this);
        officeLoginNetWorkHelper = new OfficeLoginNetWorkHelper(this);
        teaLoginNetWorkHelper = new TeaLoginNetWorkHelper(this);
        mstu.setChecked(true);
        boolean tea = SaveTeacherHelper.getIslogin(this, "data", "teaislogin");
        boolean stu = SaveStudentHelper.getIslogin(this, "data", "stuislogin");
        boolean off = SaveOfficeHelper.getIslogin(this, "data", "officeislogin");
        if (tea) {
            Intent intent = new Intent(LoginActivity.this, TeacherActivity.class);
            startActivity(intent);
            finish();
        }
        if (stu) {
            Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
            startActivity(intent);
            finish();
        }
        if (off) {
            Intent intent = new Intent(LoginActivity.this, DeptActivity.class);
            startActivity(intent);
            finish();
        }
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag = group.getCheckedRadioButtonId();
                if (flag == R.id.dept) {
                    String account = mAccount.getText().toString();
                    String password = mPassword.getText().toString();
                    if (account.equals("") || password.equals("")) {
                        Toast.makeText(LoginActivity.this, "账号或密码不能为空！", Toast.LENGTH_SHORT).show();
                    } else {
                        officeLoginNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "office_login:" + account + "&" + password, LoginActivity.this);
                    }
                } else if (flag == R.id.teacher) {
                    String account = mAccount.getText().toString();
                    String password = mPassword.getText().toString();
                    if (account.equals("") || password.equals("")) {
                        Toast.makeText(LoginActivity.this, "账号或密码不能为空！", Toast.LENGTH_SHORT).show();
                    } else {
                        teaLoginNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "tea_login:" + account + "&" + password, LoginActivity.this);
                    }
                } else {
                    String account = mAccount.getText().toString();
                    String password = mPassword.getText().toString();
                    if (account.equals("") || password.equals("")) {
                        Toast.makeText(LoginActivity.this, "账号或密码不能为空！", Toast.LENGTH_SHORT).show();
                    } else {
                        helper.startNetThread(Constant.IPADDRESS, Constant.PORT, "stu_login:" + account + "&" + password, LoginActivity.this);
                    }
                }
            }
        });
    }

    private void bindViews() {

        mTextView = (TextView) findViewById(R.id.textView);
        mAccount = (EditText) findViewById(R.id.account);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        group = findViewById(R.id.radioGroup);
        mdept = findViewById(R.id.dept);
        mteacher = findViewById(R.id.teacher);
        mstu = findViewById(R.id.student);
    }


    @Override
    public void onSucceed(String response) {
        Toast.makeText(this, "学生登录成功", Toast.LENGTH_SHORT).show();
        SaveStudentHelper.saveIslogin(this, "data", "stuislogin");

        Log.d("123456", "onSucceed: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            /**
             * 使用jsonObject.optString， 不使用jsonObject.getString
             * jsonObject.optString获取null不会报错
             */
            String id = jsonObject.optString("ID", null);
            String name = jsonObject.optString("Name", null);
            String tel = jsonObject.optString("Tel", null);
            String sex = jsonObject.optString("Sex", null);
            String password = jsonObject.optString("Password", null);
            int grade = jsonObject.optInt("Grade", 0);
            String college = jsonObject.optString("College", null);
            String major_name = jsonObject.optString("major_name", null);
            String major_id=jsonObject.optString("major_id", null);
            Student user = new Student(id, name, password, tel, sex, grade, college, major_id);
            user.setMajor_name(major_name);
            SaveStudentHelper.saveUser(this, "data", "stuuser", user);
            // 日志打印结果：
            Log.d("123546", "analyzeJSON1解析的结果：" + user.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(LoginActivity.this, StudentActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFalied(String errStr) {
        Toast.makeText(this, errStr.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onofficeSucceed(String response) {
        Toast.makeText(this, "教务处登录成功", Toast.LENGTH_SHORT).show();
        SaveOfficeHelper.saveIslogin(this, "data", "officeislogin");

        Log.d("123456", "onSucceed: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            /**
             * 为什么要使用jsonObject.optString， 不使用jsonObject.getString
             * 因为jsonObject.optString获取null不会报错
             */
            String id = jsonObject.optString("ID", null);
            String password = jsonObject.optString("Password", null);
            String college = jsonObject.optString("College", null);
            Office user = new Office(id, password, college);
            SaveOfficeHelper.saveUser(this, "data", "officeuser", user);
            // 日志打印结果：
            Log.d("123546", "analyzeJSON1解析的结果：" + user.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(LoginActivity.this, DeptActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onofficeFalied(String errStr) {
        Toast.makeText(this, errStr.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onteaSucceed(String response) {
        Toast.makeText(this, "教师登录成功", Toast.LENGTH_SHORT).show();
        SaveTeacherHelper.saveIslogin(this, "data", "teaislogin");

        Log.d("123456", "onSucceed: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            /**
             * 为什么要使用jsonObject.optString， 不使用jsonObject.getString
             * 因为jsonObject.optString获取null不会报错
             */
            String id = jsonObject.optString("ID", null);
            String password = jsonObject.optString("Password", null);
            String college = jsonObject.optString("College", null);
            String major_name = jsonObject.optString("major_name", null);
            String name = jsonObject.optString("Name", null);
            String tel = jsonObject.optString("Tel", null);
            String sex = jsonObject.optString("Sex", null);
            String major_id=jsonObject.optString("major_id");
            Teacher user = new Teacher(id, name, password, tel, sex, college, major_id);
            user.setMajor_name(major_name);
            SaveTeacherHelper.saveUser(this, "data", "teauser", user);
            // 日志打印结果：
            Log.d("123546", "analyzeJSON1解析的结果：" + user.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(LoginActivity.this, TeacherActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onteaFalied(String errStr) {
        Toast.makeText(this, errStr.toString(), Toast.LENGTH_SHORT).show();
    }
}
