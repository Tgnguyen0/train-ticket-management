package app.thuc_the;

public enum DaiNgo {
    GIAMGIAHAIMUOIPHANTRAM(0.20),
    GIAMGIANAMPHANTRAM(0.05),
    GIAMGIAMUOIPHANTRAM(0.10),
    GIAMGIAKHONGPHANTRAM(0.0)
    ;
    double price;

    DaiNgo(double price) {
        this.price = price;
    }

    public double getValue() {
        return price;
    }
}
