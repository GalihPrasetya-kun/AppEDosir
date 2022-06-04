package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKontrak;

public class KontrakListModel {
    String namakontrak, tgllahirkontrak, urlkontrak;

    public KontrakListModel(){

    }

    public KontrakListModel(String namakontrak, String tgllahirkontrak, String urlkontrak) {
        this.namakontrak = namakontrak;
        this.tgllahirkontrak = tgllahirkontrak;
        this.urlkontrak = urlkontrak;
    }

    public String getNamakontrak() {
        return namakontrak;
    }

    public void setNamakontrak(String namakontrak) {
        this.namakontrak = namakontrak;
    }

    public String getTgllahirkontrak() {
        return tgllahirkontrak;
    }

    public void setTgllahirkontrak(String tgllahirkontrak) {
        this.tgllahirkontrak = tgllahirkontrak;
    }

    public String getUrlkontrak() {
        return urlkontrak;
    }

    public void setUrlkontrak(String urlkontrak) {
        this.urlkontrak = urlkontrak;
    }
}
