package app.ClassEnum;

public enum GIOI_TINH {
    NAM("Nam"),
    NU("Nữ"),
    KHAC("Khác");

    private String value;

    GIOI_TINH(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
