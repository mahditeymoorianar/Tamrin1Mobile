package edu.sharif.mpqueraapp.view.mainPage;

import androidx.appcompat.app.AppCompatActivity;
import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.mainPage.CourseController;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.User;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

public class CreateCourseActivity extends AppCompatActivity {

    EditText editTextCourseName;
    TextView statusCreateCourse;
    Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);

        Gson gson = new Gson();
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        Professor professor = gson.fromJson(user, new TypeToken<Professor>(){}.getType());

        createButton = findViewById(R.id.createButton);
        editTextCourseName = findViewById(R.id.editTextCourseName);
        statusCreateCourse = findViewById(R.id.statusCreateCourse);

        createButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (editTextCourseName.getText() != null) {
                    String response = CourseController.createNewCourseCheck(professor.username, editTextCourseName.getText().toString());
                    if (!response.equals("success")) {
                        statusCreateCourse.setText(response);
                    }
                } else {
                    statusCreateCourse.setText("Enter course name first!");
                }
            }
        });

    }
}