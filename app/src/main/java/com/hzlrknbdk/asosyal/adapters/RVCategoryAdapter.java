package com.hzlrknbdk.asosyal.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.model.CategoryName;

import java.util.List;

public class RVCategoryAdapter extends RecyclerView.Adapter<RVCategoryAdapter.CategoryViewHolder> {

    Context mContext;
    List<CategoryName> mData;
    private LinearLayoutManager layoutManager;
    public String[] mColors = {"#9ccc65", "#ffa726", "#ab47bc", "#f06292"};

    public RVCategoryAdapter(Context mContext, List<CategoryName> mData) {
        this.mContext = mContext;
        this.mData = mData;
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

        holder.category_name.setText(mData.get(position).getName());
        holder.itemView.setBackgroundColor(Color.parseColor(mColors[position % 4]));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setLayoutManager(LinearLayoutManager layoutManager) {

        this.layoutManager = layoutManager;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView category_name;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.category_name);
        }
    }

}
