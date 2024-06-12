package com.example.myapplication;


import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Tempo de espera da tela de splash (3 segundos)
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Inicia a próxima Activity (por exemplo, LoginActivity)
                    Intent intent = new Intent(MainActivity.this, TelaActivity.class);
                    startActivity(intent);
                    finish(); // Fecha a MainActivity
                }
            }, 3000); // 3000 milissegundos = 3 segundos
        }
    }
