package com.epicodus.splatter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.splatter.adapters.GalleryListAdapter;
import com.epicodus.splatter.models.Image;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GalleryActivity extends AppCompatActivity {
    public static final String TAG = HomeActivity.class.getSimpleName();
    private GalleryListAdapter mAdapter;
    private RecyclerView mImagesRecyclerView;
    private List<Image> mGallery = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Intent intent = getIntent();
        String search = intent.getStringExtra("search");
        getImages(search);

        mImagesRecyclerView = (RecyclerView) findViewById (R.id.recyclerView);

//        mWhatResult = (TextView) findViewById(R.id.whatResult);



//        mWhatResult.setText("" + search + "");

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
//                try {
//                    String jsonData = response.body().string();
//                    Log.v(TAG, jsonData);
                    mGallery =  unsplashService.processResults(response);
                    GalleryActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new GalleryListAdapter(getApplicationContext(), mGallery);
                            mImagesRecyclerView.setAdapter(mAdapter);


                            RecyclerView.LayoutManager layoutManager =
                                    new LinearLayoutManager(GalleryActivity.this);
                            mImagesRecyclerView.setLayoutManager(layoutManager);
                            mImagesRecyclerView.setHasFixedSize(true);
                        }
                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }
}