package com.epicodus.splatter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;



import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class HomeActivity extends AppCompatActivity {
        private Button mSearchButton;
        private EditText mSearchText;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            mSearchButton = (Button) findViewById(R.id.search);
            mSearchText = (EditText) findViewById(R.id.searchText);


            mSearchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String search = mSearchText.getText().toString();
//
                    Intent intent = new Intent(HomeActivity.this, GalleryActivity.class);
                    intent.putExtra("query", search);
                    startActivity(intent);

                }
            });


        }

        }

    }