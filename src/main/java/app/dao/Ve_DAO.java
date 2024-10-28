package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.DaiNgo;
import app.thuc_the.KhachHang;
import app.thuc_the.Ve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ve_DAO {
    // Các câu lệnh SQL
    String NHAP_SQL = "INSERT INTO KhachHang (MaKH, TenKH, DiaChi, SoDT, Email, GioiTinh) values (?, ?, ?, ?, ?, ?)";
    String CAP_NHAT_SQL = "UPDATE TenKH=?, DiaChi=?, SoDT=?, Email=?, GioiTinh=? WHERE MaKH=?";
    String TAI_TAT_CA_SQL = "SELECT * FROM KhachHang";
    String CHON_THEO_MA_SQL = "SELECT * FROM KhachHang WHERE MaKH=?";

    List<Ve> danhSachVe; // Tránh thông tin bị trùng

    // Khởi tạo danh sách Vé
    public Ve_DAO() {
        danhSachVe = new ArrayList<Ve>();
    }

    // Thêm khách hàng
    public boolean ThemVe(Ve ve) {
        return danhSachVe.add(ve);
    }

    // Tìm Kiếm khách hàng
    /*
    public Ve TimKiemVe(String maVe, String gaDi, String gaDen, String soHieu) {
        for (int i = 0 ; i < dsVe.size() ; i++) {
            boolean dungVe = true;

            // Kiểm tra điều kiện để chọn khách hàng cần tìm kiếm
            dungVe = maVe.equals(dsVe.get(i).getMaVe()) &&
                    gaDi.equals(dsVe.get(i).getGaKhoiHanh()) &&
                    gaDen.equals(dsVe.get(i).getGaKetThuc()) &&
                   // soHieu.equals(dsVe.get(i).getTau().getSoHieu());

            if (dungVe) {
                return dsVe.get(i);
            }
        }

        return null;
    }
     */

    // Cập Nhật thông tin cho khách hàng
    /*
    public boolean CapNhatThongTinKhachHang(Ve ve) {
        Ve veCanCapNhat = TimKiemVe(ve.getMaVe(), ve.getGaKhoiHanh(), ve.getGaKetThuc(), ve.getMaTau().getSoHieu());

        if (veCanCapNhat == null) {
            return false;
        }

        veCanCapNhat.setLoaiDoiTuong(ve.getLoaiDoiTuong());
        veCanCapNhat.setNgayKhoiHanh(ve.getNgayKhoiHanh());
        veCanCapNhat.setNgayDatVe(ve.getNgayDatVe());
//        veCanCapNhat.setDaiNgo(ve.getDaiNgo());
        veCanCapNhat.setGaKhoiHanh(ve.getGaKhoiHanh());
        veCanCapNhat.setGaKetThuc(ve.getGaKetThuc());
        veCanCapNhat.setGiaVe(ve.getGiaVe());
//        veCanCapNhat.setKhachHang(ve.getKhachHang());
//        veCanCapNhat.setGhe(ve.getGhe());
        veCanCapNhat.setLoaiVe(ve.getLoaiVe());

        return true;
    }

    // Lưu kh vào cơ sở dữ liệu
    public int LuuKHVaoCSDL(Ve ve) {
        int i;
        try {
            i = 1;
            KetNoiCoSoDuLieu.CapNhat(
                    NHAP_SQL,
                    ve.getMaVe(),
                    ve.getNgayDatVe(),
                    ve.getGiaVe(),
//                    ve.getKhachHang().getMaKH(),
//                    ve.getDaiNgo(),
                    ve.getGaKhoiHanh(),
                    ve.getGaKetThuc(),
//                    ve.getGhe().getMaGhe(),
                    ve.getLoaiVe(),
                    ve.getLoaiDoiTuong(),
                    ve.getNgayKhoiHanh()
            );
        } catch (Exception e) {
            i = 0;
        }

        return i;
    }
    */
    public int CapNhatKhachHangCSDL(Ve ve) {
        int i = 0;

        try {
            i = 1;
            KetNoiCoSoDuLieu.capNhat(
                    CAP_NHAT_SQL,
                    ve.getNgayDatVe(),
                    ve.getGiaVe(),
//                    ve.getKhachHang().getMaKH(),
//                    ve.getDaiNgo(),
                    ve.getGaKhoiHanh(),
                    ve.getGaKetThuc(),
//                    ve.getGhe().getMaGhe(),
                    ve.getLoaiVe(),
                    ve.getLoaiDoiTuong(),
                    ve.getNgayKhoiHanh(),
                    ve.getMaVe()
            );
        } catch (Exception e) {
            i = 0;
        }

        return i;
    }

    public Ve ChonTheoID(String manv) {
        List<Ve> list = this.ChonSQL(CHON_THEO_MA_SQL, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Ve> ChonTatCa() {
        return this.ChonSQL(TAI_TAT_CA_SQL);
    }

    public List<Ve> ChonSQL(String lenhSQL, Object... thamSo) {
        List<Ve> list = new ArrayList<>();
        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.truyVan(lenhSQL, thamSo);
                while (boKetQua.next()) {
                    DaiNgo daiNgo = DaiNgo.GIAMGIAKHONGPHANTRAM;
                    Ve ve = new Ve();

                    if (boKetQua.getDouble("DaiNgo") == DaiNgo.GIAMGIAHAIMUOIPHANTRAM.getValue()) {
                        daiNgo = DaiNgo.GIAMGIAHAIMUOIPHANTRAM;
                    }

                    if (boKetQua.getDouble("DaiNgo") == DaiNgo.GIAMGIANAMPHANTRAM.getValue()) {
                        daiNgo = DaiNgo.GIAMGIANAMPHANTRAM;
                    }

                    if (boKetQua.getDouble("DaiNgo") == DaiNgo.GIAMGIAMUOIPHANTRAM.getValue()) {
                        daiNgo = DaiNgo.GIAMGIAMUOIPHANTRAM;
                    }

                    ve.setMaVeTuCSDL(boKetQua.getString("MaVe"));
                    ve.setNgayDatVe(boKetQua.getDate("NgayDatVe").toLocalDate());
                    ve.setGiaVe(boKetQua.getDouble("GiaVe"));
                    //ve.setKhachHang(boKetQua.getString("MaKH"));
//                  ve.setDaiNgo(daiNgo);
                    ve.setGaKetThuc(boKetQua.getString("GaKhoiHanh"));
                    ve.setGaKhoiHanh(boKetQua.getString("GaKetThuc"));
                    //ve.setGhe(boKetQua.getString("MaGhe"));
                    ve.setLoaiVe(boKetQua.getString("LoaiVe"));
                    ve.setLoaiDoiTuong(boKetQua.getString("LoaiDoiTuong"));
                    ve.setNgayKhoiHanh(boKetQua.getDate("NgayKhoiHanh").toLocalDate());
                    list.add(ve);
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

    public List<Ve> ChonTheoTuKhoa(String keyword) {
        String sql = "SELECT * FROM Ve WHERE TenKH LIKE ?";
        return this.ChonSQL(    sql, "%" + keyword + "%");
    }

    public void KiemTraDangNhap(String nguoiDung, String matKhau){

        if(nguoiDung.equals("sa") && matKhau.equals("123")){

        }else{

        }
    }

    public  List<Ve> layToanBoVe() throws SQLException {
        List<Ve> danhSachVe = new ArrayList<>();
        String sql = "select  * from Ve";
        Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            String maVe = resultSet.getString("MaVe");
            LocalDate ngayDatVe = resultSet.getDate("NgayDatVe").toLocalDate();
            double giaVe = resultSet.getDouble("GiaVe");
            String maKh = resultSet.getString("MaKH");
            String gaKhoiHanh = resultSet.getString("GaKhoiHanh");
            String gaKetThuc = resultSet.getString("GaKetThuc");
            String maGhe =  resultSet.getString("MaGhe");
            String loaiGhe = resultSet.getString("LoaiVe");
            String loaiDoiTuong = resultSet.getString("LoaiDoiTuong");
            LocalDate ngayKhoiHanh = resultSet.getDate("NgayKhoiHanh").toLocalDate();
            danhSachVe.add(new Ve(maVe,  loaiDoiTuong,  ngayKhoiHanh,  ngayDatVe,  gaKhoiHanh,  gaKetThuc,  giaVe,  maKh, maGhe,  loaiGhe));
        }
        return danhSachVe;
    }

    public Ve layVe_DuaVaoMaVe(String maVeRequest)throws SQLException{
        String sql = "SELECT * FROM Ve WHERE MaVe = ?";
        Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, maVeRequest); // Đặt tham số MaVe

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) { // Di chuyển con trỏ đến dòng kết quả đầu tiên
            String maVe = resultSet.getString("MaVe");
            LocalDate ngayDatVe = resultSet.getDate("NgayDatVe").toLocalDate();
            double giaVe = resultSet.getDouble("GiaVe");
            String maKh = resultSet.getString("MaKH");
            String gaKhoiHanh = resultSet.getString("GaKhoiHanh");
            String gaKetThuc = resultSet.getString("GaKetThuc");
            String maGhe =  resultSet.getString("MaGhe");
            String loaiGhe = resultSet.getString("LoaiVe");
            String loaiDoiTuong = resultSet.getString("LoaiDoiTuong");
            LocalDate ngayKhoiHanh = resultSet.getDate("NgayKhoiHanh").toLocalDate();

            return new Ve(maVe, loaiDoiTuong, ngayKhoiHanh, ngayDatVe, gaKhoiHanh, gaKetThuc, giaVe, maKh, maGhe, loaiGhe);
        } else {
            System.out.println("Không tìm thấy vé với mã: " + maVeRequest);
            return null; // Hoặc xử lý khác tùy theo yêu cầu
        }

    }
}
