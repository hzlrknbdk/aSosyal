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

public class RVScientificAdapter extends RecyclerView.Adapter<RVScientificAdapter.ScientificViewHolder> {
    Context sContext;
    List<CategoryName> sData;
    private LinearLayoutManager layoutManager;

    public String[] sColors = {"#413c0b", "#57500f", "#6c6313", "#827717", "#988b1b", "#ad9f1f", "#c3b322", "#d9c726", "#ddcd3c", "#e0d252"};


    public RVScientificAdapter(Context sContext, List<CategoryName> sData) {
        this.sContext = sContext;
        this.sData = sData;
    }

    @NonNull
    @Override
    public ScientificViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(sContext).inflate(R.layout.item_scientific, parent, false);
        ScientificViewHolder vHolder = new ScientificViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScientificViewHolder holder, int position) {
        holder.scientificName.setText(sData.get(position).getName());
        holder.cardView.setCardBackgroundColor(Color.parseColor(sColors[position % 10]));
    }

    @Override
    public int getItemCount() {
        return sData.size();
    }

    public void setLayoutManager(LinearLayoutManager layoutManager) {

        this.layoutManager = layoutManager;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

    public static class ScientificViewHolder extends RecyclerView.ViewHolder {

        private TextView scientificName;
        CardView cardView;


        public ScientificViewHolder(@NonNull View itemView) {
            super(itemView);

            scientificName = itemView.findViewById(R.id.scientific_name);
            cardView = itemView.findViewById(R.id.CV_scientific);
        }
    }
}
