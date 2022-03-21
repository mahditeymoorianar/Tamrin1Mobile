package edu.sharif.mpqueraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

public class HomeworkCreateActivity extends AppCompatActivity {
    public static Homework homework = null;
    public static int courseId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_create);

        EditText homeworkTitle = findViewById(R.id.newHomeworkTitleTextView);
        EditText homeworkDescription = findViewById(R.id.homeworkDescriptionEditText);
        Button button = findViewById(R.id.professorSubmitButtonView);
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
                    } catch (IOException e) {
                        e.printStackTrace();
//                        Toast toast = new Toast("")
                    }
                } else {
                    homework.title = homeworkTitle.getText().toString();
                    homework.description = homeworkDescription.getText().toString();
                    // to save the homework in the database
                    try {
                        Save.saveHomeworks(AuthActivity.mPrefs);
                    } catch (IOException e) {
//                        Toast toast = new Toast("")
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}