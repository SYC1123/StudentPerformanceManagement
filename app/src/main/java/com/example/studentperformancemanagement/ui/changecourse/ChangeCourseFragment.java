package com.example.studentperformancemanagement.ui.changecourse;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.studentperformancemanagement.R;

public class ChangeCourseFragment extends Fragment {
    private EditText mDelid;
    private Button mDelcourse;
    private EditText mChangeid;
    private Button mChange;
    private Button mAddcourse;
    private Switch mChoose_switch;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_changecourse, container, false);
        mDelid = (EditText) root.findViewById(R.id.delid);
        mDelcourse = (Button) root.findViewById(R.id.delcourse);
        mChangeid = (EditText) root.findViewById(R.id.changeid);
        mChange = (Button) root.findViewById(R.id.change);
        mAddcourse = (Button) root.findViewById(R.id.addcourse);
        mChoose_switch = (Switch) root.findViewById(R.id.choose_switch);
        mDelcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mDelid.getText().toString().equals("")){
                    
                }else {
                    Toast.makeText(getContext(), "输入课号", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mChoose_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mChoose_switch.setText("开");
                }else {
                    mChoose_switch.setText("关");

                }
            }
        });
        mAddcourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), CourseActivity.class);
                intent.putExtra("flag",true);//是否是加课
                startActivity(intent);
            }
        });
        mChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mChangeid.getText().toString().equals("")) {
                    Intent intent = new Intent(getContext(), CourseActivity.class);
                    intent.putExtra("flag", false);//是否是加课
                    intent.putExtra("courseid", Integer.parseInt(mChangeid.getText().toString()));
                    startActivity(intent);
                }else {
                    Toast.makeText(getContext(), "输入课号", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
    }

}
