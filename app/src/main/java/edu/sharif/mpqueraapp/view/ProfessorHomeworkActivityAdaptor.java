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

    LayoutInflater layoutInflater;
    List<HomeworkAnswer> answers;

    public ProfessorHomeworkActivityAdaptor(Context context, List<HomeworkAnswer> answers) {
        this.layoutInflater = LayoutInflater.from(context);
        this.answers = answers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(layoutInflater.inflate(R.layout.item,
                parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (getItemCount() != 0) {
            holder.studentId.setText(answers.get(position).studentId+"");

        }

    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView studentId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            studentId = itemView.findViewById(R.id.itemTextView);
        }


    }

}