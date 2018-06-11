package com.epicodus.splatter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mStartDiscoveryButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartDiscoveryButton = (Button) findViewById(R.id.startDiscoveryButton);


        mStartDiscoveryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                android.widget.Toast.makeText(MainActivity.this, "I Know Youll Love It!", android.widget.Toast.LENGTH_LONG).show();


                startActivity(intent);
            }
        });
    }
}
