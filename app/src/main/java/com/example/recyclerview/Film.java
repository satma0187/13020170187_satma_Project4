package com.example.recyclerview;

public class Film {
    String nama,desc;
    int photo;

    public Film(String nama, String desc, int photo) {
        this.nama = nama;
        this.desc = desc;
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public String getDesc() {
        return desc;
    }

    public int getPhoto() {
        return photo;
    }
}
