package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.Tau;
import app.thuc_the.Toa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Toa_DAO {
    String CHON_TAT_SQL = "SELECT * FROM Toa";
    String CHON_THEO_MA_SQL = "select * from Toa where MaToa =?";
    String CHON_THEO_SO_HIEU_SQL = "select * from Toa where SoHieu =?";

    public List<Toa> dsToa;

    public void Toa_DAO() {
        dsToa = new ArrayList<Toa>();
    }

    public Toa ChonTheoMa(String maToa) {
        List<Toa> list = this.ChonSql(CHON_THEO_MA_SQL, maToa);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Toa> ChonTheoSoHieuTatCa(String soHieu) {
        List<Toa> list = this.ChonSql(CHON_THEO_SO_HIEU_SQL, soHieu);
        return list;
    }

    public List<Toa> ChonTatCa() {
        return this.ChonSql(CHON_TAT_SQL);
    }

    protected List<Toa> ChonSql(String sql, Object... args) {
        List<Toa> list = new ArrayList<>();
        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.truyVan(sql, args);
                while (boKetQua.next()) {
                    Toa toa = new Toa();
                    toa.setMaToa(boKetQua.getString("MaToa"));
                    toa.setTenToa(boKetQua.getString("TenToa"));
                    toa.setSoLuongGhe(boKetQua.getInt("SoLuongGhe"));
                    //toa.setTau();
                    list.add(toa);
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

    public List<Toa> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Toa WHERE HoTen LIKE ?";
        return this.ChonSql(sql, "%" + keyword + "%");
    }

    public void testLogin(String username, String password){

        if(username.equals("Duy") && password.equals("anhduy2002")){

        }else{

        }
    }
}
