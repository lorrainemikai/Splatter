package com.epicodus.splatter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.splatter.models.Image;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryDetailFragement extends Fragment {

    @BindView(R.id.galleryImageView) ImageView mGalleryImageView;
    @BindView(R.id.galleryNameTextView)TextView mGalleryNameTextView;
    @BindView(R.id.savePhoto) TextView mSavePhoto;

    private Image mImage;

    public static GalleryDetailFragement newInstance(Image image) {
        GalleryDetailFragement galleryDetailFragement = new GalleryDetailFragement();
        Bundle args = new Bundle();

        args.putParcelable("image", Parcels.wrap(image));
        galleryDetailFragement.setArguments(args);

        return galleryDetailFragement;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImage = Parcels.unwrap(getArguments().getParcelable("image"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery_detail, container,false);
        // Inflate the layout for this fragment
        ButterKnife.bind(this,view);

        Picasso.with(view.getContext()).load(mImage.getUrls().getRegular()).into(mGalleryImageView);
        mGalleryNameTextView.setText(mImage.getDescription());

        return view;
    }

}
