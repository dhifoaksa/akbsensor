package com.example.tugassensor_10119289.views.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import  com.example.tugassensor_10119289.MainActivity;

/*
 * NIM : 10119289
 * NAMA : Dhifo Aksa Hermawan
 * Kelas : IF-7
 * */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}