package com.example.mygate;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    Button button;
    ListView list;
    String[] mobile
            = { "POLICE = 100 or 112", "FIRE = 101",
            "AMBULANCE = 102", "Women Helpline = 1091",
            "Deputy Commissioner Of Police–Missing Child And Women = 1094", "Senior Citizen Helpline = 14567",
            "Road Accident Emergency Service = 1073", "ORBO Centre, AIIMS (For Donation Of Organ) Delhi= 1060 ",
            "CYBER CRIME HELPLINE = 155620", "LPG Leak Helpline = 1906", "COVID 19 HELPLINE : 011-23978046 OR 1075"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5);
        list = findViewById(R.id.listview);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<>(this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, mobile);
        list.setAdapter(arr);
        button= findViewById(R.id.btn6);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}

