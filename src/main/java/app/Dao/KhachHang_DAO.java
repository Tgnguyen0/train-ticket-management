package app.dao;

import app.thuc_the.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHang_DAO {
    List<KhachHang> dskh; // Tránh thông tin bị trùng

    // Khởi tạo danh sách khách hàng
    public KhachHang_DAO() {
        dskh = new ArrayList<KhachHang>();
    }

    // Thêm khách hàng
    public boolean ThemKhachHang(KhachHang kh) {
        return dskh.add(kh);
    }

    // Tìm Kiếm khách hàng
    public KhachHang TimKiemKhachHang(String tenKH, String diaChi, String sdt) {
        for (int i = 0 ; i < dskh.size() ; i++) {
            boolean dungKh = true;

            // Kiểm tra điều kiện để chọn khách hàng cần tìm kiếm
            dungKh = tenKH.equals(dskh.get(i).getDiaChi()) &&
                     diaChi.equals(dskh.get(i).getTenKH()) &&
                     sdt.equals(dskh.get(i).getSoDT());

            if (dungKh) {
                return dskh.get(i);
            }
        }

        return null;
    }

    // Cập Nhật thông tin cho khách hàng
    public boolean CapNhatThongTinKhachHang(KhachHang kh) {
        KhachHang khCanCapNhat = TimKiemKhachHang(kh.getTenKH(), kh.getDiaChi(), kh.getSoDT());

        return false;
    }

    // Lưu vào kh vào cơ sở dữ liệu
    public void luuKHVaoCSDL(KhachHang kh) {

    }
}
