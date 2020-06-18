package com.example.studentperformancemanagement.ui.stucourse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.studentperformancemanagement.CourseDetailsActivity;
import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Helper.QueryCourseNetWorkHelper;
import com.example.studentperformancemanagement.Helper.SaveStudentHelper;
import com.example.studentperformancemanagement.Interface.IQueryCourse;
import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.adapter.CourseAdapter;
import com.example.studentperformancemanagement.adapter.GradeAdapter;
import com.example.studentperformancemanagement.classes.Course;
import com.example.studentperformancemanagement.classes.GradeItem;
import com.example.studentperformancemanagement.classes.Student;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StuCourseFragment extends Fragment implements IQueryCourse<String> {
    private List<Course> itemArrayList = new ArrayList<>();
    private ListView listView;
    private QueryCourseNetWorkHelper queryCourseNetWorkHelper;
    private Student student;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_course, container, false);
        queryCourseNetWorkHelper = new QueryCourseNetWorkHelper(this);
        queryCourseNetWorkHelper.setCallback(this);
        student= SaveStudentHelper.getUser(getContext(),"data","stuuser");
        Log.d("2222222", "onCreateView: "+student.toString());
        queryCourseNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "query_course:" + (student.getStudent_grade()+1) + "&" +student.getMajor_id());
        listView = root.findViewById(R.id.courselist);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course = itemArrayList.get(position);
                Intent intent = new Intent(getContext(), CourseDetailsActivity.class);
                intent.putExtra("name", course.getCourse_name());
                startActivity(intent);
            }
        });
        return root;
    }

//    private void initfruit() {
//        for (int i = 0; i < 10; i++) {
//            Course fruit = new Course("aaa", R.drawable.course, 3);
//            itemArrayList.add(fruit);
//            Course fruit1 = new Course("bbb", R.drawable.course, 4);
//            itemArrayList.add(fruit1);
//            Course fruit2 = new Course("ccc", R.drawable.course, 5);
//            itemArrayList.add(fruit2);
//        }
//    }

    @Override
    public void onSucceed(String res) {
        itemArrayList.clear();
        try {
            JSONArray jsonArray = new JSONArray(res);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String course_name = jsonObject.optString("Course_name", null);
                String course_photo = jsonObject.optString("Course_Photo", null);
                int course_credit = jsonObject.optInt("Course_Credit", 0);
                String course_id = jsonObject.optString("Course_ID", null);
                String course_place = jsonObject.optString("Course_Place", null);
                int capacity=jsonObject.optInt("Course_capacity",0);
                int restcapacity=jsonObject.optInt("Course_restcapacity",0);
                String time=jsonObject.optString("Course_Time",null);
                String tracher=jsonObject.optString("Teacher_name",null);
                Course course = new Course(course_name,course_photo,course_credit,course_id,course_place,capacity,restcapacity,Integer.parseInt(time));
                itemArrayList.add(course);
            }
            CourseAdapter adapter = new CourseAdapter(getContext(), R.layout.course_item, itemArrayList);
            listView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
