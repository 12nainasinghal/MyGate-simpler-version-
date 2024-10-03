package com.example.mygate;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
public class MainActivity7 extends AppCompatActivity {
    String otp, phone;
    String message = "is your verification code.";
    Button button;
    Button button1;
    EditText etphone, etotp;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity7);
        button = findViewById(R.id.sendsms);
        etotp = findViewById(R.id.etotp);
        button1 = findViewById(R.id.btn8);
        etphone =  findViewById(R.id.etphone);
        button1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity7.this, MainActivity2.class);
            startActivity(intent);
        });
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity7.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    sendOTP();
                } else {
                    ActivityCompat.requestPermissions(MainActivity7.this, new String[]{Manifest.permission.SEND_SMS}, 100);
                }
            }
        });
    }
    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 100){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                sendOTP();
            } else{
                Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void sendOTP() {
        otp = etotp.getText().toString();
        phone = etphone.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        ArrayList <String> parts = smsManager.divideMessage(otp + " " + message);
        String phoneNumber = phone;
        smsManager.sendMultipartTextMessage(phoneNumber, null, parts, null, null);
    }
}