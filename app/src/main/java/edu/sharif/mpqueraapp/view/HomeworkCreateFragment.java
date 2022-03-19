package edu.sharif.mpqueraapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeworkCreateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeworkCreateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static Homework homework = null;
    private static int courseId = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeworkCreateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeworkCreateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeworkCreateFragment newInstance(String param1, String param2) {
        HomeworkCreateFragment fragment = new HomeworkCreateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        EditText homeworkTitle = container.findViewById(R.id.newHomeworkTitleTextView);
        EditText homeworkDescription = container.findViewById(R.id.homeworkDescriptionEditText);
        Button button = container.findViewById(R.id.professorSubmitButtonView);
        if (homework != null) {
            homeworkTitle.setText(homework.title);
            homeworkDescription.setText(homework.description);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homework == null) {
                    homework = new Homework(courseId,
                            homeworkTitle.getText().toString(),
                            homeworkDescription.getText().toString());
                    // to save the homework in the database
                    try {
                        Save.saveHomeworks(AuthActivity.mPrefs);
                    } catch (IOException e) {
//                        Toast toast = new Toast("")
                    }
                } else {
                    homework.title = homeworkTitle.getText().toString();
                    homework.description = homeworkDescription.getText().toString();
                    // to save the homework in the database
                    try {
                        Save.saveHomeworks(AuthActivity.mPrefs);
                    } catch (IOException e) {
//                        Toast toast = new Toast("")
                    }
                }
            }
        });
        return inflater.inflate(R.layout.fragment_homework_create, container, false);
    }
}