package app.thuc_the;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {
    String maHoaDon;
    LocalDate ngayLapHoaDon;
    double thanhTien;
    KhachHang khachHang;
    ChiTietHoaDon chiTietHoaDon;

    public HoaDon(LocalDate ngayLapHoaDon, KhachHang khachHang, ChiTietHoaDon chiTietHoaDon) {
        this.maHoaDon = setMaHoaDon();
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.khachHang = khachHang;
        this.chiTietHoaDon = chiTietHoaDon;
       // this.thanhTien = (chiTietHoaDon.tongTien * chiTietHoaDon.soLuong) - ((chiTietHoaDon.tongTien * chiTietHoaDon.soLuong)* chiTietHoaDon.thue) ;
    }

    public HoaDon() {
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String setMaHoaDon() {
        String maHoaDon;
        String ngayTrongThang = String.valueOf(LocalDate.now().getDayOfMonth());
        String thang = String.valueOf(LocalDate.now().getMonthValue());
        String nam = String.valueOf(LocalDate.now().getYear());

        nam = nam.substring(nam.length() - 2);

        maHoaDon = nam + thang + ngayTrongThang;

        return maHoaDon;
    }

    public LocalDate getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public ChiTietHoaDon getChiTietHoaDon() {
        return chiTietHoaDon;
    }

    public void setChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        this.chiTietHoaDon = chiTietHoaDon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HoaDon hoaDon)) return false;
        return Objects.equals(getMaHoaDon(), hoaDon.getMaHoaDon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaHoaDon());
    }
}


