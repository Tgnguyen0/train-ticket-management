package app.thuc_the;

import java.util.Objects;

public class Ghe {
    private int maGhe;
    private Toa toa;
    private LOAI_GHE loaiGhe;
    private TRANG_THAI_GHE trangThai;

    String soGhe;

    public Ghe() {
    }

    public Ghe(int maGhe, Toa toa, LOAI_GHE loaiGhe, TRANG_THAI_GHE trangThai, String soGhe) {
        this.maGhe = maGhe;
        this.toa = toa;
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

    public Toa getToa_maToa() {
        return toa;
    }

    public void setToa_maToa(Toa toa_maToa) {
        this.toa = toa_maToa;
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
