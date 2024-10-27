package app.thuc_the;

import java.time.LocalDate;
import java.util.Objects;

public class LichCapBenGa {
    String maLich;
    String maTau;
    LocalDate gioCapBen;
    LocalDate gioKhoiHanh;
    String moTa;
    String maGa;

    public LichCapBenGa() {
    }

    public LichCapBenGa(String maLich, String maTau, LocalDate gioCapBen, LocalDate gioKhoiHanh, String moTa, String maGa) {
        this.maLich = maLich;
        this.maTau = maTau;
        this.gioCapBen = gioCapBen;
        this.gioKhoiHanh = gioKhoiHanh;
        this.moTa = moTa;
        this.maGa = maGa;
    }

    public String getMaLich() {
        return maLich;
    }

    public void setMaLich(String maLich) {
        this.maLich = maLich;
    }

    public LocalDate getGioCapBen() {
        return gioCapBen;
    }

    public void setGioCapBen(LocalDate gioCapBen) {
        this.gioCapBen = gioCapBen;
    }

    public LocalDate getGioKhoiHanh() {
        return gioKhoiHanh;
    }

    public void setGioKhoiHanh(LocalDate gioKhoiHanh) {
        this.gioKhoiHanh = gioKhoiHanh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMaTau() {
        return maTau;
    }

    public void setMaTau(String maTau) {
        this.maTau = maTau;
    }

    public String getMaGa() {
        return maGa;
    }

    public void setMaGa(String maGa) {
        this.maGa = maGa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LichCapBenGa that)) return false;
        return Objects.equals(getMaLich(), that.getMaLich());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaLich());
    }
}
