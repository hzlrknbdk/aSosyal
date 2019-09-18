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

public class RVCategoryAdapter extends RecyclerView.Adapter<RVCategoryAdapter.CategoryViewHolder> {

    Context mContext;
    List<CategoryInformation> categoryInformationList;
    private LinearLayoutManager layoutManager;

    public RVCategoryAdapter(Context mContext, List<CategoryInformation> categoryInformations) {
        this.mContext = mContext;
        this.categoryInformationList = categoryInformations;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_institutions, parent, false);
        CategoryViewHolder vHolder = new CategoryViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
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

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView icon;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.institutions_name);
            icon = itemView.findViewById(R.id.institutions_icon);


        }
    }

}
