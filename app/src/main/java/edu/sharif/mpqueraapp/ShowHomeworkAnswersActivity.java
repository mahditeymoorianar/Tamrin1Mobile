package edu.sharif.mpqueraapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ShowHomeworkAnswersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_homework_answers);

        RecyclerView recyclerView = findViewById(R.id.studentsAnswersRecyclerView);
//        TODO : Recycler View

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