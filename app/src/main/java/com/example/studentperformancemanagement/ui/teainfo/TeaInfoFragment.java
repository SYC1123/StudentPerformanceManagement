package com.example.studentperformancemanagement.ui.teainfo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.Helper.SaveTeacherHelper;
import com.example.studentperformancemanagement.LoginActivity;
import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.SetInfoActivity;
import com.example.studentperformancemanagement.TeacherActivity;
import com.example.studentperformancemanagement.classes.Teacher;

public class TeaInfoFragment extends Fragment {

    private TextView mTeaname;
    private Button mExitsys;
    private TextView mTeasex;
    private TextView mTeaid;
    private TextView mTeacollege;
    private TextView mTeamajor,mTel;
    private ImageView mSet;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_taeinfo, container, false);
        mTeaname = (TextView) root.findViewById(R.id.teaname);
        mExitsys = (Button) root.findViewById(R.id.exitsys);
        mTeasex = (TextView) root.findViewById(R.id.teasex);
        mTeaid = (TextView) root.findViewById(R.id.teaid);
        mTeacollege = (TextView) root.findViewById(R.id.teacollege);
        mTeamajor = (TextView) root.findViewById(R.id.teamajor);
        mSet = (ImageView) root.findViewById(R.id.set);
        mTel=root.findViewById(R.id.teatel);
        Teacher teacher=SaveTeacherHelper.getUser(getContext(),"data","teauser");
        mTeaname.setText(teacher.getTeacher_name());
        mTeasex.setText(teacher.getTeacher_sex());
        mTeaid.setText(teacher.getTeacher_id());
        mTeacollege.setText(teacher.getTeacher_collegename());
        mTeamajor.setText(teacher.getMajor_id());
        mTel.setText(teacher.getTeacher_tel());
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
                SaveTeacherHelper.saveNotlogin(getContext(),"data","teaislogin");
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return root;
    }
}
