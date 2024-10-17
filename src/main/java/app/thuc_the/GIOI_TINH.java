package app.thuc_the;

public enum GIOI_TINH {
    NAM("Nam"),
    NU("N?"),
    KHAC("Khác");

    private String value;

    GIOI_TINH(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
