package com.example.quisdayat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hasilislam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilislam);
        TextView hasil = (TextView) findViewById(R.id.hasil);
        TextView nilai = (TextView) findViewById(R.id.nilai);
        Button kembali = (Button) findViewById(R.id.btn_home);

        hasil.setText("jawaban  yang benar :"+tanyaislam.benar+"\njawaban yang salah :"+tanyaislam.salah);
        nilai.setText("" + tanyaislam.hasil);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(hasilislam.this, MainActivity.class));
            }
        });

    }

    public void ulangi(View view){
        finish();
        Intent a = new Intent(getApplicationContext(),tanyaislam.class);
        startActivity(a);
    }
}