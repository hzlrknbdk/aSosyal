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
import com.hzlrknbdk.asosyal.model.CategoryInformation;

import java.util.ArrayList;
import java.util.List;

public class ScientificFragment extends Fragment {
    View v;
    private List<CategoryInformation> lstScientific;
    private RecyclerView sRV;

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
        v = inflater.inflate(R.layout.fragment_scientific, container, false);
        sRV = v.findViewById(R.id.rv_scientific);
        RVScientificAdapter rvScientificAdapter = new RVScientificAdapter(getContext(), lstScientific);
        LinearLayoutManager linearHorizontal = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        rvScientificAdapter.setLayoutManager(linearHorizontal);
        sRV.setAdapter(rvScientificAdapter);

        return v;
    }

}
