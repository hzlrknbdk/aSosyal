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

public class RVSportyAdapter extends RecyclerView.Adapter<RVSportyAdapter.SportyVievHolder> {

    Context spContext;
    List<CategoryName> spData;
    private LinearLayoutManager layoutManager;
    public String[] spColors = {"#413c0b", "#57500f", "#6c6313", "#827717", "#988b1b", "#ad9f1f", "#c3b322", "#d9c726", "#ddcd3c", "#e0d252"};


    public RVSportyAdapter(Context spContext, List<CategoryName> spData) {
        this.spContext = spContext;
        this.spData = spData;
    }


    @NonNull
    @Override
    public SportyVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(spContext).inflate(R.layout.item_sporty, parent, false);
        SportyVievHolder vHolder = new SportyVievHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SportyVievHolder holder, int position) {
        holder.sportyName.setText(spData.get(position).getName());
        holder.cardView.setCardBackgroundColor(Color.parseColor(spColors[position % 10]));
    }
    public void setLayoutManager(LinearLayoutManager layoutManager) {

        this.layoutManager = layoutManager;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }
    @Override
    public int getItemCount() {
        return spData.size();
    }

    public static class SportyVievHolder extends RecyclerView.ViewHolder {

        private TextView sportyName;
        CardView cardView;

        public SportyVievHolder(@NonNull View itemView) {
            super(itemView);
            sportyName = itemView.findViewById(R.id.sporty_name);
            cardView = itemView.findViewById(R.id.CV_sporty);
        }
    }
}
