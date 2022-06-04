package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasIntake;

public class IntakeListModel {
    String namaintake, tgllahirintake, urlintake;

    public IntakeListModel(){

    }

    public IntakeListModel(String namaintake, String tgllahirintake, String urlintake) {
        this.namaintake = namaintake;
        this.tgllahirintake = tgllahirintake;
        this.urlintake = urlintake;
    }

    public String getNamaintake() {
        return namaintake;
    }

    public void setNamaintake(String namaintake) {
        this.namaintake = namaintake;
    }

    public String getTgllahirintake() {
        return tgllahirintake;
    }

    public void setTgllahirintake(String tgllahirintake) {
        this.tgllahirintake = tgllahirintake;
    }

    public String getUrlintake() {
        return urlintake;
    }

    public void setUrlintake(String urlintake) {
        this.urlintake = urlintake;
    }
}
