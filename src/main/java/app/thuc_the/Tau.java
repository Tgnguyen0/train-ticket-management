package app.thuc_the;

public class Tau {
    private String soHieu;
    private int soToa;
    private int soLuongToiDa;;

    public Tau() {
    }

    public Tau(int soToa, int soLuongToiDa, String soHieu) {
        this.soToa = soToa;
        this.soLuongToiDa = soLuongToiDa;
        this.soHieu = soHieu;
    }

    public String getSoHieu() {
        return soHieu;
    }

    public void setSoHieu(String soHieu) {
        this.soHieu = soHieu;
    }

    public int getSoToa() {
        return soToa;
    }

    public void setSoToa(int soToa) {
        this.soToa = soToa;
    }

    public int getSoLuongToiDa() {
        return soLuongToiDa;
    }

    public void setSoLuongToiDa(int soLuongToiDa) {
        this.soLuongToiDa = soLuongToiDa;
    }
}
