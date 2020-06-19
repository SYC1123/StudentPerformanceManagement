package com.example.studentperformancemanagement.ui.inputgrade;

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

import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Helper.GetTeachCourseNetWorkHelper;
import com.example.studentperformancemanagement.Helper.SaveTeacherHelper;
import com.example.studentperformancemanagement.Interface.IGetTeacheCourse;
import com.example.studentperformancemanagement.R;
import com.example.studentperformancemanagement.SetScoreRatioActivity;
import com.example.studentperformancemanagement.adapter.CourseAdapter;
import com.example.studentperformancemanagement.adapter.GradeAdapter;
import com.example.studentperformancemanagement.classes.Course;
import com.example.studentperformancemanagement.classes.GradeItem;
import com.example.studentperformancemanagement.classes.Teacher;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InputGradeFragment extends Fragment implements IGetTeacheCourse<String> {
    private List<Course> itemArrayList = new ArrayList<>();
    private GetTeachCourseNetWorkHelper getTeachCourseNetWorkHelper;
    private ListView listView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_inputgrade, container, false);
        getTeachCourseNetWorkHelper=new GetTeachCourseNetWorkHelper(this);
        getTeachCourseNetWorkHelper.setCallback(this);
//        initfruit();
        Teacher teacher= SaveTeacherHelper.getUser(getContext(),"data","teauser");
        getTeachCourseNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT,"get_teacourse:"+teacher.getTeacher_id());
//        Log.d("dddddd", "onCreateView: "+teacher.toString());
         listView = root.findViewById(R.id.inputlist);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Course course =itemArrayList.get(position);
                Intent intent=new Intent(getContext(), SetScoreRatioActivity.class);
                intent.putExtra("course",course);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onSucceed(String res) {
        itemArrayList.clear();
        try {
            JSONArray jsonArray = new JSONArray(res);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String course_id = jsonObject.optString("Course_ID", null);
                String name = jsonObject.optString("Course_name", null);
                int credit = jsonObject.optInt("Course_Credit", 0);
                Course course=new Course(name,credit,course_id);
                itemArrayList.add(course);
            }
            CourseAdapter adapter = new CourseAdapter(getContext(), R.layout.course_item, itemArrayList);
            listView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void initfruit() {
//        for (int i = 0; i < 10; i++) {
//            Course fruit = new Course("rrr", R.drawable.course, 3);
//            itemArrayList.add(fruit);
//            Course fruit1 = new Course("yyy", R.drawable.course, 4);
//            itemArrayList.add(fruit1);
//            Course fruit2 = new Course("ooo", R.drawable.course, 5);
//            itemArrayList.add(fruit2);
//        }
//    }
}