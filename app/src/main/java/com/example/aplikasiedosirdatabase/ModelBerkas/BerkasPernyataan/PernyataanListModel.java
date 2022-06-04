package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasPernyataan;

public class PernyataanListModel {
    String namapernyataan, tgllahirpernyataan, urlpernyataan;

    public PernyataanListModel(){

    }

    public PernyataanListModel(String namapernyataan, String tgllahirpernyataan, String urlpernyataan) {
        this.namapernyataan = namapernyataan;
        this.tgllahirpernyataan = tgllahirpernyataan;
        this.urlpernyataan = urlpernyataan;
    }

    public String getNamapernyataan() {
        return namapernyataan;
    }

    public void setNamapernyataan(String namapernyataan) {
        this.namapernyataan = namapernyataan;
    }

    public String getTgllahirpernyataan() {
        return tgllahirpernyataan;
    }

    public void setTgllahirpernyataan(String tgllahirpernyataan) {
        this.tgllahirpernyataan = tgllahirpernyataan;
    }

    public String getUrlpernyataan() {
        return urlpernyataan;
    }

    public void setUrlpernyataan(String urlpernyataan) {
        this.urlpernyataan = urlpernyataan;
    }
}
