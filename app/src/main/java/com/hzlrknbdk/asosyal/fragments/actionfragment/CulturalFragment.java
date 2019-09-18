package com.hzlrknbdk.asosyal.fragments.actionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.RVCulturalAdapter;
import com.hzlrknbdk.asosyal.model.CategoryInformation;

import java.util.ArrayList;

public class CulturalFragment extends Fragment {

    private RecyclerView RVcultural;
    private ArrayList<CategoryInformation> categoryInformationList;

    public CulturalFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cultural, container, false);
        RVcultural = v.findViewById(R.id.rv_cultural);
        categoryInformationList = new ArrayList<CategoryInformation>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference().child("Category").child("Cultural");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    CategoryInformation information = dataSnapshot1.getValue(CategoryInformation.class);
                    categoryInformationList.add(information);
                }

                RVCulturalAdapter culturalAdapter = new RVCulturalAdapter(getContext(), categoryInformationList);
                LinearLayoutManager linearHorizontal = new LinearLayoutManager(CulturalFragment.this.getContext(), LinearLayoutManager.VERTICAL, false);
                culturalAdapter.setLayoutManager(linearHorizontal);
                RVcultural.setAdapter(culturalAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CulturalFragment.this.getContext(), "Oppsss", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
