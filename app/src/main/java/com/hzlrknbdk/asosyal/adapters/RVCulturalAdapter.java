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

public class RVCulturalAdapter extends RecyclerView.Adapter<RVCulturalAdapter.CulturalViewHolder> {
    Context cContext;
    List<CategoryName> cData;
    private LinearLayoutManager layoutManager;

    public String[] cColors = {"#8800cc", "#9900e6", "#aa00ff", "#b31aff", "#bb33ff", "#c44dff", "#cc66ff", "#d580ff", "#dd99ff","#e6b3ff","#eeccff"};

    public RVCulturalAdapter(Context cContext, List<CategoryName> cData) {
        this.cContext = cContext;
        this.cData = cData;

    }

    @NonNull
    @Override
    public CulturalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(cContext).inflate(R.layout.item_cultural, parent, false);
        CulturalViewHolder vHolder = new CulturalViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CulturalViewHolder holder, int position) {
        holder.cultural_name.setText(cData.get(position).getName());
        holder.cardView.setCardBackgroundColor(Color.parseColor(cColors[position % 11]));
    }

    public void setLayoutManager(LinearLayoutManager layoutManager) {

        this.layoutManager = layoutManager;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

    @Override
    public int getItemCount() {
        return cData.size();
    }

    public static class CulturalViewHolder extends RecyclerView.ViewHolder {
        private TextView cultural_name;
        CardView cardView;

        public CulturalViewHolder(@NonNull View itemView) {
            super(itemView);
            cultural_name = itemView.findViewById(R.id.cultural_name);
            cardView = itemView.findViewById(R.id.CV_cultural);
        }
    }
}
