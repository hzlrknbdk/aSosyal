package com.hzlrknbdk.asosyal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.hzlrknbdk.asosyal.R;

public class SliderAdapter extends PagerAdapter {

    Context sliderContext;
    LayoutInflater layoutInflater;


    public SliderAdapter(Context sliderContext) {
        this.sliderContext = sliderContext;
    }

    public int[] slide_images =

            {
                    R.drawable.logo,
                    R.drawable.logo,
                    R.drawable.logo


            };

    public String[] slide_headings = {
            "HOŞGELDİN",
            " ",
            " "
    };

    public String[] slide_descs = {
            "Çocuklar ve gençlerin sosyalleşmesine katkı sağlamak için buradayız. Sen de bunu hedefliyorsan hadi başlayalım!",
            "Çocuklarımız ve gençlerimiz için birçok kategori oluşturduk. İlgisini çektiği alanları bul ve onları etkinliklere dahil et.",
            "Gerçekleştirdiğin etkinlikleri burada paylaş ve başkalarına da ilham ol.",
            };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) sliderContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);


        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_heading);
        TextView slideDesc = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_descs[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
