package com.example.studentperformancemanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.classes.GradeItem;

import java.util.List;

public class GradeAdapter extends ArrayAdapter<GradeItem> {
    private int resourceId;

    public GradeAdapter(Context context, int resourceid, List<GradeItem> objects) {
        super(context, resourceid, objects);
        resourceId = resourceid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GradeItem item = getItem(position); // 获取当前项的实例
        View view;
//提升ListView的运行效率，可以看到，现在我们在 getView()方法中进行了判断，如果 convertView为空，则使用LayoutInflater去加载布局，如果不为空则直接对 convertView进行重用。这样就大大提高了 ListView的运行效率，在快速滚动的时候也可以表现出更好的性能。
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        } else {
            view = convertView;
        }

        TextView courseName = (TextView) view.findViewById(R.id.grade_name);
        TextView courseScore=view.findViewById(R.id.grade_score);
        TextView courseGrade=view.findViewById(R.id.grade);
        courseName.setText(item.getName());
        courseScore.setText("学分:"+item.getCredit());
        if (item.getGrade()<60){
            courseGrade.setText("成绩:"+item.getGrade());
            courseGrade.setTextColor(getContext().getResources().getColor(R.color.red));
        }else {
            courseGrade.setText("成绩:"+item.getGrade());
        }

        return view;
    }

}
