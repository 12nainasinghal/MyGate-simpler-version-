package com.example.mygate;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    TextView showTitle, showDetails;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Notes Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        showTitle = findViewById(R.id.showtitle);
        showDetails = findViewById(R.id.showdetails);
        NoteModel noteModel;
        NoteDatabase db = new NoteDatabase(this);
            Intent intent = getIntent();
            id = intent.getIntExtra("ID", 0);
            noteModel = db.getNotes(id);
        showTitle.setText(noteModel.getNoteTitle());
        showDetails.setText(noteModel.getNoteDetails());
        Toast.makeText(getApplicationContext(),"id"+noteModel.getId(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        if (item.getItemId() == R.id.delete){
            NoteDatabase db = new NoteDatabase(this);
            Intent intent = getIntent();
            id = intent.getIntExtra("ID", 0);
            db.deleteNote(id);
            Toast.makeText(getApplicationContext(), "Note Details", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(DetailActivity.this, MainActivity4.class);
            startActivity(intent1);
        }

        return super.onOptionsItemSelected(item);
    }
}