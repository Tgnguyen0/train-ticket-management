package app.thuc_the;

import java.util.Objects;
import java.util.Set;

public class NhaGa {
    String maGa;
    String tenGa;
    String diaChi;
    String soDienThoaiLienHe;
    String thanhPho;

    public NhaGa() {
    }

    public String getMaGa() {
        return maGa;
    }

    public void setMaGa(String maGa) {
        this.maGa = maGa;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NhaGa nhaGa)) return false;
        return Objects.equals(getMaGa(), nhaGa.getMaGa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaGa());
    }
}
