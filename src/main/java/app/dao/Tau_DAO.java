package app.dao;

import app.thuc_the.Tau;
import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tau_DAO {
    String CHON_TAT_SQL = "SELECT * FROM Tau";
    String CHON_THEO_MA_SQL = "select * from Tau where SoHieu =?";

    public List<Tau> dsTau;

    public void Tau_DAO() {
        dsTau = new ArrayList<Tau>();
    }

    public void datDSTau(List<Tau> dsTau) {
        this.dsTau = dsTau;
    }

    public Tau ChonTheoMa(String maTau) {
        List<Tau> list = this.chonSql(CHON_THEO_MA_SQL, maTau);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Tau> chonTatCa() {
        return this.chonSql(CHON_TAT_SQL);
    }

    protected List<Tau> chonSql(String sql, Object... args) {
        List<Tau> list = new ArrayList<>();

        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.truyVan(sql, args);

                while (boKetQua.next()) {
                    Tau tau = new Tau();
                    tau.setSoHieu(boKetQua.getString("SoHieu"));
                    tau.setSoToa(boKetQua.getInt("SoToa"));
                    tau.setSoLuongToiDa(boKetQua.getInt("SoLuongToiDa"));
                    //tau.setDanhSachToa();
                    //tau.setDanhSachLichCapBenTau();
                    list.add(tau);
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

    public List<Tau> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Tau WHERE HoTen LIKE ?";
        return this.chonSql(sql, "%" + keyword + "%");
    }

    public void testLogin(String username, String password){

        if(username.equals("Duy") && password.equals("anhduy2002")){

        }else{

        }
    }
}
