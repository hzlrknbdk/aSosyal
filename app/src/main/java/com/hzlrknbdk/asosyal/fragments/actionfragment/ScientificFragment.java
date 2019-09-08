package com.hzlrknbdk.asosyal.fragments.actionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.RVScientificAdapter;
import com.hzlrknbdk.asosyal.model.CategoryName;

import java.util.ArrayList;
import java.util.List;

public class ScientificFragment extends Fragment {
    View v;
    private List<CategoryName> lstScientific;
    private RecyclerView sRV;

    public ScientificFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_scientific, container, false);
        sRV = v.findViewById(R.id.rv_scientific);
        RVScientificAdapter rvScientificAdapter = new RVScientificAdapter(getContext(), lstScientific);
        LinearLayoutManager linearHorizontal = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        rvScientificAdapter.setLayoutManager(linearHorizontal);
        sRV.setAdapter(rvScientificAdapter);

        return v;
    }

}
