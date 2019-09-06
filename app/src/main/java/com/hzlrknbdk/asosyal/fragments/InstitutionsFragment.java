package com.hzlrknbdk.asosyal.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.RVCategoryAdapter;
import com.hzlrknbdk.asosyal.model.CategoryName;

import java.util.ArrayList;
import java.util.List;

public class InstitutionsFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerView;
    private List<CategoryName> lstCategoryNames;


    public InstitutionsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstCategoryNames = new ArrayList<>();
        lstCategoryNames.add(new CategoryName("Sivil Toplum Kuruluşları"));
        lstCategoryNames.add(new CategoryName("Üniversiteler"));
        lstCategoryNames.add(new CategoryName("Belediyeler"));
        lstCategoryNames.add(new CategoryName("Milli Eğitim Bakanlığına Bağlı Kurumlar"));
        lstCategoryNames.add(new CategoryName("Sanayi veTeknoloji Bakanlığına Bağlı Kurumlar"));
        lstCategoryNames.add(new CategoryName("Gençlik ve Spor Bakanlığına Bağlı Kurumlar"));
        lstCategoryNames.add(new CategoryName("Aile, Çalışma ve Sosyal Hizmetler Bakanlığına Bağlı Kurumlar"));
        lstCategoryNames.add(new CategoryName("Kültür ve Turizm Bakanlığına Bağlı Kurumlar"));
        lstCategoryNames.add(new CategoryName("Diğer Resmi Kuruluşlar"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_institutions, container, false);

        myrecyclerView = v.findViewById(R.id.rv_institutions);
        RVCategoryAdapter rvCategoryAdapter = new RVCategoryAdapter(getContext(), lstCategoryNames);
        LinearLayoutManager linearHorizontal = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        rvCategoryAdapter.setLayoutManager(linearHorizontal);
        myrecyclerView.setAdapter(rvCategoryAdapter);


        return v;
    }

}
