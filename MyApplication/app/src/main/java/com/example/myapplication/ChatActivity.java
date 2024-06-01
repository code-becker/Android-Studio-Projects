package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private ListView listViewChats;
    private EditText editTextMessage;
    private Button btnSend;
    private ArrayList<String> chatMessages;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);



        listViewChats = findViewById(R.id.listViewChats);
        editTextMessage = findViewById(R.id.editTextMessage);
        btnSend = findViewById(R.id.btnSend);

        chatMessages = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chatMessages);
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
            chatMessages.add("Amanda: Olá");
        } else if (message.equalsIgnoreCase("como vai")) {
            chatMessages.add("Amanda: Como está?");
        } else if (message.equalsIgnoreCase("estou bem, e você?")) {
            chatMessages.add("Amanda: Estou bem, e você?");
        } else {
            chatMessages.add("Amanda: Desculpe, não entendi.");
        }


    }
}