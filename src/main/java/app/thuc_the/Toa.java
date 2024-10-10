package app.thuc_the;

import java.util.Objects;
import java.util.Set;

public class Toa {
    private String maToa;
    private String tenToa;
    private int soLuongGhe;
    private Tau tau;

    private Set<Ghe> danhSachGhe;
    public Toa() {
    }


    public String getMaToa() {
        return maToa;
    }

    public void setMaToa(String maToa) {
        this.maToa = maToa;
    }

    public String getTenToa() {
        return tenToa;
    }

    public void setTenToa(String tenToa) {
        this.tenToa = tenToa;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }

    public Tau getTau() {
        return tau;
    }

    public void setTau(Tau tau) {
        this.tau = tau;
    }

    public Set<Ghe> getDanhSachGhe() {
        return danhSachGhe;
    }

    public void setDanhSachGhe(Set<Ghe> danhSachGhe) {
        this.danhSachGhe = danhSachGhe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toa toa)) return false;
        return Objects.equals(getMaToa(), toa.getMaToa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaToa());
    }
}
