package app.thuc_the;

import java.util.Objects;
import java.util.Set;

public class Tau {
    private String soHieu;
    private int soToa;
    private int soLuongToiDa;;
    private Set<Toa> danhSachToa;
    private Set<LichCapBenGa> danhSachLichCapBenTau;

    public Tau() {
    }

    public Tau(String soHieu, int soToa, int soLuongToiDa, Set<Toa> danhSachToa, Set<LichCapBenGa> danhSachLichCapBenTau) {
        this.soHieu = soHieu;
        this.soToa = soToa;
        this.soLuongToiDa = soLuongToiDa;
        this.danhSachToa = danhSachToa;
        this.danhSachLichCapBenTau = danhSachLichCapBenTau;
    }

    public String getSoHieu() {
        return soHieu;
    }

    public String setSoHieu(String soHieu) {
        return soHieu;
    }

    public int getSoToa() {
        return soToa;
    }

    public void setSoToa(int soToa) {
        this.soToa = soToa;
    }

    public int getSoLuongToiDa() {
        return soLuongToiDa;
    }

    public Set<Toa> getDanhSachToa() {
        return danhSachToa;
    }

    public void setDanhSachToa(Set<Toa> danhSachToa) {
        this.danhSachToa = danhSachToa;
    }

    public void setSoLuongToiDa(int soLuongToiDa) {
        this.soLuongToiDa = soLuongToiDa;
    }

    public Set<LichCapBenGa> getDanhSachLichCapBenTau() {
        return danhSachLichCapBenTau;
    }

    public void setDanhSachLichCapBenTau(Set<LichCapBenGa> danhSachLichCapBenTau) {
        this.danhSachLichCapBenTau = danhSachLichCapBenTau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tau tau)) return false;
        return Objects.equals(getSoHieu(), tau.getSoHieu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSoHieu());
    }
}
