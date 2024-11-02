package app.dao;

import app.giao_dien.TrangThongTinChiTietVeTau;
import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.DaiNgo;
import app.thuc_the.KhachHang;
import app.thuc_the.Ve;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class Ve_DAO {
    // Các câu lệnh SQL
    String NHAP_SQL = "INSERT INTO KhachHang (MaKH, TenKH, DiaChi, SoDT, Email, GioiTinh) values (?, ?, ?, ?, ?, ?)";
    String CAP_NHAT_SQL = "UPDATE TenKH=?, DiaChi=?, SoDT=?, Email=?, GioiTinh=? WHERE MaKH=?";
    String TAI_TAT_CA_SQL = "SELECT * FROM KhachHang";
    String CHON_THEO_MA_SQL = "SELECT * FROM KhachHang WHERE MaKH=?";

    Logger logger = LoggerFactory.getLogger(TrangThongTinChiTietVeTau.class);
    public Map<String, Map<String, Integer>> giaVeCoBan = Map.of(
            "Ghế Mềm", Map.of(
                    "Trẻ em", 400,
                    "Người lớn", 450
            ),
            "Giường Toa 4", Map.of(
                    "Trẻ em", 550,
                    "Người lớn", 600
            ),
            "Giường Toa 6", Map.of(
                    "Trẻ em", 460,
                    "Người lớn", 520
            ),
            "Giường Toa 2 VIP", Map.of(
                    "Trẻ em", 750,
                    "Người lớn", 800
            )
    );

    List<Ve> dsVeDat; // Tránh thông tin bị trùng

    // Khởi tạo danh sách Vé
    public Ve_DAO() {
        this.dsVeDat = new ArrayList<Ve>();
    }

    // Thêm khách hàng
    public boolean ThemVe(Ve ve) {
        return dsVeDat.add(ve);
    }

    public boolean themDSVe(List<Ve> dsVe) {
        return dsVeDat.addAll(dsVe);
    }

    public List<Ve> layDSVeDat() {
        return this.dsVeDat;
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

                    ve.setNgayDatVe(boKetQua.getTimestamp("NgayDatVe")
                            .toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime());
                    ve.setGiaVe(boKetQua.getDouble("GiaVe"));
                    //ve.setKhachHang(boKetQua.getString("MaKH"));
//                  ve.setDaiNgo(daiNgo);
                    ve.setGaKetThuc(boKetQua.getString("GaKhoiHanh"));
                    ve.setGaKhoiHanh(boKetQua.getString("GaKetThuc"));
                    //ve.setGhe(boKetQua.getString("MaGhe"));
                    ve.setLoaiVe(boKetQua.getString("LoaiVe"));
                    ve.setLoaiDoiTuong(boKetQua.getString("LoaiDoiTuong"));
                    ve.setNgayKhoiHanh((boKetQua.getTimestamp("NgayKhoiHanh")
                            .toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime()));

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

    public List<Ve> layToanBoVe() throws SQLException {
        List<Ve> danhSachVe = new ArrayList<>();
        String sql = "SELECT * FROM Ve";
        Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String maVe = resultSet.getString("MaVe");
            LocalDateTime ngayDatVe = resultSet.getTimestamp("NgayDatVe")
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime(); // Chuyển đổi thành LocalDateTime
            double giaVe = resultSet.getDouble("GiaVe");
            String maKh = resultSet.getString("MaKH");
            String gaKhoiHanh = resultSet.getString("GaKhoiHanh");
            String gaKetThuc = resultSet.getString("GaKetThuc");
            String maGhe = resultSet.getString("MaGhe");
            String loaiGhe = resultSet.getString("LoaiVe");
            String loaiDoiTuong = resultSet.getString("LoaiDoiTuong");
            LocalDateTime ngayKhoiHanh = resultSet.getTimestamp("NgayKhoiHanh")
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime(); // Chuyển đổi thành LocalDateTime

            danhSachVe.add(new Ve(maVe, loaiDoiTuong, ngayKhoiHanh, ngayDatVe, gaKhoiHanh, gaKetThuc, giaVe, maKh, maGhe, loaiGhe));
        }
        return danhSachVe;
    }

    public List<Ve> layVe_DuaVaoMaVe(String maVeRequest) throws SQLException {
        List<Ve> danhSachVe = new ArrayList<>();
        String sql = "SELECT * FROM Ve WHERE MaVe = ?";
        Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, maVeRequest); // Đặt tham số MaVe

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) { // Di chuyển con trỏ đến dòng kết quả đầu tiên
            String maVe = resultSet.getString("MaVe");
            LocalDateTime ngayDatVe = resultSet.getTimestamp("NgayDatVe")
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime(); // Chuyển đổi thành LocalDateTime
            double giaVe = resultSet.getDouble("GiaVe");
            String maKh = resultSet.getString("MaKH");
            String gaKhoiHanh = resultSet.getString("GaKhoiHanh");
            String gaKetThuc = resultSet.getString("GaKetThuc");
            String maGhe = resultSet.getString("MaGhe");
            String loaiGhe = resultSet.getString("LoaiVe");
            String loaiDoiTuong = resultSet.getString("LoaiDoiTuong");
            LocalDateTime ngayKhoiHanh = resultSet.getTimestamp("NgayKhoiHanh")
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime(); // Chuyển đổi thành LocalDateTime

            danhSachVe.add(new Ve(maVe, loaiDoiTuong, ngayKhoiHanh, ngayDatVe, gaKhoiHanh, gaKetThuc, giaVe, maKh, maGhe, loaiGhe));
        }
        return danhSachVe;
    }

    public LocalDateTime getNgayKhoiHanh_DuaVaoMaVe(String maVeRequest) throws SQLException {
        LocalDateTime ngayKhoiHanh = null;
        String sql = "SELECT * FROM Ve WHERE MaVe = ?";
        Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, maVeRequest); // Đặt tham số MaVe

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) { // Di chuyển con trỏ đến dòng kết quả đầu tiên
            String maVe = resultSet.getString("MaVe");
            ngayKhoiHanh = resultSet.getTimestamp("NgayKhoiHanh")
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime(); // Chuyển đổi thành LocalDateTime
        }
        return ngayKhoiHanh;
    }

    public void capNhatVeTau(Ve ve){
        String sql = "UPDATE Ve SET  ngayKhoiHanh = ?, NgayDatVe = ?, "
                + "GiaVe = ?, MaGhe = ? "
                + "WHERE MaVe = ?";
        logger.info("bắt đầu cập nhật vé ");
        try (
                Connection connection = KetNoiCoSoDuLieu.ketNoiDB_HinhDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            logger.info(ve.getNgayKhoiHanh().toString());
            // Định dạng thời gian cho SQL
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Thiết lập giá trị cho câu truy vấn
            preparedStatement.setString(1, ve.getNgayKhoiHanh().format(formatter));
            preparedStatement.setString(2, ve.getNgayDatVe().format(formatter));
            preparedStatement.setDouble(3, ve.getGiaVe());
            preparedStatement.setString(4, ve.getMaGhe());
            // Giả sử SoHieu là mã của đối tượng Tau
            preparedStatement.setString(5, ve.getMaVe());

            // Thực hiện câu lệnh cập nhật
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công!");
            } else {
                JOptionPane.showMessageDialog(null, "Cập Nhật Thất Bại!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Lỗi khi cập nhật vé trong cơ sở dữ liệu");
        }
    }
}
