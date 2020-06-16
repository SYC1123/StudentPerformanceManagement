package com.example.studentperformancemanagement.ui.inputgrade;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.SetScoreRatioActivity;
import com.example.studentperformancemanagement.adapter.CourseAdapter;
import com.example.studentperformancemanagement.classes.Course;

import java.util.ArrayList;
import java.util.List;

public class InputGradeFragment extends Fragment {
    private List<Course> itemArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_inputgrade, container, false);
        initfruit();
        CourseAdapter adapter=new CourseAdapter(getContext(),R.layout.course_item,itemArrayList);
        ListView listView = root.findViewById(R.id.inputlist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course =itemArrayList.get(position);
                Intent intent=new Intent(getContext(), SetScoreRatioActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    private void initfruit() {
        for (int i = 0; i < 10; i++) {
            Course fruit = new Course("rrr", R.drawable.course, 3);
            itemArrayList.add(fruit);
            Course fruit1 = new Course("yyy", R.drawable.course, 4);
            itemArrayList.add(fruit1);
            Course fruit2 = new Course("ooo", R.drawable.course, 5);
            itemArrayList.add(fruit2);
        }
    }
}