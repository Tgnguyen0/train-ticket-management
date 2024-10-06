package app.thuc_the;

import app.ClassEnum.GIOI_TINH;
public class KhachHang {
    private String maKH;
    private String tenKH;
    private String diaChi;
    private String soDT;
    private String email;
    private GIOI_TINH gioiTinh;

    public KhachHang(String maKH, String tenKH, String diaChi, String soDT, String email, GIOI_TINH gioiTinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.email = email;
        this.setGioiTinh(gioiTinh);
    }

    public KhachHang() {
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
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
