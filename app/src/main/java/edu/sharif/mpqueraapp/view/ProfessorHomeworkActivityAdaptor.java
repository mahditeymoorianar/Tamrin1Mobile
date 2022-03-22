package edu.sharif.mpqueraapp.view;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.model.Course;
import edu.sharif.mpqueraapp.model.Homework;
import edu.sharif.mpqueraapp.model.HomeworkAnswer;
import edu.sharif.mpqueraapp.model.Professor;
import edu.sharif.mpqueraapp.view.coursePage.CoursePageRecyclerViewAdapter;
import edu.sharif.mpqueraapp.view.mainPage.student.JoinCourseRecyclerViewAdapter;

public class ProfessorHomeworkActivityAdaptor extends RecyclerView.Adapter<ProfessorHomeworkActivityAdaptor.ViewHolder> {

    private List<HomeworkAnswer> answers;
    private LayoutInflater inflater;

    public ProfessorHomeworkActivityAdaptor(Context context, List<HomeworkAnswer> answers) {
        this.answers = answers;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ProfessorHomeworkActivityAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProfessorHomeworkActivityAdaptor.ViewHolder(inflater.inflate(R.layout.fragment_course_recycler_view_item, parent
                , false));
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessorHomeworkActivityAdaptor.ViewHolder holder, int position) {
        if (getItemCount() != 0){
            holder.studentId.setText(answers.get(position).studentId);
            holder.grade.setText(answers.get(position).grade);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView studentId;
        TextView grade;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentId = itemView.findViewById(R.id.courseName);
            grade = itemView.findViewById(R.id.profName);
        }

    }

}