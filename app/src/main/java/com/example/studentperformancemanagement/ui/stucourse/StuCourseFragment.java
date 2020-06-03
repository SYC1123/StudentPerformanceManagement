package com.example.studentperformancemanagement.ui.stucourse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.CourseDetailsActivity;
import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.adapter.CourseAdapter;
import com.example.studentperformancemanagement.classes.CourseItem;

import java.util.ArrayList;
import java.util.List;

public class StuCourseFragment extends Fragment {
    private List<CourseItem> itemArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_course, container, false);
        initfruit();
//        CourseAdapter courseAdapter = new CourseAdapter(getContext(), R.layout.course_item, itemArrayList);
        CourseAdapter adapter=new CourseAdapter(getContext(),R.layout.course_item,itemArrayList);
        ListView listView = root.findViewById(R.id.courselist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CourseItem courseItem=itemArrayList.get(position);
                Intent intent=new Intent(getContext(), CourseDetailsActivity.class);
                intent.putExtra("name",courseItem.getName());
                startActivity(intent);
            }
        });
        return root;
    }
    private void initfruit() {
        for (int i = 0; i < 10; i++) {
            CourseItem fruit = new CourseItem("aaa", R.drawable.course,3);
            itemArrayList.add(fruit);
            CourseItem fruit1 = new CourseItem("bbb",  R.drawable.course,4);
            itemArrayList.add(fruit1);
            CourseItem fruit2 = new CourseItem("ccc",  R.drawable.course,5);
            itemArrayList.add(fruit2);
        }
    }
}
