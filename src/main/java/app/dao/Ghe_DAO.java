package app.dao;

import java.util.HashSet;
import java.util.Set;

public class Ghe_DAO {
    String CHON_TAT_SQL = "SELECT * FROM Ghe";
    String CHON_THEO_MA_SQL = "select * from Toa where MaToa =?";

    private Set<String> dsGhe;

    public Ghe_DAO() {
        dsGhe = new HashSet<>();
    }

    public boolean themGhe(String cau) {
        return dsGhe.add(cau);
    }

    public boolean xoaGhe(String cau) {
        return dsGhe.contains(cau) ? dsGhe.remove(cau) : false;
    }

    public Set layDsGhe() {
        return dsGhe;
    }
}
