package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Film> data = new ArrayList<>();
    private RecyclerView recyclerView;
    String[] nama, desc;
    TypedArray photo;
    private Toolbar toolbar;
    private Button BHapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("List Movie");

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final FilmAdapter filmAdapter = new FilmAdapter(this, data);
        recyclerView.setAdapter(filmAdapter);
        getData();
        filmAdapter.notifyDataSetChanged();


    }

    void prepare() {
        nama = getResources().getStringArray(R.array.nama);
        desc = getResources().getStringArray(R.array.desc);
        photo = getResources().obtainTypedArray(R.array.photo);
    }

    void addItem() {
        for (int i = 0; i < nama.length; i++) {
            Film p = new Film(nama[i], desc[i], photo.getResourceId(i, -1));
            data.add(p);
        }
    }

    void getData() {
        prepare();
        addItem();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.id_Recyclerview:
                getData();
                break;
            case R.id.id_about:
                about();
                break;
        }
    }

    void about() {
        Intent i = new Intent(this, AboutActivity.class);
        startActivity(i);
    }


}
