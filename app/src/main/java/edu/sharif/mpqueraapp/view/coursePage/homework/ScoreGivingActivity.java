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
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.HomeworkAnswer;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

public class ScoreGivingActivity extends AppCompatActivity {
    public static Homework homework;
    public static int studentId;

    TextView studentName;
    TextView studentAns;
    EditText studentGrade;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_giving);

        studentName = findViewById(R.id.studentsNameTextView);
        studentAns = findViewById(R.id.studentsAnswerTextView);
        studentGrade = findViewById(R.id.gradeEditText);
        submit = findViewById(R.id.submitScore);

        System.out.println();

        studentName.setText(Student.getStudentById(studentId).name);
        studentAns.setText(homework.getStudentsAnswer(studentId).answer);

        if (homework.getStudentsAnswer(studentId).grade != -1){
            studentGrade.setText(homework.getStudentsAnswer(studentId).grade + "");
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeworkAnswer.answersIds.get(homework.getStudentsAnswer(studentId).id).grade
                        = Integer.parseInt(studentGrade.getText().toString());
                System.out.println(homework.getStudentsAnswer(studentId).grade);

                try {
                    Save.saveHomeworksAnswers(AuthActivity.mPrefs);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent backIntent = new Intent(ScoreGivingActivity.this,
                        ShowHomeworkAnswersActivity.class);
                startActivity(backIntent);
            }
        });
    }
}