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
import edu.sharif.mpqueraapp.model.User;
import edu.sharif.mpqueraapp.view.mainPage.student.JoinCourseActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    LayoutInflater layoutInflater;
    List<Course> courses;
    Context mContext;
    String userString;
    String role;
    private OnNoteListener mOnNoteListener;

    public RecyclerViewAdapter(Context context, List<Course> courses, OnNoteListener onNoteListener,
                               String role, String userString) {
        this.layoutInflater = LayoutInflater.from(context);
        this.courses = courses;
        this.mContext = context;
        this.role = role;
        this.userString = userString;
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item, parent,
                false), mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (getItemCount() != 0) {
            holder.courseName.setText(courses.get(position).courseName);

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (role.equals("s")) {

                    Intent joinCourseIntent = new Intent(mContext
                            , JoinCourseActivity.class);
                    joinCourseIntent.putExtra("user", userString);
                    mContext.startActivity(joinCourseIntent);

                } else {

                    Intent createClassIntent = new Intent(mContext,
                            CreateCourseActivity.class);
                    createClassIntent.putExtra("user", userString);
                    mContext.startActivity(createClassIntent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView courseName;
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);

            courseName = itemView.findViewById(R.id.itemTextView);
            this.onNoteListener = onNoteListener;

        }

        @Override
        public void onClick(View view) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }


    public interface OnNoteListener {
        void onNoteClick(int position);

    }
}