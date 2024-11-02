package app.thuc_the;

import java.util.Objects;

public class Ghe {
    private String maGhe;
    private String maToa;
    private LOAI_GHE loaiGhe;
    private TRANG_THAI_GHE trangThai;
    private String soGhe;

    public Ghe() {
    }

    public Ghe(String maGhe, String maToa, LOAI_GHE loaiGhe, TRANG_THAI_GHE trangThai, String soGhe) {
        this.maGhe = maGhe;
        this.maToa = maToa;
        this.loaiGhe = loaiGhe;
        this.trangThai = trangThai;
        this.soGhe = soGhe;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public String getMaToa() {
        return this.maToa;
    }

    public void setMaToa(String maToa) {
        this.maToa = maToa;
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

    public String getSoGhe() { return this.soGhe; }

    public void setSoGhe(String soGhe) { this.soGhe = soGhe; }

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
