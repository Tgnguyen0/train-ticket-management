package app.thuc_the;

import java.sql.Date;

public class LichCapBenGa {
    private String maLich, moTa;
    private Tau tau_soHieuTau;
    private Date gioCapBen, gioKhoiHanh;

    public LichCapBenGa() {
    }

    public LichCapBenGa(String maLich, String moTa, Tau soHieuTau, Date gioCapBen, Date gioKhoiHanh) {
        this.maLich = maLich;
        this.moTa = moTa;
        this.tau_soHieuTau = soHieuTau;
        this.gioCapBen = gioCapBen;
        this.gioKhoiHanh = gioKhoiHanh;
    }

    public Tau getTau_soHieuTau() {
        return tau_soHieuTau;
    }

    public void setTau_soHieuTau(Tau tau_soHieuTau) {
        this.tau_soHieuTau = tau_soHieuTau;
    }

    public String getMaLich() {
        return maLich;
    }

    public void setMaLich(String maLich) {
        this.maLich = maLich;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getGioCapBen() {
        return gioCapBen;
    }

    public void setGioCapBen(Date gioCapBen) {
        this.gioCapBen = gioCapBen;
    }

    public Date getGioKhoiHanh() {
        return gioKhoiHanh;
    }

    public void setGioKhoiHanh(Date gioKhoiHanh) {
        this.gioKhoiHanh = gioKhoiHanh;
    }
}
