package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasBpjs;

public class BpjsListModel {
    String namabpjs, tgllahirbpjs, urlbpjs;

    public BpjsListModel(){

    }

    public BpjsListModel(String namabpjs, String tgllahirbpjs, String urlbpjs) {
        this.namabpjs = namabpjs;
        this.tgllahirbpjs = tgllahirbpjs;
        this.urlbpjs = urlbpjs;
    }

    public String getNamabpjs() {
        return namabpjs;
    }

    public void setNamabpjs(String namabpjs) {
        this.namabpjs = namabpjs;
    }

    public String getTgllahirbpjs() {
        return tgllahirbpjs;
    }

    public void setTgllahirbpjs(String tgllahirbpjs) {
        this.tgllahirbpjs = tgllahirbpjs;
    }

    public String getUrlbpjs() {
        return urlbpjs;
    }

    public void setUrlbpjs(String urlbpjs) {
        this.urlbpjs = urlbpjs;
    }
}
