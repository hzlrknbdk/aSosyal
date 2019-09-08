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
import com.hzlrknbdk.asosyal.model.CategoryName;

import java.util.ArrayList;
import java.util.List;


public class CommunityServiceFragment extends Fragment {
    List<CategoryName> lstCSA;
    private RecyclerView csaRV;

    public CommunityServiceFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstCSA = new ArrayList<>();
        lstCSA.add(new CategoryName("Toplumsal Refah ve Eşitliği Sağlamaya Yönelik Çalışmalar"));
        lstCSA.add(new CategoryName("Toplumsal Bilinci Geliştirmeye Yönelik Çalışmalar"));
        lstCSA.add(new CategoryName("Millî ve Manevi Değerleri Koruma ve Yaşatmaya Yönelik Çalışmalar"));
        lstCSA.add(new CategoryName("Velilerin ve Diğer Paydaşların Okulla İş Birliğini Artırmaya Yönelik Çalışmalar"));
        lstCSA.add(new CategoryName("Tarihi ve Doğal Çevrenin Korunması ve Geliştirilmesine Yönelik Çalışmalar"));
        lstCSA.add(new CategoryName("Dezavantajlı Bireylerin Toplumsal Entegrasyonuna Yönelik Çalışmalar"));
        lstCSA.add(new CategoryName("Sanat, Kültür ve Bilim İmkânlarının ve Kültürünün Geliştirilmesine Yönelik Çalışmalar"));
        lstCSA.add(new CategoryName("Sivil Toplum Kuruluşları ile Sosyal Hizmetlere Yönelik Çalışmalar"));
        lstCSA.add(new CategoryName("Spor ve Sağlık Kültürünün Geliştirilmesine Yönelik Çalışmalar"));
        lstCSA.add(new CategoryName("Trafik Kuralları ve Güvenliğine Yönelik Çalışmalar"));
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
