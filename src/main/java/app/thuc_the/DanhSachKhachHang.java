package app.thuc_the;

import java.util.List;

public class DanhSachKhachHang {
    public static List<KhachHang> getDanhsachKhachHang() {
        List<KhachHang> dskh = null;
        KhachHang_DAO khachHang_dao = new KhachHang_DAO();
        try {
            dskh = khachHang_dao.ChonTatCa();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dskh;
    }


}
