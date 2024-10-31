package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.KhachHang;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachHang_DAO {
    String NHAP_SQL = "INSERT INTO KhachHang (MaKH, TenKH, DiaChi, SoDT, Email, GioiTinh) values (?, ?, ?, ?, ?, ?)";
    String CAP_NHAT_SQL = "UPDATE TenKH=?, DiaChi=?, SoDT=?, Email=?, GioiTinh=? WHERE MaKH=?";
    String CHON_TAT_SQL = "use TrainStationDatabase SELECT * FROM KhachHang";
    String CHON_THEO_MA_SQL = "SELECT * FROM KhachHang WHERE MaKH=?";

    List<KhachHang> dskhDatVe; // Tránh thông tin bị trùng

    // Khởi tạo danh sách khách hàng
    public KhachHang_DAO() {
        dskhDatVe = new ArrayList<KhachHang>();
    }

    public boolean themDSKH(List<KhachHang> dskh) { return dskhDatVe.addAll(dskh); }

    // Thêm khách hàng
    public boolean ThemKhachHang(KhachHang kh) {
        return dskhDatVe.add(kh);
    }

    // Tìm Kiếm khách hàng
    public KhachHang TimKiemKhachHang(String tenKH, String diaChi, String sdt) {
        for (int i = 0; i < dskhDatVe.size(); i++) {
            boolean dungKh = true;

            // Kiểm tra điều kiện để chọn khách hàng cần tìm kiếm
            dungKh = tenKH.equals(dskhDatVe.get(i).getDiaChi()) &&
                    diaChi.equals(dskhDatVe.get(i).getTenKH()) &&
                    sdt.equals(dskhDatVe.get(i).getSoDT());

            if (dungKh) {
                return dskhDatVe.get(i);
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
            KetNoiCoSoDuLieu.capNhat(
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
            KetNoiCoSoDuLieu.capNhat(
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
                boKetQua = KetNoiCoSoDuLieu.truyVan(lenhSQL, thamSo);
                if (boKetQua == null) {
                    System.out.println("Không có kết quả trả về");
                }
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
                if (boKetQua != null)
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

    // Cập nhật thông tin khách hàng
    public void capNhatKhachHang_KhangVersion(KhachHang khachHang) {

        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE KhachHang " +
                    " SET " +
                    " TenKH=?" +
                    ", DiaChi=?" +
                    ", SoDT=?" +
                    ", Email=?" +
                    ", GioiTinh=?" +
                    " WHERE MaKH=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, khachHang.getTenKH());
            st.setString(2, khachHang.getDiaChi());
            st.setString(3, khachHang.getSoDT());
            st.setString(4, khachHang.getEmail());
            st.setString(5, khachHang.getGioiTinh().getValue());
            st.setString(6, khachHang.getMaKH());
            // Bước 3: thực thi câu lệnh SQL
            int ketQuaThucHien = st.executeUpdate();
            if (ketQuaThucHien > 0) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            } else {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
            }


            // Bước 4: đóng kết nối
            st.close();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ArrayList<KhachHang> layDanhSachKhachHang_KhangVersion() {
        ArrayList<KhachHang> list = new ArrayList<>();

        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement st = connection.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4: xử lý kết quả
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }

            // Bước 5: đóng kết nối
            st.close();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<KhachHang> timTheoTen_KhangVersion(String ten){
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + ten + "%");

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4: xử lý kết quả
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }

            // Bước 5: đóng kết nối
            st.close();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<KhachHang> timTheoSDT_KhangVersion (String sdt){
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM KhachHang WHERE SoDT LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + sdt + "%");

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4: xử lý kết quả
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }

            // Bước 5: đóng kết nối
            st.close();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<KhachHang> timTheoTenVaSDT_KhangVersion(String ten, String sdt){
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ? AND SoDT LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + ten + "%");
            st.setString(2, "%" + sdt + "%");

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4: xử lý kết quả
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }

            // Bước 5: đóng kết nối
            st.close();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    }
    public static int themKhachHang(KhachHang khachHang){
        int ketQuaThucThi = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO KhachHang (TenKH, DiaChi, SoDT, Email, GioiTinh) values ( ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, khachHang.getTenKH());
            st.setString(2, khachHang.getDiaChi());
            st.setString(3, khachHang.getSoDT());
            st.setString(4, khachHang.getEmail());
            st.setString(5, khachHang.getGioiTinh().getValue());




            // Bước 3: thực thi câu lệnh SQL
            ketQuaThucThi = st.executeUpdate();

            // Bước 4: xử lý kết quả


            // Bước 5: đóng kết nối
            st.close();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketQuaThucThi;
    }

    public KhachHang layKhachHangMuaVeTheoMaKhachHang(String maKhRequest){
        KhachHang khachHang = null;
        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
            String sql = "SELECT top 1 * FROM KhachHang kh WHERE kh.MaKH = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maKhRequest); // Tránh SQL Injection
            ResultSet rs = st.executeQuery();

            if (rs.next()) { // Di chuyển đến hàng đầu tiên
                String maKh = rs.getString(1);
                String tenKh = rs.getString(2);
                String diaChi = rs.getString(3);
                String soDienThoai = rs.getString(4);
                String email = rs.getString(5);
                String gioiTinh = rs.getString(6);

                if (gioiTinh.equalsIgnoreCase(GIOI_TINH.NAM.getValue())) {
                    khachHang = new KhachHang(maKh, tenKh, diaChi, soDienThoai, email, GIOI_TINH.NAM);
                } else {
                    khachHang = new KhachHang(maKh, tenKh, diaChi, soDienThoai, email, GIOI_TINH.NU);
                }
            }

            rs.close(); // Đóng ResultSet
            st.close(); // Đóng PreparedStatement
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return khachHang;

    }

    public static KhachHang layCuoiDanhSach () {
        KhachHang kh = new KhachHang();
        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            String sql = "SELECT TOP 1 * FROM KhachHang ORDER BY MaKH DESC";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                kh.setMaKHTuCSDL(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDT(rs.getString("SoDT"));
                kh.setEmail(rs.getString("Email"));
                if (rs.getString("GioiTinh").equals(GIOI_TINH.NAM.getValue())) {
                    kh.setGioiTinh(GIOI_TINH.NAM);
                } else {
                    kh.setGioiTinh(GIOI_TINH.NU);
                }
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kh;
    }

    public static KhachHang timTheoMaKH_KhangVersion(String maKH){
        KhachHang kh = new KhachHang();
        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, maKH);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                kh.setMaKHTuCSDL(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSoDT(rs.getString("SoDT"));
                kh.setEmail(rs.getString("Email"));
                if (rs.getString("GioiTinh").equals(GIOI_TINH.NAM.getValue())) {
                    kh.setGioiTinh(GIOI_TINH.NAM);
                } else {
                    kh.setGioiTinh(GIOI_TINH.NU);
                }
                return kh;
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kh;
    }




    public ArrayList<KhachHang> tim_ten(String timTen) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + timTen + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
    } return list;
    }

    public ArrayList<KhachHang> tim_sdt(String timSDT) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            String sql = "SELECT * FROM KhachHang WHERE SoDT LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + timSDT + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return list;
    }

    public ArrayList<KhachHang> tim_email(String timEmail) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            String sql = "SELECT * FROM KhachHang WHERE Email LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + timEmail + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } return list;
    }

    public ArrayList<KhachHang> tim_ten_email(String timTen, String timEmail) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ? AND Email LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + timTen + "%");
            st.setString(2, "%" + timEmail + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();} return list;
    }

    public ArrayList<KhachHang> tim_sdt_email(String timSDT, String timEmail) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            String sql = "SELECT * FROM KhachHang WHERE SoDT LIKE ? AND Email LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + timSDT + "%");
            st.setString(2, "%" + timEmail + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return list;
    }

    public ArrayList<KhachHang> tim_ten_sdt_email(String timTen, String timSDT, String timEmail) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ? AND SoDT LIKE ? AND Email LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + timTen + "%");
            st.setString(2, "%" + timSDT + "%");
            st.setString(3, "%" + timEmail + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return list;
    }

    public ArrayList<KhachHang> tim_ten_sdt(String timTen, String timSDT) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection connection = KetNoiCoSoDuLieu.ketNoiDB_KhangVersion();
            String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ? AND SoDT LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + timTen + "%");
            st.setString(2, "%" + timSDT + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String soDT = rs.getString("SoDT");
                String email = rs.getString("Email");
                String gioiTinh = rs.getString("GioiTinh");

                GIOI_TINH gt = GIOI_TINH.NAM;
                if(!gioiTinh.equals(GIOI_TINH.NAM.getValue())){
                    gt = GIOI_TINH.NU;
                }

                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, soDT, email, gt);
                list.add(kh);
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return list;
    }
}

