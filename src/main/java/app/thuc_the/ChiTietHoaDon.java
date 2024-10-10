package app.thuc_the;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

public class ChiTietHoaDon {
    String MaChiTietHoaDon;
    Set<Ve> danhSachVe;
    int soLuong;
    int tongTien;
    final double thue = 0.2;
    String trangThai;

    public ChiTietHoaDon() {
    }

    public String getMaChiTietHoaDon() {
        return MaChiTietHoaDon;
    }

    public void setMaChiTietHoaDon(String maChiTietHoaDon) {
        MaChiTietHoaDon = maChiTietHoaDon;
    }

    public Set<Ve> getDanhSachVe() {
        return danhSachVe;
    }

    public void setDanhSachVe(Set<Ve> danhSachVe) {
        this.danhSachVe = danhSachVe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public double getThue() {
        return thue;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChiTietHoaDon that)) return false;
        return Objects.equals(getMaChiTietHoaDon(), that.getMaChiTietHoaDon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaChiTietHoaDon());
    }
}
