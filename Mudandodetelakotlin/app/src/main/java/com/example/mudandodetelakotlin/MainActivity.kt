package com.example.mudandodetelakotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mudandodetelakotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //variaveis
    public var loginuser = 0
    public var loginpass = 0


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

       loginuser = binding.editTextUser.text.toString().toString()

        binding.buttonAvancar.setOnClickListener {
            //chamar (esta, tela2:: da classe java), essa se usa quando tem muitas tela
        val i = Intent(this, Tela2::class.java)
            startActivity(i) //esse comando executa i

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}