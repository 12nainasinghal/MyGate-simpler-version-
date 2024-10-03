package com.example.mygate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity9 extends AppCompatActivity {
    Button button;
    ListView list;
    String[] mobile
            = {"CALL GUARD: 9984383997", "EMERGENCY NUMBER 1(24/7) = 1234567456",
            "EMERGENCY NUMBER 2 = 8936637765",
            "OFFICE = 108", "E-MAIL(For Complaints/Query) = abc12society@gmail.com",
            "Secretary: 9949009495"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity9);
        list = findViewById(R.id.lists);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, mobile);
        list.setAdapter(arr);

        button= findViewById(R.id.btn11);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity9.this, MainActivity8.class);
            startActivity(intent);
        });
    }
}

