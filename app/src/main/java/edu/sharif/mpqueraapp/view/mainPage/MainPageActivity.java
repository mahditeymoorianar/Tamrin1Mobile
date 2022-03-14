package edu.sharif.mpqueraapp.view.mainPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.model.User;


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
            if (student.courses.size() != 0) {
                initRecyclerView(student);
            }
        }
        else{
            professor = gson.fromJson(user, new TypeToken<Professor>(){}.getType());
            nameTextView.setText("Hello, "+professor.name);
            if (professor.courses.size() != 0) {
                initRecyclerView(professor);
            }
        }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                
            }
        });



    }


    private void initRecyclerView(User user){

        recyclerViewFragment recyclerViewFragment = new recyclerViewFragment(user.courses);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, recyclerViewFragment);
        fragmentTransaction.commit();

    }


}