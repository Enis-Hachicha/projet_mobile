package com.example.myapplication;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Login extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void ShowAll(View view) {
        EditText Username = findViewById(R.id.username);
        String UsernameValue = Username.getText().toString();

        EditText Password = findViewById(R.id.password);
        String PasswordValue = Password.getText().toString();

        if (UsernameValue.isEmpty()){
            Toast.makeText(Login.this, "Enter your username..", Toast.LENGTH_SHORT).show();
            return;
        }

        if (PasswordValue.isEmpty()){
            Toast.makeText(Login.this, "Enter a password..", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!UsernameValue.equals("topadmin")){
            Toast.makeText(Login.this, "Couldn't find an account with your username..", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!PasswordValue.equals("topadmin")){
            Toast.makeText(Login.this, "Wrong Password..", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent shift = new Intent(this, Liste.class);
        startActivity(shift);
    }

    public void signin(View view) {
        Intent shift = new Intent(this, SignUp.class);
        startActivity(shift);
    }
}