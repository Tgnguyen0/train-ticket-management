package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.KhachHang;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHang_DAO {
    String NHAP_SQL = "INSERT INTO KhachHang (MaKH, TenKH, DiaChi, SoDT, Email, GioiTinh) values (?, ?, ?, ?, ?, ?)";
    String CAP_NHAT_SQL = "UPDATE TenKH=?, DiaChi=?, SoDT=?, Email=?, GioiTinh=? WHERE MaKH=?";
    String CHON_TAT_SQL = "SELECT * FROM KhachHang";
    String CHON_THEO_MA_SQL = "SELECT * FROM KhachHang WHERE MaKH=?";

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

    // Lưu kh vào cơ sở dữ liệu
    public int LuuKHVaoCSDL(KhachHang kh) {
        int i;
        try {
            i = 1;
            KetNoiCoSoDuLieu.CapNhat(
                    NHAP_SQL,
                    kh.getMaKH(),
                    kh.getTenKH(),
                    kh.getDiaChi(),
                    kh.getSoDT(),
                    kh.getEmail(),
                    kh.getGioiTinh()
            );
        } catch (Exception e) {
            i = 0;
        }

        return i;
    }

    public int CapNhatKhachHangCSDL(KhachHang kh) {
        int i = 0;

        try {
            i = 1;
            KetNoiCoSoDuLieu.CapNhat(
                    CAP_NHAT_SQL,
                    kh.getTenKH(),
                    kh.getDiaChi(),
                    kh.getSoDT(),
                    kh.getEmail(),
                    kh.getGioiTinh(),
                    kh.getMaKH()
            );
        } catch (Exception e) {
            i = 0;
        }

        return i;
    }

    public KhachHang ChonTheoID(String manv) {
        List<KhachHang> list = this.ChonSQL(CHON_THEO_MA_SQL, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<KhachHang> ChonTatCa() {
        return this.ChonSQL(CHON_TAT_SQL);
    }

    public List<KhachHang> ChonSQL(String lenhSQL, Object... thamSo) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.TruyVan(lenhSQL, thamSo);
                while (boKetQua.next()) {
                    KhachHang kh = new KhachHang();

                    kh.setMaKHTuCSDL(boKetQua.getString("MaKH"));
                    kh.setTenKH(boKetQua.getString("TenKH"));
                    kh.setDiaChi(boKetQua.getString("DiaChi"));
                    kh.setSoDT(boKetQua.getString("SoDT"));
                    kh.setEmail(boKetQua.getString("Email"));
                    kh.setGioiTinh(boKetQua.getString("GioiTinh") == GIOI_TINH.NAM.getValue() ? GIOI_TINH.NAM : GIOI_TINH.NU);
                    list.add(kh);
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

    public List<KhachHang> ChonTheoTuKhoa(String keyword) {
        String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ?";
        return this.ChonSQL(    sql, "%" + keyword + "%");
    }

    public void kiemTraDangNhap(String nguoiDung, String matKhau){

        if(nguoiDung.equals("sa") && matKhau.equals("123")){

        }else{

        }
    }
}
