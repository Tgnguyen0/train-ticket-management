package app.thuc_the;


import java.time.LocalDate;

public class HoaDon {
    public String maHD;
    public LocalDate ngayLap;;
    public String maNV;
    public float thanhTien;
    public String maKH;
    public int soLuong;
    public float tongTien;
    public String trangThai;
    public float daiNgo;
    public float thue;

    public HoaDon() {
    }

    public HoaDon(String maHD, LocalDate ngayLap, String maNV, float thanhTien, String maKH, int soLuong, float tongTien, String trangThai, float daiNgo, float thue) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.maNV = maNV;
        this.thanhTien = thanhTien;
        this.maKH = maKH;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.daiNgo = daiNgo;
        this.thue = thue;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public float getDaiNgo() {
        return daiNgo;
    }

    public void setDaiNgo(float daiNgo) {
        this.daiNgo = daiNgo;
    }

    public float getThue() {
        return thue;
    }

    public void setThue(float thue) {
        this.thue = thue;
    }
}


