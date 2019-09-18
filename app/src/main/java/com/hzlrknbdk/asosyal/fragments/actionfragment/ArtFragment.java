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
       /* lstArt = new ArrayList<>();
        lstArt.add(new CategoryInformation("Resim"));
        lstArt.add(new CategoryInformation("Koro"));
        lstArt.add(new CategoryInformation("Yabancı Dil Etkinlikleri"));
        lstArt.add(new CategoryInformation("Özgün Baskı Resmi"));
        lstArt.add(new CategoryInformation("Heykel"));
        lstArt.add(new CategoryInformation("Üflemeli Çalgılar"));
        lstArt.add(new CategoryInformation("Mekan Sanatları"));
        lstArt.add(new CategoryInformation("Maket"));
        lstArt.add(new CategoryInformation("Seramik"));
        lstArt.add(new CategoryInformation("Grafik Sanatlar"));
        lstArt.add(new CategoryInformation("Geleneksel Türk Sanatları"));
        lstArt.add(new CategoryInformation("Tiyatro"));
        lstArt.add(new CategoryInformation("Rölyef"));
        lstArt.add(new CategoryInformation("Vurmalı Çalgılar"));
        lstArt.add(new CategoryInformation("Hikaye/Tiyatro Metni/ Roman"));
        lstArt.add(new CategoryInformation("Bale"));
        lstArt.add(new CategoryInformation("Çini"));
        lstArt.add(new CategoryInformation("Yaylı Çalgılar"));
        lstArt.add(new CategoryInformation("Mızraplı/Tezeneli Çalgılar"));
        lstArt.add(new CategoryInformation("Opera"));
        lstArt.add(new CategoryInformation("Origami"));
        lstArt.add(new CategoryInformation("Tuşlu Çalgılar"));
        lstArt.add(new CategoryInformation("Deneme /Makale / Fıkra"));
        lstArt.add(new CategoryInformation("Drama"));
        lstArt.add(new CategoryInformation("Orkestra"));
        lstArt.add(new CategoryInformation("Şiir(Sözlü Anlatım)"));
        lstArt.add(new CategoryInformation("Mektup / Günlük / Anı"));
        lstArt.add(new CategoryInformation("Sinema"));
        lstArt.add(new CategoryInformation("Şiir(Yazılı Anlatım)"));
        lstArt.add(new CategoryInformation("Münazara"));
        lstArt.add(new CategoryInformation("Konferans/Panel / Forum"));
        lstArt.add(new CategoryInformation("Fabl / Masal"));
        lstArt.add(new CategoryInformation("Şan (Solo)"));
        lstArt.add(new CategoryInformation("Sunuculuk"));
        lstArt.add(new CategoryInformation("Sohbet / Eleştiri / Gezi Yazısı"));
        lstArt.add(new CategoryInformation("Mask"));
        lstArt.add(new CategoryInformation("Mülakat/Röportaj"));
        lstArt.add(new CategoryInformation("Biyografi / Otobiyografi"));
        lstArt.add(new CategoryInformation("Oratoryo"));*/
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
