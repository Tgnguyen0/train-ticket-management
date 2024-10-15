package app.thuc_the;

public enum DaiNgo {
    GIAMGIAHAIMUOIPHANTRAM(0.20),
    GIAMGIANAMPHANTRAM(0.05),
    GIAMGIAMUOIPHANTRAM(0.10)
    ;
    double price;

    DaiNgo(double price) {
        this.price = price;
    }
}
