package com.example.studentperformancemanagement.ui.teachercourse;

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
import com.example.studentperformancemanagement.classes.Course;

import java.util.ArrayList;
import java.util.List;

public class TeacherCourseFragment extends Fragment {

    private List<Course> itemArrayList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_teachercourse, container, false);
        initfruit();
//        CourseAdapter courseAdapter = new CourseAdapter(getContext(), R.layout.course_item, itemArrayList);
        CourseAdapter adapter=new CourseAdapter(getContext(),R.layout.course_item,itemArrayList);
        ListView listView = root.findViewById(R.id.teacourselist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course =itemArrayList.get(position);
                Intent intent=new Intent(getContext(), CourseDetailsActivity.class);
                intent.putExtra("name", course.getCourse_name());
                intent.putExtra("flag",true);
                startActivity(intent);
            }
        });
        return root;
    }
    private void initfruit() {
        for (int i = 0; i < 10; i++) {
            Course fruit = new Course("aaa", R.drawable.course,3);
            itemArrayList.add(fruit);
            Course fruit1 = new Course("bbb",  R.drawable.course,4);
            itemArrayList.add(fruit1);
            Course fruit2 = new Course("ccc",  R.drawable.course,5);
            itemArrayList.add(fruit2);
        }
    }
}
