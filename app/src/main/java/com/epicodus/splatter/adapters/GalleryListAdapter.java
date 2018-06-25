package com.epicodus.splatter.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.splatter.GalleryDetailActivity;
import com.epicodus.splatter.R;
import com.epicodus.splatter.models.Image;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder> {
    private List<Image> mGallery ;

    private Context mContext;

    public GalleryListAdapter(Context context, List<Image> myGallery) {
        mGallery = myGallery;
        mContext = context;
    }

    @Override
    public GalleryListAdapter.GalleryViewHolder onCreateViewHolder(
    ViewGroup parent,int viewType)

    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_list_item, parent, false);
        GalleryViewHolder viewHolder = new GalleryViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position){

        holder.bindImage(mGallery.get(position));
    }
    @Override
    public int getItemCount(){
        return mGallery.size();
    }


    public class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.galleryImageView)
        ImageView mGalleryImageView;
        @BindView(R.id.galleryNameTextView)
        TextView mNameTextView;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bindImage(Image image) {
            Picasso.with(mContext).load(image.getUrls().getSmall()).into(mGalleryImageView);
            Log.d("recyclerView", "bindImage: "+image.getDescription());
                mNameTextView.setText(image.getDescription());
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, GalleryDetailActivity.class);
            intent.putExtra("position",itemPosition);
            intent.putExtra("gallery", Parcels.wrap(mGallery));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
    }

}
