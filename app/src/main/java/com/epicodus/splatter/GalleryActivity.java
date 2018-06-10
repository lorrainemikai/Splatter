package com.epicodus.splatter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GalleryActivity extends AppCompatActivity {
    private final String images[] ={"Sheila Pree", "BrightCindy Sherman","Hiroshi Sugimoto" ,"Shirin Neshat" ,"Michael Wolf"};


    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this,  android.R.layout.simple_list_item_1,images);
//        mListView.setAdapter(adapter);

         }
}
