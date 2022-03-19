package edu.sharif.mpqueraapp.view.mainPage;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.mainPage.CourseController;
import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.model.User;
import edu.sharif.mpqueraapp.view.coursePage.CoursePageActivity;
import edu.sharif.mpqueraapp.view.mainPage.student.JoinCourseActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        Log.d(TAG, "onCreate: " + user);
        Professor professor = gson.fromJson(user, new TypeToken<Professor>(){}.getType());

        createButton = findViewById(R.id.createButton);
        editTextCourseName = findViewById(R.id.editTextCourseName);
        statusCreateCourse = findViewById(R.id.statusCreateCourse);

        createButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (editTextCourseName.getText() != null) {
                    String response = CourseController
                            .createNewCourseCheck(professor.username, editTextCourseName.getText()
                                    .toString());
                    if (!response.equals("success")) {
                        statusCreateCourse.setText(response);
                    } else {

                        Intent goToCoursePageIntent = new Intent(CreateCourseActivity.this
                                , CoursePageActivity.class);
                        Gson gson = new Gson();
                        String json = gson.toJson(Course.activeCourse);
                        goToCoursePageIntent.putExtra("course", json);
                        startActivity(goToCoursePageIntent);

                    }
                } else {
                    statusCreateCourse.setText("Enter course name first!");
                }
            }
        });

    }
}