package com.example.studentperformancemanagement.ui.stuinfo;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.studentperformancemanagement.Helper.SaveStudentHelper;
import com.example.studentperformancemanagement.LoginActivity;
import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.SetInfoActivity;
import com.example.studentperformancemanagement.classes.Student;

public class StuInfoFragment extends Fragment {

    private TextView mStuname;
    private Button mExitsys;
    private TextView mCollege;
    private TextView mSex;
    private TextView mMajor,mTel;
    private ImageView mSet;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);
        mStuname = (TextView) root.findViewById(R.id.stuname);
        mExitsys = (Button) root.findViewById(R.id.exitsys);
        mCollege = (TextView) root.findViewById(R.id.college);
        mSex = (TextView) root.findViewById(R.id.sex);
        mMajor = (TextView) root.findViewById(R.id.major);
        mSet = (ImageView) root.findViewById(R.id.set);
        mTel=root.findViewById(R.id.tel);
        Student student=SaveStudentHelper.getUser(getContext(),"data","stuuser");
        mStuname.setText(student.getStudent_name());
        mCollege.setText(student.getStudent_collegename());
        mSex.setText(student.getStudent_sex());
        mMajor.setText(student.getMajor_id());
        mTel.setText(student.getStudent_tel());
        mSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), SetInfoActivity.class);
                startActivity(intent);
            }
        });
        mExitsys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveStudentHelper.saveNotlogin(getContext(),"data","stuislogin");
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return root;
    }

}
