package com.exemple.editlistview;

public class nghesy {
    String ten,nghedanh, sosao, quocgia;
    int imageId;

    public nghesy(String ten, String nghedanh, String sosao, String quocgia, int imageId) {
        this.ten = ten;
        this.nghedanh = nghedanh;
        this.sosao = sosao;
        this.quocgia = quocgia;
        this.imageId = imageId;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNghedanh() {
        return nghedanh;
    }

    public void setNghedanh(String nghedanh) {
        this.nghedanh = nghedanh;
    }

    public String getSosao() {
        return sosao;
    }

    public void setSosao(String sosao) {
        this.sosao = sosao;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
