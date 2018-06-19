package com.epicodus.splatter.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.splatter.R;
import com.epicodus.splatter.models.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder> {
    private List<Image> mGallery ;

    private Context mContext;

    public GalleryListAdapter(Context context, List<Image> myGallery) {
        mContext = context;
        mGallery = myGallery;
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


    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.galleryImageView)
        ImageView mGalleryImageView;
        @BindView(R.id.galleryNameTextView)
        TextView mNameTextView;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindImage(Image image) {
            Picasso.with(mContext).load(image.getUrls().getSmall()).into(mGalleryImageView);
            Log.d("recyclerView", "bindImage: "+image.getDescription());
                mNameTextView.setText(image.getDescription());
        }
    }
}
//}
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gallery);
//        getImages("query");
//
//        mWhatResult = (TextView) findViewById(R.id.whatResult);
//
//        Intent intent = getIntent();
//        String search = intent.getStringExtra("search");
//        mWhatResult.setText("" + search + "");
//
//    }
//
//    private void getImages(String query) {
//
//
//        final UnsplashService unsplashService = new UnsplashService();
//        unsplashService.search(query, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//
//            }
//
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                try {
//                    String jsonData = response.body().string();
//                    Log.v(TAG, jsonData);
//                    images =  unsplashService.processResults(response);
//                    GalleryActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
////                            String[] imageNames = new String[mWhatResult.name()];
////                            for (int i = 0; i<imageNames.length;i++){
////                                imageNames[i] =mWhatResult.get(i).getName();
////                            }
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }