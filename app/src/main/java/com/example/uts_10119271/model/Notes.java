package com.example.uts_10119271.model;



public class Notes {
    private String id;
    private String tanggal;
    private String judul;
    private String kategori;
    private String isi;
    //    NIM : 10119271
    //    Nama : Ikra Esa A'raaf Mahardika
    //    Kelas : IF 7

    public Notes(String id, String tanggal, String judul, String kategori, String isi) {
        this.id = id;
        this.tanggal = tanggal;
        this.judul = judul;
        this.kategori = kategori;
        this.isi = isi;
    }
    public String getId(){
        return id;
    }
    public String getTanggal(){
        return tanggal;
    }
    public String getJudul(){
        return judul;
    }
    public String getKategori(){
        return kategori;
    }
    public String getIsi(){
        return isi;
    }
}
