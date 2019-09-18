package com.hzlrknbdk.asosyal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.model.CategoryInformation;

import java.util.List;

public class RVScientificAdapter extends RecyclerView.Adapter<RVScientificAdapter.ScientificViewHolder> {
    Context sContext;
    List<CategoryInformation> sData;
    private LinearLayoutManager layoutManager;


    public RVScientificAdapter(Context sContext, List<CategoryInformation> sData) {
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


        public ScientificViewHolder(@NonNull View itemView) {
            super(itemView);

            scientificName = itemView.findViewById(R.id.scientific_name);
        }
    }
}
