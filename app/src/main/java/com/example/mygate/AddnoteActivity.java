package com.example.mygate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddnoteActivity extends AppCompatActivity {
    EditText title,details;
    Button addnotebtn;
    String todayDate, currentTime;
    Calendar calendar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);
        getSupportActionBar().setTitle("Add New Note!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = findViewById(R.id.addnote);
        details = findViewById(R.id.notedetails);
        addnotebtn = findViewById(R.id.addnotebtn);
        calendar = Calendar.getInstance();
        todayDate = calendar.get(Calendar.YEAR)+"/"+calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH);
        currentTime = pad(calendar.get(Calendar.HOUR))+":"+pad(calendar.get(Calendar.MINUTE));
        Log.d("Calender", "Date and Time" + todayDate+" and "+currentTime);

        addnotebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteModel noteModel = new NoteModel(title.getText().toString(),details.getText().toString(),todayDate,currentTime);
                NoteDatabase db = new NoteDatabase(AddnoteActivity.this);
                db.AddNote(noteModel);

                Intent intent = new Intent(AddnoteActivity.this, MainActivity4.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "NOTE SAVED!", Toast.LENGTH_SHORT).show();
        }
        });
    }
    public String pad(int i){
        if(i < 0)
            return"0"+i;
        return String.valueOf(i);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}