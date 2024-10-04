package app.giao_dien;

import app.phan_tu_tuy_chinh.CustomCellRenderer;
import app.phan_tu_tuy_chinh.CustomHeaderRenderer;
import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TrangHoaDon extends JPanel {
    public JPanel trangChua;
    public DefaultTableModel moHinhBang;

    /* Khoi Tao Phong Chu Mau Sac */
    public int kichThuocChu = 12;
    public int chieuDaiNut = 210;
    public int chieuRongNut = 30;
    private PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color trang = new Color(255, 255, 255);
    public Color xanhNhat = new Color(66, 186, 255);
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Border vienNhat = BorderFactory.createLineBorder(xanhNhat);
    public Border vienDam = BorderFactory.createLineBorder(xanhBrandeis);
    public Border gachChanNhat = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhNhat);
    public Border gachChanDam = BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis);

    private ActionListener hanhDong;
    private MouseListener thaoTacChuot;

    public TrangHoaDon() {
        setSize(1200, 600);
        setLayout(new BorderLayout());
        setBackground(trang);

        this.trangChua = new JPanel();
        trangChua.setPreferredSize(new Dimension(1200, 700));
        trangChua.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        trangChua.setBackground(trang);

        taoTrangChuaDSHD();
        taoTrangChuaChucNang();

        add(trangChua, BorderLayout.CENTER);
    }

    public void taoTrangChuaDSHD() {
        JPanel trangChuaDSHD = new JPanel();
        trangChuaDSHD.setBackground(trang);
        trangChuaDSHD.setLayout(new BorderLayout());
        trangChuaDSHD.setPreferredSize(new Dimension(700, 600));

        JLabel tieuDeDS = new JLabel("Danh Sách Hóa Đơn", SwingConstants.LEFT);
        tieuDeDS.setPreferredSize(new Dimension(600, 25));
        tieuDeDS.setBackground(trang);
        tieuDeDS.setForeground(xanhBrandeis);
        tieuDeDS.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 15));
        trangChuaDSHD.add(tieuDeDS, BorderLayout.NORTH);

        Object[] tieuDeCot = {"STT", "Mã hóa đơn", "Tên khách hàng", "Số điện thoại", "Ngày mua", "Số lượng"};

        Object[][] duLieu = {
                {"1", "HD001", "Nguyễn Văn A", "0987654321", "01-10-2024", "3"},
                {"2", "HD002", "Trần Thị B", "0912345678", "02-10-2024", "5"},
                {"1", "HD001", "Nguyễn Văn A", "0987654321", "01-10-2024", "3"},
                {"2", "HD002", "Trần Thị B", "0912345678", "02-10-2024", "5"}
        };

        this.moHinhBang = new DefaultTableModel(duLieu, tieuDeCot);

        JTable bangHoaDon = new JTable(moHinhBang);
        bangHoaDon.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        bangHoaDon.setBackground(trang);
        bangHoaDon.setForeground(xanhBrandeis);
        bangHoaDon.setShowGrid(false);
        bangHoaDon.setShowHorizontalLines(true);
        bangHoaDon.setShowVerticalLines(false);
        bangHoaDon.setGridColor(xanhBrandeis);
        bangHoaDon.setDefaultRenderer(Object.class, new CustomCellRenderer());
        //bangHoaDon.setBorder(gachChanDam);
        bangHoaDon.setBackground(trang);

        JTableHeader tieuDeBang = bangHoaDon.getTableHeader();
        tieuDeBang.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));
        tieuDeBang.setBackground(trang);
        tieuDeBang.setBorder(vienDam);
        tieuDeBang.setForeground(xanhBrandeis);
        tieuDeBang.setDefaultRenderer(new CustomHeaderRenderer());

        /*DefaultTableCellRenderer vienBang = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                // Call the superclass method to get the default renderer
                JLabel phanTu = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Customize the cell's appearance based on your requirements
                phanTu.setForeground(xanhBrandeis); // Set text color
                phanTu.setBackground(trang); // Set background color
                phanTu.setBorder(vienDam);
                phanTu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, kichThuocChu));

                return phanTu;
            }
        };

        for (int i = 0; i < bangHoaDon.getColumnCount(); i++) {
            bangHoaDon.getColumnModel().getColumn(i).setCellRenderer(vienBang);
        }*/

        JScrollPane trangChuaBang = new JScrollPane(bangHoaDon);
        trangChuaBang.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        trangChuaBang.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        trangChuaBang.setPreferredSize(new Dimension(600, 500));
        trangChuaBang.setForeground(xanhBrandeis);
        trangChuaBang.getViewport().setBackground(trang);
        trangChuaBang.setBorder(null);
        trangChuaBang.getViewport().setBorder(null);
        trangChuaBang.setBorder(null);
        trangChuaBang.getViewport().setBorder(null);
        trangChuaBang.getVerticalScrollBar().setBorder(null);
        trangChuaBang.getHorizontalScrollBar().setBorder(null);

        trangChuaBang.getViewport().setBackground(trang);
        trangChuaDSHD.add(trangChuaBang, BorderLayout.CENTER);

        trangChua.add(trangChuaDSHD);
    }

    public void taoTrangChuaChucNang() {
        JPanel trangChuaChucNang = new JPanel();
        trangChuaChucNang.setBackground(trang);
        trangChuaChucNang.setPreferredSize(new Dimension(500, 600));

        trangChua.add(trangChuaChucNang);
    }
}
