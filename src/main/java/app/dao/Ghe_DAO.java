package app.dao;

import java.util.HashSet;
import java.util.Set;

public class Ghe_DAO {
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
