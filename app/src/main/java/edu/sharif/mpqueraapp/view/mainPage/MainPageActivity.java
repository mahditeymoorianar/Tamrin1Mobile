package edu.sharif.mpqueraapp.view.mainPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedList;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.data.Load;
import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.model.User;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;
import edu.sharif.mpqueraapp.view.coursePage.CoursePageActivity;
import edu.sharif.mpqueraapp.view.coursePage.CoursePageProfessorActivity;
import edu.sharif.mpqueraapp.view.mainPage.student.JoinCourseActivity;


public class MainPageActivity extends AppCompatActivity implements RecyclerViewAdapter.OnNoteListener {

    Professor professor;
    Student student;
    Button searchButtonMainPage;
    TextView nameTextView;
    FloatingActionButton button;
    RecyclerView classesRecyclerView;
    RecyclerViewAdapter adapter;
    EditText exerciseNameInput;

    String role;
    LinkedList<Course> userCourses = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Gson gson = new Gson();
        Intent intent = getIntent();
        role = intent.getStringExtra("role");
        String user = intent.getStringExtra("user");
        System.out.println(user);
        System.out.println("User last id : " + User.lastId);
        System.out.println("Course last id : " + Course.lastCourseId);


        nameTextView = findViewById(R.id.nameTextView);
        button = findViewById(R.id.addHomeworkButton);
        classesRecyclerView = findViewById(R.id.classesRecyclerView);
        searchButtonMainPage = findViewById(R.id.searchButtonMainPage);
        exerciseNameInput = findViewById(R.id.exerciseNameInput);


        if (role.equals("s")) {
            student = gson.fromJson(user, new TypeToken<Student>() {
            }.getType());
            nameTextView.setText("Hello, " + student.name);
//            if (student.courses.size() != 0) {
//                System.out.println("Courses Size");
//                initRecyclerView(student);
//
//            }
            initRecyclerView(student);
        } else {
            professor = gson.fromJson(user, new TypeToken<Professor>() {
            }.getType());
            nameTextView.setText("Hello, " + professor.name);
//            if (professor.courses.size() != 0) {
//                initRecyclerView(professor);
//            }
            initRecyclerView(professor);
        }


        searchButtonMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer courseId = Course.name2id(exerciseNameInput.getText().toString());
                goToCourseActivity(courseId);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (role.equals("s")) {

                    Intent joinCourseIntent = new Intent(MainPageActivity.this
                            , JoinCourseActivity.class);
                    joinCourseIntent.putExtra("user", user);
                    startActivity(joinCourseIntent);

                } else {

                    Intent createClassIntent = new Intent(MainPageActivity.this,
                            CreateCourseActivity.class);
                    createClassIntent.putExtra("user", user);
                    startActivity(createClassIntent);
                }
            }
        });


    }


    private void initRecyclerView(User user) {

        System.out.println("initRecyclerView MainPageActivity **********");
        Load.loadCourses(AuthActivity.mPrefs);
        if (role.equals("s")) {
            System.out.println("Courses Main Page");
            for (Course course : Course.courses) {
                if (course.studentsIds.contains(student.id)) {
                    userCourses.add(course);
                }
            }
        } else {

            for (Course course : Course.courses) {
                if (course.profId == user.id) {
                    userCourses.add(course);
                }
            }
        }

        classesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, userCourses, this);
        classesRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


//        recyclerViewFragment recyclerViewFragment = new recyclerViewFragment(user.courses);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.frameLayout, recyclerViewFragment);
//        fragmentTransaction.commit();

    }


    @Override
    public void onNoteClick(int position) {

//        System.out.println(userCourses.get(position).courseName);

        System.out.println("one item clicked!!");

    }

    public void goToCourseActivity(Integer courseId) {


        if (courseId == -1) {
        } else {

            Course.activeCourse = Course.coursesIds.get(courseId);


            if (role.equals("s")) {

                Intent goToCoursePageIntent = new Intent(MainPageActivity.this
                        , CoursePageActivity.class);
                Gson gson = new Gson();
                String courseJson = gson.toJson(Course.activeCourse);
                goToCoursePageIntent.putExtra("course", courseJson);
                startActivity(goToCoursePageIntent);

            } else {

                Intent goToCoursePageProfessorIntent = new Intent(MainPageActivity.this
                        , CoursePageProfessorActivity.class);
                Gson gson = new Gson();
                String courseJson = gson.toJson(Course.activeCourse);
                String userJson = gson.toJson(Student.activeStudent);
                goToCoursePageProfessorIntent.putExtra("course", courseJson);
                goToCoursePageProfessorIntent.putExtra("user", userJson);
                startActivity(goToCoursePageProfessorIntent);
            }

        }

    }
}