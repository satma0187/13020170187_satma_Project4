package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView judul, description;
    String judulfilm, desk;
    int poster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = findViewById(R.id.image_detail);
        judul = findViewById(R.id.judulFilm);
        description = findViewById(R.id.deskripsi);

        judulfilm = getIntent().getStringExtra("judulFilm");
        desk = getIntent().getStringExtra("deskripsi");
        poster = getIntent().getIntExtra("image_detail",0);

        judul.setText(judulfilm);
        description.setText(desk);
        imageView.setImageResource(poster);
    }
}
