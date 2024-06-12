package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import android.os.Bundle;
public class ConversaActivity extends AppCompatActivity {
    private ListView listViewChats;
    private EditText editTextMessage;
    private Button btnSend;
    private ArrayList<String> chatMessages;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversa);

        String contatoNome = getIntent().getStringExtra("CONTATO_NOME");
        TextView textViewConversa = findViewById(R.id.textViewConversa);
        textViewConversa.setText("Chat " + contatoNome);

        listViewChats = findViewById(R.id.listViewChats);
        editTextMessage = findViewById(R.id.editTextMessage);
        btnSend = findViewById(R.id.btnSend);

        chatMessages = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chatMessages) {
            @Override
            public View getView(int position, View convertView, android.view.ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK); // Define a cor do texto para preto
                return view;
            }
        };
        listViewChats.setAdapter(adapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString();
                if (!message.isEmpty()) {
                    chatMessages.add("Você: " + message);
                    respondToMessage(message);
                    adapter.notifyDataSetChanged();
                    editTextMessage.setText("");
                }
            }
        });
    }

    private void respondToMessage(String message) {
        if (message.equalsIgnoreCase("oi")) {
            chatMessages.add("Usuário: Olá");
        } else if (message.equalsIgnoreCase("como vai?")) {
            chatMessages.add("Usuário: Estou bem, e você?");
        } else if (message.equalsIgnoreCase("estou bem, e você?")) {
            chatMessages.add("Usuário: Estou bem, e você?");
        } else {
            chatMessages.add("Usuário: Desculpe, não entendi.");
        }
    }
}