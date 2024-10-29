package app.ket_noi_co_so_du_lieu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection() {
        Connection c = null;

        try {
            // Đăng ký MySQL Driver với DriverManager
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Các thông số
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TrainStationDatabase;user=sa;password=123;trustServerCertificate=true;";

            String username = "sa";
            String password = "123";

            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);

        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
