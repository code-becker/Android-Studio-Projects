package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;

public class TermsActivity extends AppCompatActivity {

    private TextView textViewTerms, textViewPrivacy;
    private CheckBox checkBoxAccept;
    private Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        textViewTerms = findViewById(R.id.textViewTerms);
        textViewPrivacy = findViewById(R.id.textViewPrivacy);
        checkBoxAccept = findViewById(R.id.checkBoxAccept);
        buttonContinue = findViewById(R.id.buttonContinue);

        loadDocuments();

        checkBoxAccept.setOnCheckedChangeListener((buttonView, isChecked) -> buttonContinue.setEnabled(isChecked));

        buttonContinue.setOnClickListener(v -> {
            if (checkBoxAccept.isChecked()) {
                // Lógica para continuar
                Toast.makeText(TermsActivity.this, "Termos aceitos!", Toast.LENGTH_SHORT).show();
                // Você pode adicionar uma navegação para outra activity aqui
                Intent Newpage = new Intent(TermsActivity.this, LoginActivity.class);
                startActivity(Newpage);
                finish(); // Fecha a TermsActivity
            } else {
                Toast.makeText(TermsActivity.this, "Você deve aceitar os termos para continuar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadDocuments() {
        String terms = readTextFromAsset("terms.txt");
        String privacy = readTextFromAsset("privacy.txt");

        textViewTerms.setText(terms);
        textViewPrivacy.setText(privacy);
    }

    private String readTextFromAsset(String fileName) {
        StringBuilder text = new StringBuilder();
        try {
            InputStream is = getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text.append(new String(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}