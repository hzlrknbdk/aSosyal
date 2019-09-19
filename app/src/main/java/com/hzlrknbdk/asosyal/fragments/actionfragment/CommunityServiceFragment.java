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
import com.hzlrknbdk.asosyal.adapters.RVCommunityAdapter;
import com.hzlrknbdk.asosyal.model.CategoryInformation;

import java.util.ArrayList;
import java.util.List;


public class CommunityServiceFragment extends Fragment {
    private DatabaseReference reference;
    private RecyclerView RVcsa;
    private ArrayList<CategoryInformation> categoryInformationList;
    private RVCommunityAdapter communityAdapter;


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
        RVcsa = v.findViewById(R.id.rv_csa);
        RVcsa.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        categoryInformationList = new ArrayList<CategoryInformation>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Category").child("Community");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    CategoryInformation information = dataSnapshot1.getValue(CategoryInformation.class);
                    categoryInformationList.add(information);
                }
                communityAdapter = new RVCommunityAdapter(CommunityServiceFragment.this.getContext(), categoryInformationList);
                RVcsa.setAdapter(communityAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CommunityServiceFragment.this.getContext(), "Oppsss", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }


}
