package edu.sharif.mpqueraapp.view.authentication.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import edu.sharif.mpqueraapp.R;

public class ProfSignUpTabFragment extends Fragment {

    EditText username;
    EditText password;
    EditText confirmPass;
    EditText university;
    Button button;

    float v = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.prof_signup_tab_fragment, container, false);

        username = root.findViewById(R.id.username);
        password = root.findViewById(R.id.password);
        confirmPass = root.findViewById(R.id.confirmpassword);
        university = root.findViewById(R.id.university);
        button = root.findViewById(R.id.login);

        username.setAlpha(v);
        password.setAlpha(v);
        confirmPass.setAlpha(v);
        university.setAlpha(v);
        button.setAlpha(v);


        username.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        password.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        confirmPass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        university.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        button.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(850).start();

        return root;
    }
}
