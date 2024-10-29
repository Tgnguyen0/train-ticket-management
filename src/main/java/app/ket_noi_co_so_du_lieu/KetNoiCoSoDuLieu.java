package app.ket_noi_co_so_du_lieu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class KetNoiCoSoDuLieu {
    // Cac thuoc tinh ket noi
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  // Driver de ket noi voi SQL Server

    //DOI MAY TINH NHO XEM LAI DUONG DAN CUA MAY MINH!!!!!!
    private static String duongDan = "jdbc:sqlserver://localhost:1433;databaseName=TrainStationDatabase;user=sa;password=123;trustServerCertificate=true;"; // URL ket noi voi co so du lieu cua KHANG

    private static String duongDan_Hinh = "jdbc:sqlserver://localhost:1433;databaseName=TrainStationDatabase;user=sa;password=123;trustServerCertificate=true;"; // URL ket noi voi co so du lieu cua Hinh
    private static String nguoiDung = "sa";  // Ten dang nhap vao SQL Server
    private static String matKhau = "123";   // Mat khau dang nhap

    // Khoi static duoc thuc thi khi lop duoc tai de dang ky driver SQL
    static {
        // Thu ket noi voi co so du lieu bang cach tai driver
        try {
            Class.forName(driver);  // Nap driver cho ket noi SQL Server
        }
        catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);  // Neu khong tim thay driver thi nem ra ngoai le
        }
    }

    /**
     * Phuong thuc lay cau lenh SQL voi cac tham so
     * @param cauLenhSQL: Chuoi cau lenh SQL hoac stored procedure
     * @param thamSo: Cac tham so se duoc gan vao cau lenh SQL
     * @return PreparedStatement: Cau lenh SQL da chuan bi
     * @throws SQLException
     */
    public static PreparedStatement layCauLenh(String cauLenhSQL, Object...thamSo) throws SQLException {
        Connection lienKet = DriverManager.getConnection(duongDan, nguoiDung, matKhau);  // Tao ket noi voi CSDL

        if(lienKet == null) {
            System.out.println("Ket noi that bai");
            return null;
        }

        PreparedStatement cauLenhChuanBi = null;

        // Kiem tra xem cau lenh co phai la mot stored procedure
        if (cauLenhSQL.trim().startsWith("{")) {
            cauLenhChuanBi = lienKet.prepareCall(cauLenhSQL);  // Chuan bi stored procedure
        } else {
            cauLenhChuanBi = lienKet.prepareStatement(cauLenhSQL);  // Chuan bi cau lenh SQL thong thuong
        }

        // Gan cac tham so cho cau lenh SQL
        for (int i = 0; i < thamSo.length; i++) {
            cauLenhChuanBi.setObject(i + 1, thamSo[i]);  // Gan tung tham so vao cau lenh
        }

        return cauLenhChuanBi;  // Tra ve cau lenh da chuan bi
    }

    /**
     * Phuong thuc thuc thi cau lenh cap nhat (INSERT, UPDATE, DELETE)
     * @param cauLenhSQL: Cau lenh SQL
     * @param thamSo: Cac tham so cho cau lenh SQL
     */
    public static void capNhat(String cauLenhSQL, Object...thamSo) {
        try {
            PreparedStatement cauLenhChuanBi = KetNoiCoSoDuLieu.layCauLenh(cauLenhSQL, thamSo);  // Chuan bi cau lenh

            try {
                cauLenhChuanBi.executeUpdate();  // Thuc thi cau lenh SQL cap nhat du lieu
            } finally {
                cauLenhChuanBi.getConnection().close();  // Dam bao dong ket noi sau khi su dung
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);  // Nem ra ngoai le neu co loi SQL
        }
    }

    /**
     * Phuong thuc thuc hien truy van du lieu (SELECT)
     * @param cauLenhSQL: Cau lenh SQL
     * @param thamSo: Cac tham so cho cau lenh SQL
     * @return ResultSet: Ket qua cua truy van
     */
    public static ResultSet truyVan(String cauLenhSQL, Object...thamSo) {
        try {
            PreparedStatement cauLenhChuanBi = KetNoiCoSoDuLieu.layCauLenh(cauLenhSQL, thamSo);  // Chuan bi cau lenh

            return cauLenhChuanBi.executeQuery();  // Thuc thi truy van va tra ve ket qua ResultSet
        } catch (SQLException e) {
            e.printStackTrace();  // In loi ra console neu xay ra
            throw new RuntimeException(e);  // Nem ra ngoai le neu co loi SQL
        }
    }

    /**
     * Phuong thuc lay gia tri don le tu truy van
     * @param cauLenhSQL: Cau lenh SQL
     * @param thamSo: Cac tham so cho cau lenh SQL
     * @return Object: Gia tri don le tu ket qua truy van
     */
    public static Object giaTri(String cauLenhSQL, Object...thamSo) {
        try {
            ResultSet boKetQua = KetNoiCoSoDuLieu.truyVan(cauLenhSQL, thamSo);  // Thuc hien truy van

            if (boKetQua.next()) {
                return boKetQua.getObject(0);  // Tra ve gia tri o cot dau tien
            }

            boKetQua.getStatement().getConnection().close();  // Dam bao dong ket noi sau khi truy van xong
            return null;  // Tra ve null neu khong co ket qua
        } catch (Exception e) {
            throw new RuntimeException(e);  // Nem ra ngoai le neu co loi
        }
    }

    public static Connection ketNoiDB_KhangVersion() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(duongDan, nguoiDung, matKhau);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Connection ketNoiDB_HinhDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(duongDan_Hinh, nguoiDung, matKhau);
        } catch (SQLException e) {
            //log.error("connect database unfinished!!!");
            e.printStackTrace();
        }

        return  connection ;
    }
}
