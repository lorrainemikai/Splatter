package com.epicodus.splatter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.BindView;


public class MainActivity extends AppCompatActivity {
    @Bind(R.id.startDiscoveryButton)
    Button mStartDiscoveryButton;
    @Bind(R.id.appNameTextView)
    TextView mAppNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mStartDiscoveryButton.setOnClickListener(this);
        @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "I Know Youll Love It!!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this , HomeActivity.class);
                startActivity(intent);

            }
        }
    }
