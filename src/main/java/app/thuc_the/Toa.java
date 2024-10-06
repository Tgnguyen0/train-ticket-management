package app.thuc_the;

public class Toa {
    private String maToa;
    private String tenToa;
    private int soLuongGhe;
    private Tau tau_soHieuTau;

    public Toa() {
    }

    public Toa(int soLuongGhe, String tenToa, String maToa, Tau tau_soHieuTau) {
        this.soLuongGhe = soLuongGhe;
        this.tenToa = tenToa;
        this.maToa = maToa;
        this.tau_soHieuTau = tau_soHieuTau;
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

    public Tau getTau_soHieuTau() {
        return tau_soHieuTau;
    }

    public void setTau_soHieuTau(Tau tau_soHieuTau) {
        this.tau_soHieuTau = tau_soHieuTau;
    }
}
