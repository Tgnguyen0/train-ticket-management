package app.thuc_the;

import java.sql.Date;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private Date ngaySinh;
    private String diaChia;
    private String soDT;
    private GIOI_TINH gioiTinh;
    private String password;
    private String vaiTro;

    public NhanVien(String maNV, String tenNV, Date ngaySinh, String diaChia, String soDT, GIOI_TINH gioiTinh, String password, String vaiTro) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.diaChia = diaChia;
        this.soDT = soDT;
        this.gioiTinh = gioiTinh;
        this.password = password;
        this.vaiTro = vaiTro;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChia() {
        return diaChia;
    }

    public void setDiaChia(String diaChia) {
        this.diaChia = diaChia;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public GIOI_TINH getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GIOI_TINH gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV + '\'' +
                ", tenNV='" + tenNV + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChia='" + diaChia + '\'' +
                ", soDT='" + soDT + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", password='" + password + '\'' +
                ", vaiTro='" + vaiTro + '\'' +
                '}';
    }
}
