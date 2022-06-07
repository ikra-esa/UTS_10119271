package com.example.uts_10119271.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_10119271.MainActivity;

public class SplashActivity extends AppCompatActivity {

    //    NIM : 10119271
    //    Nama : Ikra Esa A'raaf Mahardika
    //    Kelas : IF 7
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}
