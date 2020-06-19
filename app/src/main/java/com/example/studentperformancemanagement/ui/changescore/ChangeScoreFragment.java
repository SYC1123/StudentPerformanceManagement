package com.example.studentperformancemanagement.ui.changescore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.R;

public class ChangeScoreFragment extends Fragment {

    private EditText mStuid;
    private EditText mCourseid;
    private EditText mScore;
    private Button mSure;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_changescore, container, false);
        mStuid = (EditText) root.findViewById(R.id.student_id);
        mCourseid = (EditText) root.findViewById(R.id.courseid);
        mScore = (EditText) root.findViewById(R.id.score);
        mSure = (Button) root.findViewById(R.id.sure);
        return root;
    }
}
