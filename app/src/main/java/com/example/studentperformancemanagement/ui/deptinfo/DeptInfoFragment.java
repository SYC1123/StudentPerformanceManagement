package com.example.studentperformancemanagement.ui.deptinfo;

import android.content.Intent;
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

import com.example.studentperformancemanagement.Helper.SaveOfficeHelper;
import com.example.studentperformancemanagement.Helper.SaveTeacherHelper;
import com.example.studentperformancemanagement.LoginActivity;
import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.classes.Office;

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
        Office office=SaveOfficeHelper.getUser(getContext(),"data","officeuser");
        mOfficeid.setText(office.getOffice_id());
        mOfficecollege.setText(office.getOffice_collegename());
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveOfficeHelper.saveNotlogin(getContext(),"data","officeislogin");
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return root;
    }
}
