package app.thuc_the;

public class Ghe {
    private int maGhe;
    private Toa toa_maToa;
    private LOAI_GHE loaiGhe;
    private TRANG_THAI_GHE trangThai;

    public Ghe() {
    }

    public Ghe(int maGhe, Toa toa_maToa, LOAI_GHE loaiGhe, TRANG_THAI_GHE trangThai) {
        this.maGhe = maGhe;
        this.toa_maToa = toa_maToa;
        this.loaiGhe = loaiGhe;
        this.trangThai = trangThai;
    }

    public int getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(int maGhe) {
        this.maGhe = maGhe;
    }

    public Toa getToa_maToa() {
        return toa_maToa;
    }

    public void setToa_maToa(Toa toa_maToa) {
        this.toa_maToa = toa_maToa;
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
}
