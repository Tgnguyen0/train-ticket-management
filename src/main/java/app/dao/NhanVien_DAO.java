package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.KhachHang;
import app.thuc_the.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NhanVien_DAO {
    String CHON_TAT_SQL = "SELECT * FROM NhaGa";
    String CHON_THEO_MA_SQL = "select * from NhanVien where MaNV =?";
    String query = "SELECT * FROM NhanVien WHERE maNV = ?";
    public List<NhanVien> dsnv;

    public NhanVien_DAO() {
    }

    public static String getVaiTro(String username) {
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT VaiTro FROM NhanVien WHERE TenDangNhap = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);

            // Bước 3: thực thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String vaiTro = rs.getString("VaiTro");
                st.close();
                connection.close();
                return vaiTro;
            }
            st.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static boolean update(NhanVien nv) {
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE NhanVien SET TenNV = ?, NgaySinh = ?, DiaChi = ?, SoDT = ?, GioiTinh = ? WHERE MaNV = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, nv.getTenNV());
            st.setDate(2, java.sql.Date.valueOf(nv.getNgaySinh()));
            st.setString(3, nv.getDiaChi());
            st.setString(4, nv.getSoDT());
            st.setString(5, nv.getGioiTinh().getValue());
            st.setString(6, nv.getMaNV());

            // Bước 3: thực thi câu lệnh truy vấn
            int kq = st.executeUpdate();
            if (kq > 0) {
                st.close();
                connection.close();
                return true;
            }
            st.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public static String layMatKhau(String username) {
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT MatKhau FROM NhanVien WHERE TenDangNhap = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);

            // Bước 3: thực thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String matKhau = rs.getString("MatKhau");
                st.close();
                connection.close();
                System.out.printf(matKhau);
                return matKhau.trim();
            }
            st.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static boolean doiMatKhau(String mkMoi, String username) {
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE NhanVien SET MatKhau = ? WHERE TenDangNhap = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, mkMoi);
            st.setString(2, username);

            // Bước 3: thực thi câu lệnh truy vấn
            int kq = st.executeUpdate();
            if (kq > 0) {
                st.close();
                connection.close();
                return true;
            }
            st.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

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

    public void testLogin(String username, String password) {

        if (username.equals("Duy") && password.equals("anhduy2002")) {

        } else {

        }
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
            st.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    public static NhanVien layThongTinNV(String username) {
        NhanVien nv = new NhanVien();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM NhanVien WHERE TenDangNhap = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);

            // Bước 3: thực thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String maNV = rs.getString("MaNV");
                String tenNV = rs.getString("TenNV");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
                GIOI_TINH gt = GIOI_TINH.NAM;
                if (!rs.getString("GioiTinh").equals("Nam")) {
                    nv.setGioiTinh(GIOI_TINH.NU);
                }
                st.close();
                connection.close();
                return nv = new NhanVien(maNV, tenNV, ngaySinh, diaChi, soDT, gt);
            }
            st.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return nv;

    }
}
