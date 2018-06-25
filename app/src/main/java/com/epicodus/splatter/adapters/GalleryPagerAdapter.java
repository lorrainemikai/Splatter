package com.epicodus.splatter.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.splatter.GalleryDetailFragement;
import com.epicodus.splatter.models.Image;

import java.util.List;

;

public class GalleryPagerAdapter extends FragmentPagerAdapter {
    private List<Image> mGallery;

    public GalleryPagerAdapter(FragmentManager fm , List<Image> gallery){
        super(fm);
        mGallery = gallery;

    }
    @Override
    public Fragment getItem(int position) {
        return GalleryDetailFragement.newInstance(mGallery.get(position));
    }
    @Override
    public int getCount(){
        return mGallery.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return (CharSequence) mGallery.get(position).getId();
    }
}

