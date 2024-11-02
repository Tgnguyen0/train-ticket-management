package app.dao;

import app.ket_noi_co_so_du_lieu.JDBCUtil;
import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.KhachHang;
import app.thuc_the.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVien_DAO {
    String CHON_TAT_SQL = "SELECT * FROM NhaGa";
    String CHON_THEO_MA_SQL = "select * from NhanVien where MaGa =?";

    public List<NhanVien> dsnv;

    public void NhanVien_DAO() {
        dsnv = new ArrayList<NhanVien>();
    }

    public NhanVien ChonTheoMa(String manv) {
        List<NhanVien> list = this.ChonSql(CHON_THEO_MA_SQL, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NhanVien> ChonTatCa() {
        return this.ChonSql(CHON_TAT_SQL);
    }

    protected List<NhanVien> ChonSql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.truyVan(sql, args);
                while (boKetQua.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(boKetQua.getString("MaNV"));
                    nv.setTenNV(boKetQua.getString("TenNV"));
                    nv.setNgaySinh(boKetQua.getDate("NgaySinh").toLocalDate());
                    nv.setDiaChi(boKetQua.getString("DiaChi"));
                    nv.setNgaySinh(boKetQua.getDate("NgaySinh").toLocalDate());
                    nv.setGioiTinh(boKetQua.getString("GioiTinh") == GIOI_TINH.NAM.getValue() ? GIOI_TINH.NAM : GIOI_TINH.NU);
                    nv.setMatKhau(boKetQua.getString("MatKhau"));
                    nv.setVaiTro(boKetQua.getString("VaiTro"));
                    list.add(nv);
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

    public List<NhanVien> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhanVien WHERE HoTen LIKE ?";
        return this.ChonSql(sql, "%" + keyword + "%");
    }

    public void testLogin(String username, String password){

        if(username.equals("Duy") && password.equals("anhduy2002")){

        }else{

        }
    }
    // Hàm lấy tên Nhân Viên
    public String layTenNhanVien(String maNV) {
        String tenNV = null;
        // Kết nối tới cơ sở dữ liệu và thực hiện truy vấn
        String query = "SELECT * FROM NhanVien WHERE maNV = ?"; // Giả sử bảng nhân viên có tên cột 'te  n'

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maNV);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tenNV = rs.getString("TenNV"); // Lấy tên nhân viên
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenNV;
    }
    public static boolean login(String username, String password) {
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM NhanVien WHERE TenDangNhap = ? AND MatKhau = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);

            // Bước 3: thực thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                st.close();
                connection.close();
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }
}
