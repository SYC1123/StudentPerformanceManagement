package com.example.studentperformancemanagement.ui.changecourse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.CourseActivity;
import com.example.studentperformancemanagement.Helper.CheckChooseFlagNetWorkHelper;
import com.example.studentperformancemanagement.Helper.ChooseFlagControlNetWorkHelper;
import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Helper.DeleteCourseNetWorkHelper;
import com.example.studentperformancemanagement.Helper.GetCourseNetWorkHelper;
import com.example.studentperformancemanagement.Helper.SaveOfficeHelper;
import com.example.studentperformancemanagement.Helper.SaveStudentHelper;
import com.example.studentperformancemanagement.Helper.SaveTeacherHelper;
import com.example.studentperformancemanagement.Interface.ICheckChooseflag;
import com.example.studentperformancemanagement.Interface.IDeleteCourse;
import com.example.studentperformancemanagement.Interface.IGetCourse;
import com.example.studentperformancemanagement.LoginActivity;
import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.classes.Course;
import com.example.studentperformancemanagement.classes.Student;

import org.json.JSONObject;

public class ChangeCourseFragment extends Fragment implements ICheckChooseflag<Integer>, IDeleteCourse<String>, IGetCourse<String> {
    private EditText mDelid;
    private Button mDelcourse;
    private EditText mChangeid;
    private Button mChange;
    private Button mAddcourse;
    private Switch mChoose_switch;
    private CheckChooseFlagNetWorkHelper checkChooseFlagNetWorkHelper;
    private ChooseFlagControlNetWorkHelper chooseFlagControlNetWorkHelper;
    private DeleteCourseNetWorkHelper deleteCourseNetWorkHelper;
    private GetCourseNetWorkHelper getCourseNetWorkHelper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_changecourse, container, false);
        checkChooseFlagNetWorkHelper = new CheckChooseFlagNetWorkHelper(this);
        checkChooseFlagNetWorkHelper.setCallback(this);
        chooseFlagControlNetWorkHelper = new ChooseFlagControlNetWorkHelper(this);
        deleteCourseNetWorkHelper = new DeleteCourseNetWorkHelper(this);
        deleteCourseNetWorkHelper.setCallback(this);
        getCourseNetWorkHelper = new GetCourseNetWorkHelper(this);
        getCourseNetWorkHelper.setCallback(this);
        checkChooseFlagNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "check:");
        mDelid = (EditText) root.findViewById(R.id.delid);
        mDelcourse = (Button) root.findViewById(R.id.delcourse);
        mChangeid = (EditText) root.findViewById(R.id.changeid);
        mChange = (Button) root.findViewById(R.id.change);
        mAddcourse = (Button) root.findViewById(R.id.addcourse);
        mChoose_switch = (Switch) root.findViewById(R.id.choose_switch);
        mDelcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mDelid.getText().toString().equals("")) {
                    String c_id = mDelid.getText().toString();
                    deleteCourseNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "del_course:" + c_id);
                } else {
                    Toast.makeText(getContext(), "输入课号", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mChoose_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mChoose_switch.setText("开");
                    int flag = 1;
                    chooseFlagControlNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "flag:" + flag);
                } else {
                    mChoose_switch.setText("关");
                    int flag = 0;
                    chooseFlagControlNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "flag:" + flag);
                }
            }
        });
        mAddcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CourseActivity.class);
                intent.putExtra("flag", true);//是否是加课
                startActivity(intent);
            }
        });
        mChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mChangeid.getText().toString().equals("")) {
                    String c_id = mChangeid.getText().toString();
                    getCourseNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "get_course:" + c_id);
                } else {
                    Toast.makeText(getContext(), "输入课号", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

    @Override
    public void onSucceed(Integer response) {
        if (response == 1) {
            mChoose_switch.setChecked(true);
        } else {
            mChoose_switch.setChecked(false);
        }
    }


    @Override
    public void ondelSucceed(String res) {
        Toast.makeText(getContext(), res, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String err) {
        Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetSucceed(String res) {
        try {
            JSONObject jsonObject = new JSONObject(res);
            /**
             * 使用jsonObject.optString， 不使用jsonObject.getString
             * jsonObject.optString获取null不会报错
             */
            String id = jsonObject.optString("ID", null);
            String teacher_id = jsonObject.optString("Teacher_ID", null);
            String name = jsonObject.optString("Course_name", null);
            String grade = jsonObject.optString("Grade", null);
            String credit = jsonObject.optString("Course_Credit", null);
            String palce = jsonObject.optString("Course_Place", null);
            String capacity = jsonObject.optString("Course_capacity", null);
            String restcapacity = jsonObject.optString("Course_restcapacity", null);
            String time = jsonObject.optString("Course_Time", null);
            Course course = new Course(name, Integer.parseInt(credit),
                    id, palce, Integer.parseInt(capacity),
                    Integer.parseInt(restcapacity)
                    , time, grade, teacher_id);
            // 日志打印结果：
            Log.d("123546", "analyzeJSON1解析的结果：" + course.toString());
            Intent intent = new Intent(getContext(), CourseActivity.class);
            intent.putExtra("flag", false);//是否是加课
            intent.putExtra("course",course);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onGetFailed(String err) {
        Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
    }
}
