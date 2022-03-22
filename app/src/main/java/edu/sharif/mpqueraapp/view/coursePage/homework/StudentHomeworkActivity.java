package edu.sharif.mpqueraapp.view.coursePage.homework;

import static androidx.fragment.app.FragmentManager.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.IOException;
import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.HomeworkAnswer;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

public class StudentHomeworkActivity extends AppCompatActivity {

    public static HomeworkAnswer homeworkAnswer = null;
    public static Homework homework = null;
    public static Student student;

    // TODO: Rename parameter argument
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_homework);

        //        TODO : show the title of the homework
        student = Student.activeStudent;
        homeworkAnswer = homework.getStudentsAnswer(student.id);
        TextView titleTextView = (TextView) findViewById(R.id.homeworkTitleTextView);
        if (homework != null) {
            titleTextView.setText(homework.title);
        } else {
            Log.e(TAG, "onCreateView: StudentHomeworkFragment : public static Homework" +
                            " homework : is null",
                    new Exception("StudentHomeworkFragment : public static Homework homework " +
                            ": is null"));
        }

        EditText answer = findViewById(R.id.answerTextEditView);
//       show the student's current answer if not null
        if (homeworkAnswer != null) {
            answer.setText(homeworkAnswer.answer);
        }
        Button submitButton = (Button) findViewById(R.id.submitHomeworkAnswer);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                if (homeworkAnswer == null) {
                    homeworkAnswer = new HomeworkAnswer(student.id, homework.id, answer.getText().toString());
                    student.homeworkAnswers.add(homeworkAnswer.id);
//
                } else {
                    homeworkAnswer.answer = answer.getText().toString();
                }
                // save the homeworkAnswer
                try {
                    Save.saveHomeworks(AuthActivity.mPrefs);
                    Save.saveCourses(AuthActivity.mPrefs);
                    Save.saveHomeworks(AuthActivity.mPrefs);
                    Save.saveHomeworksAnswers(AuthActivity.mPrefs);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String answerText = answer.getText().toString();
                if (answerText.equals("")) {
                    Log.e(TAG, "onCreateView: StudentHomeworkFragment : answer is empty",
                            new Exception("StudentHomeworkFragment : answer is empty"));
                }
                homeworkAnswer.answer = answerText;
            }
        });

        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeworkAnswer.delete();
            }
        });
    }
}