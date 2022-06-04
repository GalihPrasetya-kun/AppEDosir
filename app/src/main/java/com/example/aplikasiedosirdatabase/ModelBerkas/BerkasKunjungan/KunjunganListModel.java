package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKunjungan;

public class KunjunganListModel {
    String namakunjungan, tgllahirkunjungan, urlkunjungan;

    public KunjunganListModel(){

    }

    public KunjunganListModel(String namakunjungan, String tgllahirkunjungan, String urlkunjungan) {
        this.namakunjungan = namakunjungan;
        this.tgllahirkunjungan = tgllahirkunjungan;
        this.urlkunjungan = urlkunjungan;
    }

    public String getNamakunjungan() {
        return namakunjungan;
    }

    public void setNamakunjungan(String namakunjungan) {
        this.namakunjungan = namakunjungan;
    }

    public String getTgllahirkunjungan() {
        return tgllahirkunjungan;
    }

    public void setTgllahirkunjungan(String tgllahirkunjungan) {
        this.tgllahirkunjungan = tgllahirkunjungan;
    }

    public String getUrlkunjungan() {
        return urlkunjungan;
    }

    public void setUrlkunjungan(String urlkunjungan) {
        this.urlkunjungan = urlkunjungan;
    }
}
