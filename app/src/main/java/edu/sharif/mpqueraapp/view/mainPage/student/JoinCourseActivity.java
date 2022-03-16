package edu.sharif.mpqueraapp.view.mainPage.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.LinkedList;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

public class JoinCourseActivity extends AppCompatActivity {

    TextInputEditText courseName;
    Button joinButton;
    RecyclerView coursesRecyclerView;
    JoinCourseRecyclerViewAdapter courseRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_course);

        Gson gson = new Gson();
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        Student student = gson.fromJson(user, new TypeToken<Student>(){}.getType());

        LinkedList<Course> courses = new LinkedList<>();
        for (Course course : Course.courses) {
            if (!course.studentsIds.contains(student.id)){
                courses.add(course);
            }
        }

        courseName = findViewById(R.id.courseNameInput);
        joinButton = findViewById(R.id.joinButton);

        coursesRecyclerView = findViewById(R.id.coursesRecyclerView);
        coursesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseRecyclerViewAdapter = new JoinCourseRecyclerViewAdapter(this, courses);
        coursesRecyclerView.setAdapter(courseRecyclerViewAdapter);
        courseRecyclerViewAdapter.notifyDataSetChanged();


        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer courseId = Course.name2id(courseName.getText().toString());
                if (courseId == -1){}
                else{
                    Course.coursesIds.get(courseId).studentsIds.add(student.id);
                    student.courses.add(courseId);
                    try {
                        Save.saveCourses(AuthActivity.mPrefs);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        Save.saveStudents(AuthActivity.mPrefs);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}