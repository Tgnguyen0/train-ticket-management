package app.thuc_the;

import java.io.Serializable;
import java.time.LocalDate;

public class KhachHang implements Serializable {
    private String maKH;
    private String tenKH;
    private String diaChi;
    private String soDT;
    private String email;
    private GIOI_TINH gioiTinh;


    public KhachHang(int soNgauNhien, String tenKH, String diaChi, String soDT, String email, GIOI_TINH gioiTinh) {
        this.maKH = setMaKH(soNgauNhien);
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.email = email;
        this.setGioiTinh(gioiTinh);
    }

    public KhachHang() {
    }

    public KhachHang(String tenKH, String diaChi, String soDT, String email, GIOI_TINH gioiTinh) {
        this.maKH = setMaKH_KhangVersion();
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.email = email;
        this.setGioiTinh(gioiTinh);
    }

    public KhachHang(String maKH, String tenKH, String diaChi, String soDT, String email, GIOI_TINH gioiTinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.email = email;
        this.setGioiTinh(gioiTinh);
    }

    public String getMaKH() {
        return maKH;
    }

    public String setMaKH_KhangVersion(){
        return this.maKH = MaKhachHangTuDong.taoMaKhachHangTuDong();
    }

    // Dùng khi tạo khách hàng mới
    public String setMaKH(int soNgauNhien) {
        String maKH;
        String ngayTrongThang = String.valueOf(LocalDate.now().getDayOfMonth());
        String thang = String.valueOf(LocalDate.now().getMonthValue());
        String nam = String.valueOf(LocalDate.now().getYear());

        nam = nam.substring(nam.length() - 2);

        maKH = "KH" + nam + thang + ngayTrongThang + String.valueOf(soNgauNhien);

        return maKH;
    }

    // Dùng khi lấy từ cơ sở dữ liệu
    public void setMaKHTuCSDL(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GIOI_TINH getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GIOI_TINH gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String chiLayTen() {
        return tenKH.lastIndexOf(" ") == -1 ? tenKH : tenKH.substring(tenKH.lastIndexOf(" ") + 1);
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH='" + maKH + '\'' +
                ", tenKH='" + tenKH + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDT='" + soDT + '\'' +
                ", email='" + email + '\'' +
                ", gioiTinh=" + getGioiTinh() +
                '}';
    }
}
