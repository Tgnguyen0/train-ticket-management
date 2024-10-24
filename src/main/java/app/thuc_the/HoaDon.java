package app.thuc_the;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {
    String maHoaDon;
    LocalDate ngayLapHoaDon;
    double thanhTien;
    String maKhachHang;
    String maNhanVien;
    int soLuong;
    double tongTien;
    String trangThai;
    DaiNgo daiNgo;
    float thue;

    public HoaDon(String maHoaDon, LocalDate ngayLapHoaDon, double thanhTien, String maKhachHang, String maNhanVien, int soLuong, double tongTien, String trangThai, DaiNgo daiNgo, float thue) {
        this.maHoaDon = maHoaDon;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.thanhTien = thanhTien;
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.daiNgo = daiNgo;
        this.thue = thue;
    }

    public HoaDon() {
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String setMaHoaDon(int soNgauNhien) {
        String maHoaDon;
        String ngayTrongThang = String.valueOf(LocalDate.now().getDayOfMonth());
        String thang = String.valueOf(LocalDate.now().getMonthValue());
        String nam = String.valueOf(LocalDate.now().getYear());

        nam = nam.substring(nam.length() - 2);

        maHoaDon = nam + thang + ngayTrongThang + String.valueOf(soNgauNhien);

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

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public DaiNgo getDaiNgo() {
        return daiNgo;
    }

    public void setDaiNgo(DaiNgo daiNgo) {
        this.daiNgo = daiNgo;
    }

    public float getThue() {
        return thue;
    }

    public void setThue(float thue) {
        this.thue = thue;
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


