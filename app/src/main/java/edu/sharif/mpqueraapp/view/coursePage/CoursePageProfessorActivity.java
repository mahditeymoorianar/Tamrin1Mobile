package edu.sharif.mpqueraapp.view.coursePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.sharif.mpqueraapp.view.coursePage.homework.HomeworkCreateActivity;
import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.data.Load;
import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedList;

public class CoursePageProfessorActivity extends AppCompatActivity {


    TextInputEditText exerciseNameInput;
    Button enterButtonCoursePage;
    RecyclerView exercisesRecyclerView;
    CoursePageRecyclerViewAdapter courseRecyclerViewAdapter;
    TextView profNameTextView;
    FloatingActionButton addHomeworkButtonProf;

    Course course;
    Professor professor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page_professor);

        Gson gson = new Gson();
        Intent intent = getIntent();
        String userJson = intent.getStringExtra("user");
        String courseJson = intent.getStringExtra("course");
        course = gson.fromJson(courseJson, new TypeToken<Course>(){}.getType());
        professor = gson.fromJson(userJson, new TypeToken<Professor>(){}.getType());
        System.out.println(userJson+"\n-----------\n"+courseJson);
        LinkedList<Homework> homeworks = new LinkedList<>();



        Load.loadHomeworks(AuthActivity.mPrefs);
        Load.loadHomeworksAnswers(AuthActivity.mPrefs);

        System.out.println(course.homeworksIds.toString());

        System.out.println("courses: ");
        for (Course course : Course.courses) {

            System.out.println(course.courseName + " " + course.id);

        }
        System.out.println("courseIds: ");
        System.out.println(Course.coursesIds.toString());


        for (Integer homeworkId : course.homeworksIds) {
            homeworks.add(Homework.getHomeworkById(homeworkId));
        }

        exerciseNameInput = findViewById(R.id.exerciseNameInput);
        enterButtonCoursePage = findViewById(R.id.enterButtonCoursePage);
        exercisesRecyclerView = findViewById(R.id.exercisesRecyclerView);
        profNameTextView = findViewById(R.id.profNameTextView);
        addHomeworkButtonProf = findViewById(R.id.addHomeworkButtonProf);

        profNameTextView.setText(Professor.getProfById(course.profId).name.toString());

        exercisesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseRecyclerViewAdapter = new CoursePageRecyclerViewAdapter(this, homeworks);
        exercisesRecyclerView.setAdapter(courseRecyclerViewAdapter);
        courseRecyclerViewAdapter.notifyDataSetChanged();


        addHomeworkButtonProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeworkCreateActivity.homework = null;
                HomeworkCreateActivity.courseId = course.id;
                Intent goToAddHomeworkActivity = new Intent(CoursePageProfessorActivity.this
                        , HomeworkCreateActivity.class);
                Gson gson = new Gson();
                String courseJson = gson.toJson(course);
                String userJson = gson.toJson(professor);
                System.out.println("addHomework coursePageProfessor course is : " + courseJson);
                System.out.println("addHomework coursePageProfessor user is : " + userJson);
                goToAddHomeworkActivity.putExtra("course", courseJson);
                goToAddHomeworkActivity.putExtra("user", userJson);
                startActivity(goToAddHomeworkActivity);
            }
        });


        enterButtonCoursePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer exerciseId = Homework.name2id(exerciseNameInput.getText().toString());

                if (exerciseId == -1){}

                else {
//                    StudentHomeworkFragment.homework = Homework.getHomeworkById(exerciseId);
                    HomeworkCreateActivity.homework = Homework.getHomeworkById(exerciseId);
                    HomeworkCreateActivity.courseId = course.id;
                    Intent goToHomeworkPageProfessor = new Intent(CoursePageProfessorActivity.this
                            , HomeworkCreateActivity.class);
                    Gson gson = new Gson();
                    String courseJson = gson.toJson(course);
                    String userJson = gson.toJson(professor);
                    System.out.println("enterButton coursePageProfessor course is : " + courseJson);
                    System.out.println("enterButton coursePageProfessor user is : " + userJson);
                    goToHomeworkPageProfessor.putExtra("course", courseJson);
                    goToHomeworkPageProfessor.putExtra("user", userJson);
                    startActivity(goToHomeworkPageProfessor);

                }

            }
        });

    }
}