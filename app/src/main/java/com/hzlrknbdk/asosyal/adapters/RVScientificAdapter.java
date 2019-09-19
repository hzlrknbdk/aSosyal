package com.hzlrknbdk.asosyal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.model.CategoryInformation;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVScientificAdapter extends RecyclerView.Adapter<RVScientificAdapter.ScientificViewHolder> {
    Context sContext;
    List<CategoryInformation> categoryInformationList;
    private LinearLayoutManager layoutManager;

    public RVScientificAdapter(Context sContext, List<CategoryInformation> categoryInformations) {
        this.sContext = sContext;
        this.categoryInformationList = categoryInformations;
    }

    @NonNull
    @Override
    public ScientificViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scientific, parent, false);
        ScientificViewHolder vh = null;
        vh = new ScientificViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ScientificViewHolder holder, int position) {
        holder.name.setText(categoryInformationList.get(position).getName());
        Picasso.get().load(categoryInformationList.get(position).getImage()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return categoryInformationList.size();
    }

    public void setLayoutManager(LinearLayoutManager layoutManager) {

        this.layoutManager = layoutManager;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

    class ScientificViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView icon;


        public ScientificViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.scientific_name);
            icon = itemView.findViewById(R.id.scientific_icon);

        }
    }
}
