package app.thuc_the;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Ga {
    String maGa;
    String tenGa;
    String diaChi;
    String soDienThoaiLienHe;
    String thanhPho;
    Set<LichCapBenGa> danhSachTauCapBen;

    public Ga() {
    }

    public String getMaGa() {
        return maGa;
    }

    public String setMaGa(int soNgauNhien) {
        String maGa;

        maGa = "VNGA" + soNgauNhien;

        return maGa;
    }

    public String getTenGa() {
        return tenGa;
    }

    public void setTenGa(String tenGa) {
        this.tenGa = tenGa;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoaiLienHe() {
        return soDienThoaiLienHe;
    }

    public void setSoDienThoaiLienHe(String soDienThoaiLienHe) {
        this.soDienThoaiLienHe = soDienThoaiLienHe;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public Set<LichCapBenGa> getDanhSachTauCapBen() {
        return danhSachTauCapBen;
    }

    public void setDanhSachTauCapBen(Set<LichCapBenGa> danhSachTauCapBen) {
        this.danhSachTauCapBen = danhSachTauCapBen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ga ga)) return false;
        return Objects.equals(getMaGa(), ga.getMaGa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaGa());
    }
}
