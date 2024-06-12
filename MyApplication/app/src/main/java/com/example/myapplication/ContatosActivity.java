package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import java.util.Arrays;
import java.util.List;

import java.util.Arrays;

public class ContatosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContatosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);

        recyclerView = findViewById(R.id.recyclerViewContatos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> contatos = Arrays.asList("Carlos ", "Jonas ", "Aline ", "Maria ", "João ", 
                "Ana ", "Maria ", "João ", "Ana ", "Maria ", "João ", "Ana ");

        adapter = new ContatosAdapter(contatos, new ContatosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String contato) {
                Intent intent = new Intent(ContatosActivity.this, ConversaActivity.class);
                intent.putExtra("CONTATO_NOME", contato);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }
}