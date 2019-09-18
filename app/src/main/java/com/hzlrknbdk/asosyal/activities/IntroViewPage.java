package com.hzlrknbdk.asosyal.activities;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.hzlrknbdk.asosyal.R;
import com.hzlrknbdk.asosyal.adapters.SliderAdapter;
import com.hzlrknbdk.asosyal.fragments.actionfragment.ActionFragment;

public class IntroViewPage extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button mNextBtn;
    private Button mPrevBtn;
    private Button mskip;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_view_page);
        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotLayout);
        mNextBtn = findViewById(R.id.nextBtn);
        mPrevBtn = findViewById(R.id.prevBtn);
        mskip = findViewById(R.id.skip);


        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(v -> {
            mSlideViewPager.setCurrentItem(mCurrentPage + 1);
        });

        mPrevBtn.setOnClickListener(v -> mSlideViewPager.setCurrentItem(mCurrentPage - 1));
        mskip.setOnClickListener(this);

    }


    public void addDotsIndicator(int position) {

        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.white));
            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;
            if (position == 0) {
                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(false);
                mPrevBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setText("İleri");
                mPrevBtn.setText("");
            } else if (position == mDots.length - 1) {
                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(true);
                mPrevBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("");
                mPrevBtn.setText("Geri");
            } else {
                mNextBtn.setEnabled(true);
                mPrevBtn.setEnabled(true);
                mPrevBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("İleri");
                mPrevBtn.setText("Geri");

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.skip) {
            ActionFragment actionFragment = new ActionFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            assert fragmentManager != null;
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.intro_container, actionFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            mPrevBtn.setVisibility(View.INVISIBLE);
            mskip.setVisibility(View.INVISIBLE);
            mNextBtn.setVisibility(View.INVISIBLE);
        }
    }
}
