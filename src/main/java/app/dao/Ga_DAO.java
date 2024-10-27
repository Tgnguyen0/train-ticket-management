package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.NhaGa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ga_DAO {
    String CHON_TAT_SQL = "SELECT * FROM NhaGa";
    String CHON_THEO_MA_SQL = "select * from NhaGa where MaGa =?";

    public List<NhaGa> dsNhaGa;

    public void Ga_DAO() {
        dsNhaGa = new ArrayList<NhaGa>();
    }

    public NhaGa ChonTheoMa(String manv) {
        List<NhaGa> list = this.ChonSql(CHON_THEO_MA_SQL, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NhaGa> ChonTatCa() {
        return this.ChonSql(CHON_TAT_SQL);
    }

    protected List<NhaGa> ChonSql(String sql, Object... args) {
        List<NhaGa> list = new ArrayList<>();
        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.truyVan(sql, args);
                while (boKetQua.next()) {
                    NhaGa nhaGa = new NhaGa();
                    nhaGa.setMaGa(boKetQua.getString("MaGa"));
                    nhaGa.setTenGa(boKetQua.getString("TenGa"));
                    nhaGa.setSoDienThoaiLienHe(boKetQua.getString("SoDTLH"));
                    nhaGa.setThanhPho(boKetQua.getString("ThanhPho"));
                    list.add(nhaGa);
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

    public List<NhaGa> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhaGa WHERE HoTen LIKE ?";
        return this.ChonSql(sql, "%" + keyword + "%");
    }

    public void testLogin(String username, String password){

        if(username.equals("Duy") && password.equals("anhduy2002")){

        }else{

        }
    }
}
