package edu.sharif.mpqueraapp.view;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

import edu.sharif.mpqueraapp.controller.data.Load;
import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.HomeworkAnswer;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.model.User;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;
import edu.sharif.mpqueraapp.view.coursePage.CoursePageActivity;
import edu.sharif.mpqueraapp.view.coursePage.CoursePageProfessorActivity;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.view.coursePage.CoursePageRecyclerViewAdapter;
import edu.sharif.mpqueraapp.view.mainPage.CreateCourseActivity;
import edu.sharif.mpqueraapp.view.mainPage.MainPageActivity;
import edu.sharif.mpqueraapp.view.mainPage.RecyclerViewAdapter;
import edu.sharif.mpqueraapp.view.mainPage.student.JoinCourseActivity;

public class ProfessorHomeworkActivity extends AppCompatActivity {

    Professor professor;
    Student student;
    Homework homework;

    Button searchButtonAnswerProf;
    TextView nameTextViewProf;
    RecyclerView answersRecyclerView;
    ProfessorHomeworkActivityAdaptor adapter;
    EditText answerNameInput;

    LinkedList<HomeworkAnswer> homeworkAnswers = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_homework);

        Gson gson = new Gson();
        Intent intent = getIntent();
        String homeworkJson = intent.getStringExtra("homework");
        homework = gson.fromJson(homeworkJson, new TypeToken<Homework>() {}.getType());
        System.out.println(homeworkJson);


        nameTextViewProf = findViewById(R.id.nameTextViewProf);
        searchButtonAnswerProf = findViewById(R.id.searchButtonAnswerProf);
        answersRecyclerView = findViewById(R.id.answersRecyclerView);
        answerNameInput = findViewById(R.id.answerNameInput);

        nameTextViewProf.setText(homework.title);


        // init recyclerView

        answersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProfessorHomeworkActivityAdaptor(this, homeworkAnswers);
        answersRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        searchButtonAnswerProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer answerId = Integer.parseInt(answerNameInput.getText().toString());

                HomeworkAnswer homeworkAnswer = null;

                // handle the condition that answer id doesn't exist

                Intent goToAnswerPageIntent = new Intent(ProfessorHomeworkActivity.this
                        , CoursePageActivity.class);
                Gson gson = new Gson();
                String answerJson = gson.toJson(homeworkAnswer);
                goToAnswerPageIntent.putExtra("course", answerJson);
                startActivity(goToAnswerPageIntent);

            }
        });

    }

}