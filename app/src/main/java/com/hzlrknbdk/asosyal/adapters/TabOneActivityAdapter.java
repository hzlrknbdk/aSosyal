package com.hzlrknbdk.asosyal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.model.CourseDetails;

import java.util.ArrayList;

public class TabOneActivityAdapter extends RecyclerView.Adapter<TabOneActivityAdapter.TabOneActivityViewHolder> {
    Context context;
    ArrayList<CourseDetails> courseDetailsList;

    public TabOneActivityAdapter(Context context, ArrayList<CourseDetails> courseDetailsList) {
        this.context = context;
        this.courseDetailsList = courseDetailsList;
    }

    @NonNull
    @Override
    public TabOneActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_tabone, parent, false);
        TabOneActivityViewHolder vh = null;
        vh = new TabOneActivityViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TabOneActivityViewHolder holder, int position) {
        holder.workplaceName.setText(courseDetailsList.get(position).getWorkplaceName());
        holder.time.setText(courseDetailsList.get(position).getTime());
        holder.courseType.setText(courseDetailsList.get(position).getCourseType());
        holder.price.setText(courseDetailsList.get(position).getPrice());
        holder.city.setText(courseDetailsList.get(position).getCity());
    }

    @Override
    public int getItemCount() {
        return courseDetailsList.size();
    }

    class TabOneActivityViewHolder extends RecyclerView.ViewHolder {

        TextView workplaceName, time, courseType, price, city;

        public TabOneActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            workplaceName = itemView.findViewById(R.id.workplace_name);
            time = itemView.findViewById(R.id.time);
            courseType = itemView.findViewById(R.id.course_type);
            price = itemView.findViewById(R.id.price);
            city = itemView.findViewById(R.id.city);
        }
    }
}
