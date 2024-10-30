package app.thuc_the;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ve {

    // ở đây không có thông tin tàu đâu nha cho nên khi xuất ra thì lưu ý, tìm tàu của cái mã ghế đó.
    // sau đó thì setTau(tau) hoặc là có thể lấy tàu từ class ghế sau đ láy class toa và cuối cùng là tàu.
    String maVe;
    String loaiDoiTuong;
    LocalDateTime ngayKhoiHanh;
    LocalDateTime ngayDatVe;
    DaiNgo daiNgo;
    String gaKhoiHanh;
    String gaKetThuc;
    double giaVe;
    String maGhe;
    String maKhachHang;
    String loaiVe;
    Tau tau;

    public Ve(String maVe, String loaiDoiTuong, LocalDateTime ngayKhoiHanh, LocalDateTime ngayDatVe, String gaKhoiHanh, String gaKetThuc, double giaVe, String maKhachHang, String maGhe, String loaiVe) {
        this.maVe = maVe;
        this.loaiDoiTuong = loaiDoiTuong;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayDatVe = ngayDatVe;
        this.daiNgo = daiNgo;
        this.gaKhoiHanh = gaKhoiHanh;
        this.gaKetThuc = gaKetThuc;
        this.giaVe = giaVe;
        this.maKhachHang = maKhachHang;
        this.maGhe = maGhe;
        this.loaiVe = loaiVe;
    }

    public Ve(String loaiDoiTuong, LocalDateTime ngayKhoiHanh, LocalDateTime ngayDatVe, String gaKhoiHanh, String gaKetThuc, double giaVe, String maKhachHang, String maGhe, String loaiVe) {
        this.maVe = setMaVe();
        this.loaiDoiTuong = loaiDoiTuong;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayDatVe = ngayDatVe;
        this.daiNgo = daiNgo;
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
        String ngayTrongThang = String.valueOf(LocalDateTime.now().getDayOfMonth());
        String thang = String.valueOf(LocalDateTime.now().getMonthValue());
        String nam = String.valueOf(LocalDateTime.now().getYear());

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

    public LocalDateTime getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(LocalDateTime ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public LocalDateTime getNgayDatVe() {
        return ngayDatVe;
    }

    public void setNgayDatVe(LocalDateTime ngayDatVe) {
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

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaGhe() {
        return this.maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
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
