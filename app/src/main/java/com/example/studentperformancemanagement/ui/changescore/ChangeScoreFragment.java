package com.example.studentperformancemanagement.ui.changescore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.Helper.ChangeScoreNetWorkHelper;
import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Interface.IChangeScore;
import com.example.studentperformancemanagement.R;

public class ChangeScoreFragment extends Fragment implements IChangeScore<String> {

    private EditText mStuid;
    private EditText mCourseid;
    private EditText mScore;
    private Button mSure;
    private ChangeScoreNetWorkHelper changeScoreNetWorkHelper;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_changescore, container, false);
        changeScoreNetWorkHelper=new ChangeScoreNetWorkHelper(this);
        changeScoreNetWorkHelper.setCallback(this);
        mStuid = (EditText) root.findViewById(R.id.student_id);
        mCourseid = (EditText) root.findViewById(R.id.courseid);
        mScore = (EditText) root.findViewById(R.id.score);
        mSure = (Button) root.findViewById(R.id.sure);
        mSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStuid.getText().toString().equals("")||mCourseid.getText().toString().equals("")||mScore.getText().toString().equals("")){
                    Toast.makeText(getContext(), "请输入内容！", Toast.LENGTH_SHORT).show();
                }else {
                    String stu_id=mStuid.getText().toString();
                    String c_id=mCourseid.getText().toString();
                    double score=Double.parseDouble(mScore.getText().toString());
                    if (score>100){
                        Toast.makeText(getContext(), "请输入正确的分数！", Toast.LENGTH_SHORT).show();
                    }else {
                    changeScoreNetWorkHelper.startNetThread(Constant.IPADDRESS,Constant.PORT,"change_score:"+stu_id+"&"+c_id+"&"+score);
                    }
                }
            }
        });
        return root;
    }

    @Override
    public void onSucceed(String res) {
        Toast.makeText(getContext(), res, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFaild(String err) {
        Toast.makeText(getContext(), err, Toast.LENGTH_SHORT).show();
    }
}
