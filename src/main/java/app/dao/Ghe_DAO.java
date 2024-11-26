package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.Ghe;
import app.thuc_the.LOAI_GHE;
import app.thuc_the.TRANG_THAI_GHE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ghe_DAO {
    int soGheToiDa;
    Set<Ghe> gheDat;
    Ghe gheDaChon;
    String CHON_TAT_SQL = "SELECT * FROM Ghe";
    String CHON_THEO_MA_GHE_SQL = "select * from Ghe where MaGhe =?";
    String CHON_THEO_MA_TOA_SQL = "select * from Ghe where MaToa =?";
    String CAP_NHAT_TRANG_THAI_GHE = "UPDATE Ghe SET TrangThaiGhe = ? WHERE MaGhe = ?";

    public Ghe_DAO() {
        this.gheDat = new HashSet<>();
    }

    public void datSoGheToiDa(int soGhe) { this.soGheToiDa = soGhe; }

    public int laySoGheToiDa() { return this.soGheToiDa; }

    public boolean themGhe(Ghe ghe) {
        return gheDat.add(ghe);
    }

    public boolean xoaGhe(Ghe ghe) {
        return gheDat.remove(ghe);
    }

    public Set<Ghe> layDSGheDat() {
        return this.gheDat;
    }

    public void datGheChon(Ghe gheDaChon) {
        this.gheDaChon = gheDaChon;
    }

    public Ghe traGheChon() {
        return this.gheDaChon;
    }

    public void xoaDSGheChon() {
        Set<Ghe> dsCanXoa = this.gheDat;
        this.gheDat.removeAll(dsCanXoa);
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

    public void capNhatTrangThaiGhe(String trangThai, String maGhe) {
        LuuSQL(CAP_NHAT_TRANG_THAI_GHE, trangThai, maGhe);
    }

    protected List<Ghe> ChonSql(String sql, Object... args) {
        List<Ghe> list = new ArrayList<>();
        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.truyVan(sql, args);
                while (boKetQua.next()) {
                    Ghe ghe = new Ghe();
                    ghe.setMaGhe(boKetQua.getString("MaGhe"));
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

    public void LuuSQL(String sql, Object... args) {
        try {
            try (PreparedStatement stmt = KetNoiCoSoDuLieu.layCauLenh(sql, args)) {
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
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

    public static Ghe layGheTheoMaGhe(String maGheRequest){
        String sql =  "SELECT * FROM Ghe WHERE MaGhe = ?";
        Ghe ghe = new Ghe();
        try{

            Connection connect = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
            PreparedStatement preparedStatement =  connect.prepareStatement(sql);

            // Thiết lập giá trị cho câu truy vấn
            preparedStatement.setString(1, maGheRequest);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy thông tin từ hàng tìm được
                    ghe.setMaGhe(resultSet.getString("MaGhe"));
                    ghe.setMaToa(resultSet.getString("MaToa"));
                    String loaiGhe = resultSet.getString("LoaiGhe");
                    switch (loaiGhe) {
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
                    String trangThai = resultSet.getString("TrangThaiGhe");
                    switch (trangThai) {
                        case "Trống":
                            ghe.setTrangThai(TRANG_THAI_GHE.Trong);
                            break;
                        case "Đã Đặt":
                            ghe.setTrangThai(TRANG_THAI_GHE.Da_dat);
                            break;
                    }// Giả sử có các cột tên TenGhe và TrangThai
                    ghe.setSoGhe(resultSet.getString("SoGhe"));
                    return ghe;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi truy vấn cơ sở dữ liệu");
        }
        return ghe;
    }

    public static Ghe layGheTheoMaToa_SoGhe(String maToaRequest, String soGheRequest){
        String sql =  "SELECT * FROM Ghe WHERE MaToa = ? and SoGhe = ?";
        Ghe ghe = new Ghe();
        try{

            Connection connect = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
            PreparedStatement preparedStatement =  connect.prepareStatement(sql);

            // Thiết lập giá trị cho câu truy vấn
            preparedStatement.setString(1, maToaRequest);
            preparedStatement.setString(2, soGheRequest);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy thông tin từ hàng tìm được
                    ghe.setMaGhe(resultSet.getString("MaGhe"));
                    ghe.setMaToa(resultSet.getString("MaToa"));
                    String loaiGhe = resultSet.getString("LoaiGhe");
                    switch (loaiGhe) {
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
                    String trangThai = resultSet.getString("TrangThaiGhe");
                    switch (trangThai) {
                        case "Trống":
                            ghe.setTrangThai(TRANG_THAI_GHE.Trong);
                            break;
                        case "Đã Đặt":
                            ghe.setTrangThai(TRANG_THAI_GHE.Da_dat);
                            break;
                    }// Giả sử có các cột tên TenGhe và TrangThai
                    ghe.setSoGhe(resultSet.getString("SoGhe"));
                    return ghe;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi truy vấn cơ sở dữ liệu");
        }
        return ghe;
    }
}
