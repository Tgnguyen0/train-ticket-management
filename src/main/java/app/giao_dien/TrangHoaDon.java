package app.giao_dien;

import app.dao.HoaDon_DAO;
import app.dao.NhanVien_DAO;
import app.dieu_khien.HanhDong_TrangHoaDon;
import app.phan_tu_tuy_chinh.CustomCellRenderer;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.HoaDon;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khanh
 */
public class TrangHoaDon extends JPanel {
    public PhongChuMoi phongTuyChinh = new PhongChuMoi();

    // Variables declaration - do not modify
    public javax.swing.JLabel LbTimKiem;
    public javax.swing.JLabel TieuDeLuuY;
    public javax.swing.JButton buttonTimKiem;
    public javax.swing.JButton buttonLamMoi;
    public javax.swing.JButton buttonChiTiet;
    public javax.swing.JButton buttonInHoaDon;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbDanhSachHoaDon;
    public javax.swing.JLabel lbThongTin;
    public javax.swing.JLabel lbMaNhanVien;
    public javax.swing.JLabel lbNhanVienPhuTrach;
    public javax.swing.JLabel lbtieuchi;
    public javax.swing.JLabel luuY1;
    public javax.swing.JLabel luuY2;
    public javax.swing.JLabel luuY3;
    public javax.swing.JLabel luuY4;
    public javax.swing.JTable tableDanhSach;
    public javax.swing.JTextField tfMaNhanVien;
    public javax.swing.JTextField tfTenNhanVien;
    public javax.swing.JTextField tfTimKiem;
    public javax.swing.JLabel thongTin1;
    public javax.swing.JLabel thongTin2;
    public javax.swing.JLabel thongTin3;
    public javax.swing.JPanel trangChua_Button;
    public javax.swing.JPanel trangChua_CacLuuY;
    public javax.swing.JPanel trangChua_DanhSachHoaDonTable;
    public javax.swing.JPanel trangChua_LbTimKiem;
    public javax.swing.JPanel trangChua_LuuY;
    public javax.swing.JPanel trangChua_TFTimKiem;
    public javax.swing.JPanel trangChua_ThongTinNhanVien;
    public javax.swing.JPanel trangChua_TieuDeHoaDon;
    public javax.swing.JPanel trangChua_chiTietThongTin;
    public javax.swing.JPanel trangChua_lbThongTin;
    public javax.swing.JPanel trangChua_timKiemHoaDon;
    private MouseListener thaoTacChuot;
    private ActionListener hanhDong;
    private ItemListener mucDaChon;
    public NhanVien_DAO nhanVien_dao;
    public HoaDon_DAO hoaDon_dao= new HoaDon_DAO();
    public DefaultTableModel model;
    public HoaDon hdTao= new HoaDon();
    //public PhongChuMoi phongChuMoi= new PhongChuMoi();

    public TrangHoaDon() {
        initComponents();
        setPreferredSize(new java.awt.Dimension(1200, 600));
        HoaDon_DAO hoaDon_dao= new HoaDon_DAO();
        hienThiDanhSachHoaDon( hoaDon_dao.chonTatCa());
    }

    public void datHoaDonDTao(HoaDon hd) {
        this.hdTao = hd;
        System.out.println(hd.getMaHoaDon());
    }

    public HoaDon layHoaDonTao() {
        return this.hdTao;
    }

    private void initComponents() {
        List<HoaDon> listHD= new ArrayList<HoaDon>();
        trangChua_TieuDeHoaDon = new javax.swing.JPanel();
        lbDanhSachHoaDon = new javax.swing.JLabel();
        trangChua_timKiemHoaDon = new javax.swing.JPanel();
        trangChua_LbTimKiem = new javax.swing.JPanel();
        LbTimKiem = new javax.swing.JLabel();
        LbTimKiem.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 18));

        lbtieuchi = new javax.swing.JLabel();

        trangChua_TFTimKiem = new javax.swing.JPanel();

        tfTimKiem = new javax.swing.JTextField();
        tfTimKiem.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        Border vienDam = BorderFactory.createLineBorder(new Color(0, 112, 255));
        tfTimKiem.setBorder(vienDam);

        trangChua_CacLuuY = new javax.swing.JPanel();
        trangChua_lbThongTin = new javax.swing.JPanel();
        lbThongTin = new javax.swing.JLabel();
        trangChua_chiTietThongTin = new javax.swing.JPanel();
        thongTin1 = new javax.swing.JLabel();
        thongTin2 = new javax.swing.JLabel();
        thongTin3 = new javax.swing.JLabel();
        trangChua_DanhSachHoaDonTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDanhSach = new javax.swing.JTable();

        tableDanhSach.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
        tableDanhSach.setBackground(new Color(255, 255, 255));
        tableDanhSach.setShowGrid(false);
        tableDanhSach.setShowHorizontalLines(false);
        tableDanhSach.setShowVerticalLines(false);
        tableDanhSach.setDefaultRenderer(Object.class, new CustomCellRenderer());
        tableDanhSach.setRowHeight(25);

        trangChua_Button = new javax.swing.JPanel();
        buttonChiTiet = new javax.swing.JButton();
        buttonInHoaDon = new javax.swing.JButton();
        buttonTimKiem = new javax.swing.JButton();
        buttonLamMoi = new javax.swing.JButton();
        trangChua_ThongTinNhanVien = new javax.swing.JPanel();
        lbNhanVienPhuTrach = new javax.swing.JLabel();
        lbNhanVienPhuTrach.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 15));

        Border gachChanDam = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0, 112, 255));
        tfTenNhanVien = new javax.swing.JTextField();
        tfTenNhanVien.setBorder(gachChanDam);
        tfTenNhanVien.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 15));

        lbMaNhanVien = new javax.swing.JLabel();
        lbMaNhanVien.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 15));

        tfMaNhanVien = new javax.swing.JTextField();
        tfMaNhanVien.setBorder(gachChanDam);
        tfMaNhanVien.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 15));

        trangChua_LuuY = new javax.swing.JPanel();
        TieuDeLuuY = new javax.swing.JLabel();
        luuY1 = new javax.swing.JLabel();
        luuY2 = new javax.swing.JLabel();
        luuY3 = new javax.swing.JLabel();
        luuY4 = new javax.swing.JLabel();

        //Set up Thao Tac cho Hoa Don
        thaoTacChuot= new HanhDong_TrangHoaDon(this);
        hanhDong= new HanhDong_TrangHoaDon(this);
        mucDaChon= new HanhDong_TrangHoaDon(this);

        // Tieu de của trang
        //lbDanhSachHoaDon.setFont(new java.awt.Font("Segoe UI", 3, 40)); // NOI18N
        lbDanhSachHoaDon.setText("    DANH SÁCH HÓA ĐƠN");
        lbDanhSachHoaDon.setFont(phongTuyChinh.layPhongRobotoMonoReg(1, 40));
        javax.swing.GroupLayout trangChua_TieuDeHoaDonLayout = new javax.swing.GroupLayout(trangChua_TieuDeHoaDon);
        trangChua_TieuDeHoaDon.setLayout(trangChua_TieuDeHoaDonLayout);
        trangChua_TieuDeHoaDonLayout.setHorizontalGroup(
                trangChua_TieuDeHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_TieuDeHoaDonLayout.createSequentialGroup()
                                .addContainerGap(137, Short.MAX_VALUE)
                                .addComponent(lbDanhSachHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
        );
        trangChua_TieuDeHoaDonLayout.setVerticalGroup(
                trangChua_TieuDeHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_TieuDeHoaDonLayout.createSequentialGroup()
                                .addContainerGap(58, Short.MAX_VALUE)
                                .addComponent(lbDanhSachHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        // Tìm kiếm hóa đơn
        //LbTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LbTimKiem.setText("Tìm kiếm hóa đơn:");
        lbtieuchi.setText("Mã hóa đơn - Số điện thoại khách hàng");
        lbtieuchi.setFont(phongTuyChinh.layPhongRobotoMonoReg(2, 10));

        javax.swing.GroupLayout trangChua_LbTimKiemLayout = new javax.swing.GroupLayout(trangChua_LbTimKiem);
        trangChua_LbTimKiem.setLayout(trangChua_LbTimKiemLayout);
        trangChua_LbTimKiemLayout.setHorizontalGroup(
                trangChua_LbTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_LbTimKiemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LbTimKiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbtieuchi, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addGap(12, 12, 12))
        );
        trangChua_LbTimKiemLayout.setVerticalGroup(
                trangChua_LbTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_LbTimKiemLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(trangChua_LbTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LbTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                        .addComponent(lbtieuchi))
                                .addGap(14, 14, 14))
        );

        //trangChua_TFTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 255)));


        javax.swing.GroupLayout trangChua_TFTimKiemLayout = new javax.swing.GroupLayout(trangChua_TFTimKiem);
        trangChua_TFTimKiem.setLayout(trangChua_TFTimKiemLayout);
        trangChua_TFTimKiemLayout.setHorizontalGroup(
                trangChua_TFTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        trangChua_TFTimKiemLayout.setVerticalGroup(
                trangChua_TFTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout trangChua_timKiemHoaDonLayout = new javax.swing.GroupLayout(trangChua_timKiemHoaDon);
        trangChua_timKiemHoaDon.setLayout(trangChua_timKiemHoaDonLayout);
        trangChua_timKiemHoaDonLayout.setHorizontalGroup(
                trangChua_timKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_timKiemHoaDonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_LbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(trangChua_timKiemHoaDonLayout.createSequentialGroup()
                                .addComponent(trangChua_TFTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        trangChua_timKiemHoaDonLayout.setVerticalGroup(
                trangChua_timKiemHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_timKiemHoaDonLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChua_LbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_TFTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
        );

        // Các lưu ý
        lbThongTin.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.ITALIC, 20)); // NOI18N
        lbThongTin.setForeground(new java.awt.Color(255, 51, 51));
        lbThongTin.setText("Thông Tin:");

        javax.swing.GroupLayout trangChua_lbLuuYLayout = new javax.swing.GroupLayout(trangChua_lbThongTin);
        trangChua_lbThongTin.setLayout(trangChua_lbLuuYLayout);
        trangChua_lbLuuYLayout.setHorizontalGroup(
                trangChua_lbLuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_lbLuuYLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbThongTin)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChua_lbLuuYLayout.setVerticalGroup(
                trangChua_lbLuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_lbLuuYLayout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addComponent(lbThongTin)
                                .addGap(15, 15, 15))
        );

        thongTin1.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.ITALIC, 12)); // NOI18N
        thongTin1.setText("+ LÀM MỚI: Hỗ trợ làm mới lại dữ liệu sau khi tìm kiếm thành công.");

        thongTin2.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.ITALIC, 12)); // NOI18N
        thongTin2.setText("+ CHI TIẾT: Hỗ trợ xem thêm các thông tin chi tiết của Hóa Đơn.");

        thongTin3.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.ITALIC, 12)); // NOI18N
        thongTin3.setText("+ IN HÓA ĐƠN: Hỗ trợ In ra hóa đơn vật lí gửi khách hàng.");

        javax.swing.GroupLayout trangChua_chiTietThongTinLayout = new javax.swing.GroupLayout(trangChua_chiTietThongTin);
        trangChua_chiTietThongTin.setLayout(trangChua_chiTietThongTinLayout);
        trangChua_chiTietThongTinLayout.setHorizontalGroup(
                trangChua_chiTietThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_chiTietThongTinLayout.createSequentialGroup()
                                .addGroup(trangChua_chiTietThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(thongTin2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(thongTin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(thongTin3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(13, Short.MAX_VALUE))
        );
        trangChua_chiTietThongTinLayout.setVerticalGroup(
                trangChua_chiTietThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_chiTietThongTinLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(thongTin2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thongTin1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thongTin3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout trangChua_CacLuuYLayout = new javax.swing.GroupLayout(trangChua_CacLuuY);
        trangChua_CacLuuY.setLayout(trangChua_CacLuuYLayout);
        trangChua_CacLuuYLayout.setHorizontalGroup(
                trangChua_CacLuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_CacLuuYLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_lbThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_chiTietThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChua_CacLuuYLayout.setVerticalGroup(
                trangChua_CacLuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_CacLuuYLayout.createSequentialGroup()
                                .addComponent(trangChua_lbThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(trangChua_CacLuuYLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChua_chiTietThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        this.model = new DefaultTableModel(new Object [][] {},
                new String [] {
                        "STT", "Mã Hóa Đơn", "Mã Khách Hàng","Thành Tiền", "Ngày Lập", "Số Lượng", "Tổng Tiền", "Trạng Thái","Mã Nhân Viên"
                })
        {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false
            };

            // Hàm không cho phép chỉnh sửa dữ liệu trên Jtable
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        tableDanhSach.setModel(model);

        // Thiết lập Màu cho JtableHeader gồm màu sắc và font chữ
        JTableHeader header = tableDanhSach.getTableHeader();
        /*header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBackground(new Color(0, 125, 255)); // Đặt màu nền mong muốn
                label.setForeground(Color.WHITE); // Đặt màu chữ
//                label.setFont(new Font("Arial", Font.BOLD, 14)); // Đặt font và kích thước chữ
                label.setFont(phongChuMoi.layPhongRobotoMonoReg(1, 12));
                label.setOpaque(true); // Đảm bảo nền được tô màu
                return label;
            }
        });*/

        DefaultTableCellRenderer vienBang = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel phanTu = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                phanTu.setForeground(new Color(0, 112, 255));
                phanTu.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));
                phanTu.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Tăng khoảng cách trên và dưới
                phanTu.setHorizontalAlignment(SwingConstants.CENTER);

                return phanTu;
            }
        };

        header.setBackground(new Color(255, 255, 255));
        header.setDefaultRenderer(vienBang);
        header.setReorderingAllowed(false);
        tableDanhSach.setDefaultRenderer(Object.class, new CustomCellRenderer());

        // Ẩn cột mã nhân viên
        tableDanhSach.getColumnModel().getColumn(8).setMinWidth(0);
        tableDanhSach.getColumnModel().getColumn(8).setMaxWidth(0);

        // Hiển thị dữ liệu
        // Set không cho thay đổi kích thước cột
        jScrollPane1.setViewportView(tableDanhSach);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        if (tableDanhSach.getColumnModel().getColumnCount() > 0) {
            tableDanhSach.getColumnModel().getColumn(0).setResizable(false);
            tableDanhSach.getColumnModel().getColumn(1).setResizable(false);
            tableDanhSach.getColumnModel().getColumn(2).setResizable(false);
            tableDanhSach.getColumnModel().getColumn(3).setResizable(false);
            tableDanhSach.getColumnModel().getColumn(4).setResizable(false);
            tableDanhSach.getColumnModel().getColumn(5).setResizable(false);
            tableDanhSach.getColumnModel().getColumn(6).setResizable(false);
            tableDanhSach.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout trangChua_DanhSachHoaDonTableLayout = new javax.swing.GroupLayout(trangChua_DanhSachHoaDonTable);
        trangChua_DanhSachHoaDonTable.setLayout(trangChua_DanhSachHoaDonTableLayout);
        trangChua_DanhSachHoaDonTableLayout.setHorizontalGroup(
                trangChua_DanhSachHoaDonTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DanhSachHoaDonTableLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        trangChua_DanhSachHoaDonTableLayout.setVerticalGroup(
                trangChua_DanhSachHoaDonTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_DanhSachHoaDonTableLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 36, Short.MAX_VALUE))
        );

        trangChua_Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 255), 1));

        // Set các thông số cho các button Chi tiết
        buttonChiTiet.setBackground(new java.awt.Color(0, 112, 255));
        buttonChiTiet.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 14)); // NOI18N
        buttonChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        buttonChiTiet.setText("Chi Tiết");

        // Set các thông số cho các button In Hóa Đơn
        buttonInHoaDon.setBackground(new java.awt.Color(0, 112, 255));
        buttonInHoaDon.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 14)); // NOI18N
        buttonInHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        buttonInHoaDon.setText("In Hóa Đơn");

        // Set các thông số cho các button Tìm Kiếm
        buttonTimKiem.setBackground(new java.awt.Color(0, 112, 255));
        buttonTimKiem.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 14)); // NOI18N
        buttonTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        buttonTimKiem.setText("Tìm Kiếm");

        // Set các thông số cho các button Làm Mới
        buttonLamMoi.setBackground(new java.awt.Color(0, 112, 255));
        buttonLamMoi.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 14)); // NOI18N
        buttonLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        buttonLamMoi.setText("Làm Mới");

        // Set các sự kiện hoạt động cho các button và Jtable
        buttonTimKiem.addActionListener(hanhDong);
        buttonChiTiet.addActionListener(hanhDong);
        buttonChiTiet.addMouseListener(thaoTacChuot);
        buttonInHoaDon.addActionListener(hanhDong);
        buttonLamMoi.addActionListener(hanhDong);
        tableDanhSach.addMouseListener(thaoTacChuot);


        javax.swing.GroupLayout trangChua_ButtonLayout = new javax.swing.GroupLayout(trangChua_Button);
        trangChua_Button.setLayout(trangChua_ButtonLayout);
        trangChua_ButtonLayout.setHorizontalGroup(
                trangChua_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING) // Đẩy sang phải
                        .addGroup(trangChua_ButtonLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Căn sát bên phải
                                .addGroup(trangChua_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(trangChua_ButtonLayout.createSequentialGroup()
                                                .addComponent(buttonChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80) // Khoảng cách giữa buttonChiTiet và buttonInHoaDon
                                                .addComponent(buttonInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(trangChua_ButtonLayout.createSequentialGroup()
                                                .addComponent(buttonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80) // Khoảng cách giữa buttonTimKiem và buttonLamMoi
                                                .addComponent(buttonLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(30, 30)) // Khoảng cách giữa cột cuối và biên phải
        );
        trangChua_ButtonLayout.setVerticalGroup(
                trangChua_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50) // Khoảng cách giữa hàng đầu và hàng thứ hai
                                .addGroup(trangChua_ButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) // Khoảng cách cuối cùng
        );


        // Thông tin nhân viên  phụ trách
        //lbMaNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbMaNhanVien.setText("Mã Nhân Viên:");

        //lbNhanVienPhuTrach.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbNhanVienPhuTrach.setText("Nhân viên phụ trách:");


        javax.swing.GroupLayout trangChua_ThongTinNhanVienLayout = new javax.swing.GroupLayout(trangChua_ThongTinNhanVien);
        trangChua_ThongTinNhanVien.setLayout(trangChua_ThongTinNhanVienLayout);
        trangChua_ThongTinNhanVienLayout.setHorizontalGroup(
                trangChua_ThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinNhanVienLayout.createSequentialGroup()
                                .addComponent(lbNhanVienPhuTrach, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        trangChua_ThongTinNhanVienLayout.setVerticalGroup(
                trangChua_ThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_ThongTinNhanVienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_ThongTinNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbNhanVienPhuTrach, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        // Phần Lưu Ý
        trangChua_LuuY.setBackground(new java.awt.Color(0, 112, 255));
        trangChua_LuuY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 255), 2));
        trangChua_LuuY.setForeground(new java.awt.Color(255, 255, 255));

        TieuDeLuuY.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 18)); // NOI18N
        TieuDeLuuY.setForeground(new java.awt.Color(255, 255, 255));
        TieuDeLuuY.setText("LƯU Ý:");

        luuY1.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.ITALIC, 10)); // NOI18N
        luuY1.setForeground(new java.awt.Color(255, 255, 255));
        luuY1.setText("1. Kiểm tra lại chi tiết hóa đơn kĩ càng trước khi in hóa đơn.");

        luuY2.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.ITALIC, 10)); // NOI18N
        luuY2.setForeground(new java.awt.Color(255, 255, 255));
        luuY2.setText("2. In hóa đơn nếu khách hàng cần.");

        luuY3.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.ITALIC, 10)); // NOI18N
        luuY3.setForeground(new java.awt.Color(255, 255, 255));
        luuY3.setText("3. Hõ trợ khách hàng in lại hóa đơn nếu lỡ mất");

        luuY4.setFont(phongTuyChinh.layPhongRobotoMonoReg(Font.ITALIC, 10)); // NOI18N
        luuY4.setForeground(new java.awt.Color(255, 255, 255));
        luuY4.setText("<html><i><b>4. Hỗ trợ tìm kiếm hóa đơn theo mã hóa đơn hoặc số điện thoại khách hàng.</b></i></html>");

        javax.swing.GroupLayout trangChua_LuuYLayout = new javax.swing.GroupLayout(trangChua_LuuY);
        trangChua_LuuY.setLayout(trangChua_LuuYLayout);
        trangChua_LuuYLayout.setHorizontalGroup(
                trangChua_LuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChua_LuuYLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TieuDeLuuY, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(128, 128, 128))
                        .addGroup(trangChua_LuuYLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(trangChua_LuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(luuY1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(luuY2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(luuY3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                        .addComponent(luuY4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChua_LuuYLayout.setVerticalGroup(
                trangChua_LuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChua_LuuYLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TieuDeLuuY)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(luuY1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(luuY2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(luuY3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(luuY4)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(trangChua_timKiemHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(trangChua_CacLuuY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(trangChua_DanhSachHoaDonTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(trangChua_ThongTinNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(trangChua_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(trangChua_LuuY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(316, 316, 316)
                                .addComponent(trangChua_TieuDeHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(trangChua_TieuDeHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_timKiemHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChua_CacLuuY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChua_DanhSachHoaDonTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(trangChua_Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(trangChua_LuuY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChua_ThongTinNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(13, Short.MAX_VALUE))
        );
    }
    // Hàm hiển thị danh sách len Jtable
    public void hienThiDanhSachHoaDon(List<HoaDon> dsHD)
    {
        DefaultTableModel model = (DefaultTableModel) tableDanhSach.getModel();
        model.setRowCount(0);
        int stt=1;
        for (HoaDon o:dsHD)
        {
            model.addRow(new Object[]{
                    stt++,
                    o.getMaHoaDon(),
                    o.getMaKhachHang(),
                    o.getThanhTien(),
                    o.getNgayLapHoaDon(),
                    o.getSoLuong(),
                    o.getTongTien(),
                    o.getTrangThai(),
                    o.getMaNhanVien()
            });
        }
    }
    // Hàm lấy mã nhân viên từ Jtable
    public void layDuLieuVaoTFNhanVien() {
        int selectedRow = tableDanhSach.getSelectedRow();

        if (selectedRow != -1) {
            // Lấy mã nhân viên từ cột tương ứng trong JTable
            String maNV = (String) tableDanhSach.getValueAt(selectedRow, 8);
            String maHD = (String) tableDanhSach.getValueAt(selectedRow, 1);
            // Đã tạo column này ở Jtable nhưng đã ẩn đi nên giờ tiện lấy

            tfMaNhanVien.setText(maNV);
            tfTimKiem.setText(maHD);

            NhanVien_DAO nhanVienDao = new NhanVien_DAO();
            String tenNV = nhanVienDao.ChonTheoMa(maNV).getTenNV();
            tfTenNhanVien.setText(tenNV);

            // Không cho chỉnh sửa thông tin nhân viên
            tfMaNhanVien.setEditable(false);
            tfTenNhanVien.setEditable(false);
            tfTimKiem.setEditable(true);
        } else {
            System.out.println("Không có hàng nào được chọn.");
        }
    }
    public void lamMoiDuLieu()
    {
        tfTimKiem.setText("");
        tfMaNhanVien.setText("");
        tfTenNhanVien.setText("");
        tfMaNhanVien.setEditable(false);
        tfTenNhanVien.setEditable(false);
        hienThiDanhSachHoaDon(hoaDon_dao.chonTatCa());
    }
}