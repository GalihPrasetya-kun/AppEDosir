package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasRekomendasi;

public class RekomendasiListModel {
    String namarekomendasi, tgllahirrekomendasi, urlrekomendasi;

    public RekomendasiListModel(){

    }

    public RekomendasiListModel(String namarekomendasi, String tgllahirrekomendasi, String urlrekomendasi) {
        this.namarekomendasi = namarekomendasi;
        this.tgllahirrekomendasi = tgllahirrekomendasi;
        this.urlrekomendasi = urlrekomendasi;
    }

    public String getNamarekomendasi() {
        return namarekomendasi;
    }

    public void setNamarekomendasi(String namarekomendasi) {
        this.namarekomendasi = namarekomendasi;
    }

    public String getTgllahirrekomendasi() {
        return tgllahirrekomendasi;
    }

    public void setTgllahirrekomendasi(String tgllahirrekomendasi) {
        this.tgllahirrekomendasi = tgllahirrekomendasi;
    }

    public String getUrlrekomendasi() {
        return urlrekomendasi;
    }

    public void setUrlrekomendasi(String urlrekomendasi) {
        this.urlrekomendasi = urlrekomendasi;
    }
}
