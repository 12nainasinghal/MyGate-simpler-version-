package com.example.mygate;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    public Button fab;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    LinearLayout Notice;
    LinearLayout Helpdesk;
    LinearLayout Emergency;
    LinearLayout Visitor;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        fab = findViewById(R.id.fab);
        txt1 = findViewById(R.id.text1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.text3);
        txt4 = findViewById(R.id.text4);
        Notice = findViewById(R.id.notice);
        Helpdesk = findViewById(R.id.helpdesk);
        Emergency = findViewById(R.id.emergency);
        Visitor = findViewById(R.id.visitor);
        img1 = findViewById(R.id.imgnotice);
        img2 = findViewById(R.id.imghelp);
        img3 = findViewById(R.id.imgemer);
        img4 = findViewById(R.id.imgvisit);

        img1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
            startActivity(intent);
        });
        img2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity8.class);
            startActivity(intent);
        });
        img3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
            startActivity(intent);
        });
        img4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity6.class);
            startActivity(intent);
        });

        Notice.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
            startActivity(intent);
        });
        Helpdesk.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity8.class);
            startActivity(intent);
        });
        Emergency.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
            startActivity(intent);
        });
        Visitor.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity6.class);
            startActivity(intent);
        });

        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        });
        txt1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
            startActivity(intent);
        });
        txt3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
            startActivity(intent);
        });
        txt4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity6.class);
            startActivity(intent);
        });
        txt2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity8.class);
            startActivity(intent);
        });

    }
}

