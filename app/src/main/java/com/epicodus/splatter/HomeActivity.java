package com.epicodus.splatter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;


    public class HomeActivity extends AppCompatActivity {
        @Bind(R.id.listView)
        ListView mListView;
        private String[] images = new String[] {"Mi Mero Mole", "Mother's Bistro",
                "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
                "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
                "Lardo", "Portland City Grill", "Fat Head's Brewery",
                "Chipotle", "Subway"};

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this,  android.R.layout.simple_list_item_1, images);
            mListView.setAdapter(adapter);
    }
}
