package com.hzlrknbdk.asosyal.fragments.actionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.RVCulturalAdapter;
import com.hzlrknbdk.asosyal.model.CategoryName;

import java.util.ArrayList;
import java.util.List;

public class CulturalFragment extends Fragment {

    View v;
    private RecyclerView cRecyclerView;
    private List<CategoryName> lstCulturalNames;


    public CulturalFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        lstCulturalNames = new ArrayList<>();
        lstCulturalNames.add(new CategoryName("Müze/Örenyeri Gezileri"));
        lstCulturalNames.add(new CategoryName("Tarihi Mekân Gezileri"));
        lstCulturalNames.add(new CategoryName("Sanat Galerisi Gezileri"));
        lstCulturalNames.add(new CategoryName("Doğa Gezileri"));
        lstCulturalNames.add(new CategoryName("Gösteri Sanatları"));
        lstCulturalNames.add(new CategoryName("El Sanatları Geleneği"));
        lstCulturalNames.add(new CategoryName("Doğa ve Evrenle İlgili Bilgi ve Uygulamalar"));
        lstCulturalNames.add(new CategoryName("Mesleki Alan Etkinlikleri"));
        lstCulturalNames.add(new CategoryName("Sözlü Gelenekler ve Anlatımlar"));
        lstCulturalNames.add(new CategoryName("Mesleki Alanlara Yönelik Tanıtım Gezileri"));
        lstCulturalNames.add(new CategoryName("Toplumsal Uygulamalar Ritüeller ve Şölenler"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_cultural, container, false);

        cRecyclerView = v.findViewById(R.id.rv_cultural);
        RVCulturalAdapter rvCulturalAdapter = new RVCulturalAdapter(getContext(), lstCulturalNames);
        LinearLayoutManager linearHorizontal = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        rvCulturalAdapter.setLayoutManager(linearHorizontal);
        cRecyclerView.setAdapter(rvCulturalAdapter);


        return v;
    }

}
