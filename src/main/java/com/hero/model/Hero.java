package com.hero.model;

public class Hero {
    private int idHero;
    private String namaHero;
    private String kategori;
    private String gender;

    // Constructor kosong
    public Hero() {}

    // Constructor untuk tambah data (tanpa ID)
    public Hero(String namaHero, String kategori, String gender) {
        this.namaHero = namaHero;
        this.kategori = kategori;
        this.gender = gender;
    }

    // Constructor lengkap (dengan ID)
    public Hero(int idHero, String namaHero, String kategori, String gender) {
        this.idHero = idHero;
        this.namaHero = namaHero;
        this.kategori = kategori;
        this.gender = gender;
    }

    // Getter dan Setter
    public int getIdHero() {
        return idHero;
    }

    public void setIdHero(int idHero) {
        this.idHero = idHero;
    }

    public String getNamaHero() {
        return namaHero;
    }

    public void setNamaHero(String namaHero) {
        this.namaHero = namaHero;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}