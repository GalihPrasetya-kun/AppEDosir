package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasSerah;

public class SerahListModel {
    String namaserah, tgllahirserah, urlserah;

    public SerahListModel(){

    }

    public SerahListModel(String namaserah, String tgllahirserah, String urlserah) {
        this.namaserah = namaserah;
        this.tgllahirserah = tgllahirserah;
        this.urlserah = urlserah;
    }

    public String getNamaserah() {
        return namaserah;
    }

    public void setNamaserah(String namaserah) {
        this.namaserah = namaserah;
    }

    public String getTgllahirserah() {
        return tgllahirserah;
    }

    public void setTgllahirserah(String tgllahirserah) {
        this.tgllahirserah = tgllahirserah;
    }

    public String getUrlserah() {
        return urlserah;
    }

    public void setUrlserah(String urlserah) {
        this.urlserah = urlserah;
    }
}
