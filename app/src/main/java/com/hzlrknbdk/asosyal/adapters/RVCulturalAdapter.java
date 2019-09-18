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

public class RVCulturalAdapter extends RecyclerView.Adapter<RVCulturalAdapter.CulturalViewHolder> {

    Context mContext;
    List<CategoryInformation> categoryInformationList;
    private LinearLayoutManager layoutManager;

    public RVCulturalAdapter(Context mContext, List<CategoryInformation> categoryInformations) {
        this.mContext = mContext;
        this.categoryInformationList = categoryInformations;
    }

    @NonNull
    @Override
    public CulturalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cultural, parent, false);
        CulturalViewHolder vh = null;
        vh = new CulturalViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CulturalViewHolder holder, int position) {
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

    class CulturalViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView icon;

        public CulturalViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cultural_name);
            icon = itemView.findViewById(R.id.cultural_icon);

        }
    }
}
