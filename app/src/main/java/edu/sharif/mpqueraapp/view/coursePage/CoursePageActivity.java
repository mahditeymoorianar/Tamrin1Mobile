package edu.sharif.mpqueraapp.view.coursePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.view.mainPage.student.JoinCourseRecyclerViewAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedList;

public class CoursePageActivity extends AppCompatActivity {


    TextInputEditText exerciseNameInput;
    Button enterButtonCoursePage;
    RecyclerView exercisesRecyclerView;
    JoinCourseRecyclerViewAdapter courseRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);


        Gson gson = new Gson();
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        Student student = gson.fromJson(user, new TypeToken<Student>(){}.getType());

        LinkedList<Homework> exercises = new LinkedList<>();

//        for (Homework homework : Course.courses) {
//            if (!course.studentsIds.contains(student.id)){
//                exercises.add(course);
//            }
//        }


    }
}