package edu.sharif.mpqueraapp.view.mainPage.student;

import androidx.annotation.NonNull;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.model.Course;

public class JoinCourseRecyclerViewAdapter extends RecyclerView.Adapter<JoinCourseRecyclerViewAdapter.ViewHolder>{

    private List<Course> courses;
    private LayoutInflater inflater;

    public JoinCourseRecyclerViewAdapter(Context context, List<Course> courses) {
        this.courses = courses;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.fragment_course_recycler_view_item, parent
                , false));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.courseName.setText(courses.get(position).courseName);
        holder.profName.setText(courses.get(position).profId);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView courseName;
        TextView profName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.courseName);
            profName = itemView.findViewById(R.id.profName);
        }

    }
}
