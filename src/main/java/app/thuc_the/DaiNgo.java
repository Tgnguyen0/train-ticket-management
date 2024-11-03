package app.thuc_the;

import lombok.Builder;

public enum DaiNgo {
    KhongDaiNgo(0) ,
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

    public String toString() {
        switch (this) {
            case GIAMGIAHAIMUOIPHANTRAM:
                return "20%";
            case GIAMGIAMUOIPHANTRAM:
                return "10%";
            case GIAMGIANAMPHANTRAM:
                return "5%";
            default:
                return "0%";
        }
    }
}
