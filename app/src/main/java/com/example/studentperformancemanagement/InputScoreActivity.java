package com.example.studentperformancemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.studentperformancemanagement.Helper.Constant;
import com.example.studentperformancemanagement.Helper.GetTeachStuNetWorkHelper;
import com.example.studentperformancemanagement.Interface.IGetTeachStu;
import com.example.studentperformancemanagement.adapter.CourseAdapter;
import com.example.studentperformancemanagement.adapter.StuAdapter;
import com.example.studentperformancemanagement.classes.Course;
import com.example.studentperformancemanagement.classes.GradeRatio;
import com.example.studentperformancemanagement.classes.Student;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InputScoreActivity extends AppCompatActivity implements IGetTeachStu<String> {
    private List<Student> itemArrayList = new ArrayList<>();
    private GetTeachStuNetWorkHelper getTeachStuNetWorkHelper;
    private ListView listView;
    private GradeRatio gradeRatio;
    private Course course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_score);
        getTeachStuNetWorkHelper = new GetTeachStuNetWorkHelper(this);
        Intent intent = getIntent();
          gradeRatio = (GradeRatio) intent.getSerializableExtra("ratio");
          course = (Course) intent.getSerializableExtra("course");
        listView = findViewById(R.id.stulist);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = itemArrayList.get(position);
                Intent intent = new Intent(InputScoreActivity.this, InputStuScoreActivity.class);
                intent.putExtra("stu_id",student.getStudent_id());
                intent.putExtra("course_id",course.getCourse_Id());
                intent.putExtra("ratio",gradeRatio);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getTeachStuNetWorkHelper.startNetThread(Constant.IPADDRESS, Constant.PORT, "get_teastu:" + course.getCourse_Id(), this);
    }

    @Override
    public void onSucceed(String res) {
        itemArrayList.clear();
        try {
            JSONArray jsonArray = new JSONArray(res);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String stu_name = jsonObject.optString("Stu_Name", null);
                String stu_id = jsonObject.optString("Stu_ID", null);
                Log.d("1234567", "onSucceed: "+stu_id);
                Student student = new Student(stu_id, stu_name);
                itemArrayList.add(student);
            }
            StuAdapter adapter = new StuAdapter(this, R.layout.stu_item, itemArrayList);
            listView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}