package com.example.testebd

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.testebd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
            binding=ActivityMainBinding.inflate(layoutInflater)

        //Executar comandos sql
        val db = Conexao(this)
        //Armazenar os dados retornado pelo select, que está em listaDados
        val listaDados = db.buscaDados()
        //Metodo paa exibir os dados na tela layout
        binding.listView.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, listaDados)




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
