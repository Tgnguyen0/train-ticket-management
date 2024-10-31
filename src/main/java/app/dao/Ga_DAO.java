package app.dao;

import app.ket_noi_co_so_du_lieu.KetNoiCoSoDuLieu;
import app.thuc_the.NhaGa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ga_DAO {
    String CHON_TAT_SQL = "SELECT * FROM NhaGa";
    String CHON_THEO_MA_SQL = "select * from NhaGa where MaGa =?";
    String CHON_THEO_TEN_SQL = "SELECT * FROM NhaGa WHERE TenGa =?";

    public Map<String, Integer> luocDoKhoangCach = Map.ofEntries(
            Map.entry("Sài Gòn", 0),
            Map.entry("Biên Hòa", 50),
            Map.entry("Nha Trang", 460),
            Map.entry("Vinh", 960),
            Map.entry("Hải Vân Bắc", 1060),
            Map.entry("Đà Nẵng", 1100),
            Map.entry("Huế", 1210),
            Map.entry("Hương Thủy", 1225),
            Map.entry("Truồi", 1243),
            Map.entry("Cầu Hai", 1253),
            Map.entry("Yên Thái", 1303),
            Map.entry("Nghĩa Trang", 1315),
            Map.entry("Đò Lèn", 1335),
            Map.entry("Bỉm Sơn", 1353),
            Map.entry("Đồng Giao", 1378),
            Map.entry("Ghềnh", 1400),
            Map.entry("Cầu Yên", 1412),
            Map.entry("Ninh Bình", 1422),
            Map.entry("Núi Gôi", 1430),
            Map.entry("Trình Xuyên", 1445),
            Map.entry("Nam Định", 1465),
            Map.entry("Đặng Xá", 1487),
            Map.entry("Cầu Họ", 1505),
            Map.entry("Bình Lục", 1517),
            Map.entry("Phủ Lý", 1532),
            Map.entry("Đồng Văn", 1542),
            Map.entry("Phú Xuyên", 1567),
            Map.entry("Chợ Tía", 1579),
            Map.entry("Thường Tín", 1587),
            Map.entry("Văn Điển", 1597),
            Map.entry("Giáp Bát", 1602),
            Map.entry("Hà Nội", 1610),
            Map.entry("Hải Phòng", 1710)
    );

    public List<NhaGa> dsNhaGa;

    public void Ga_DAO() {
        dsNhaGa = new ArrayList<NhaGa>();
    }

    public NhaGa ChonTheoTen(String tenGa) {
        List<NhaGa> list = this.ChonSql(CHON_THEO_TEN_SQL, tenGa);
        return list.size() > 0 ? list.get(0) : null;
    }

    public NhaGa ChonTheoMa(String maGa) {
        List<NhaGa> list = this.ChonSql(CHON_THEO_MA_SQL, maGa);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NhaGa> ChonTatCa() {
        return this.ChonSql(CHON_TAT_SQL);
    }

    protected List<NhaGa> ChonSql(String sql, Object... args) {
        List<NhaGa> list = new ArrayList<>();
        try {
            ResultSet boKetQua = null;
            try {
                boKetQua = KetNoiCoSoDuLieu.truyVan(sql, args);
                while (boKetQua.next()) {
                    NhaGa nhaGa = new NhaGa();
                    nhaGa.setMaGa(boKetQua.getString("MaGa"));
                    nhaGa.setTenGa(boKetQua.getString("TenGa"));
                    nhaGa.setSoDienThoaiLienHe(boKetQua.getString("SoDTLH"));
                    nhaGa.setThanhPho(boKetQua.getString("ThanhPho"));
                    list.add(nhaGa);
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

    public List<NhaGa> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhaGa WHERE HoTen LIKE ?";
        return this.ChonSql(sql, "%" + keyword + "%");
    }

    public void testLogin(String username, String password){

        if(username.equals("Duy") && password.equals("anhduy2002")){

        }else{

        }
    }
}
