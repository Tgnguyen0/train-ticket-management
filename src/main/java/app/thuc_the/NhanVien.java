package app.thuc_the;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private LocalDate ngaySinh;
    private String diaChi;
    private String soDT;
    private GIOI_TINH gioiTinh;
    private String matKhau;
    private String vaiTro;

    public NhanVien(String maNV, String tenNV, LocalDate ngaySinh, String diaChi, String soDT, GIOI_TINH gioiTinh, String matKhau, String vaiTro) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.gioiTinh = gioiTinh;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    /*public String setMaNV(int soNgauNhien) {
        String maNV;
        String nam = String.valueOf(LocalDate.now().getYear());

        nam = nam.substring(nam.length() - 2);

        maNV = "NV" + nam + soNgauNhien;

        return maNV;
    }*/

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public GIOI_TINH getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GIOI_TINH gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NhanVien nhanVien)) return false;
        return Objects.equals(getNgaySinh(), nhanVien.getNgaySinh());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNgaySinh());
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNV='" + maNV + '\'' +
                ", tenNV='" + tenNV + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", soDT='" + soDT + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", matKhau='" + matKhau + '\'' +
                ", vaiTro='" + vaiTro + '\'' +
                '}';
    }
}
