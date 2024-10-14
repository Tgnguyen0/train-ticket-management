package app.dao;

import app.thuc_the.Ghe;
import app.thuc_the.Ve;

import java.util.ArrayList;
import java.util.List;

public class Ve_DAO {
    // Các câu lệnh SQL
    String INSERT_SQL = "INSERT INTO SanPham (MaSanPham, TenSanPham, DonGia, Size, Hinh, MaLoai) VALUES (?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE SanPham SET TenSanPham=?, DonGia=?, Size=?, Hinh=?, MaLoai=? WHERE MaSanPham=?";
    String DELETE_SQL = "DELETE FROM SanPham WHERE MaSanPham=?";
    String SELECT_ALL_SQL = "SELECT * FROM SanPham";
    String SELECT_BY_ID_SQL = "SELECT * FROM SanPham WHERE MaSanPham =?";

    List<Ve> dsVe; // Tránh thông tin bị trùng

    // Khởi tạo danh sách Vé
    public Ve_DAO() {
        dsVe = new ArrayList<Ve>();
    }

    // Thêm khách hàng
    public boolean ThemVe(Ve ve) {
        return dsVe.add(ve);
    }

    // Tìm Kiếm khách hàng
    public Ve TimKiemVe(String maVe, String gaDi, String gaDen, String soHieu) {
        for (int i = 0 ; i < dsVe.size() ; i++) {
            boolean dungVe = true;

            // Kiểm tra điều kiện để chọn khách hàng cần tìm kiếm
            dungVe = maVe.equals(dsVe.get(i).getMaVe()) &&
                    gaDi.equals(dsVe.get(i).getGaKhoiHanh()) &&
                    gaDen.equals(dsVe.get(i).getGaKetThuc()) &&
                    soHieu.equals(dsVe.get(i).getTau().getSoHieu());

            if (dungVe) {
                return dsVe.get(i);
            }
        }

        return null;
    }

    // Cập Nhật thông tin cho khách hàng
    public boolean CapNhatThongTinKhachHang(Ve ve) {
        Ve veCanCapNhat = TimKiemVe(ve.getMaVe(), ve.getGaKhoiHanh(), ve.getGaKetThuc(), ve.getTau().getSoHieu());

        if (veCanCapNhat == null) {
            return false;
        }

        veCanCapNhat.setLoaiDoiTuong(ve.getLoaiDoiTuong());
        veCanCapNhat.setNgayKhoiHanh(ve.getNgayKhoiHanh());
        veCanCapNhat.setNgayDatVe(ve.getNgayDatVe());
        veCanCapNhat.setDaiNgo(ve.getDaiNgo());
        veCanCapNhat.setGaKhoiHanh(ve.getGaKhoiHanh());
        veCanCapNhat.setGaKetThuc(ve.getGaKetThuc());
        veCanCapNhat.setGiaVe(ve.getGiaVe());
        veCanCapNhat.setKhachHang(ve.getKhachHang());
        veCanCapNhat.setGhe(ve.getGhe());
        veCanCapNhat.setLoaiVe(ve.getLoaiVe());

        return true;
    }
}
