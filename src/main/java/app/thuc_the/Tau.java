package app.thuc_the;

import java.util.Objects;
import java.util.Set;

public class Tau {
    private String soHieu;
    private int soToa;
    private int soLuongToiDa;;
    private int soLuongKhachHangDaDatVe;
    private Set<Toa> danhSachToa;
    private Set<LichCapBenGa> danhSachLichCapBenTau;
    public Tau() {
    }

    public String getSoHieu() {
        return soHieu;
    }

    public void setSoHieu(String soHieu) {
        this.soHieu = soHieu;
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

    public int getSoLuongKhachHangDaDatVe() {
        return soLuongKhachHangDaDatVe;
    }

    public void setSoLuongKhachHangDaDatVe(int soLuongKhachHangDaDatVe) {
        this.soLuongKhachHangDaDatVe = soLuongKhachHangDaDatVe;
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
