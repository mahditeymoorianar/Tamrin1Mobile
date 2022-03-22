package edu.sharif.mpqueraapp.view.coursePage.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.LinkedList;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.HomeworkAnswer;
import edu.sharif.mpqueraapp.view.ProfessorHomeworkActivityAdaptor;

public class ShowHomeworkAnswersActivity extends AppCompatActivity {

    public static int homeworkId;
    RecyclerView answersRecyclerView;
    ProfessorHomeworkActivityAdaptor adapter;

    LinkedList<HomeworkAnswer> homeworkAnswers = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_homework_answers);


        answersRecyclerView = findViewById(R.id.studentsAnswersRecyclerView);
        answersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        LinkedList<Integer> homeworkAnsIds = Homework.homeworksIds.get(homeworkId).answersIds;
        for (Integer homeworkAnsId : homeworkAnsIds) {
            homeworkAnswers.add(HomeworkAnswer.answersIds.get(homeworkAnsId));
        }

        adapter = new ProfessorHomeworkActivityAdaptor(this, homeworkAnswers);
        answersRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        ImageButton imageButton = findViewById(R.id.searchImageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int studentId = Integer.parseInt(((EditText) findViewById(R.id.studentIdEditText)).getText().toString());
                Intent intent = new Intent(ShowHomeworkAnswersActivity.this, ScoreGivingActivity.class);
                startActivity(intent);
            }
        });
    }
}