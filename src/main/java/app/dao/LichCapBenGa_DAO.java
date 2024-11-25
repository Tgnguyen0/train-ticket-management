package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.LichCapBenGa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class LichCapBenGa_DAO {
    String CHON_THEO_NGAY_VA_GA = "SELECT * FROM LichCapBenGa WHERE CAST(GioCapBen AS DATE) = ? AND MaGa = ?";
    String CHON_THEO_SO_HIEU_NGAY_VA_GA = "SELECT * FROM LichCapBenGa WHERE SoHieu = ? AND CAST(GioCapBen AS DATE) = ? AND MaGa = ?";

    public List<LichCapBenGa> ChonTheoNgayKHVaGa(LocalDateTime ngayKH, String maGa) {
        return this.ChonSQL(CHON_THEO_NGAY_VA_GA, ngayKH.toLocalDate(), maGa);
    }

    public LichCapBenGa ChonTheoSoHieuNgayKHVaGa(String soHieu, LocalDateTime ngayKH, String maGa) {
        List<LichCapBenGa> list = this.ChonSQL(CHON_THEO_SO_HIEU_NGAY_VA_GA, soHieu, ngayKH.toLocalDate(), maGa);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<LichCapBenGa> ChonSQL(String lenhSQL, Object... thamSo) {
        List<LichCapBenGa> list = new ArrayList<>();
        try (ResultSet boKetQua = KetNoiCoSoDuLieu.truyVan(lenhSQL, thamSo)) {
            while (boKetQua.next()) {
                LichCapBenGa lich = new LichCapBenGa();
                lich.setMaLich(boKetQua.getString("MaLich"));
                lich.setGioCapBen(boKetQua.getTimestamp("GioCapBen")
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime());
                lich.setGioKhoiHanh(boKetQua.getTimestamp("GioKhoiHanh")
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime());
                lich.setMoTa(boKetQua.getString("MoTa"));
                lich.setMaGa(boKetQua.getString("MaGa"));
                lich.setMaTau(boKetQua.getString("SoHieu"));

                list.add(lich);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }
}
