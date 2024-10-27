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
    DaiNgo daiNgo;
    String gaKhoiHanh;
    String gaKetThuc;
    double giaVe;
    KhachHang khachHang;
    Ghe ghe;
    String loaiVe;
    Tau tau;

    public Ve(String maVe, String loaiDoiTuong, LocalDate ngayKhoiHanh, LocalDate ngayDatVe, DaiNgo daiNgo, String gaKhoiHanh, String gaKetThuc, double giaVe, KhachHang khachHang, Ghe ghe, String loaiVe) {
        this.maVe = maVe;
        this.loaiDoiTuong = loaiDoiTuong;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayDatVe = ngayDatVe;
        this.daiNgo = daiNgo;
        this.gaKhoiHanh = gaKhoiHanh;
        this.gaKetThuc = gaKetThuc;
        this.giaVe = giaVe;
        this.khachHang = khachHang;
        this.ghe = ghe;
        this.loaiVe = loaiVe;
    }

    public Ve(String loaiDoiTuong, LocalDate ngayKhoiHanh, LocalDate ngayDatVe, DaiNgo daiNgo, String gaKhoiHanh, String gaKetThuc, double giaVe, KhachHang khachHang, Ghe ghe, String loaiVe) {
        this.maVe = setMaVe();
        this.loaiDoiTuong = loaiDoiTuong;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayDatVe = ngayDatVe;
        this.daiNgo = daiNgo;
        this.gaKhoiHanh = gaKhoiHanh;
        this.gaKetThuc = gaKetThuc;
        this.giaVe = giaVe;
        this.khachHang = khachHang;
        this.ghe = ghe;
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

    public DaiNgo getDaiNgo() {
        return daiNgo;
    }

    public void setDaiNgo(DaiNgo daiNgo) {
        this.daiNgo = daiNgo;
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

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
    }

    public String getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }

    public void setTau(Tau tau) {
        this.tau = tau;
    }

    public Tau getTau() {
        return this.tau;
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
}
