package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        editTextEmail = findViewById(R.id.editTextNome_Cadastro);
        editTextPassword = findViewById(R.id.editTextEmail_Cadastro);
        btnLogin = findViewById(R.id.btnCadastrar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Verifica se os campos não estão vazios
                if (!email.isEmpty() && !password.isEmpty()) {
                    // Inicia a atividade ContatosActivity se os campos não estiverem vazios
                    Intent i = new Intent(LoginActivity.this, ContatosActivity.class);
                    startActivity(i);
                } else {
                    // Exibe uma mensagem informando que os campos não podem estar vazios
                    if (email.isEmpty()) {
                        editTextEmail.setError("Email não pode estar vazio");
                    }
                    if (password.isEmpty()) {
                        editTextPassword.setError("Senha não pode estar vazia");
                    }
                }
            }
        });
    }
}

