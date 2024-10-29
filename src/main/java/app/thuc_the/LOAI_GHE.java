package app.thuc_the;

public enum LOAI_GHE {
    GHẾ_MỀM("Ghế Mềm"), GIƯỜNG_TOA_6("Giường Toa 6"), GIƯỜNG_TOA_4("Giường Toa 4"), GIƯỜNG_TOA_2_VIP("Giường Toa 2 VIP");

    String name;

    LOAI_GHE(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        switch (this) {
            case GHẾ_MỀM:
                return "Ghế Mềm";
            case GIƯỜNG_TOA_6:
                return "Giường Toa 6";
            case GIƯỜNG_TOA_4:
                return "Giường Toa 4";
            case GIƯỜNG_TOA_2_VIP:
                return "Giường Toa 2 VIP";
            default:
                return super.toString();
        }
    }
}
