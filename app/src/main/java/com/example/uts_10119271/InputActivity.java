package com.example.uts_10119271;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uts_10119271.imp.SecondFragmentImp;
import com.example.uts_10119271.model.Notes;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class InputActivity extends AppCompatActivity {

    private SecondFragmentInterface notesInterface;
    private EditText et_tanggal, et_judul, et_kategori, et_isi;
    private Button btn_simpan;
    private Intent intent;
    private boolean TAG = true;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();

    //    NIM : 10119271
    //    Nama : Ikra Esa A'raaf Mahardika
    //    Kelas : IF 7

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        init();

        intent = getIntent();

        if(intent.getStringExtra("id") != null){
            et_tanggal.setText(intent.getStringExtra("tanggal"));
//            et_tanggal.setText("asd");
            et_judul.setText(intent.getStringExtra("judul"));
            et_kategori.setText(intent.getStringExtra("kategori"));
            et_isi.setText(intent.getStringExtra("isi"));
            TAG = false;
        } else{
            TAG = true;
        }


    }
    private void init(){
        et_tanggal = findViewById(R.id.et_tanggal);
        et_tanggal.setText(formatter.format(date).toString());
        et_judul = findViewById(R.id.et_judul);
        et_kategori = findViewById(R.id.et_kategori);
        et_isi = findViewById(R.id.et_isi);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener((view -> {save(); }));
    }

    private void save(){
        notesInterface = new SecondFragmentImp(this);

        if (TAG){
//            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            Date date = new Date();
//            System.out.println(formatter.format(date));
            Notes notes1 = new Notes(
                    generateTextRandom(),
                    et_tanggal.getText().toString(),
                    et_judul.getText().toString(),
                    et_kategori.getText().toString(),
                    et_isi.getText().toString()
            );

            if(notesInterface.create(notes1)){
                Toast.makeText(this, "Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            Notes notes2 = new Notes(
                    intent.getStringExtra("id"),

                    et_judul.getText().toString(),
                    et_tanggal.getText().toString(),
                    et_kategori.getText().toString(),
                    et_isi.getText().toString()
            );

            if(notesInterface.update(notes2)){
                Toast.makeText(this, "Berhasil Diubah", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
    private static String generateTextRandom(){
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, Charset. forName("UTF-8"));
    }
}