package edu.sharif.mpqueraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.Student;

public class ScoreGivingActivity extends AppCompatActivity {
    public static Homework homework;
    public static int studentId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_giving);
        ((TextView) findViewById(R.id.studentsNameTextView)).setText
                (Student.getStudentById(studentId).name+" "+
                Student.getStudentById(studentId).lastName+" : "+
                studentId);
        ((TextView) findViewById(R.id.studentsAnswerTextView)).setText(homework.getStudentsAnswer(studentId).answer);
        if (homework.getStudentsAnswer(studentId).grade != -1)
            ((EditText) findViewById(R.id.gradeEditText)).setText(homework.getStudentsAnswer(studentId).grade);
        ((Button) findViewById(R.id.submitScore)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homework.getStudentsAnswer(studentId).grade = Integer.parseInt(((EditText) findViewById(R.id.gradeEditText)).getText().toString());
            }
        });
    }
}