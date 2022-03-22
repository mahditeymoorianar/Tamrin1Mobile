package edu.sharif.mpqueraapp.view.coursePage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.StudentHomeworkActivity;
import edu.sharif.mpqueraapp.model.Homework;


public class CoursePageRecyclerViewAdapter extends RecyclerView.Adapter<CoursePageRecyclerViewAdapter.ViewHolder> {

    LayoutInflater layoutInflater;
    List<Homework> exercises;

    public CoursePageRecyclerViewAdapter(Context context, List<Homework> exercises) {
        this.layoutInflater = LayoutInflater.from(context);
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(layoutInflater.inflate(R.layout.item, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (getItemCount() != 0) {
            holder.courseName.setText(exercises.get(position).title); // kolliat chetore dar in vaziat ke

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView courseName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.itemTextView);
        }


    }
}