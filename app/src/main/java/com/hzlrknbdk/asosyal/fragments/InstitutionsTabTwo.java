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
import com.hzlrknbdk.asosyal.adapters.TabTwoAdapter;
import com.hzlrknbdk.asosyal.model.OrganizationDetails;

import java.util.ArrayList;

public class InstitutionsTabTwo extends Fragment {

    private RecyclerView RVtabtwo;
    private ArrayList<OrganizationDetails> organizationDetailsList;
    private TabTwoAdapter tabTwoAdapter;

    public InstitutionsTabTwo() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_institutions_tab_two, container, false);

        RVtabtwo = view.findViewById(R.id.rv_tabtwo);
        RVtabtwo.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        organizationDetailsList = new ArrayList<OrganizationDetails>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference().child("ToBeOrganized");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    OrganizationDetails information = dataSnapshot1.getValue(OrganizationDetails.class);
                    organizationDetailsList.add(information);
                }

                tabTwoAdapter = new TabTwoAdapter(InstitutionsTabTwo.this.getContext(), organizationDetailsList);
                RVtabtwo.setAdapter(tabTwoAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(InstitutionsTabTwo.this.getContext(), "Oppsss", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
