package com.example.quisdayat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class tanyaislam extends AppCompatActivity {

    TextView kuis;
    RadioGroup rg;
    RadioButton pilihanA, pilihanB, pilihanC, pilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //untuk pertanyaan
String[] pertanyaan_kuis =new String[]{

        "pada tanggal berapakah nabi muhammad saw lahir?",
        "siapakah nama ayah kandung dari nabi muhammad saw?",
        "siapakah nama ibu nabi muhammad saw?",
        "pada umur berapakah nabi muhammad di angkat menjadi rasul?",
    };

   //untuk jawaban a, b, c, dan d.
    String[] pilihan_jawaban = new String[]{

        "pada tanggal 12 Rabiul awal", "pada tanggal 13 Rabiul awal", "pada tanggal 14 Rabiul awal", "semua benar",
        "abu thalib", "abdul mutholib", "abdullah", "semua benar",
        "halimatu sa'diah", "khadijah", "aminah", "semua benar",
        "35 tahun", "39 tahun", "45 tahun", "40 tahun"
   };

    //untuk jawaban yang benar
    String[] jawaban_benar = new String[]{

            "pada tanggal 12 Rabiul awal",
            "abdullah",
            "aminah",
            "40 tahun",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanyaislam);

        kuis = (TextView) findViewById(R.id.kuis);
        rg = (RadioGroup) findViewById(R.id.pilihan1);
        pilihanA = (RadioButton) findViewById(R.id.pilihanA);
        pilihanB = (RadioButton) findViewById(R.id.pilihanB);
        pilihanC = (RadioButton) findViewById(R.id.pilihanC);
        pilihanD = (RadioButton) findViewById(R.id.pilihanD);

        kuis.setText(pertanyaan_kuis[nomor]);
        pilihanA.setText(pilihan_jawaban[0]);
        pilihanB.setText(pilihan_jawaban[1]);
        pilihanC.setText(pilihan_jawaban[2]);
        pilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view){

        if (pilihanA.isChecked() || pilihanB.isChecked() || pilihanC.isChecked() || pilihanD.isChecked()){

            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_kuis.length){
                kuis.setText(pertanyaan_kuis[nomor]);
                pilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                pilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                pilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                pilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);


            }else {
                hasil = benar * 10;
                Intent selesai = new Intent(getApplicationContext(), hasilislam.class);
                startActivity(selesai);
            }
        }else {
            Toast.makeText(this, "tolong jawab dulu",Toast.LENGTH_SHORT).show();
        }
    }
}