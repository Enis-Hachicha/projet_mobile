package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class Liste extends AppCompatActivity {
    DataBase dbName;
    final String[] from = new String[]{DataBase.NAME, DataBase.FAMILYNAME, DataBase.Email, DataBase.Phone};
    final int[] to = new int[]{R.id.nameT, R.id.familyNameT, R.id.emailT, R.id.phoneT};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.liste);

        //DataBase
        dbName = new DataBase(Liste.this);

        //GetAll
        try {
            ArrayList<Donut> profileList = dbName.getUsers();
            //display using adapter
            ListView lv = (ListView) findViewById(R.id.liste);
            ListAdapter adapter = new DonutAdapter(this, profileList);
            lv.setAdapter(adapter);

            lv.setOnItemClickListener((parent, view, position, id) ->{
                Donut profile = profileList.get(position);

                Intent intent = new Intent(Liste.this, UpdateProfile.class);

                intent.putExtra(DataBase.ID, profile.getID());
                intent.putExtra(DataBase.NAME, profile.getNAME());
                intent.putExtra(DataBase.FAMILYNAME, profile.getFAMILYNAME());
                intent.putExtra(DataBase.Email, profile.getEmail());
                intent.putExtra(DataBase.Phone, profile.getPhone());

                startActivity(intent);
            });

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void Back(View view) {
        Intent shift = new Intent(this, Login.class);
        startActivity(shift);
    }

    public void signin(View view) {
        Intent shift = new Intent(this, SignUp.class);
        startActivity(shift);
    }
}