package com.hzlrknbdk.asosyal.fragments.actionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.RVArtAdapter;
import com.hzlrknbdk.asosyal.model.CategoryName;

import java.util.ArrayList;
import java.util.List;

public class ArtFragment extends Fragment {

    List<CategoryName> lstArt;
    private RecyclerView artRV;

    public ArtFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstArt = new ArrayList<>();
        lstArt.add(new CategoryName("Resim"));
        lstArt.add(new CategoryName("Koro"));
        lstArt.add(new CategoryName("Yabancı Dil Etkinlikleri"));
        lstArt.add(new CategoryName("Özgün Baskı Resmi"));
        lstArt.add(new CategoryName("Heykel"));
        lstArt.add(new CategoryName("Üflemeli Çalgılar"));
        lstArt.add(new CategoryName("Mekan Sanatları"));
        lstArt.add(new CategoryName("Maket"));
        lstArt.add(new CategoryName("Seramik"));
        lstArt.add(new CategoryName("Grafik Sanatlar"));
        lstArt.add(new CategoryName("Geleneksel Türk Sanatları"));
        lstArt.add(new CategoryName("Tiyatro"));
        lstArt.add(new CategoryName("Rölyef"));
        lstArt.add(new CategoryName("Vurmalı Çalgılar"));
        lstArt.add(new CategoryName("Hikaye/Tiyatro Metni/ Roman"));
        lstArt.add(new CategoryName("Bale"));
        lstArt.add(new CategoryName("Çini"));
        lstArt.add(new CategoryName("Yaylı Çalgılar"));
        lstArt.add(new CategoryName("Mızraplı/Tezeneli Çalgılar"));
        lstArt.add(new CategoryName("Opera"));
        lstArt.add(new CategoryName("Origami"));
        lstArt.add(new CategoryName("Tuşlu Çalgılar"));
        lstArt.add(new CategoryName("Deneme /Makale / Fıkra"));
        lstArt.add(new CategoryName("Drama"));
        lstArt.add(new CategoryName("Orkestra"));
        lstArt.add(new CategoryName("Şiir(Sözlü Anlatım)"));
        lstArt.add(new CategoryName("Mektup / Günlük / Anı"));
        lstArt.add(new CategoryName("Sinema"));
        lstArt.add(new CategoryName("Şiir(Yazılı Anlatım)"));
        lstArt.add(new CategoryName("Münazara"));
        lstArt.add(new CategoryName("Konferans/Panel / Forum"));
        lstArt.add(new CategoryName("Fabl / Masal"));
        lstArt.add(new CategoryName("Şan (Solo)"));
        lstArt.add(new CategoryName("Sunuculuk"));
        lstArt.add(new CategoryName("Sohbet / Eleştiri / Gezi Yazısı"));
        lstArt.add(new CategoryName("Mask"));
        lstArt.add(new CategoryName("Mülakat/Röportaj"));
        lstArt.add(new CategoryName("Biyografi / Otobiyografi"));
        lstArt.add(new CategoryName("Oratoryo"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_art, container, false);

        artRV = v.findViewById(R.id.rv_art);
        RVArtAdapter artAdapter = new RVArtAdapter(this.getContext(), lstArt);
        artRV.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        artRV.setAdapter(artAdapter);

        return v;
    }

}
