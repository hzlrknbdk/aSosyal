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

public class RVSportyAdapter extends RecyclerView.Adapter<RVSportyAdapter.SportyViewHolder> {
    Context context;
    ArrayList<CategoryInformation> categoryInformationList;

    public RVSportyAdapter(Context c, ArrayList<CategoryInformation> categoryInformations) {
        context = c;
        categoryInformationList = categoryInformations;

    }

    @NonNull
    @Override
    public SportyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sporty, parent, false);
        SportyViewHolder vh = null;
        vh = new SportyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SportyViewHolder holder, int position) {
        holder.name.setText(categoryInformationList.get(position).getName());
        Picasso.get().load(categoryInformationList.get(position).getImage()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return categoryInformationList.size();
    }

    class SportyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView icon;

        public SportyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.sporty_name);
            icon = itemView.findViewById(R.id.sporty_icon);
        }
    }
}
