package app.dao;

import app.thuc_the.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoaDon_DAO {
    ArrayList<HoaDon> dshd;

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
}
