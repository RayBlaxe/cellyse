package com.project.celllyse;

public class ArtikelItem {
     int imgArtikel;
     String judulArtikel;
     String isiArtikel;

public ArtikelItem(int imageUrl, String judul, String isi) {
    imgArtikel = imageUrl;
        judulArtikel = judul;
        isiArtikel = isi;
    }

    public int getImgArtikel() {
        return imgArtikel;
    }

    public void setImgArtikel(int imgArtikel) {
        this.imgArtikel = imgArtikel;
    }

    public String getJudulArtikel() {
        return judulArtikel;
    }

    public void setJudulArtikel(String judulArtikel) {
        this.judulArtikel = judulArtikel;
    }

    public String getIsiArtikel() {
        return isiArtikel;
    }

    public void setIsiArtikel(String isiArtikel) {
        this.isiArtikel = isiArtikel;
    }
}
