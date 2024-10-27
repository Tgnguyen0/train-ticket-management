package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.GIOI_TINH;
import app.thuc_the.NhanVien;

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
                boKetQua = KetNoiCoSoDuLieu.TruyVan(sql, args);
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
}
