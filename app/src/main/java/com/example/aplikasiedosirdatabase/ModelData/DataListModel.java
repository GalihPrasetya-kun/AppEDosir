package com.example.aplikasiedosirdatabase.ModelData;

public class DataListModel {
    String noinduk, noktp, nama, tgllahir, jkelamin, status, pendidikan, agama, alamat, asrama, pjawab, tglmasuk, catatanpm, urlprofile;

    public DataListModel(){

    }

    public DataListModel(String noinduk, String noktp, String nama, String tgllahir, String jkelamin, String status, String pendidikan, String agama, String alamat, String asrama, String pjawab, String tglmasuk, String catatanpm, String urlprofile) {
        this.noinduk = noinduk;
        this.noktp = noktp;
        this.nama = nama;
        this.tgllahir = tgllahir;
        this.jkelamin = jkelamin;
        this.status = status;
        this.pendidikan = pendidikan;
        this.agama = agama;
        this.alamat = alamat;
        this.asrama = asrama;
        this.pjawab = pjawab;
        this.tglmasuk = tglmasuk;
        this.catatanpm = catatanpm;
        this.urlprofile = urlprofile;
    }

    public String getNoinduk() {
        return noinduk;
    }

    public void setNoinduk(String noinduk) {
        this.noinduk = noinduk;
    }

    public String getNoktp() {
        return noktp;
    }

    public void setNoktp(String noktp) {
        this.noktp = noktp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTgllahir() {
        return tgllahir;
    }

    public void setTgllahir(String tgllahir) {
        this.tgllahir = tgllahir;
    }

    public String getJkelamin() {
        return jkelamin;
    }

    public void setJkelamin(String jkelamin) {
        this.jkelamin = jkelamin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAsrama() {
        return asrama;
    }

    public void setAsrama(String asrama) {
        this.asrama = asrama;
    }

    public String getPjawab() {
        return pjawab;
    }

    public void setPjawab(String pjawab) {
        this.pjawab = pjawab;
    }

    public String getTglmasuk() {
        return tglmasuk;
    }

    public void setTglmasuk(String tglmasuk) {
        this.tglmasuk = tglmasuk;
    }

    public String getCatatanpm() {
        return catatanpm;
    }

    public void setCatatanpm(String catatanpm) {
        this.catatanpm = catatanpm;
    }

    public String getUrlprofile() {
        return urlprofile;
    }

    public void setUrlprofile(String urlprofile) {
        this.urlprofile = urlprofile;
    }
}
