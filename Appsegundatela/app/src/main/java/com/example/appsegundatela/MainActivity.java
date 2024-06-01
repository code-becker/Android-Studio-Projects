package com.example.appsegundatela;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    // abaixo eu criei as seguintes variaveis:
    Button botaosair,botaoabrir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        botaosair = findViewById(R.id.button_sair);
        botaoabrir = findViewById(R.id.button_abrir);

        botaosair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }

        });

        botaoabrir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // inicio com intent dps posso colocar qualquer nome
                // nova intenção (obtenha o contexto dessa aplicação(), o nome da tela.class
                Intent Outratela=new Intent(getApplicationContext(),Outratela.class);
                startActivity(Outratela); //inicia a nova atividade
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;


        });
    }
}