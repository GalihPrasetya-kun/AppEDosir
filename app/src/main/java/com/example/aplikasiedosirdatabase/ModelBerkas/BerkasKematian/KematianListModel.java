package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKematian;

public class KematianListModel {
    String namakematian, tgllahirkematian, urlkematian;

    public KematianListModel(){

    }

    public KematianListModel(String namakematian, String tgllahirkematian, String urlkematian) {
        this.namakematian = namakematian;
        this.tgllahirkematian = tgllahirkematian;
        this.urlkematian = urlkematian;
    }

    public String getNamakematian() {
        return namakematian;
    }

    public void setNamakematian(String namakematian) {
        this.namakematian = namakematian;
    }

    public String getTgllahirkematian() {
        return tgllahirkematian;
    }

    public void setTgllahirkematian(String tgllahirkematian) {
        this.tgllahirkematian = tgllahirkematian;
    }

    public String getUrlkematian() {
        return urlkematian;
    }

    public void setUrlkematian(String urlkematian) {
        this.urlkematian = urlkematian;
    }
}
