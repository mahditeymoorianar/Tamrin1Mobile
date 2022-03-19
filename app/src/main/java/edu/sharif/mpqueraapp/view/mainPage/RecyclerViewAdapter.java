package edu.sharif.mpqueraapp.view.mainPage;

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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    LayoutInflater layoutInflater;
    List<Course> courses;

    public RecyclerViewAdapter(Context context, List<Course> courses) {
        this.layoutInflater = LayoutInflater.from(context);
        this.courses = courses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(layoutInflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (getItemCount() != 0) {
            holder.courseName.setText(courses.get(position).courseName);

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView courseName;
//        OneNoteListener oneNoteListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            courseName = itemView.findViewById(R.id.itemTextView);
        }

    }
}