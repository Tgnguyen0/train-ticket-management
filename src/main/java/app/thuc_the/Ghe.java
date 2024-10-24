package app.thuc_the;

import java.util.Objects;

public class Ghe {
    private int maGhe;
    private String maToa;
    private LOAI_GHE loaiGhe;
    private TRANG_THAI_GHE trangThai;

    String soGhe;

    public Ghe() {
    }

    public Ghe(int maGhe, String maToa, LOAI_GHE loaiGhe, TRANG_THAI_GHE trangThai, String soGhe) {
        this.maGhe = maGhe;
        this.maToa = maToa;
        this.loaiGhe = loaiGhe;
        this.trangThai = trangThai;
        this.soGhe = soGhe;
    }

    public int getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(int maGhe) {
        this.maGhe = maGhe;
    }

    public LOAI_GHE getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(LOAI_GHE loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public TRANG_THAI_GHE getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TRANG_THAI_GHE trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaToa() {
        return maToa;
    }

    public void setMaToa(String maToa) {
        this.maToa = maToa;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ghe ghe)) return false;
        return getMaGhe() == ghe.getMaGhe();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaGhe());
    }
}
