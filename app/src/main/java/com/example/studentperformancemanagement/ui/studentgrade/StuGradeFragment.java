package com.example.studentperformancemanagement.ui.studentgrade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.adapter.GradeAdapter;
import com.example.studentperformancemanagement.classes.GradeItem;

import java.util.ArrayList;
import java.util.List;

public class StuGradeFragment extends Fragment {
    private Spinner spinner;
    private List<GradeItem> itemArrayList = new ArrayList<>();
    private String[] province = {"大一上学期","大一下学期","大二上学期","大二下学期","大三上学期","大三下学期","大四上学期","大四下学期"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_grade, container, false);
        initfruit();
        GradeAdapter adapter=new GradeAdapter(getContext(), R.layout.grade_item,itemArrayList);
        ListView listView = root.findViewById(R.id.gradelist);
        listView.setAdapter(adapter);
        spinner = (Spinner) root.findViewById(R.id.spinner);
        initView();
        return root;
    }

    private void initfruit() {
        for (int i = 0; i < 10; i++) {
            GradeItem fruit = new GradeItem("aaa", 4,3);
            itemArrayList.add(fruit);
            GradeItem fruit1 = new GradeItem("bbb", 5,4);
            itemArrayList.add(fruit1);
            GradeItem fruit2 = new GradeItem("ccc", 6,5);
            itemArrayList.add(fruit2);
        }
    }
    private void initView() {
//        //新建一个数组适配器ArrayAdapter设置三个参数：上下文，下拉列表的样式，数据源
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item,province);
//        //将适配器设置给Spinner
        spinner.setAdapter(adapter);

        //设置item的被选择的监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //当item被选择后调用此方法
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //获取我们所选中的内容
                String s = parent.getItemAtPosition(position).toString();
                //弹一个吐司提示我们所选中的内容
//                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
            //只有当patent中的资源没有时，调用此方法
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
