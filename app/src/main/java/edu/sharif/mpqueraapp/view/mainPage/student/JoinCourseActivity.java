package edu.sharif.mpqueraapp.view.mainPage.student;

import static androidx.fragment.app.FragmentManager.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.LinkedList;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.data.Load;
import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;
import edu.sharif.mpqueraapp.view.coursePage.CoursePageActivity;
import edu.sharif.mpqueraapp.view.mainPage.CreateCourseActivity;

public class JoinCourseActivity extends AppCompatActivity {

    TextInputEditText courseName;
    Button enterButton;
    RecyclerView exercisesRecyclerView;
    JoinCourseRecyclerViewAdapter courseRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_course);

        Gson gson = new Gson();
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        Student student = gson.fromJson(user, new TypeToken<Student>(){}.getType());
        System.out.println(user);

        LinkedList<Course> courses = new LinkedList<>();
        Load.loadCourses(AuthActivity.mPrefs);
        for (Course course : Course.courses) {
            if (!course.studentsIds.contains(student.id)){
                courses.add(course);
            }
        }

        courseName = findViewById(R.id.exerciseNameInput);
        enterButton = findViewById(R.id.enterButtonCoursePage);

        exercisesRecyclerView = findViewById(R.id.exercisesRecyclerView);
        exercisesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseRecyclerViewAdapter = new JoinCourseRecyclerViewAdapter(this, courses);
        exercisesRecyclerView.setAdapter(courseRecyclerViewAdapter);
        courseRecyclerViewAdapter.notifyDataSetChanged();


        enterButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                Integer courseId = Course.name2id(courseName.getText().toString());
                if (courseId == -1){}
                else{
                    Course.coursesIds.get(courseId).studentsIds.add(student.id);
                    student.courses.add(courseId);
                    Course.activeCourse = Course.coursesIds.get(courseId);

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

                    Intent goToCoursePageIntent = new Intent(JoinCourseActivity.this
                            , CoursePageActivity.class);
                    Gson gson = new Gson();
                    String courseJson = gson.toJson(Course.activeCourse);
                    String userJson = gson.toJson(Student.activeStudent);
                    goToCoursePageIntent.putExtra("course", courseJson);
                    goToCoursePageIntent.putExtra("user", userJson);
                    Log.d(TAG, "onClick: !!!!");
                    System.out.println("JoinCourseActivity");
                    System.out.println("user is : " + userJson + "finished");
                    System.out.println("course is : " + courseJson + "finished");
                    startActivity(goToCoursePageIntent);
                }
            }
        });
    }
}