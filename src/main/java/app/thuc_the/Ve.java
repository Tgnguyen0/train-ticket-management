package app.thuc_the;

import java.time.LocalDate;
import java.util.Objects;

public class Ve {

    // ở đây không có thông tin tàu đâu nha cho nên khi xuất ra thì lưu ý, tìm tàu của cái mã ghế đó.
    // sau đó thì setTau(tau) hoặc là có thể lấy tàu từ class ghế sau đ láy class toa và cuối cùng là tàu.
    String maVe;
    String loaiDoiTuong;
    LocalDate ngayKhoiHanh;
    LocalDate ngayDatVe;
    String gaKhoiHanh;
    String gaKetThuc;
    double giaVe;
    String maKhachHang;
    String  maGhe;
    String loaiVe;

    public Ve(String maVe, String loaiDoiTuong, LocalDate ngayKhoiHanh, LocalDate ngayDatVe,  String gaKhoiHanh, String gaKetThuc, double giaVe, String maKhachHang,String maGhe, String loaiVe) {
        this.maVe = maVe;
        this.loaiDoiTuong = loaiDoiTuong;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayDatVe = ngayDatVe;
        this.gaKhoiHanh = gaKhoiHanh;
        this.gaKetThuc = gaKetThuc;
        this.giaVe = giaVe;
        this.maKhachHang = maKhachHang;
        this.maGhe = maGhe;
        this.loaiVe = loaiVe;
    }

    public Ve() {
    }

    public String getMaVe() {
        return maVe;
    }

    public String setMaVe() {
        String maVe;
        String ngayTrongThang = String.valueOf(LocalDate.now().getDayOfMonth());
        String thang = String.valueOf(LocalDate.now().getMonthValue());
        String nam = String.valueOf(LocalDate.now().getYear());

        nam = nam.substring(nam.length() - 2);

        maVe = "V" + nam + thang + ngayTrongThang;

        return maVe;
    }

    public void setMaVeTuCSDL(String maVe) {
        this.maVe = maVe;
    }

    public String getLoaiDoiTuong() {
        return loaiDoiTuong;
    }

    public void setLoaiDoiTuong(String loaiDoiTuong) {
        this.loaiDoiTuong = loaiDoiTuong;
    }

    public LocalDate getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(LocalDate ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public LocalDate getNgayDatVe() {
        return ngayDatVe;
    }

    public void setNgayDatVe(LocalDate ngayDatVe) {
        this.ngayDatVe = ngayDatVe;
    }


    public String getGaKhoiHanh() {
        return gaKhoiHanh;
    }

    public void setGaKhoiHanh(String gaKhoiHanh) {
        this.gaKhoiHanh = gaKhoiHanh;
    }

    public String getGaKetThuc() {
        return gaKetThuc;
    }

    public void setGaKetThuc(String gaKetThuc) {
        this.gaKetThuc = gaKetThuc;
    }

    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaHang() {
        return maKhachHang;
    }

    public void setMaHang(String maHang) {
        this.maKhachHang = maHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public String getLoaiVe() {
        return loaiVe;
    }


    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }






    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ve ve)) return false;
        return Objects.equals(getMaVe(), ve.getMaVe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaVe());
    }

    @Override
    public String toString() {
        return "Ve{" +
                "maVe='" + maVe + '\'' +
                ", loaiDoiTuong='" + loaiDoiTuong + '\'' +
                ", ngayKhoiHanh=" + ngayKhoiHanh +
                ", ngayDatVe=" + ngayDatVe +

                ", gaKhoiHanh='" + gaKhoiHanh + '\'' +
                ", gaKetThuc='" + gaKetThuc + '\'' +
                ", giaVe=" + giaVe +
                ", khachHang=" + maKhachHang +
                ", ghe=" + maGhe +
                ", loaiVe='" + loaiVe + '\'' +
                '}';
    }
}
