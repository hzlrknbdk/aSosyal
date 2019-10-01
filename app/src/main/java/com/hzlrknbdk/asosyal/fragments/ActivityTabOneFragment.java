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
import com.hzlrknbdk.asosyal.adapters.TabOneActivityAdapter;
import com.hzlrknbdk.asosyal.model.CourseDetails;

import java.util.ArrayList;


public class ActivityTabOneFragment extends Fragment {

    private RecyclerView RVtabone;
    private ArrayList<CourseDetails> courseDetailsList;
    private TabOneActivityAdapter tabOneActivityAdapter;

    public ActivityTabOneFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_tab_one, container, false);

        RVtabone = view.findViewById(R.id.rv_activity_tabone);
        RVtabone.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        courseDetailsList = new ArrayList<CourseDetails>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference().child("CourseDetails");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    CourseDetails information = dataSnapshot1.getValue(CourseDetails.class);
                    courseDetailsList.add(information);
                }

                tabOneActivityAdapter = new TabOneActivityAdapter(ActivityTabOneFragment.this.getContext(), courseDetailsList);
                RVtabone.setAdapter(tabOneActivityAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ActivityTabOneFragment.this.getContext(), "Oppsss", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
