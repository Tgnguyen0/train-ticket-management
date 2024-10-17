package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.Ga;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ga_DAO {
    String CHON_TAT_SQL = "SELECT * FROM NhaGa";
    String CHON_THEO_MA_SQL = "select * from NhaGa where MaGa =?";

    public List<Ga> dsGa;

    public void Ga_DAO() {
        dsGa = new ArrayList<Ga>();
    }

    public Ga ChonTheoMa(String manv) {
        List<Ga> list = this.ChonSql(CHON_THEO_MA_SQL, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Ga> ChonTatCa() {
        return this.ChonSql(CHON_TAT_SQL);
    }

    protected List<Ga> ChonSql(String sql, Object... args) {
        List<Ga> list = new ArrayList<>();
        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.TruyVan(sql, args);
                while (boKetQua.next()) {
                    Ga ga = new Ga();
                    ga.setMaGa(boKetQua.getString("MaGa"));
                    ga.setTenGa(boKetQua.getString("TenGa"));
                    ga.setSoDienThoaiLienHe(boKetQua.getString("SoDTLH"));
                    ga.setThanhPho(boKetQua.getString("ThanhPho"));
                    list.add(ga);
                }
            } finally {
                boKetQua.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<Ga> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhaGa WHERE HoTen LIKE ?";
        return this.ChonSql(sql, "%" + keyword + "%");
    }

    public void testLogin(String username, String password){

        if(username.equals("Duy") && password.equals("anhduy2002")){

        }else{

        }
    }
}
