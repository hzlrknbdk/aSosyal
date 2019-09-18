package com.hzlrknbdk.asosyal.fragments.actionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.RVSportyAdapter;
import com.hzlrknbdk.asosyal.model.CategoryInformation;

import java.util.ArrayList;

public class SportyFragment extends Fragment {


    private DatabaseReference reference;
    private RecyclerView RVsporty;
    private ArrayList<CategoryInformation> categoryInformationList;
    private RVSportyAdapter sportyAdapter;

    public SportyFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sporty, container, false);

        RVsporty = v.findViewById(R.id.rv_sporty);
        RVsporty.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        categoryInformationList = new ArrayList<CategoryInformation>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Category").child("Sporty");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    CategoryInformation information = dataSnapshot1.getValue(CategoryInformation.class);
                    categoryInformationList.add(information);
                }


                sportyAdapter = new RVSportyAdapter(SportyFragment.this.getContext(), categoryInformationList);
                RVsporty.setAdapter(sportyAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(SportyFragment.this.getContext(), "Oppsss", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }


}

