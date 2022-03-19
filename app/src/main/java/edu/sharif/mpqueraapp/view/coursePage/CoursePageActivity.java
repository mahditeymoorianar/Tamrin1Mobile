package edu.sharif.mpqueraapp.view.coursePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;
import edu.sharif.mpqueraapp.view.mainPage.student.JoinCourseRecyclerViewAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.LinkedList;

public class CoursePageActivity extends AppCompatActivity {


    TextInputEditText exerciseNameInput;
    Button enterButtonCoursePage;
    RecyclerView exercisesRecyclerView;
    CoursePageRecyclerViewAdapter courseRecyclerViewAdapter;
    TextView profNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);


        Gson gson = new Gson();
        Intent intent = getIntent();
        String courseJson = intent.getStringExtra("course");
        Course course = gson.fromJson(courseJson, new TypeToken<Course>(){}.getType());

        LinkedList<Homework> homeworks = new LinkedList<>();

        for (Integer homeworkId : course.homeworksIds) {
            homeworks.add(Homework.getHomeworkById(homeworkId));
        }

        exerciseNameInput = findViewById(R.id.exerciseNameInput);
        enterButtonCoursePage = findViewById(R.id.enterButtonCoursePage);
        exercisesRecyclerView = findViewById(R.id.exercisesRecyclerView);
        profNameTextView = findViewById(R.id.profNameTextView);

        profNameTextView.setText(Professor.getProfById(course.profId).name.toString());

        exercisesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseRecyclerViewAdapter = new CoursePageRecyclerViewAdapter(this, homeworks);
        exercisesRecyclerView.setAdapter(courseRecyclerViewAdapter);
        courseRecyclerViewAdapter.notifyDataSetChanged();

        enterButtonCoursePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer exerciseId = Homework.name2id(exerciseNameInput.getText().toString());

                if (exerciseId == -1){}

                else {

                    // go to exercise page with exerciseId

                }

            }
        });

    }
}