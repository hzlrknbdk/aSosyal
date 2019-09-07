package com.hzlrknbdk.asosyal.fragments.actionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.RVScientificAdapter;
import com.hzlrknbdk.asosyal.model.CategoryName;

import java.util.ArrayList;
import java.util.List;

public class ScientificFragment extends Fragment {

    List<CategoryName> lstScientific;
    private RecyclerView sRV;

    public ScientificFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_scientific, container, false);
        lstScientific = new ArrayList<>();
        lstScientific.add(new CategoryName("Bilim Olimpiyatları"));
        lstScientific.add(new CategoryName("Bilim Şenlikleri"));
        lstScientific.add(new CategoryName("Bilim Fuarları"));
        lstScientific.add(new CategoryName("Patent Sahibi Olma"));
        lstScientific.add(new CategoryName("Bilimsel Toplantılar"));
        lstScientific.add(new CategoryName("Zekâ Oyunları"));
        lstScientific.add(new CategoryName("Bilimsel Araştırma Yarışmaları"));
        lstScientific.add(new CategoryName("Bilimsel Proje Yarışmaları"));
        lstScientific.add(new CategoryName("Bilişim Teknolojilerine Yönelik Uygulamalar"));
        lstScientific.add(new CategoryName("Fen, Teknoloji, Mühendislik ve Matematik Alanlarına Yönelik Uygulamalar"));

        sRV = v.findViewById(R.id.rv_scientific);
        RVScientificAdapter scientificAdapter = new RVScientificAdapter(this.getContext(), lstScientific);
        sRV.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        sRV.setAdapter(scientificAdapter);

        return v;
    }

}
