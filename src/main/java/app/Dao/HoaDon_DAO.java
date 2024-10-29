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
    }}


// Tìm Kiếm khách hàng
//    public HoaDon TimKiemHoaDon(String maHD, String tenKH, String sdt) {
//        for (int i = 0; i < dshd.size(); i++) {
//            boolean dungHd = true;
//
//            // Kiểm tra điều kiện để chọn hoá đơn cần tìm kiếm
//            dungHd = maHD.equals(dshd.get(i).getMaHD()) &&
//                    tenKH.equals(dshd.get(i).getKhachHang().getTenKH()) &&
//                    sdt.equals(dshd.get(i).getKhachHang().getSoDT());
//
//            if (dungHd) {
//                return dshd.get(i);
//            }
//        }
//
//        return null;
//    }

// Cập Nhật thông tin cho khách hàng
//    public boolean CapNhatThongTinHoaDon(HoaDon hd) {
//        HoaDon hdCanCapNhat = TimKiemHoaDon(hd.getMaHoaDon(), hd.getKhachHang().getTenKH(), hd.getKhachHang().getSoDT());
//
//        return false;
//    }

// Lưu vào hóa đơn vào cơ sở dữ liệu



