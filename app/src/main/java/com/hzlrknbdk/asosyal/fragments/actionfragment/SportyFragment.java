package com.hzlrknbdk.asosyal.fragments.actionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.RVSportyAdapter;
import com.hzlrknbdk.asosyal.model.CategoryName;

import java.util.ArrayList;
import java.util.List;

public class SportyFragment extends Fragment {
    List<CategoryName> lstSporty;
    private RecyclerView sportyRV;

    public SportyFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstSporty = new ArrayList<>();
        lstSporty.add(new CategoryName("Atıcılık"));
        lstSporty.add(new CategoryName("Bocce"));
        lstSporty.add(new CategoryName("Dağcılık"));
        lstSporty.add(new CategoryName("Florbal"));
        lstSporty.add(new CategoryName("Motosiklet"));
        lstSporty.add(new CategoryName("Voleybol"));
        lstSporty.add(new CategoryName("Kayak"));
        lstSporty.add(new CategoryName("Sualtı Sporları"));
        lstSporty.add(new CategoryName("Atletizm"));
        lstSporty.add(new CategoryName("Boks"));
        lstSporty.add(new CategoryName("Dart"));
        lstSporty.add(new CategoryName("Futbol"));
        lstSporty.add(new CategoryName("Okçuluk"));
        lstSporty.add(new CategoryName("Fitness"));
        lstSporty.add(new CategoryName("Masa Tenisi"));
        lstSporty.add(new CategoryName("Kick Boks"));
        lstSporty.add(new CategoryName("Badminton"));
        lstSporty.add(new CategoryName("Bowling"));
        lstSporty.add(new CategoryName("Eskrim"));
        lstSporty.add(new CategoryName("Futsal"));
        lstSporty.add(new CategoryName("Oryantiring"));
        lstSporty.add(new CategoryName("Wushu"));
        lstSporty.add(new CategoryName("Su Topu"));
        lstSporty.add(new CategoryName("Dans Sporları"));
        lstSporty.add(new CategoryName("Basketbol"));
        lstSporty.add(new CategoryName("Briç"));
        lstSporty.add(new CategoryName("Halter"));
        lstSporty.add(new CategoryName("Golf"));
        lstSporty.add(new CategoryName("Ragbi"));
        lstSporty.add(new CategoryName("Yelken"));
        lstSporty.add(new CategoryName("Buz Pateni"));
        lstSporty.add(new CategoryName("Buz Hokeyi"));
        lstSporty.add(new CategoryName("Beyzbol"));
        lstSporty.add(new CategoryName("Kızak"));
        lstSporty.add(new CategoryName("Hentbol"));
        lstSporty.add(new CategoryName("Güreş"));
        lstSporty.add(new CategoryName("Satranç"));
        lstSporty.add(new CategoryName("Yüzme"));
        lstSporty.add(new CategoryName("Curling"));
        lstSporty.add(new CategoryName("Hava Sporları"));
        lstSporty.add(new CategoryName("Bilardo"));
        lstSporty.add(new CategoryName("Kürek"));
        lstSporty.add(new CategoryName("Hokey"));
        lstSporty.add(new CategoryName("Kano"));
        lstSporty.add(new CategoryName("Taekwondo"));
        lstSporty.add(new CategoryName("Triatlon"));
        lstSporty.add(new CategoryName("Bisiklet"));
        lstSporty.add(new CategoryName("Halk Oyunları"));
        lstSporty.add(new CategoryName("Binicilik"));
        lstSporty.add(new CategoryName("Cimnastik"));
        lstSporty.add(new CategoryName("İzcilik"));
        lstSporty.add(new CategoryName("Karate"));
        lstSporty.add(new CategoryName("Tenis"));
        lstSporty.add(new CategoryName("Judo"));
        lstSporty.add(new CategoryName("Muay Thai"));
        lstSporty.add(new CategoryName("Korumalı Futbol"));
        lstSporty.add(new CategoryName("Otomobil Sporları"));
        lstSporty.add(new CategoryName("Vücut Geliştirme"));
        lstSporty.add(new CategoryName("Modern Pentatlon"));
        lstSporty.add(new CategoryName("Geleneksel Spor Dalları"));
        lstSporty.add(new CategoryName("E-Spor"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sporty, container, false);
        sportyRV = v.findViewById(R.id.rv_sporty);
        RVSportyAdapter sportyAdapter = new RVSportyAdapter(this.getContext(), lstSporty);
        sportyRV.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        sportyRV.setAdapter(sportyAdapter);
        return v;
    }


}
