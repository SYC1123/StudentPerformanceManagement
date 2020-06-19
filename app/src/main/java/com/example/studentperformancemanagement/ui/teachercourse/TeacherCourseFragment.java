package com.example.studentperformancemanagement.ui.teachercourse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.CourseDetailsActivity;
import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Helper.GetTeaCourseNetWorkHelper;
import com.example.studentperformancemanagement.Helper.SaveTeacherHelper;
import com.example.studentperformancemanagement.Interface.IGetTeaCourse;
import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.adapter.CourseAdapter;
import com.example.studentperformancemanagement.classes.Course;
import com.example.studentperformancemanagement.classes.Teacher;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TeacherCourseFragment extends Fragment implements IGetTeaCourse<String> {

    private List<Course> itemArrayList = new ArrayList<>();
    private GetTeaCourseNetWorkHelper getTeaCourseNetWorkHelper;
    private ListView listView;
    private Teacher teacher;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_teachercourse, container, false);
        teacher = SaveTeacherHelper.getUser(getContext(), "data", "teauser");
        getTeaCourseNetWorkHelper = new GetTeaCourseNetWorkHelper(this);
        getTeaCourseNetWorkHelper.setCallback(this);
        getTeaCourseNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "get_teachecourse:" + teacher.getTeacher_id());
        listView = root.findViewById(R.id.teacourselist);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = itemArrayList.get(position);
                Intent intent = new Intent(getContext(), CourseDetailsActivity.class);
                intent.putExtra("course", course);
                intent.putExtra("flag", true);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onSucceed(String res) {
        itemArrayList.clear();
        try {
            Log.d("123456", "onSucceed: " + res);
            JSONArray jsonArray = new JSONArray(res);
            Log.d("123456", "onSucceed: " + jsonArray);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String course_id = jsonObject.optString("Course_ID", null);
                String name = jsonObject.optString("Course_name", null);
                int credit = jsonObject.optInt("Course_Credit", 0);
                String photo = jsonObject.optString("Course_Photo", null);
                String place = jsonObject.optString("Course_Place", null);
                int capacity = jsonObject.optInt("Course_capacity", 0);
                int restcapacity = jsonObject.optInt("Course_restcapacity", 0);
                String time = jsonObject.optString("Course_Time", null);
                Course course = new Course(name, photo, credit, course_id, place, capacity, restcapacity, time);
                course.setTeacher_name(teacher.getTeacher_name());
                itemArrayList.add(course);
            }
            CourseAdapter adapter = new CourseAdapter(getContext(), R.layout.course_item, itemArrayList);
            listView.setAdapter(adapter);
        } catch (Exception e) {
            Log.d("123456", "onSucceed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
