package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpdateProfile extends AppCompatActivity {
    DataBase db;
    String id;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_profile);
        db =new DataBase(UpdateProfile.this);

        id = getIntent().getStringExtra(DataBase.ID);
        String name = getIntent().getStringExtra(DataBase.NAME);
        String familyName = getIntent().getStringExtra(DataBase.FAMILYNAME);
        String email = getIntent().getStringExtra(DataBase.Email);
        String phone = getIntent().getStringExtra(DataBase.Phone);

        EditText Name = findViewById(R.id.name);
        Name.setText(name);
        EditText FamilyName = findViewById(R.id.familyName);
        FamilyName.setText(familyName);
        EditText Email = findViewById(R.id.email);
        Email.setText(email);
        EditText Phone = findViewById(R.id.phone);
        Phone.setText(phone);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }


    public void updating(View view) {

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
        String PhoneValue = Phone.getText().toString();

        // validating if the text fields are empty or not.
        if (NameValue.isEmpty()){
            Toast.makeText(UpdateProfile.this, "Please enter the Name..", Toast.LENGTH_SHORT).show();
            return;
        }
        if (FamilyNameValue.isEmpty()){
            Toast.makeText(UpdateProfile.this, "Please enter the Family name..", Toast.LENGTH_SHORT).show();
            return;
        }
        if (EmailValue.isEmpty()){
            Toast.makeText(UpdateProfile.this, "Please enter the Email..", Toast.LENGTH_SHORT).show();
            return;
        }
        if (PhoneValue.isEmpty()){
            Toast.makeText(UpdateProfile.this, "Please enter the Phone number..", Toast.LENGTH_SHORT).show();
            return;
        }

        db.updateProfile(id, NameValue, FamilyNameValue, EmailValue, PhoneValue);

        Intent shift = new Intent(this, Liste.class);
        startActivity(shift);

    }

    public void ShowAll(View view) {
        Intent shift = new Intent(this, Liste.class);
        startActivity(shift);
    }

    //public void Delete(View view){

        //db.deleteProfile(id);
        //Intent shift = new Intent(this, Liste.class);
        //startActivity(shift);
   // }
    public void Delete(View view) {
        // Get the ID from the Intent or wherever you're storing it
        String id = getIntent().getStringExtra(DataBase.ID);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete this profile?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked the Yes button, attempt to delete the profile
                        try {
                            db.deleteProfile(id);
                            Toast.makeText(UpdateProfile.this, "Profile deleted successfully", Toast.LENGTH_SHORT).show();
                            Intent shift = new Intent(UpdateProfile.this, Liste.class);
                            startActivity(shift);
                        } catch (Exception e) {
                            Log.e("DeleteProfile", "Error deleting profile: " + e.getMessage());
                            Toast.makeText(UpdateProfile.this, "Failed to delete profile", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog, do nothing
                    }
                });
        // Create the AlertDialog object and return it
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}