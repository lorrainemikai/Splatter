package com.epicodus.splatter;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.epicodus.splatter.adapters.GalleryPagerAdapter;
import com.epicodus.splatter.models.Image;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GalleryDetailActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager mViewpager;
    private GalleryPagerAdapter adapterViewPager;
    private List<Image> mGallery = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_detail);
        ButterKnife.bind(this);
        mGallery = Parcels.unwrap(getIntent().getParcelableExtra("gallery"));
        int startingPosition = getIntent().getIntExtra("position",0);

        adapterViewPager = new GalleryPagerAdapter(getSupportFragmentManager(),mGallery);
        mViewpager.setAdapter(adapterViewPager);
        mViewpager.setCurrentItem(startingPosition);

    }
}
