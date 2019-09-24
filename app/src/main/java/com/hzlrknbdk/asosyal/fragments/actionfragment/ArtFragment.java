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
import com.hzlrknbdk.asosyal.adapters.RVArtAdapter;
import com.hzlrknbdk.asosyal.model.CategoryInformation;

import java.util.ArrayList;

public class ArtFragment extends Fragment {

    private DatabaseReference reference;
    private RecyclerView RVart;
    private ArrayList<CategoryInformation> categoryInformationList;
    private RVArtAdapter artAdapter;

    public ArtFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_art, container, false);
        RVart = v.findViewById(R.id.rv_art);
        RVart.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        categoryInformationList = new ArrayList<CategoryInformation>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Category").child("Art");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    CategoryInformation information = dataSnapshot1.getValue(CategoryInformation.class);
                    categoryInformationList.add(information);
                }
                artAdapter = new RVArtAdapter(ArtFragment.this.getContext(), categoryInformationList);
                RVart.setAdapter(artAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ArtFragment.this.getContext(), "Oppsss", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}
