package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.Ghe;
import app.thuc_the.LOAI_GHE;
import app.thuc_the.TRANG_THAI_GHE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ghe_DAO {
    Set<Ghe> gheDat;
    String CHON_TAT_SQL = "SELECT * FROM Ghe";
    String CHON_THEO_MA_GHE_SQL = "select * from Ghe where MaGhe =?";
    String CHON_THEO_MA_TOA_SQL = "select * from Ghe where MaToa =?";

    public Ghe_DAO() {
        gheDat = new HashSet<>();
    }

    public boolean themGhe(Ghe ghe) {
        return gheDat.add(ghe);
    }

    public boolean xoaGhe(Ghe ghe) {
        return gheDat.contains(ghe) ? gheDat.remove(ghe) : false;
    }

    public Set<Ghe> layDSGheDat() {
        return this.gheDat;
    }

    public Ghe ChonTheoMa(String maGhe) {
        List<Ghe> list = this.ChonSql(CHON_THEO_MA_GHE_SQL, maGhe);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Ghe> ChonTheoMaToaTatCa(String maToa) {
        List<Ghe> list = this.ChonSql(CHON_THEO_MA_TOA_SQL, maToa);
        return list;
    }

    public List<Ghe> ChonTatCa() {
        return this.ChonSql(CHON_TAT_SQL);
    }

    protected List<Ghe> ChonSql(String sql, Object... args) {
        List<Ghe> list = new ArrayList<>();
        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.TruyVan(sql, args);
                while (boKetQua.next()) {
                    Ghe ghe = new Ghe();
                    ghe.setMaGhe(boKetQua.getInt("MaGhe"));
                    ghe.setMaToa(boKetQua.getString("MaToa"));

                    switch (boKetQua.getString("LoaiGhe")) {
                        case "Ghế Mềm":
                            ghe.setLoaiGhe(LOAI_GHE.GHẾ_MỀM);
                            break;
                        case "Giường Toa 6":
                            ghe.setLoaiGhe(LOAI_GHE.GIƯỜNG_TOA_6);
                            break;
                        case "Giường Toa 4":
                            ghe.setLoaiGhe(LOAI_GHE.GIƯỜNG_TOA_4);
                            break;
                        case "Giường Toa 2 VIP":
                            ghe.setLoaiGhe(LOAI_GHE.GIƯỜNG_TOA_2_VIP);
                            break;
                    }

                    switch (boKetQua.getString("TrangThaiGhe")) {
                        case "Trống":
                            ghe.setTrangThai(TRANG_THAI_GHE.Trong);
                            break;
                        case "Đã Đặt":
                            ghe.setTrangThai(TRANG_THAI_GHE.Da_dat);
                            break;
                    }

                    ghe.setSoGhe(boKetQua.getString("SoGhe"));

                    list.add(ghe);
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

    public List<Ghe> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Toa WHERE HoTen LIKE ?";
        return this.ChonSql(sql, "%" + keyword + "%");
    }

    public void testLogin(String username, String password){

        if(username.equals("Duy") && password.equals("anhduy2002")){

        }else{

        }
    }
}
