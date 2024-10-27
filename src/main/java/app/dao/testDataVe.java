package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.Ve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class testDataVe {
    public static void main(String[] args) throws SQLException {
        Logger logger = LoggerFactory.getLogger(testDataVe.class);
        List<Ve> danhSachVe = new ArrayList<>();
        String sql = "SELECT * FROM Ve";
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
            danhSachVe.add(new Ve( maVe,  loaiDoiTuong,  ngayKhoiHanh,  ngayDatVe,  gaKhoiHanh,  gaKetThuc,  giaVe,  maKh, maGhe,  loaiGhe));
        }

        for (Ve ve: danhSachVe) {
            logger.info(ve.toString());
        }
    }
}
