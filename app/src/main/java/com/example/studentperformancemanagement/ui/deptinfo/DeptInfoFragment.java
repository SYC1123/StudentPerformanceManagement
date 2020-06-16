package com.example.studentperformancemanagement.ui.deptinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.studentperformancemanagement.R;

public class DeptInfoFragment extends Fragment {
    private TextView mOfficeid;
    private TextView mOfficecollege;
    private Button mExit;
    private EditText mPassword;
    private ImageView mChangepassword;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_deptinfo, container, false);
        mOfficeid = (TextView) root.findViewById(R.id.officeid);
        mOfficecollege = (TextView) root.findViewById(R.id.officecollege);
        mExit = (Button) root.findViewById(R.id.exit);
        mPassword = (EditText) root.findViewById(R.id.password);
        mChangepassword = (ImageView) root.findViewById(R.id.changepassword);
        return root;
    }
}
