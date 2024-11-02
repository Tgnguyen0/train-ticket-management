package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.Tau;
import app.thuc_the.Toa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Toa_DAO {
    String CHON_TAT_SQL = "SELECT * FROM Toa";
    String CHON_THEO_MA_SQL = "select * from Toa where MaToa =?";
    String CHON_THEO_SO_HIEU_SQL = "select * from Toa where SoHieu =?";
    public List<Toa> dsToaDaChon;

    public void Toa_DAO() { dsToaDaChon = new ArrayList<Toa>();}

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
                    toa.setSoHieu(boKetQua.getString("SoHieu"));
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

    public static Toa layToaTheoMaToa(String maToaRequest){
        String sql = "SELECT * FROM Toa WHERE MaToa = ?";
        Toa toa = new Toa();
        try {
                Connection connect = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
                PreparedStatement preparedStatement =  connect.prepareStatement(sql);

            // Thiết lập giá trị cho câu truy vấn
            preparedStatement.setString(1, maToaRequest);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy thông tin từ hàng tìm được
                   toa.setMaToa(resultSet.getString("MaToa"));
                   toa.setTenToa(resultSet.getString("TenToa")); // Giả sử có cột LoaiToa
                   toa.setSoLuongGhe( resultSet.getInt("SoLuongGhe")); // Giả sử có cột SoGhe
                   toa.setMaTau( resultSet.getString("SoHieu"));

                   return toa;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi truy vấn cơ sở dữ liệu");
        }
        return toa;
    }

    public static Toa layToaTheoMaTau_TenToa(String tenToaRequest, String maTauRequest){
        String sql = "SELECT * FROM Toa WHERE SoHieu = ? and TenToa = ?";
        Toa toa = new Toa();
        try {
            Connection connect = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
            PreparedStatement preparedStatement =  connect.prepareStatement(sql);

            // Thiết lập giá trị cho câu truy vấn
            preparedStatement.setString(1, maTauRequest);
            preparedStatement.setString(2, tenToaRequest);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy thông tin từ hàng tìm được
                    toa.setMaToa(resultSet.getString("MaToa"));
                    toa.setTenToa(resultSet.getString("TenToa")); // Giả sử có cột LoaiToa
                    toa.setSoLuongGhe( resultSet.getInt("SoLuongGhe")); // Giả sử có cột SoGhe
                    toa.setMaTau( resultSet.getString("SoHieu"));
                    return toa;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi truy vấn cơ sở dữ liệu");
        }
        return toa;
    }
}
