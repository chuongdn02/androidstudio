package com.jovanovic.stefan.sqlitetutorial.Model;

public class Bien_ban {
    private int id;
    private String CCCD;
    private String diaDiem;
    private String loaixe;
    private String Noidung;
    private String LoaiViPham;
    private String soTienPhat;
    private int id_can_bo;

    public Bien_ban() {
    }

    public Bien_ban(final int id, final String CCCD, final String diaDiem, final String loaixe, final String noidung, final String loaiViPham, final String soTienPhat, final int id_can_bo) {
        this.id = id;
        this.CCCD = CCCD;
        this.diaDiem = diaDiem;
        this.loaixe = loaixe;
        this.Noidung = noidung;
        this.LoaiViPham = loaiViPham;
        this.soTienPhat = soTienPhat;
        this.id_can_bo = id_can_bo;
    }

    public Bien_ban(final String CCCD, final String diaDiem, final String loaixe, final String noidung, final String loaiViPham, final String soTienPhat, final int id_can_bo) {
        this.CCCD = CCCD;
        this.diaDiem = diaDiem;
        this.loaixe = loaixe;
        this.Noidung = noidung;
        this.LoaiViPham = loaiViPham;
        this.soTienPhat = soTienPhat;
        this.id_can_bo = id_can_bo;
    }


    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getCCCD() {
        return this.CCCD;
    }

    public void setCCCD(final String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDiaDiem() {
        return this.diaDiem;
    }

    public void setDiaDiem(final String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public String getLoaixe() {
        return this.loaixe;
    }

    public void setLoaixe(final String loaixe) {
        this.loaixe = loaixe;
    }

    public String getNoidung() {
        return this.Noidung;
    }

    public void setNoidung(final String noidung) {
        this.Noidung = noidung;
    }

    public String getLoaiViPham() {
        return this.LoaiViPham;
    }

    public void setLoaiViPham(final String loaiViPham) {
        this.LoaiViPham = loaiViPham;
    }

    public String getSoTienPhat() {
        return this.soTienPhat;
    }

    public void setSoTienPhat(final String soTienPhat) {
        this.soTienPhat = soTienPhat;
    }

    public int getNguoiLap() {
        return this.id_can_bo;
    }

    public void setNguoiLap(final int nguoiLap) {
        this.id_can_bo = nguoiLap;
    }


}


