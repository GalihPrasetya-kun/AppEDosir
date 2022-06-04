package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKetSehat;

public class KetSehatListModel {
    String namaketsehat, tgllahirketsehat, urlketsehat;

    public KetSehatListModel(){

    }

    public KetSehatListModel(String namaketsehat, String tgllahirketsehat, String urlketsehat) {
        this.namaketsehat = namaketsehat;
        this.tgllahirketsehat = tgllahirketsehat;
        this.urlketsehat = urlketsehat;
    }

    public String getNamaketsehat() {
        return namaketsehat;
    }

    public void setNamaketsehat(String namaketsehat) {
        this.namaketsehat = namaketsehat;
    }

    public String getTgllahirketsehat() {
        return tgllahirketsehat;
    }

    public void setTgllahirketsehat(String tgllahirketsehat) {
        this.tgllahirketsehat = tgllahirketsehat;
    }

    public String getUrlketsehat() {
        return urlketsehat;
    }

    public void setUrlketsehat(String urlketsehat) {
        this.urlketsehat = urlketsehat;
    }
}
