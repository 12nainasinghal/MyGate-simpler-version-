package com.example.mygate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    Button chooseImgBtn, sendMMSBtn;
    ImageView imageView;
    String imageUri = "";
    Button button;
    EditText message;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        button = findViewById(R.id.next);
        chooseImgBtn = findViewById(R.id.idBtnChooseImage);
        sendMMSBtn = findViewById(R.id.idBtnSendMMS);
        imageView = findViewById(R.id.idIVImage);
        message = findViewById(R.id.idEdtBody);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity7.class);
            startActivity(intent);
        });
        chooseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line choosing image using intent.
                Intent i = new Intent();
                // on below line setting intent type.
                i.setType("image/*");
                // on below line setting action for intent.
                i.setAction(Intent.ACTION_GET_CONTENT);
                // on below line starting activity for result to select the image..
                startActivityForResult(Intent.createChooser(i, "Select Picture"), 100);
            }
        });
        sendMMSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line checking if the edit text field is empty.
                if (message.getText().toString().isEmpty()) {
                    // if edit text field is empty displaying a toast message.
                    Toast.makeText(MainActivity3.this, "Please enter MMS Body", Toast.LENGTH_SHORT).show();
                } else {
                    // on below line creating an intent to send sms
                    Intent sendIntent = new Intent(Intent.ACTION_SEND);
                    // on below line putting extra as sms body with the data from edit text
                    sendIntent.putExtra("sms_body", message.getText().toString());
                    // on below line putting extra as image uri
                    sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(imageUri));
                    // on below line setting intent type.
                    sendIntent.setType("image/png");
                    // on below line starting activity to send sms.
                    startActivity(sendIntent);
                }
            }
        });
    }
    // calling on activity result method.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // on below line checking if result is ok.
        if (resultCode == RESULT_OK) {
            // on below line checking for request code.
            if (requestCode == 100) {
                // on below line getting the selected image uri.
                Uri selectedImageUri = data.getData();
                // on below line checking if selected image uri is not null.
                if (null != selectedImageUri) {
                    // setting image uri in our variable.
                    imageUri = selectedImageUri.toString();
                    // loading the image from image uri in the image view
                    imageView.setImageURI(selectedImageUri);
                }
            }
        }
    }
}
