package com.hzlrknbdk.asosyal.fragments.actionfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.RVCommunityAdapter;
import com.hzlrknbdk.asosyal.model.CategoryInformation;

import java.util.ArrayList;
import java.util.List;


public class CommunityServiceFragment extends Fragment {
    List<CategoryInformation> lstCSA;
    private RecyclerView csaRV;

    public CommunityServiceFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* lstCSA = new ArrayList<>();
        lstCSA.add(new CategoryInformation("Toplumsal Refah ve Eşitliği Sağlamaya Yönelik Çalışmalar"));
        lstCSA.add(new CategoryInformation("Toplumsal Bilinci Geliştirmeye Yönelik Çalışmalar"));
        lstCSA.add(new CategoryInformation("Millî ve Manevi Değerleri Koruma ve Yaşatmaya Yönelik Çalışmalar"));
        lstCSA.add(new CategoryInformation("Velilerin ve Diğer Paydaşların Okulla İş Birliğini Artırmaya Yönelik Çalışmalar"));
        lstCSA.add(new CategoryInformation("Tarihi ve Doğal Çevrenin Korunması ve Geliştirilmesine Yönelik Çalışmalar"));
        lstCSA.add(new CategoryInformation("Dezavantajlı Bireylerin Toplumsal Entegrasyonuna Yönelik Çalışmalar"));
        lstCSA.add(new CategoryInformation("Sanat, Kültür ve Bilim İmkânlarının ve Kültürünün Geliştirilmesine Yönelik Çalışmalar"));
        lstCSA.add(new CategoryInformation("Sivil Toplum Kuruluşları ile Sosyal Hizmetlere Yönelik Çalışmalar"));
        lstCSA.add(new CategoryInformation("Spor ve Sağlık Kültürünün Geliştirilmesine Yönelik Çalışmalar"));
        lstCSA.add(new CategoryInformation("Trafik Kuralları ve Güvenliğine Yönelik Çalışmalar"));*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_community, container, false);
        csaRV = v.findViewById(R.id.rv_csa);
        RVCommunityAdapter communityAdapter = new RVCommunityAdapter(this.getContext(), lstCSA);
        csaRV.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        csaRV.setAdapter(communityAdapter);
        return v;
    }


}
