package com.hzlrknbdk.asosyal.fragments.navigationbarfragment;

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
import com.hzlrknbdk.asosyal.adapters.HomePagePostAdapter;
import com.hzlrknbdk.asosyal.model.Post;

import java.util.ArrayList;


public class HomePageFragment extends Fragment {
    private DatabaseReference reference;
    private RecyclerView RVhomepagepost;
    private ArrayList<Post> postList;
    private HomePagePostAdapter homePagePostAdapter;


    public HomePageFragment() {

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        RVhomepagepost = view.findViewById(R.id.rv_homepage);
        RVhomepagepost.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        postList = new ArrayList<Post>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Post");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Post information = dataSnapshot1.getValue(Post.class);
                    postList.add(information);
                }
                homePagePostAdapter = new HomePagePostAdapter(HomePageFragment.this.getContext(), postList);
                RVhomepagepost.setAdapter(homePagePostAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(HomePageFragment.this.getContext(), "Oppsss", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
