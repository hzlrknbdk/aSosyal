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

public class TabOneAdapter extends RecyclerView.Adapter<TabOneAdapter.TabOneViewHolder> {
    Context context;
    ArrayList<OrganizationDetails> organizationDetailsList;

    public TabOneAdapter(Context c, ArrayList<OrganizationDetails> organizationDetails) {
        this.context = c;
        this.organizationDetailsList = organizationDetails;
    }

    @NonNull
    @Override
    public TabOneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tabone, parent, false);
        TabOneViewHolder vh = null;
        vh = new TabOneViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TabOneViewHolder holder, int position) {
        holder.organizationName.setText(organizationDetailsList.get(position).getOrganizationName());
        holder.organizer.setText(organizationDetailsList.get(position).getOrganizer());
        holder.city.setText(organizationDetailsList.get(position).getCity());
        holder.date.setText(organizationDetailsList.get(position).getDate());
        Picasso.get().load(organizationDetailsList.get(position).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return organizationDetailsList.size();
    }

    class TabOneViewHolder extends RecyclerView.ViewHolder {

        private TextView organizationName, organizer, city, date;
        private ImageView image;

        public TabOneViewHolder(@NonNull View itemView) {
            super(itemView);
            organizationName = itemView.findViewById(R.id.organizationName);
            organizer = itemView.findViewById(R.id.organizer);
            city = itemView.findViewById(R.id.city);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
        }
    }
}
