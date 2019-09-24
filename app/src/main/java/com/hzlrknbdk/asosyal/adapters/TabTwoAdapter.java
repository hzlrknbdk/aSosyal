package com.hzlrknbdk.asosyal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.model.OrganizationDetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TabTwoAdapter extends RecyclerView.Adapter<TabTwoAdapter.TabTwoViewHolder> {
    Context context;
    ArrayList<OrganizationDetails> organizationDetailsList;

    public TabTwoAdapter(Context c, ArrayList<OrganizationDetails> organizationDetails) {
        this.context = c;
        this.organizationDetailsList = organizationDetails;
    }

    @NonNull
    @Override
    public TabTwoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tabtwo, parent, false);
        TabTwoViewHolder vh = null;
        vh = new TabTwoViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TabTwoViewHolder holder, int position) {
        holder.organizationName.setText(organizationDetailsList.get(position).getOrganizationName());
        holder.organizer.setText(organizationDetailsList.get(position).getOrganizer());
        holder.city.setText(organizationDetailsList.get(position).getCity());
        holder.school.setText(organizationDetailsList.get(position).getSchool());
        Picasso.get().load(organizationDetailsList.get(position).getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return organizationDetailsList.size();
    }

    class TabTwoViewHolder extends RecyclerView.ViewHolder {


        private TextView organizationName, organizer, city, school;
        private ImageView image;

        public TabTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            organizationName = itemView.findViewById(R.id.organizationName);
            organizer = itemView.findViewById(R.id.organizer);
            city = itemView.findViewById(R.id.city);
            school = itemView.findViewById(R.id.school);
            image = itemView.findViewById(R.id.image);
        }
    }
}
