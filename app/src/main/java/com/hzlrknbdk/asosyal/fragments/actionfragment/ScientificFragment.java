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
import com.hzlrknbdk.asosyal.adapters.RVScientificAdapter;
import com.hzlrknbdk.asosyal.model.CategoryInformation;

import java.util.ArrayList;

public class ScientificFragment extends Fragment {
    private RecyclerView RVscientific;
    private ArrayList<CategoryInformation> categoryInformationList;

    public ScientificFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  lstScientific = new ArrayList<>();
        lstScientific.add(new CategoryInformation("Bilim Olimpiyatları"));
        lstScientific.add(new CategoryInformation("Bilim Şenlikleri"));
        lstScientific.add(new CategoryInformation("Bilim Fuarları"));
        lstScientific.add(new CategoryInformation("Patent Sahibi Olma"));
        lstScientific.add(new CategoryInformation("Bilimsel Toplantılar"));
        lstScientific.add(new CategoryInformation("Zekâ Oyunları"));
        lstScientific.add(new CategoryInformation("Bilimsel Araştırma Yarışmaları"));
        lstScientific.add(new CategoryInformation("Bilimsel Proje Yarışmaları"));
        lstScientific.add(new CategoryInformation("Bilişim Teknolojilerine Yönelik Uygulamalar"));
        lstScientific.add(new CategoryInformation("Fen, Teknoloji, Mühendislik ve Matematik Alanlarına Yönelik Uygulamalar"));
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_scientific, container, false);
        RVscientific = v.findViewById(R.id.rv_scientific);
        categoryInformationList = new ArrayList<CategoryInformation>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference().child("Category").child("Scientific");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    CategoryInformation information = dataSnapshot1.getValue(CategoryInformation.class);
                    categoryInformationList.add(information);
                }

                RVScientificAdapter scientificAdapter = new RVScientificAdapter(getContext(), categoryInformationList);
                LinearLayoutManager linearHorizontal = new LinearLayoutManager(ScientificFragment.this.getContext(), LinearLayoutManager.VERTICAL, false);
                scientificAdapter.setLayoutManager(linearHorizontal);
                RVscientific.setAdapter(scientificAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ScientificFragment.this.getContext(), "Oppsss", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

}
