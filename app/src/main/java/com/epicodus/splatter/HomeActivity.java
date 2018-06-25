package com.epicodus.splatter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity {
        @BindView(R.id.search) Button mSearchButton;
        @BindView(R.id.searchText)EditText mSearchText;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            ButterKnife.bind(this);

            mSearchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(v== mSearchButton) {
                        String search = mSearchText.getText().toString();
                        Intent intent = new Intent(HomeActivity.this, GalleryListActivity.class);
                        intent.putExtra("search", search);
                        startActivity(intent);
                    }
                }
            });


    }



}

