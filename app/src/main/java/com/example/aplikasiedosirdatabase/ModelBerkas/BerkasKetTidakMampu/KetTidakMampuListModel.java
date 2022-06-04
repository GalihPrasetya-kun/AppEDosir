package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKetTidakMampu;

public class KetTidakMampuListModel {
    String namakettidakmampu, tgllahirkettidakmampu, urlkettidakmampu;

    public KetTidakMampuListModel(){

    }

    public KetTidakMampuListModel(String namakettidakmampu, String tgllahirkettidakmampu, String urlkettidakmampu) {
        this.namakettidakmampu = namakettidakmampu;
        this.tgllahirkettidakmampu = tgllahirkettidakmampu;
        this.urlkettidakmampu = urlkettidakmampu;
    }

    public String getNamakettidakmampu() {
        return namakettidakmampu;
    }

    public void setNamakettidakmampu(String namakettidakmampu) {
        this.namakettidakmampu = namakettidakmampu;
    }

    public String getTgllahirkettidakmampu() {
        return tgllahirkettidakmampu;
    }

    public void setTgllahirkettidakmampu(String tgllahirkettidakmampu) {
        this.tgllahirkettidakmampu = tgllahirkettidakmampu;
    }

    public String getUrlkettidakmampu() {
        return urlkettidakmampu;
    }

    public void setUrlkettidakmampu(String urlkettidakmampu) {
        this.urlkettidakmampu = urlkettidakmampu;
    }
}
