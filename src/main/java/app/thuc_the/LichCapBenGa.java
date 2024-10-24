package app.thuc_the;

import java.time.LocalDate;
import java.util.Objects;

public class LichCapBenGa {
    String maLich;
    Tau tau;
    LocalDate gioCapBen;
    LocalDate gioKhoiHanh;
    String moTa;
    NhaGa nhaGa;

    public LichCapBenGa() {
    }

    public LichCapBenGa(String maLich, Tau tau, LocalDate gioCapBen, LocalDate gioKhoiHanh, String moTa, NhaGa nhaGa) {
        this.maLich = maLich;
        this.tau = tau;
        this.gioCapBen = gioCapBen;
        this.gioKhoiHanh = gioKhoiHanh;
        this.moTa = moTa;
        this.nhaGa = nhaGa;
    }

    public String getMaLich() {
        return maLich;
    }

    public void setMaLich(String maLich) {
        this.maLich = maLich;
    }

    public Tau getTau() {
        return tau;
    }

    public void setTau(Tau tau) {
        this.tau = tau;
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

    public NhaGa getGa() {
        return nhaGa;
    }

    public void setGa(NhaGa nhaGa) {
        this.nhaGa = nhaGa;
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
