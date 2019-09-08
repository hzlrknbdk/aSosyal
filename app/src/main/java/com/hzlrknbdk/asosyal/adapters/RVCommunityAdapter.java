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

public class RVCommunityAdapter extends RecyclerView.Adapter<RVCommunityAdapter.CommunityServiceVievHolder> {
    Context csaContext;
    List<CategoryName> csaData;
    private LinearLayoutManager layoutManager;

    public String[] csaColors = {"#683089", "#733597", "#813caa", "#9042bd", "#9b55c3", "#a668ca"};

    public RVCommunityAdapter(Context csaContext, List<CategoryName> csaData) {
        this.csaContext = csaContext;
        this.csaData = csaData;
    }

    @NonNull
    @Override
    public CommunityServiceVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(csaContext).inflate(R.layout.item_csa, parent, false);
        CommunityServiceVievHolder vHolder = new CommunityServiceVievHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommunityServiceVievHolder holder, int position) {
        holder.csaName.setText(csaData.get(position).getName());
        holder.CV_csa.setCardBackgroundColor(Color.parseColor(csaColors[position % 6]));
    }

    public void setLayoutManager(LinearLayoutManager layoutManager) {

        this.layoutManager = layoutManager;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

    @Override
    public int getItemCount() {
        return csaData.size();
    }

    public static class CommunityServiceVievHolder extends RecyclerView.ViewHolder {
        private TextView csaName;
        CardView CV_csa;


        public CommunityServiceVievHolder(@NonNull View itemView) {
            super(itemView);
            csaName = itemView.findViewById(R.id.csa_name);
            CV_csa = itemView.findViewById(R.id.CV_csa);
        }
    }

}
