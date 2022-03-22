package edu.sharif.mpqueraapp.view.coursePage.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

public class HomeworkCreateActivity extends AppCompatActivity {
    public static Homework homework = null;
    public static int courseId = 0;

    TextView showAnswersTextView;
    EditText homeworkDescription;
    Button button;
    EditText homeworkTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_create);


        System.out.println("Homework create course is : " + Course.coursesIds.get(courseId).toString());


        homeworkTitle = findViewById(R.id.newHomeworkTitleTextView);
         homeworkDescription = findViewById(R.id.homeworkDescriptionEditText);
         button = findViewById(R.id.professorSubmitButtonView);
        if (homework != null) {
            homeworkTitle.setText(homework.title);
            homeworkDescription.setText(homework.description);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homework == null) {
                    homework = new Homework(courseId,
                            homeworkTitle.getText().toString(),
                            homeworkDescription.getText().toString());
                    // to save the homework in the database
                    try {
                        Save.saveHomeworks(AuthActivity.mPrefs);
                        Save.saveCourses(AuthActivity.mPrefs);
                    } catch (IOException e) {
                        e.printStackTrace();
//                        Toast toast = new Toast("")
                    }
                    System.out.println("Homework create course is : " + Course.coursesIds.get(courseId).toString());
                } else {
                    homework.title = homeworkTitle.getText().toString();
                    homework.description = homeworkDescription.getText().toString();
                    // to save the homework in the database
                    try {
                        Save.saveHomeworks(AuthActivity.mPrefs);
                        Save.saveCourses(AuthActivity.mPrefs);
                    } catch (IOException e) {
//                        Toast toast = new Toast("")
                        e.printStackTrace();
                    }
                }
            }
        });

        showAnswersTextView = findViewById(R.id.showAnswersTextView);
        showAnswersTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToShowHomeworkAnswers = new Intent(HomeworkCreateActivity.this, ShowHomeworkAnswersActivity.class);
                ShowHomeworkAnswersActivity.homeworkId = homework.id;
                startActivity(goToShowHomeworkAnswers);
            }
        });
    }
}