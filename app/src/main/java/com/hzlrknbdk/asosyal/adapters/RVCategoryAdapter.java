package com.hzlrknbdk.asosyal.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.model.CategoryName;

import java.util.List;

public class RVCategoryAdapter extends RecyclerView.Adapter<RVCategoryAdapter.CategoryViewHolder> {

    Context mContext;
    List<CategoryName> mData;
    private LinearLayoutManager layoutManager;

    //  public String[] mColors = {"#ba68c8", "#9575cd", "#7986cb", "#4fc3f7", "#4db6ac", "#81c784", "#aed581", "#ffb74d", "#a1887f", "#ffb74d", "#ff8a65", "#a1887f", "#90a4ae"};

   // public String[] mColors = {"#925807","#aa6708", "#c37509", "#db840a", "#f4930b", "#f49c1e", "#f59e24", "#f6a83c", "#f7b355", "#f8be6d"};


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
      //  holder.cardView.setCardBackgroundColor(Color.parseColor(mColors[position % 9]));

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
      //  CardView cardView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.category_name);
          //  cardView = itemView.findViewById(R.id.cardView);

        }
    }

}
