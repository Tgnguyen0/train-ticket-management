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


            st.executeUpdate();

            // Bước 3: thực thi câu lệnh truy vấn

            st.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    public static ArrayList<NhanVien> timKiemTheoSDT(String soDienThoai) {
        ArrayList<NhanVien> dsnv = null;
        try {
            Connection c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                return null;
            }
            String sql = "SELECT * FROM NhanVien WHERE SoDT = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, soDienThoai);
            ResultSet rs = ps.executeQuery();
            dsnv = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setNgaySinh(rs.getDate("NgaySinh").toLocalDate());
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSoDT(rs.getString("SoDT"));
                GIOI_TINH gt = GIOI_TINH.NAM;
                if (!rs.getString("GioiTinh").equals("Nam")) {
                    gt = GIOI_TINH.NU;
                }
                nv.setGioiTinh(gt);
                nv.setVaiTro(rs.getString("VaiTro"));
                dsnv.add(nv);
            }
            rs.close();
            ps.close();
            c.close();
            return dsnv;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

    public static ArrayList<NhanVien> timKiemTheoTenVaSDT(String ten, String soDienThoai) {
        ArrayList<NhanVien> dsnv = null;
        try {
            Connection c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                return null;
            }
            String sql = "SELECT * FROM NhanVien WHERE TenNV like ? AND SoDT = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ps.setString(2, soDienThoai);
            ResultSet rs = ps.executeQuery();
            dsnv = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setNgaySinh(rs.getDate("NgaySinh").toLocalDate());
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSoDT(rs.getString("SoDT"));
                GIOI_TINH gt = GIOI_TINH.NAM;
                if (!rs.getString("GioiTinh").equals("Nam")) {
                    gt = GIOI_TINH.NU;
                }
                nv.setGioiTinh(gt);
                nv.setVaiTro(rs.getString("VaiTro"));
                dsnv.add(nv);
            }
            rs.close();
            ps.close();
            c.close();
            return dsnv;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

    public static void capNhatChiTietNhanVien(NhanVien nv) {
        try {
            Connection c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                return;
            }
            String sql = "UPDATE NhanVien SET TenNV = ?, NgaySinh = ?, DiaChi = ?, SoDT = ?, GioiTinh = ?, VaiTro = ? WHERE MaNV = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setDate(2, java.sql.Date.valueOf(nv.getNgaySinh()));
            ps.setString(3, nv.getDiaChi());
            ps.setString(4, nv.getSoDT());
            ps.setString(5, nv.getGioiTinh().getValue());
            ps.setString(6, nv.getVaiTro());
            ps.setString(7, nv.getMaNV());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int thuHoiTaiKhoan(String maNV) {
        int kq = 0;

        try {
            Connection c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                return 0;
            }
            String sql = "UPDATE NhanVien set TenDangNhap = ? WHERE MaNV = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, "Đã thu hồi");
            ps.setString(2, maNV);
            kq = ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
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

    /*public List<NhanVien> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhanVien WHERE HoTen LIKE ?";
        return this.ChonSql(sql, "%" + keyword + "%");
    }

    public void testLogin(String username, String password) {

        if (username.equals("Duy") && password.equals("anhduy2002")) {

        } else {

        }
    }*/
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
            st.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    public static NhanVien layThongTinNV(String username) {
        NhanVien nv = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);

            // Bước 3: thực thi câu lệnh truy vấn
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String maNV = rs.getString("MaNV");
                String tenNV = rs.getString("TenNV");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String tenDangNhap = rs.getString("TenDangNhap");
                LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
                GIOI_TINH gt = GIOI_TINH.NAM;
                if (!rs.getString("GioiTinh").equals("Nam")) {
                    gt = GIOI_TINH.NU;
                }
                String vaiTro = rs.getString("VaiTro");
                st.close();
                connection.close();
                nv = new NhanVien();
                nv.setMaNV(maNV);
                nv.setTenNV(tenNV);
                nv.setDiaChi(diaChi);
                nv.setSoDT(soDT);
                nv.setTenDangNhap(tenDangNhap);
                nv.setNgaySinh(ngaySinh);
                nv.setGioiTinh(gt);
                nv.setVaiTro(vaiTro);
                return nv;
            }
            st.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return nv;

    }

    public static NhanVien layNhanVienTheo_TenNhanVien(String tenNhanVienRequest) {
        NhanVien nhanVien = null;
        String sql = "SELECT * FROM NhanVien WHERE TenNV = ?";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tenNhanVienRequest);  // Set the TenNV parameter
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nhanVien = new NhanVien();
                nhanVien.setMaNV(resultSet.getString("MaNV"));
                nhanVien.setTenNV(resultSet.getString("TenNV"));
                nhanVien.setNgaySinh(resultSet.getDate("NgaySinh").toLocalDate());
                nhanVien.setDiaChi(resultSet.getString("DiaChi"));
                nhanVien.setSoDT(resultSet.getString("SoDT"));
                if (resultSet.getString("GioiTinh").compareToIgnoreCase("Nam") == 0) {
                    nhanVien.setGioiTinh(GIOI_TINH.NAM);
                } else {
                    nhanVien.setGioiTinh(GIOI_TINH.NU);
                }
                nhanVien.setMatKhau(resultSet.getString("MatKhau"));
                nhanVien.setVaiTro(resultSet.getString("VaiTro"));
                nhanVien.setVaiTro(resultSet.getString("TenDangNhap"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nhanVien;
    }
    public static NhanVien layNhanVienTheo_MaNhanVien(String maNhanVienRequest) {
        NhanVien nhanVien = null;
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";

        try (Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, maNhanVienRequest);  // Set the TenNV parameter
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nhanVien = new NhanVien();
                nhanVien.setMaNV(resultSet.getString("MaNV"));
                nhanVien.setTenNV(resultSet.getString("TenNV"));
                nhanVien.setNgaySinh(resultSet.getDate("NgaySinh").toLocalDate());
                nhanVien.setDiaChi(resultSet.getString("DiaChi"));
                nhanVien.setSoDT(resultSet.getString("SoDT"));
                if (resultSet.getString("GioiTinh").compareToIgnoreCase("Nam") == 0) {
                    nhanVien.setGioiTinh(GIOI_TINH.NAM);
                } else {
                    nhanVien.setGioiTinh(GIOI_TINH.NU);
                }
                nhanVien.setMatKhau(resultSet.getString("MatKhau"));
                nhanVien.setVaiTro(resultSet.getString("VaiTro"));
                nhanVien.setVaiTro(resultSet.getString("TenDangNhap"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nhanVien;
    }

    public static int themNhanVien(NhanVien nv) {
        int kq = 0;
        try {
            Connection c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                return 0;
            }
            String sql = "INSERT INTO NhanVien(TenNV, NgaySinh, DiaChi, SoDT, GioiTinh,VaiTro) VALUES( ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nv.getTenNV());
            ps.setDate(2, java.sql.Date.valueOf(nv.getNgaySinh()));
            ps.setString(3, nv.getDiaChi());
            ps.setString(4, nv.getSoDT());
            ps.setString(5, nv.getGioiTinh().getValue());
            ps.setString(6, nv.getVaiTro());
            kq = ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static ArrayList<NhanVien> layDSNV() {
        ArrayList<NhanVien> dsnv = null;
        try {
            Connection c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                return null;
            }
            String sql = "SELECT * FROM NhanVien order by TenNV";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            dsnv = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setNgaySinh(rs.getDate("NgaySinh").toLocalDate());
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSoDT(rs.getString("SoDT"));
                GIOI_TINH gt = GIOI_TINH.NAM;
                if (!rs.getString("GioiTinh").equals("Nam")) {
                    gt = GIOI_TINH.NU;
                }
                nv.setGioiTinh(gt);
                nv.setVaiTro(rs.getString("VaiTro"));
                dsnv.add(nv);
            }
            rs.close();
            ps.close();
            c.close();
            return dsnv;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }

    public static ArrayList<NhanVien> timTenNhanVien(String ten) {
        ArrayList<NhanVien> dsnv = null;
        try {
            Connection c = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            if (c == null) {
                return null;
            }
            String sql = "SELECT * FROM NhanVien WHERE TenNV LIKE ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            ResultSet rs = ps.executeQuery();
            dsnv = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setNgaySinh(rs.getDate("NgaySinh").toLocalDate());
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setSoDT(rs.getString("SoDT"));
                GIOI_TINH gt = GIOI_TINH.NAM;
                if (!rs.getString("GioiTinh").equals("Nam")) {
                    gt = GIOI_TINH.NU;
                }
                nv.setGioiTinh(gt);
                nv.setVaiTro(rs.getString("VaiTro"));
                dsnv.add(nv);
            }
            rs.close();
            ps.close();
            c.close();
            return dsnv;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsnv;
    }
}
