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
import com.hzlrknbdk.asosyal.model.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomePagePostAdapter extends RecyclerView.Adapter<HomePagePostAdapter.HomePagePostViewHolder> {

    Context context;
    ArrayList<Post> postList;

    public HomePagePostAdapter(Context context, ArrayList<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public HomePagePostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_page, parent, false);
        HomePagePostViewHolder vh = null;
        vh = new HomePagePostViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HomePagePostViewHolder holder, int position) {
        holder.name.setText(postList.get(position).getName());
        holder.date.setText(postList.get(position).getDate());
        holder.place.setText(postList.get(position).getPlace());
        holder.organizationName.setText(postList.get(position).getOrganizationName());
        holder.organizationContent.setText(postList.get(position).getOrganizationContent());
        holder.category.setText(postList.get(position).getCategory());
        Picasso.get().load(postList.get(position).getOrganizationImage()).into(holder.organizationImage);
        Picasso.get().load(postList.get(position).getProfileImage()).into(holder.profileImage);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class HomePagePostViewHolder extends RecyclerView.ViewHolder {

        private TextView name, date, place, organizationName, organizationContent, category;
        private ImageView organizationImage, profileImage;

        public HomePagePostViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            place = itemView.findViewById(R.id.place);
            organizationName = itemView.findViewById(R.id.organizationName);
            organizationContent = itemView.findViewById(R.id.organizationContent);
            category = itemView.findViewById(R.id.category);
            organizationImage = itemView.findViewById(R.id.organizationImage);
            profileImage = itemView.findViewById(R.id.profileImage);

        }

    }
}
