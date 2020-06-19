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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Helper.SaveOfficeHelper;
import com.example.studentperformancemanagement.Helper.SaveTeacherHelper;
import com.example.studentperformancemanagement.Helper.SetOfficeInfoNetWork;
import com.example.studentperformancemanagement.Interface.ISetOfficeInfo;
import com.example.studentperformancemanagement.LoginActivity;
import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.classes.Office;

public class DeptInfoFragment extends Fragment implements ISetOfficeInfo<String> {
    private TextView mOfficeid;
    private TextView mOfficecollege;
    private Button mExit;
    private EditText mPassword;
    private ImageView mChangepassword;
    private SetOfficeInfoNetWork setOfficeInfoNetWork;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_deptinfo, container, false);
        mOfficeid = (TextView) root.findViewById(R.id.officeid);
        mOfficecollege = (TextView) root.findViewById(R.id.officecollege);
        mExit = (Button) root.findViewById(R.id.exit);
        mPassword = (EditText) root.findViewById(R.id.password);
        mChangepassword = (ImageView) root.findViewById(R.id.changepassword);
        setOfficeInfoNetWork=new SetOfficeInfoNetWork(this);
        setOfficeInfoNetWork.setCallback(this);
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
        mChangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mPassword.getText().toString().equals("")){
                    Toast.makeText(getContext(),"输入密码", Toast.LENGTH_SHORT).show();
                }else {
                    String password=mPassword.getText().toString();
                    Office office=SaveOfficeHelper.getUser(getContext(),"data","officeuser");
                    setOfficeInfoNetWork.startNetThread(Constant.IPADDRESS,Constant.PORT,"chang_pass:"+office.getOffice_id()+"&"+password);
                }
            }
        });
        return root;
    }

    @Override
    public void onsucceed(String res) {
        Toast.makeText(getContext(), res, Toast.LENGTH_SHORT).show();
        SaveOfficeHelper.saveNotlogin(getContext(), "data", "officeislogin");
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
