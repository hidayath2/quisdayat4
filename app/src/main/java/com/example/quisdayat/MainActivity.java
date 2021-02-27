package com.example.quisdayat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSejarahIslam;
    Button btnsejarahindonesia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSejarahIslam = findViewById(R.id.btntanyaIslam);
        btnsejarahindonesia = findViewById(R.id.btntanyaindonesia);

        btnSejarahIslam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, tanyaislam.class));
            }
        });

        btnsejarahindonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, tanyaIndonesia.class);
                startActivity(i);
            }
        });

    }
}