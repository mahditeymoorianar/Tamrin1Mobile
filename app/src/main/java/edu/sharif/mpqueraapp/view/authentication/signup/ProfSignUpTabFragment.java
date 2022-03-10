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
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.view.MainPageActivity;

public class ProfSignUpTabFragment extends Fragment {

    EditText username;
    EditText name;
    EditText lastname;
    TextInputEditText password;
    TextInputEditText confirmPass;
    EditText university;
    Button button;
    TextView status;


    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.prof_signup_tab_fragment, container, false);

        username = root.findViewById(R.id.username);
        name = root.findViewById(R.id.name);
        lastname = root.findViewById(R.id.lastname);
        password = root.findViewById(R.id.password);
        confirmPass = root.findViewById(R.id.confirm_password);
        university = root.findViewById(R.id.university);
        button = root.findViewById(R.id.signup);
        status = root.findViewById(R.id.status);

        username.setAlpha(v);
        name.setAlpha(v);
        lastname.setAlpha(v);
        password.setAlpha(v);
        confirmPass.setAlpha(v);
        university.setAlpha(v);
        button.setAlpha(v);


        username.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        name.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        lastname.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        password.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        confirmPass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        university.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(750).start();
        button.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(750).start();

        button.setOnClickListener(v -> {
            String state = AuthController.SignUpCheck(username.getText().toString(),
                    password.getText().toString(), confirmPass.getText().toString()
                    , name.getText().toString(), lastname.getText().toString(),
                    university.getText().toString(), 1);
            if (state.equals("")){
                Intent intent = new Intent(getActivity(), MainPageActivity.class);
                Gson gson = new Gson();
                String json = gson.toJson(Professor.activeProf);
                intent.putExtra("user", json);
                intent.putExtra("role", "p");
                startActivity(intent);
            }
            else{
                status.setText(state);
            }

        });

        return root;
    }
}
