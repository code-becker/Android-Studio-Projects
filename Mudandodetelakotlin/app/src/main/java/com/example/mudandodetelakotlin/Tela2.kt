package com.example.mudandodetelakotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mudandodetelakotlin.databinding.ActivityTela2Binding

class Tela2 : AppCompatActivity() {
    private lateinit var binding: ActivityTela2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityTela2Binding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        binding.buttonVoltar.setOnClickListener {
            // como eu não coloquei outro nome na tela principal, eu vou chamar ela de
            //MainActivity
            val y = Intent(this, MainActivity::class.java)
            startActivity(y)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}