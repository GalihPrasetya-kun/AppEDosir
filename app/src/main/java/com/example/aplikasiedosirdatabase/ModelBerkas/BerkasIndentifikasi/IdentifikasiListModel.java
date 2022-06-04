package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasIndentifikasi;

public class IdentifikasiListModel {
    String namaidentifikasi, tgllahiridentifikasi, urlidentifikasi;

    public IdentifikasiListModel(){

    }

    public IdentifikasiListModel(String namaidentifikasi, String tgllahiridentifikasi, String urlidentifikasi) {
        this.namaidentifikasi = namaidentifikasi;
        this.tgllahiridentifikasi = tgllahiridentifikasi;
        this.urlidentifikasi = urlidentifikasi;
    }

    public String getNamaidentifikasi() {
        return namaidentifikasi;
    }

    public void setNamaidentifikasi(String namaidentifikasi) {
        this.namaidentifikasi = namaidentifikasi;
    }

    public String getTgllahiridentifikasi() {
        return tgllahiridentifikasi;
    }

    public void setTgllahiridentifikasi(String tgllahiridentifikasi) {
        this.tgllahiridentifikasi = tgllahiridentifikasi;
    }

    public String getUrlidentifikasi() {
        return urlidentifikasi;
    }

    public void setUrlidentifikasi(String urlidentifikasi) {
        this.urlidentifikasi = urlidentifikasi;
    }
}
