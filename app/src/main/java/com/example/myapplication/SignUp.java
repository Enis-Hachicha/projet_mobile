package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUp extends AppCompatActivity {
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db =new DataBase(SignUp.this);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void submission(View view) {
        //Name
        EditText Name = findViewById(R.id.name);
        String NameValue = Name.getText().toString();

        //Family Name
        EditText FamilyName = findViewById(R.id.familyName);
        String FamilyNameValue = FamilyName.getText().toString();

        //Email
        EditText Email = findViewById(R.id.email);
        String EmailValue = Email.getText().toString();

        //Phone
        EditText Phone = findViewById(R.id.phone);
        String PhoneValue = Phone.getText().toString()+" $";

        // validating if the text fields are empty or not.
        if (NameValue.isEmpty()){
            Toast.makeText(SignUp.this, "Please enter the Name..", Toast.LENGTH_SHORT).show();
            return;
        }
        if (FamilyNameValue.isEmpty()){
            Toast.makeText(SignUp.this, "Please enter the Family name..", Toast.LENGTH_SHORT).show();
            return;
        }
        if (EmailValue.isEmpty()){
            Toast.makeText(SignUp.this, "Please enter the Email..", Toast.LENGTH_SHORT).show();
            return;
        }
        if (PhoneValue.equals(" $")){
            Toast.makeText(SignUp.this, "Please enter the Phone number..", Toast.LENGTH_SHORT).show();
            return;
        }

        db.createProfile(NameValue, FamilyNameValue, EmailValue, PhoneValue);

        Toast.makeText(SignUp.this, "Profile has been added.", Toast.LENGTH_SHORT).show();
        Name.setText("");
        FamilyName.setText("");
        Email.setText("");
        Phone.setText("");

        //Intent shift = new Intent(this, liste.class);
        //startActivity(shift);

    }

    public void Back(View view) {
        Intent shift = new Intent(this, Login.class);
        startActivity(shift);
    }

    public void ShowAll(View view) {
        Intent shift = new Intent(this, Liste.class);
        startActivity(shift);
    }

}