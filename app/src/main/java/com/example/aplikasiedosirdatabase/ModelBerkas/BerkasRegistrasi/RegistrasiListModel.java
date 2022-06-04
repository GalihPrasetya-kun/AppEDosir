package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasRegistrasi;

import com.example.aplikasiedosirdatabase.ModelBerkas.BerkasPernyataan.PernyataanListModel;

public class RegistrasiListModel {
    String namaregistrasi, tgllahirregistrasi, urlregistrasi;

    public RegistrasiListModel(){

    }

    public RegistrasiListModel(String namaregistrasi, String tgllahirregistrasi, String urlregistrasi) {
        this.namaregistrasi = namaregistrasi;
        this.tgllahirregistrasi = tgllahirregistrasi;
        this.urlregistrasi = urlregistrasi;
    }

    public String getNamaregistrasi() {
        return namaregistrasi;
    }

    public void setNamaregistrasi(String namaregistrasi) {
        this.namaregistrasi = namaregistrasi;
    }

    public String getTgllahirregistrasi() {
        return tgllahirregistrasi;
    }

    public void setTgllahirregistrasi(String tgllahirregistrasi) {
        this.tgllahirregistrasi = tgllahirregistrasi;
    }

    public String getUrlregistrasi() {
        return urlregistrasi;
    }

    public void setUrlregistrasi(String urlregistrasi) {
        this.urlregistrasi = urlregistrasi;
    }
}
