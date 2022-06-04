package com.example.aplikasiedosirdatabase.ModelBerkas.BerkasAssessment;

public class AssessmentListModel {
    String namaassessment, tgllahirassessment, urlassessment;

    public AssessmentListModel(){

    }

    public AssessmentListModel(String namaassessment, String tgllahirassessment, String urlassessment) {
        this.namaassessment = namaassessment;
        this.tgllahirassessment = tgllahirassessment;
        this.urlassessment = urlassessment;
    }

    public String getNamaassessment() {
        return namaassessment;
    }

    public void setNamaassessment(String namaassessment) {
        this.namaassessment = namaassessment;
    }

    public String getTgllahirassessment() {
        return tgllahirassessment;
    }

    public void setTgllahirassessment(String tgllahirassessment) {
        this.tgllahirassessment = tgllahirassessment;
    }

    public String getUrlassessment() {
        return urlassessment;
    }

    public void setUrlassessment(String urlassessment) {
        this.urlassessment = urlassessment;
    }
}
