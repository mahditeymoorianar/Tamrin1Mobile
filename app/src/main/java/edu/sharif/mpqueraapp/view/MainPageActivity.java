package edu.sharif.mpqueraapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;

public class MainPageActivity extends AppCompatActivity {

    Professor professor;
    Student student;

    TextView nameTextView;
    FloatingActionButton button;
    RecyclerView classesRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Gson gson = new Gson();
        Intent intent = getIntent();
        String role = intent.getStringExtra("role");
        String user = intent.getStringExtra("user");


        nameTextView = findViewById(R.id.nameTextView);
        button = findViewById(R.id.addButton);
        classesRecyclerView = findViewById(R.id.classesRecyclerView);


        if (role.equals("s")){
            student = gson.fromJson(user, new TypeToken<Student>(){}.getType());
            nameTextView.setText("Hello, "+ student.name);
        }
        else{
            professor = gson.fromJson(user, new TypeToken<Professor>(){}.getType());
            nameTextView.setText("Hello, "+professor.name);
        }








    }
}