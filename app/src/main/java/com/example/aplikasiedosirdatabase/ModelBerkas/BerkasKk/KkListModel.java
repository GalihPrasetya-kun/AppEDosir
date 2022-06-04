package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKk;

public class KkListModel {
    String namakk, tgllahirkk, urlkk;

    public KkListModel(){

    }

    public KkListModel(String namakk, String tgllahirkk, String urlkk) {
        this.namakk = namakk;
        this.tgllahirkk = tgllahirkk;
        this.urlkk = urlkk;
    }

    public String getNamakk() {
        return namakk;
    }

    public void setNamakk(String namakk) {
        this.namakk = namakk;
    }

    public String getTgllahirkk() {
        return tgllahirkk;
    }

    public void setTgllahirkk(String tgllahirkk) {
        this.tgllahirkk = tgllahirkk;
    }

    public String getUrlkk() {
        return urlkk;
    }

    public void setUrlkk(String urlkk) {
        this.urlkk = urlkk;
    }
}
