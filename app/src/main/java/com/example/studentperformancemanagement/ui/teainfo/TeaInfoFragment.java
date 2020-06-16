package com.example.studentperformancemanagement.ui.teainfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.SetInfoActivity;

public class TeaInfoFragment extends Fragment {

    private TextView mTeaname;
    private Button mExitsys;
    private TextView mTeasex;
    private TextView mTeaid;
    private TextView mTeacollege;
    private TextView mTeamajor;
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
        mSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), SetInfoActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}
