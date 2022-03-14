package edu.sharif.mpqueraapp.view.authentication.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.authentication.AuthController;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.view.mainPage.MainPageActivity;

public class StudentSignUpTabFragment extends Fragment {

    TextView status;
    EditText username;
    EditText name;
    EditText lastname;
    TextInputEditText password;
    TextInputEditText confirmPass;
    EditText studentNum;
    Button button;

    float v = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.student_signup_tab_fragment, container, false);

        username = root.findViewById(R.id.answerText);
        status = root.findViewById(R.id.statusCreateCourse);
        name = root.findViewById(R.id.name);
        lastname = root.findViewById(R.id.lastname);
        password = root.findViewById(R.id.password);
        confirmPass = root.findViewById(R.id.confirm_password);
        studentNum = root.findViewById(R.id.studentId);
        button = root.findViewById(R.id.signup);


        username.setAlpha(v);
        name.setAlpha(v);
        lastname.setAlpha(v);
        password.setAlpha(v);
        confirmPass.setAlpha(v);
        studentNum.setAlpha(v);
        button.setAlpha(v);


        username.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        name.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        lastname.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        password.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        confirmPass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        studentNum.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(750).start();
        button.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(750).start();

        button.setOnClickListener(v -> {
            String state = AuthController.SignUpCheck(username.getText().toString(),
                    password.getText().toString(), confirmPass.getText().toString()
                    , name.getText().toString(), lastname.getText().toString(),
                    studentNum.getText().toString(), 0);
            if (state.equals("")){
                Intent intent = new Intent(getActivity(), MainPageActivity.class);
                Gson gson = new Gson();
                String json = gson.toJson(Student.activeStudent);
                intent.putExtra("user", json);
                intent.putExtra("role","s");
                startActivity(intent);
            }
            else{
                status.setText(state);
            }


        });


        return root;
    }
}
