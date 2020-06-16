package com.example.studentperformancemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.studentperformancemanagement.adapter.StuAdapter;
import com.example.studentperformancemanagement.classes.Student;

import java.util.ArrayList;
import java.util.List;

public class InputScoreActivity extends AppCompatActivity {
    private List<Student> itemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_score);
        initfruit();
        StuAdapter adapter=new StuAdapter(this,R.layout.stu_item,itemArrayList);
        ListView listView = findViewById(R.id.stulist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student courseItem=itemArrayList.get(position);
                Intent intent=new Intent(InputScoreActivity.this, InputStuScoreActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initfruit() {
        for (int i = 0; i < 10; i++) {
            Student fruit = new Student("张三", "20175188");
            itemArrayList.add(fruit);
            Student fruit1 = new Student("李四", "222222");
            itemArrayList.add(fruit1);
            Student fruit2 = new Student("王五", "233333");
            itemArrayList.add(fruit2);
        }
    }
}