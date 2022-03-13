package edu.sharif.mpqueraapp.view.authentication.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.authentication.AuthController;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.view.MainPageActivity;

public class LoginTabFragment extends Fragment {

    Button button;
    EditText username;
    SwitchCompat switchCompat;
    TextInputEditText password;
    TextInputLayout layout;
    Button login;
    TextView status;

    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container
                , false);

        username = root.findViewById(R.id.answerText);
        password = root.findViewById(R.id.password);
        switchCompat = root.findViewById(R.id.profSwitch);
        button = root.findViewById(R.id.login);
        status = root.findViewById(R.id.status);

        username.setAlpha(v);
        password.setAlpha(v);
        switchCompat.setAlpha(v);
        button.setAlpha(v);

        username.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        password.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        switchCompat.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(775)
                .start();
        button.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(850).start();

        button.setOnClickListener(v -> {
            String check = "s";
            if (switchCompat.isChecked()){
                check = "p";
            }
            String state = AuthController.loginCheck(username.getText().toString(),
                     password.getText().toString(), check);
            if (state.equals("s") || state.equals("p")){
                Intent intent = new Intent(getActivity(), MainPageActivity.class);
                intent.putExtra("role", state);
                if (switchCompat.isChecked()){
                    Gson gson = new Gson();
                    String json = gson.toJson(Professor.activeProf);
                    intent.putExtra("user", json);
                }
                else{
                    Gson gson = new Gson();
                    String json = gson.toJson(Student.activeStudent);
                    intent.putExtra("user", json);
                }
                startActivity(intent);
            }
            else{
                status.setText(state);
            }

        });
        return root;
    }
}
