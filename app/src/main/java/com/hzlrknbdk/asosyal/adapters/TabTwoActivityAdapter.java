package com.hzlrknbdk.asosyal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.model.OrganizationDetails;

import java.util.ArrayList;

public class TabTwoActivityAdapter extends RecyclerView.Adapter<TabTwoActivityAdapter.TabTwoActivityViewHolder> {
    Context context;
    ArrayList<OrganizationDetails> organizationDetailsList;

    public TabTwoActivityAdapter(Context context, ArrayList<OrganizationDetails> organizationDetailsList) {
        this.context = context;
        this.organizationDetailsList = organizationDetailsList;
    }

    @NonNull
    @Override
    public TabTwoActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_tabtwo, parent, false);
        TabTwoActivityViewHolder vh = null;
        vh = new TabTwoActivityViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TabTwoActivityViewHolder holder, int position) {
        holder.organizationName.setText(organizationDetailsList.get(position).getOrganizationName());
        holder.organizer.setText(organizationDetailsList.get(position).getOrganizer());
        holder.date.setText(organizationDetailsList.get(position).getDate());
        holder.place.setText(organizationDetailsList.get(position).getPlace());
        holder.clock.setText(organizationDetailsList.get(position).getClock());
    }

    @Override
    public int getItemCount() {
        return organizationDetailsList.size();
    }

    class TabTwoActivityViewHolder extends RecyclerView.ViewHolder {
        private TextView organizationName, organizer, date, place, clock;

        public TabTwoActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            organizationName = itemView.findViewById(R.id.orgName);
            organizer = itemView.findViewById(R.id.Organizer);
            date = itemView.findViewById(R.id.Date);
            place = itemView.findViewById(R.id.Place);
            clock = itemView.findViewById(R.id.clock);

        }
    }
}
