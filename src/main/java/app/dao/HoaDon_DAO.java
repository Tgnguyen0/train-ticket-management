package app.dao;

import app.giao_dien.TrangChuaThongKeDoanhThuNhaGa;
import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.HoaDon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HoaDon_DAO {
    ArrayList<HoaDon> dshd;
    Logger logger  = LoggerFactory.getLogger(TrangChuaThongKeDoanhThuNhaGa.class);
    // Khởi tạo danh sách khách hàng
    public HoaDon_DAO() {
        dshd = new ArrayList<HoaDon>();
    }

    // Thêm khách hàng
    public boolean ThemHoaDon(HoaDon hd) {
        return dshd.add(hd);
    }

    // Tìm Kiếm khách hàng
    /*
    public HoaDon TimKiemHoaDon(String maHD, String tenKH, String sdt) {
        for (int i = 0 ; i < dshd.size() ; i++) {
            boolean dungHd = true;

            // Kiểm tra điều kiện để chọn hoá đơn cần tìm kiếm
            dungHd = maHD.equals(dshd.get(i).getMaHoaDon()) &&
                    tenKH.equals(dshd.get(i).getKhachHang().getTenKH()) &&
                    sdt.equals(dshd.get(i).getKhachHang().getSoDT());

            if (dungHd) {
                return dshd.get(i);
            }
        }

        return null;
    }
    */
    // Cập Nhật thông tin cho khách hàng
    /*
    public boolean CapNhatThongTinHoaDon(HoaDon hd) {
        HoaDon hdCanCapNhat = TimKiemHoaDon(hd.getMaHoaDon(), hd.getKhachHang().getTenKH(), hd.getKhachHang().getSoDT());

        return false;
    }
    */
    // Lưu vào hóa đơn vào cơ sở dữ liệu
    public void luuKHVaoCSDL(HoaDon kh) {

    }

    public static ArrayList<String> layToanBoNamTuHoaDon(){
        ArrayList<String> namList = new ArrayList<>();
        String sql = "SELECT DISTINCT YEAR(NgayLap) AS nam FROM HoaDon  order by YEAR(NgayLap) ASC";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nam = resultSet.getString("nam");
                namList.add(nam);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return namList;
    }

    public static double tongDoanhThuCuaNam(int nam){
        double tongDoanhThu = 0.0;
        String query = "SELECT SUM(ThanhTien) AS Total FROM HoaDon WHERE YEAR(NgayLap) = ?";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nam);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongDoanhThu = resultSet.getDouble("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongDoanhThu;
    }
    public static double tongDoanhThuCuaThang_Nam(int nam, int thang){
        double tongDoanhThu = 0.0;
        String query = "SELECT SUM(ThanhTien) AS Total FROM HoaDon WHERE YEAR(NgayLap) = ? and MONTH(NgayLap) = ?";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nam);
            preparedStatement.setInt(2, thang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongDoanhThu = resultSet.getDouble("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongDoanhThu;
    }

    public static int tongSoLuongCuaThang_Nam(int nam, int thang){
        int tongSoLuong = 0;
        String query = "SELECT SUM(SoLuong) AS Total FROM HoaDon WHERE YEAR(NgayLap) = ? and MONTH(NgayLap) = ?";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nam);
            preparedStatement.setInt(2, thang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongSoLuong = resultSet.getInt("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongSoLuong;
    }

    public static Map<Integer, Double> layDoanhThuCacNam(int namXuatPhat, int namKetThuc){
        Map<Integer, Double> doanhThuTheoNam = new HashMap<>();

        String sql = "SELECT YEAR(NgayLap) AS nam, SUM(ThanhTien) AS tongDoanhThu " +
                "FROM HoaDon " +
                "WHERE YEAR(NgayLap) >= ? AND YEAR(NgayLap) <= ? " +
                "GROUP BY YEAR(NgayLap)";

        try (Connection conn = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, namXuatPhat);
            pstmt.setInt(2, namKetThuc);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int nam = rs.getInt("nam");
                    double tongDoanhThu = rs.getDouble("tongDoanhThu");
                    doanhThuTheoNam.put(nam, tongDoanhThu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return doanhThuTheoNam;
    }

    public static int tongSoLuongCuaNam(int nam){
        int tongSoLuong = 0;
        String query = "SELECT SUM(SoLuong) AS Total FROM HoaDon WHERE YEAR(NgayLap) = ?";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, nam);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongSoLuong = resultSet.getInt("Total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tongSoLuong;
    }
}
