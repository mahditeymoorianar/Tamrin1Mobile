package edu.sharif.mpqueraapp.view.mainPage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.sharif.mpqueraapp.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter {


    Context context;
    ArrayList arrayList;

    public RecyclerViewAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);

        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolderClass viewHolderClass = (ViewHolderClass) holder;
        viewHolderClass.textView.setText(arrayList.get(position).toString());
        viewHolderClass.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        TextView textView;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.itemTextView);
        }
    }
}
