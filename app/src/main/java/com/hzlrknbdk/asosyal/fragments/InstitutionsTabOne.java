package com.hzlrknbdk.asosyal.fragments;

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
import com.hzlrknbdk.asosyal.adapters.TabOneAdapter;
import com.hzlrknbdk.asosyal.model.OrganizationDetails;

import java.util.ArrayList;


public class InstitutionsTabOne extends Fragment {

    private RecyclerView RVtabone;
    private ArrayList<OrganizationDetails> organizationDetailsList;
    private TabOneAdapter tabOneAdapter;


    public InstitutionsTabOne() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_institutions_tab_one, container, false);

        RVtabone = view.findViewById(R.id.rv_tabone);
        RVtabone.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        organizationDetailsList = new ArrayList<OrganizationDetails>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference().child("Organizations");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    OrganizationDetails information = dataSnapshot1.getValue(OrganizationDetails.class);
                    organizationDetailsList.add(information);
                }

                tabOneAdapter = new TabOneAdapter(InstitutionsTabOne.this.getContext(), organizationDetailsList);
                RVtabone.setAdapter(tabOneAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(InstitutionsTabOne.this.getContext(), "Oppsss", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
