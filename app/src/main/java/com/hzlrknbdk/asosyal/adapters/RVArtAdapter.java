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

public class RVArtAdapter extends RecyclerView.Adapter<RVArtAdapter.ArtViewHolder> {

    Context aContext;
    List<CategoryName> aData;
    private LinearLayoutManager layoutManager;

    public String[] aColors = {"#683089", "#733597", "#813caa", "#9042bd", "#9b55c3", "#a668ca"};


    public RVArtAdapter(Context aContext, List<CategoryName> aData) {
        this.aContext = aContext;
        this.aData = aData;
    }


    @NonNull
    @Override
    public ArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(aContext).inflate(R.layout.item_art, parent, false);
        ArtViewHolder vHolder = new ArtViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtViewHolder holder, int position) {
        holder.artName.setText(aData.get(position).getName());
        holder.CV_art.setCardBackgroundColor(Color.parseColor(aColors[position % 6]));
    }

    @Override
    public int getItemCount() {
        return aData.size();
    }


    public static class ArtViewHolder extends RecyclerView.ViewHolder {

        private TextView artName;
        CardView CV_art;


        public ArtViewHolder(@NonNull View itemView) {
            super(itemView);
            artName = itemView.findViewById(R.id.art_name);
            CV_art = itemView.findViewById(R.id.CV_art);
        }
    }


}
