package com.epicodus.splatter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.splatter.adapters.GalleryListAdapter;
import com.epicodus.splatter.models.Image;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GalleryListActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
     RecyclerView mImagesRecyclerView;
    public static final String TAG = HomeActivity.class.getSimpleName();
    private GalleryListAdapter mAdapter;
    private List<Image> mGallery = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String search = intent.getStringExtra("search");
        getImages(search);
    }

    private void getImages(String query) {

        final UnsplashService unsplashService = new UnsplashService();
        unsplashService.search(query, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                    mGallery =  unsplashService.processResults(response);
                    GalleryListActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new GalleryListAdapter(getApplicationContext(), mGallery);
                            mImagesRecyclerView.setAdapter(mAdapter);


                            RecyclerView.LayoutManager layoutManager =
                                    new LinearLayoutManager(GalleryListActivity.this);
                            mImagesRecyclerView.setLayoutManager(layoutManager);
                            mImagesRecyclerView.setHasFixedSize(true);
                        }
                    });
            }
        });
    }
}