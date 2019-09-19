package com.hzlrknbdk.asosyal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.model.CategoryInformation;

import java.util.ArrayList;

public class RVCommunityAdapter extends RecyclerView.Adapter<RVCommunityAdapter.CommunityServiceVievHolder> {
    Context csaContext;
    ArrayList<CategoryInformation> categoryInformationList;

    public RVCommunityAdapter(Context csaContext, ArrayList<CategoryInformation> categoryInformations) {
        this.csaContext = csaContext;
        this.categoryInformationList = categoryInformations;
    }

    @NonNull
    @Override
    public CommunityServiceVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_csa, parent, false);
        CommunityServiceVievHolder vh = null;
        vh = new CommunityServiceVievHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityServiceVievHolder holder, int position) {
        holder.name.setText(categoryInformationList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categoryInformationList.size();
    }

    public static class CommunityServiceVievHolder extends RecyclerView.ViewHolder {
        TextView name;


        public CommunityServiceVievHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.csa_name);
        }
    }

}
