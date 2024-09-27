package app.giao_dien;

import app.phan_tu_tuy_chinh.CustomCellRenderer;
import app.phan_tu_tuy_chinh.CustomHeaderRenderer;
import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;

public class TrangDanhSachVeTau extends JPanel {

    private PhongChuMoi phongChuChinh = new PhongChuMoi();
    private JPanel trangChua ;
    public Color trang = new Color(255, 255, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);

    // chứa tiêu đề và thanh tìm kiếm
    private JPanel trangChua_PhanDau;
    private JPanel trangChua_TieuDe;
    private JPanel trangChua_ThanhTimKiem;
    private JPanel trangChua_BangDanhSach;
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);

    public TrangDanhSachVeTau() {
//        setPreferredSize(new Dimension(1200, 700));
        setSize(new Dimension(1200, 800));
        setLayout(new BorderLayout());
        setFont(this.phongChuChinh.layPhongRobotoMonoReg(Font.PLAIN, 13));
        setBackground(trang);

        this.trangChua = new JPanel();
        this.trangChua.setPreferredSize(new Dimension(1100, 700));
        this.trangChua.setBackground(trang);
        this.trangChua.setLayout(new BorderLayout());
        this.trangChua.setBackground(this.trang);

        this.trangChua_PhanDau = new JPanel();
        this.trangChua_PhanDau.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.trangChua_PhanDau.setBackground(trang);
        this.trangChua_PhanDau.setPreferredSize(new Dimension(1100, 75));

        this.trangChua_BangDanhSach  = new JPanel();
        this.trangChua_BangDanhSach.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.trangChua_BangDanhSach.setBackground(trang);
        this.trangChua_BangDanhSach.setPreferredSize(new Dimension(1100, 500));


        taoTieuDe();
        taoThanhTimKiem();
        tapBangDanhSach();
        this.trangChua.add(this.trangChua_PhanDau, BorderLayout.NORTH);
        this.trangChua.add(trangChua_BangDanhSach, BorderLayout.CENTER);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setLocationRelativeTo(null);
        this.add(this.trangChua);
        this.setVisible(true);
    }

    private void taoTieuDe(){
        this.trangChua_TieuDe = new JPanel();
        this.trangChua_TieuDe.setBackground(trang);
        this.trangChua_TieuDe.setPreferredSize(new Dimension(1100, 30));
        JLabel tieuDe = new JLabel("<html><u>Danh Sách Vé Tàu</u></html>", JLabel.CENTER);
        tieuDe.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 20));
        tieuDe.setForeground(xanhBrandeis);
        this.trangChua_TieuDe.add(tieuDe);
        this.trangChua_PhanDau.add(trangChua_TieuDe, BorderLayout.CENTER);
    }

    private void taoThanhTimKiem(){
        this.trangChua_ThanhTimKiem = new JPanel();
        this.trangChua_ThanhTimKiem.setLayout(new FlowLayout(FlowLayout.RIGHT,5,5 ));
        this.trangChua_ThanhTimKiem.setPreferredSize(new Dimension(1100, 35));
        this.trangChua_ThanhTimKiem.setBackground(trang);
        JLabel timKiem_TieuDe = new JLabel("Tìm Kiếm Vé: ", JLabel.RIGHT);
        timKiem_TieuDe.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 12));
        timKiem_TieuDe.setForeground(xanhBrandeis);
        JTextField timKiem_Thanh = new JTextField(25);
        timKiem_Thanh.setPreferredSize(new Dimension(120, 25));
        timKiem_Thanh.setFont((new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 12)));
        timKiem_Thanh.setBorder(vienDam);
        timKiem_Thanh.replaceSelection("Tìm kiếm");
        this.trangChua_ThanhTimKiem.add(timKiem_TieuDe);
        this.trangChua_ThanhTimKiem.add(timKiem_Thanh);
        this.trangChua_PhanDau.add(trangChua_ThanhTimKiem, BorderLayout.SOUTH);
    }

    private void tapBangDanhSach(){
        String [] columnName = {"STT", "Mã Vé", "<html>Khách<br>Hàng</html>", "<html>Điện<br>Thoại</html>",
                                "Email", "<html>Điểm Đến<div style='text-align: center;'>-</div>Điểm Đi</html>", "<html>Giờ<br>Đi</html>", "<html>Ngày<br>Đi</html>",
                                "<html>Ngày<br>Về</html>", "<html>Loại<br>Ghế</html>", "<html>Số<br>Lượng</html>", "<html>Ví<br>trí</html>", "<html>Tổng<br>Tiền</html>", "Tools"
        };

        String [][] data = {
                {"1", "MD12", "Phạm Văn Hinh", "0969880914", "20102004hinh@gmail.com", "<html>Hải Phòng<div style='text-align: center;'>-</div>Hà Nội</html>", "2 am", "20/10/2004", "21/10/2004", "Thường", "4", "B23", "12 000 000 VNĐ", "Thêm"},
                {"1", "MD15", "<html>Lê Dương<br>Bảo Lâm<!html>", "0768558858", "nguyennhattan223344@gmail.com"},
                {"1"},
                {"1"},
                {"1"},
                {"1"},
                {"1"},
                {"1"},
                {"1"},
                {"1"},
                {"1"}, {"1"},
                {"1"},
                {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"}, {"1"},

        };

        DefaultTableModel model = new DefaultTableModel(data, columnName){
            @Override
            public boolean isCellEditable(int data, int columnName) {
                return false;
            }

        };
        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setRowHeight(80);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setGridColor(Color.BLUE);
        table.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 12));
        // Thiết lập border cho JTable
//        table.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1)); // Khung bảng màu đen
        table.setShowGrid(false);
        table.setShowHorizontalLines(true); // Hiện thanh ngang
//        table.setGridColor(Color.WHITE); // Màu lưới
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setMinWidth(2);
        columnModel.getColumn(0).setPreferredWidth(3);
        columnModel.getColumn(1).setPreferredWidth(15);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(40);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(60);
        columnModel.getColumn(6).setPreferredWidth(10);
        columnModel.getColumn(7).setPreferredWidth(20);
        columnModel.getColumn(8).setPreferredWidth(20);
        columnModel.getColumn(9).setPreferredWidth(10);
        columnModel.getColumn(10).setPreferredWidth(5);
        columnModel.getColumn(11).setPreferredWidth(10);
        columnModel.getColumn(12).setPreferredWidth(40);
        columnModel.getColumn(13).setPreferredWidth(20);

        JTableHeader header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 60));
        header.setDefaultRenderer(new CustomHeaderRenderer());
        // Sử dụng renderer tùy chỉnh cho các ô trong bảng
        table.setDefaultRenderer(Object.class, new CustomCellRenderer());

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setPreferredSize(new Dimension(1100, 610));
        trangChua_BangDanhSach.add(jScrollPane);
    }


    /*public static void main(String[] args) {
        new TrangDanhSachVeTau();
    }*/
}