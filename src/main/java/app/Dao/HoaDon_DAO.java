package app.Dao;

import app.giao_dien.TrangHoaDon;
import app.ket_noi_co_so_du_lieu.JDBCUtil;
import app.thuc_the.HoaDon;
import app.thuc_the.KhachHang;
import app.thuc_the.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoaDon_DAO {
    ArrayList<HoaDon> dshd;
    // Khởi tạo danh sách khách hàng
    public HoaDon_DAO() {
        dshd = new ArrayList<HoaDon>();
    }

    public List<HoaDon> layDanhSachHoaDon() {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon";

        try (Connection conn = JDBCUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayLap(rs.getDate("NgayLap").toLocalDate());
                hd.setMaNV(rs.getString("MaNV"));
                hd.setThanhTien(rs.getFloat("ThanhTien"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setSoLuong(rs.getInt("SoLuong"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                hd.setDaiNgo(rs.getFloat("DaiNgo"));
                hd.setThue(rs.getFloat("Thue"));

                danhSachHoaDon.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachHoaDon;
    }
    // Tìm Kiếm khách hàng
    public List<HoaDon> TimKiemHoaDon(String maHD, String maKH) {
        List<HoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = "SELECT * FROM HoaDon WHERE MaHD LIKE ? OR MaKH LIKE ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + maHD + "%"); // Tìm kiếm theo mã hóa đơn
            ps.setString(2, "%" + maKH + "%"); // Tìm kiếm theo mã khách hàng

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                // Giả sử bạn có các phương thức set tương ứng để gán giá trị cho các thuộc tính
                hoaDon.setMaHD(rs.getString("MaHD"));
                hoaDon.setMaKH(rs.getString("MaKH"));
                hoaDon.setNgayLap(rs.getDate("NgayLap").toLocalDate());
                hoaDon.setMaNV(rs.getString("MaNV"));
                hoaDon.setThanhTien(rs.getFloat("ThanhTien"));
                hoaDon.setSoLuong(rs.getInt("SoLuong"));
                hoaDon.setTongTien(rs.getFloat("TongTien"));
                hoaDon.setTrangThai(rs.getString("TrangThai"));
                hoaDon.setDaiNgo(rs.getFloat("DaiNgo"));
                // Thêm các thuộc tính khác nếu cần
                danhSachHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }

}


// Cập Nhật thông tin cho khách hàng
//    public boolean CapNhatThongTinHoaDon(HoaDon hd) {
//        HoaDon hdCanCapNhat = TimKiemHoaDon(hd.getMaHoaDon(), hd.getKhachHang().getTenKH(), hd.getKhachHang().getSoDT());
//
//        return false;
//    }

// Lưu vào hóa đơn vào cơ sở dữ liệu



