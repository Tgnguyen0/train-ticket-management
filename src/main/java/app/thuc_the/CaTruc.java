package app.thuc_the;

import java.time.LocalDateTime;
import java.util.Date;

public class CaTruc {
    private String maCaTruc;
    private String maNhanVien;
    private LocalDateTime ngayGioBatDau;
    private LocalDateTime ngayGioKetThuc;
    private int tongHoaDon;
    private double tongTienCaTruoc;
    private double tongTienHoaDon;
    private double tongTienThucThu;
    private double thatThoat;
    private double tongVAT;
    private double tongTienGiamGia;

    public CaTruc() {
    }


    public CaTruc(String maNhanVien, LocalDateTime ngayGioBatDau, LocalDateTime ngayGioKetThuc, int tongHoaDon, double tongTienCaTruoc, double tongTienHoaDon, double tongTienThucThu, double thatThoat, double tongVAT, double tongTienGiamGia) {
        this.maNhanVien = maNhanVien;
        this.ngayGioBatDau = ngayGioBatDau;
        this.ngayGioKetThuc = ngayGioKetThuc;
        this.tongHoaDon = tongHoaDon;
        this.tongTienCaTruoc = tongTienCaTruoc;
        this.tongTienHoaDon = tongTienHoaDon;
        this.tongTienThucThu = tongTienThucThu;
        this.thatThoat = thatThoat;
        this.tongVAT = tongVAT;
        this.tongTienGiamGia = tongTienGiamGia;
    }


    public CaTruc(String maCaTruc, String maNhanVien, LocalDateTime ngayGioBatDau, LocalDateTime ngayGioKetThuc, int tongHoaDon, double tongTienCaTruoc, double tongTienHoaDon, double tongTienThucThu, double thatThoat, double tongVAT, double tongTienGiamGia) {
        this.maCaTruc = maCaTruc;
        this.maNhanVien = maNhanVien;
        this.ngayGioBatDau = ngayGioBatDau;
        this.ngayGioKetThuc = ngayGioKetThuc;
        this.tongHoaDon = tongHoaDon;
        this.tongTienCaTruoc = tongTienCaTruoc;
        this.tongTienHoaDon = tongTienHoaDon;
        this.tongTienThucThu = tongTienThucThu;
        this.thatThoat = thatThoat;
        this.tongVAT = tongVAT;
        this.tongTienGiamGia = tongTienGiamGia;
    }

    @Override
    public String toString() {
        return "CaTruc{" +
                "maCaTruc='" + maCaTruc + '\'' +
                ", maNhanVien='" + maNhanVien + '\'' +
                ", ngayGioBatDau=" + ngayGioBatDau +
                ", ngayGioKetThuc=" + ngayGioKetThuc +
                ", tongHoaDon=" + tongHoaDon +
                ", tongTienCaTruoc=" + tongTienCaTruoc +
                ", tongTienHoaDon=" + tongTienHoaDon +
                ", tongTienThucThu=" + tongTienThucThu +
                ", thatThoat=" + thatThoat +
                ", tongVAT=" + tongVAT +
                ", tongTienGiamGia=" + tongTienGiamGia +
                '}';
    }


    public String getMaCaTruc() {
        return maCaTruc;
    }

    public void setMaCaTruc(String maCaTruc) {
        this.maCaTruc = maCaTruc;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public LocalDateTime getNgayGioBatDau() {
        return ngayGioBatDau;
    }

    public void setNgayGioBatDau(LocalDateTime ngayGioBatDau) {
        this.ngayGioBatDau = ngayGioBatDau;
    }

    public LocalDateTime getNgayGioKetThuc() {
        return ngayGioKetThuc;
    }

    public void setNgayGioKetThuc(LocalDateTime ngayGioKetThuc) {
        this.ngayGioKetThuc = ngayGioKetThuc;
    }

    public int getTongHoaDon() {
        return tongHoaDon;
    }

    public void setTongHoaDon(int tongHoaDon) {
        this.tongHoaDon = tongHoaDon;
    }

    public double getTongTienCaTruoc() {
        return tongTienCaTruoc;
    }

    public void setTongTienCaTruoc(double tongTienCaTruoc) {
        this.tongTienCaTruoc = tongTienCaTruoc;
    }

    public double getTongTienHoaDon() {
        return tongTienHoaDon;
    }

    public void setTongTienHoaDon(double tongTienHoaDon) {
        this.tongTienHoaDon = tongTienHoaDon;
    }

    public double getTongTienThucThu() {
        return tongTienThucThu;
    }

    public void setTongTienThucThu(double tongTienThucThu) {
        this.tongTienThucThu = tongTienThucThu;
    }

    public double getThatThoat() {
        return thatThoat;
    }

    public void setThatThoat(double thatThoat) {
        this.thatThoat = thatThoat;
    }

    public double getTongVAT() {
        return tongVAT;
    }

    public void setTongVAT(double tongVAT) {
        this.tongVAT = tongVAT;
    }

    public double getTongTienGiamGia() {
        return tongTienGiamGia;
    }

    public void setTongTienGiamGia(double tongTienGiamGia) {
        this.tongTienGiamGia = tongTienGiamGia;
    }
}
