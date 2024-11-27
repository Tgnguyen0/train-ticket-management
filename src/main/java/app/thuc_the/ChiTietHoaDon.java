package app.thuc_the;

import java.util.Objects;

public class ChiTietHoaDon {
    String maHoaDon;
    String maVe;

    public ChiTietHoaDon(String maHoaDon, String maVe) {
        this.maHoaDon = maHoaDon;
        this.maVe = maVe;
    }

    public ChiTietHoaDon() {
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ChiTietHoaDon that)) return false;
        return Objects.equals(getMaHoaDon(), that.getMaHoaDon()) && Objects.equals(getMaVe(), that.getMaVe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaHoaDon(), getMaVe());
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", maVe='" + maVe + '\'' +
                '}';
    }
}
