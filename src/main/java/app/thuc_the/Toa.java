package app.thuc_the;

import java.util.Objects;
import java.util.Set;

public class Toa {
    private String maToa;
    private String tenToa;
    private int soLuongGhe;
    private String soHieu;

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

    public void setSoHieu(String soHieu) {
        this.soHieu = soHieu;
    }

    public String getSoHieu() { return this.soHieu; }

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
