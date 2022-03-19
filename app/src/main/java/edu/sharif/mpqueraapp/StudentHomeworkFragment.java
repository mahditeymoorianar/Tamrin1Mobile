package edu.sharif.mpqueraapp;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import edu.sharif.mpqueraapp.controller.data.Save;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.HomeworkAnswer;
import edu.sharif.mpqueraapp.model.Student;
import edu.sharif.mpqueraapp.view.authentication.AuthActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentHomeworkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentHomeworkFragment extends Fragment {
    public static HomeworkAnswer homeworkAnswer = null;
    public static Homework homework = null;
    public static Student student;
    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public StudentHomeworkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment StudentHomeworkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentHomeworkFragment newInstance(/*String param1, String param2*/) {
        StudentHomeworkFragment fragment = new StudentHomeworkFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        TODO : show the title of the homework
        student = Student.activeStudent;
        homeworkAnswer = homework.getStudentsAnswer(student.id);
        TextView titleTextView = (TextView) container.findViewById(R.id.homeworkTitleTextView);
        if (homework != null) {
            titleTextView.setText(homework.title);
        } else {
            Log.e(TAG, "onCreateView: StudentHomeworkFragment : public static Homework homework : is null",
                    new Exception("StudentHomeworkFragment : public static Homework homework : is null"));
        }

        EditText answer = container.findViewById(R.id.answerTextEditView);
//       show the student's current answer if not null
        if (homeworkAnswer != null) {
            answer.setText(homeworkAnswer.answer);
        }
        Button submitButton = (Button) container.findViewById(R.id.submitHomeworkAnswer);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (homeworkAnswer == null) {
                    homeworkAnswer = new HomeworkAnswer(student.id, homework.id, answer.getText().toString());
//                  save the homeworkAnswer
                    try {
                        Save.saveHomeworks(AuthActivity.mPrefs);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                String answerText = answer.getText().toString();
                if (answerText.equals("")) {
                    Log.e(TAG, "onCreateView: StudentHomeworkFragment : answer is empty",
                            new Exception("StudentHomeworkFragment : answer is empty"));
                }
                homeworkAnswer.answer = answerText;
            }
        });

        Button deleteButton = (Button) container.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeworkAnswer.delete();
            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_homework, container, false);
    }
}