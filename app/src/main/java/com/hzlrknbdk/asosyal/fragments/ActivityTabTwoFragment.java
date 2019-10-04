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
import com.hzlrknbdk.asosyal.adapters.TabTwoActivityAdapter;
import com.hzlrknbdk.asosyal.model.OrganizationDetails;

import java.util.ArrayList;

public class ActivityTabTwoFragment extends Fragment {

    private RecyclerView RVtabtwo;
    private ArrayList<OrganizationDetails> organizationDetailsList;
    private TabTwoActivityAdapter tabTwoActivityAdapter;

    public ActivityTabTwoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_activity_tab_two, container, false);

        RVtabtwo = view.findViewById(R.id.rv_activity_tabtwo);
        RVtabtwo.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        organizationDetailsList = new ArrayList<OrganizationDetails>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference().child("OrganizationDetails");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    OrganizationDetails information = dataSnapshot1.getValue(OrganizationDetails.class);
                    organizationDetailsList.add(information);
                }

                tabTwoActivityAdapter = new TabTwoActivityAdapter(ActivityTabTwoFragment.this.getContext(), organizationDetailsList);
                RVtabtwo.setAdapter(tabTwoActivityAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ActivityTabTwoFragment.this.getContext(), "Oppsss", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
