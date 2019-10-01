package com.hzlrknbdk.asosyal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.model.CategoryInformation;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RVArtAdapter extends RecyclerView.Adapter<RVArtAdapter.ArtViewHolder> {

    Context context;
    ArrayList<CategoryInformation> categoryInformationList;

    public RVArtAdapter(Context context, ArrayList<CategoryInformation> categoryInformations) {
        this.context = context;
        this.categoryInformationList = categoryInformations;
    }

    @NonNull
    @Override
    public ArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_art, parent, false);
        ArtViewHolder vh = null;
        vh = new ArtViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtViewHolder holder, int position) {
        holder.name.setText(categoryInformationList.get(position).getName());
        Picasso.get().load(categoryInformationList.get(position).getImage()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return categoryInformationList.size();
    }


    public static class ArtViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView icon;
        public ArtViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.art_name);
            icon = itemView.findViewById(R.id.art_icon);
        }
    }


}
