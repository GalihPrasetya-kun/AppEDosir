package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasKtp;

public class KtpListModel {
    String namaktp, tgllahirktp, urlktp;

    public KtpListModel(){

    }

    public KtpListModel(String namaktp, String tgllahirktp, String urlktp) {
        this.namaktp = namaktp;
        this.tgllahirktp = tgllahirktp;
        this.urlktp = urlktp;
    }

    public String getNamaktp() {
        return namaktp;
    }

    public void setNamaktp(String namaktp) {
        this.namaktp = namaktp;
    }

    public String getTgllahirktp() {
        return tgllahirktp;
    }

    public void setTgllahirktp(String tgllahirktp) {
        this.tgllahirktp = tgllahirktp;
    }

    public String getUrlktp() {
        return urlktp;
    }

    public void setUrlktp(String urlktp) {
        this.urlktp = urlktp;
    }
}
