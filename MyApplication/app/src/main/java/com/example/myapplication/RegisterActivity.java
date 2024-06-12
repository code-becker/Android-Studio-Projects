package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextNomeCadastro, editTextTelefoneCadastro, editTextEmailCadastro, editTextSenha;
    private Button buttonCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextNomeCadastro = findViewById(R.id.editTextNome_Cadastro);
        editTextTelefoneCadastro = findViewById(R.id.editTextNumero_Cadastro);
        editTextEmailCadastro = findViewById(R.id.editTextEmail_Cadastro);
        editTextSenha = findViewById(R.id.editTextSenha_Cadastro);
        buttonCadastrar = findViewById(R.id.btnCadastrar);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (areAllFieldsFilled()) {
                    registerUser();
                    Intent intent = new Intent(RegisterActivity.this, TermsActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegisterActivity.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private boolean areAllFieldsFilled() {
        return !editTextNomeCadastro.getText().toString().trim().isEmpty() &&
                !editTextTelefoneCadastro.getText().toString().trim().isEmpty() &&
                !editTextEmailCadastro.getText().toString().trim().isEmpty() &&
                !editTextSenha.getText().toString().trim().isEmpty();
    }

    private void registerUser() {
        String nome = editTextNomeCadastro.getText().toString().trim();
        String telefone = editTextTelefoneCadastro.getText().toString().trim();
        String email = editTextEmailCadastro.getText().toString().trim();
        String password = editTextSenha.getText().toString().trim();

        if (nome.isEmpty()) {
            editTextNomeCadastro.setError("Nome de usuário é obrigatório");
            editTextNomeCadastro.requestFocus();
            return;
        }

        if (telefone.isEmpty()) {
            editTextTelefoneCadastro.setError("Número de telefone é obrigatório");
            editTextTelefoneCadastro.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextEmailCadastro.setError("E-mail é obrigatório");
            editTextEmailCadastro.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmailCadastro.setError("Insira um e-mail válido");
            editTextEmailCadastro.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextSenha.setError("Senha é obrigatória");
            editTextSenha.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextSenha.setError("Senha deve ter pelo menos 6 caracteres");
            editTextSenha.requestFocus();
            return;
        }

        // Se todos os campos estiverem validados, mostrar uma mensagem de sucesso
        Toast.makeText(RegisterActivity.this, "Usuário registrado com sucesso", Toast.LENGTH_SHORT).show();

        // Aqui você pode adicionar a lógica para salvar os dados do usuário no banco de dados
    }
}
