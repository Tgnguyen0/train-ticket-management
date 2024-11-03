package app.giao_dien;
import app.thuc_the.Ve;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class TrangThanhToan extends JDialog {

    // Khai Báo Các Biến
    public JButton ButtonThanhToan;
    public JLabel LuuY1;
    public JLabel LuuY2;
    public JLabel LuuY3;
    public JPanel PanelDanhSach;
    public JPanel PanelLuuY;
    public JPanel PanelPhuongThucThanhToan;
    public JPanel PanelThanhToan1;
    public JPanel PanelTitle;
    public JPanel PanelTongTien;
    public JLabel TitleLuuY;
    public JLabel TitleThanhToan;
    public JButton jButton1;
    public JButton jButton2;
    public JButton jButton3;
    public JButton jButton4;
    public JButton jButton5;
    public JButton jButton6;
    public JRadioButton jRadioButton2;
    public JScrollPane jScrollPane1;
    public DefaultTableModel model;
    public JTable danhSachVeThanhToan;
    public JLabel lbDanhSachVe;
    public JLabel lbKhuyenMai;
    public JLabel lbPhuongThucThanhToan;
    public JLabel lbThanhTien;
    public JLabel lbThanhToanTienMat;
    public JLabel lbTienNhan;
    public JLabel lbTongTien;
    public JLabel lbVAT;
    public JLabel lnTraLai;
    public JRadioButton radioTienMat;
    public JTextField tfKhuyenMai;
    public JTextField tfThanhTien;
    public JTextField tfTongTien;
    public JTextField tfTraLai;
    public JTextField tfVAT;
    public java.util.List<Ve> danhSachVe;

    public TrangThanhToan(List<Ve> ve) {
        super();
        hienThi();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void hienThi() {
        danhSachVe = new ArrayList<>();
        PanelLuuY = new JPanel();
        TitleLuuY = new JLabel();
        LuuY1 = new JLabel();
        LuuY2 = new JLabel();
        LuuY3 = new JLabel();
        PanelTitle = new JPanel();
        TitleThanhToan = new JLabel();
        PanelDanhSach = new JPanel();
        jScrollPane1 = new JScrollPane();
        danhSachVeThanhToan = new JTable();
        lbDanhSachVe = new JLabel();
        lbThanhToanTienMat = new JLabel();
        PanelThanhToan1 = new JPanel();
        lbThanhTien = new JLabel();
        lbKhuyenMai = new JLabel();
        lbVAT = new JLabel();
        tfThanhTien = new JTextField();
        tfKhuyenMai = new JTextField();
        tfVAT = new JTextField();
        PanelTongTien = new JPanel();
        lbTongTien = new JLabel();
        lbTienNhan = new JLabel();
        lnTraLai = new JLabel();
        tfTongTien = new JTextField();
        tfTraLai = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        PanelPhuongThucThanhToan = new JPanel();
        lbPhuongThucThanhToan = new JLabel();
        radioTienMat = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        ButtonThanhToan = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));

        PanelLuuY.setForeground(new java.awt.Color(0, 112, 255));

        TitleLuuY.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        TitleLuuY.setForeground(new java.awt.Color(255, 51, 51));
        TitleLuuY.setText("LƯU Ý:");

        LuuY1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        LuuY1.setForeground(new java.awt.Color(0, 112, 255));
        LuuY1.setText("+ Trẻ em dưới 6 tuổi sẽ không tính thuế");

        LuuY2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        LuuY2.setForeground(new java.awt.Color(0, 112, 255));
        LuuY2.setText("+ Trẻ Em từ 6 -12 tuổi, tiền thuế là 2%");

        LuuY3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        LuuY3.setForeground(new java.awt.Color(0, 112, 255));
        LuuY3.setText("+ Người Lớn, tiền thuế là 2,5%");

        javax.swing.GroupLayout PanelLuuYLayout = new javax.swing.GroupLayout(PanelLuuY);
        PanelLuuY.setLayout(PanelLuuYLayout);
        PanelLuuYLayout.setHorizontalGroup(
                PanelLuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLuuYLayout.createSequentialGroup()
                                .addGroup(PanelLuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelLuuYLayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(TitleLuuY, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(LuuY1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelLuuYLayout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(LuuY3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelLuuYLayout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(LuuY2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(66, Short.MAX_VALUE))
        );
        PanelLuuYLayout.setVerticalGroup(
                PanelLuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLuuYLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelLuuYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TitleLuuY)
                                        .addComponent(LuuY1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LuuY2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LuuY3)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        TitleThanhToan.setFont(new java.awt.Font("Segoe UI", 3, 25)); // NOI18N
        TitleThanhToan.setForeground(new java.awt.Color(0, 112, 255));
        TitleThanhToan.setText("TRANG THANH TOÁN");

        javax.swing.GroupLayout PanelTitleLayout = new javax.swing.GroupLayout(PanelTitle);
        PanelTitle.setLayout(PanelTitleLayout);
        PanelTitleLayout.setHorizontalGroup(
                PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTitleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TitleThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(22, Short.MAX_VALUE))
        );
        PanelTitleLayout.setVerticalGroup(
                PanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTitleLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TitleThanhToan)
                                .addContainerGap(20, Short.MAX_VALUE))
        );
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "STT", "Tên Khách Hàng", "Loại Vé", "Loại Ghế", "Vị Trí", "Giá Vé"
                }
        ) {
            Class[] types = new Class[]{
                    Integer.class, String.class, String.class, String.class, String.class, Float.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        danhSachVeThanhToan = new JTable(model);
        JScrollPane jScrollPane1 = new JScrollPane(danhSachVeThanhToan);
        this.add(jScrollPane1);

        // Cấu hình JTable
        for (int i = 0; i < model.getColumnCount(); i++) {
            danhSachVeThanhToan.getColumnModel().getColumn(i).setResizable(false);
        }

        javax.swing.GroupLayout PanelDanhSachLayout = new javax.swing.GroupLayout(PanelDanhSach);
        PanelDanhSach.setLayout(PanelDanhSachLayout);
        PanelDanhSachLayout.setHorizontalGroup(
                PanelDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        PanelDanhSachLayout.setVerticalGroup(
                PanelDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
        );

        lbDanhSachVe.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbDanhSachVe.setForeground(new java.awt.Color(0, 112, 255));
        lbDanhSachVe.setText("Danh Sách Vé");

        lbThanhToanTienMat.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbThanhToanTienMat.setForeground(new java.awt.Color(0, 112, 255));
        lbThanhToanTienMat.setText("Thanh Toán Tiền Mặt:");

        PanelThanhToan1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 255), 3));

        lbThanhTien.setForeground(new java.awt.Color(0, 112, 255));
        lbThanhTien.setText("Thành Tiền:");

        lbKhuyenMai.setForeground(new java.awt.Color(0, 112, 255));
        lbKhuyenMai.setText("Khuyến Mãi:");

        lbVAT.setForeground(new java.awt.Color(0, 112, 255));
        lbVAT.setText("Thuế VAT:");

        tfThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfThanhTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelThanhToan1Layout = new javax.swing.GroupLayout(PanelThanhToan1);
        PanelThanhToan1.setLayout(PanelThanhToan1Layout);
        PanelThanhToan1Layout.setHorizontalGroup(
                PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelThanhToan1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                        .addComponent(lbVAT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(tfKhuyenMai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfVAT))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelThanhToan1Layout.setVerticalGroup(
                PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelThanhToan1Layout.createSequentialGroup()
                                .addContainerGap(8, Short.MAX_VALUE)
                                .addGroup(PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbThanhTien)
                                        .addComponent(tfThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbVAT)
                                        .addComponent(tfVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12))
        );

        PanelTongTien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 112, 255), 3));

        lbTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTongTien.setForeground(new java.awt.Color(0, 112, 255));
        lbTongTien.setText("TỔNG TIỀN:");

        lbTienNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTienNhan.setForeground(new java.awt.Color(0, 112, 255));
        lbTienNhan.setText("TIỀN NHẬN:");

        lnTraLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lnTraLai.setForeground(new java.awt.Color(0, 112, 255));
        lnTraLai.setText("TRẢ LẠI:");

        tfTraLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTraLaiActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jButton5.setText("jButton5");

        jButton6.setText("jButton6");

        javax.swing.GroupLayout PanelTongTienLayout = new javax.swing.GroupLayout(PanelTongTien);
        PanelTongTien.setLayout(PanelTongTienLayout);
        PanelTongTienLayout.setHorizontalGroup(
                PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTongTienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbTienNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lnTraLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(PanelTongTienLayout.createSequentialGroup()
                                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                        .addComponent(tfTongTien)
                                        .addComponent(tfTraLai))
                                .addContainerGap(51, Short.MAX_VALUE))
        );
        PanelTongTienLayout.setVerticalGroup(
                PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTongTienLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbTongTien)
                                        .addComponent(tfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelTongTienLayout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(lbTienNhan))
                                        .addGroup(PanelTongTienLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton2)
                                                        .addComponent(jButton5))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4)
                                        .addComponent(jButton6))
                                .addGap(18, 18, 18)
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lnTraLai)
                                        .addComponent(tfTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
        );

        lbPhuongThucThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPhuongThucThanhToan.setForeground(new java.awt.Color(0, 112, 255));
        lbPhuongThucThanhToan.setText("Chọn Phương Thức Thanh Toán:");

        radioTienMat.setForeground(new java.awt.Color(0, 112, 255));
        radioTienMat.setText("Tiền Mặt (Cash)");
        radioTienMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTienMatActionPerformed(evt);
            }
        });

        jRadioButton2.setForeground(new java.awt.Color(0, 112, 255));
        jRadioButton2.setText("Chuyển Khoản (Banking)");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPhuongThucThanhToanLayout = new javax.swing.GroupLayout(PanelPhuongThucThanhToan);
        PanelPhuongThucThanhToan.setLayout(PanelPhuongThucThanhToanLayout);
        PanelPhuongThucThanhToanLayout.setHorizontalGroup(
                PanelPhuongThucThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPhuongThucThanhToanLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelPhuongThucThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbPhuongThucThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                        .addComponent(radioTienMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(288, Short.MAX_VALUE))
        );
        PanelPhuongThucThanhToanLayout.setVerticalGroup(
                PanelPhuongThucThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPhuongThucThanhToanLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbPhuongThucThanhToan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioTienMat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        ButtonThanhToan.setBackground(new java.awt.Color(0, 112, 255));
        ButtonThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        ButtonThanhToan.setText("Thanh Toán");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PanelPhuongThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PanelDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbDanhSachVe, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PanelLuuY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbThanhToanTienMat, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(ButtonThanhToan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(PanelTongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(PanelThanhToan1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PanelLuuY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbDanhSachVe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbThanhToanTienMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(PanelThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PanelTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(PanelDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ButtonThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PanelPhuongThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void tfThanhTienActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tfTraLaiActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void radioTienMatActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

//    private void hienThiDanhSachVe(List<Ve>danhSachVe) {
//        model.setRowCount(0); // Xóa dữ liệu cũ nếu có
//
//        int stt = 1; // Biến đếm cho số thứ tự
//
//        // Thêm từng Ve trong danhSachVe vào model
//        for (Ve ve : danhSachVe) {
//            model.addRow(new Object[]{
//                    stt, // Số thứ tự tự động tăng
//                    ve.getMaKhachHang(),
//                    ve.getLoaiDoiTuong(),
//                    ve.getLoaiVe(),
//                    ve.getMaGhe(),
//                    ve.getGiaVe()
//            });
//            stt++; // Tăng số thứ tự lên 1 cho dòng tiếp theo
//        }
//    }
}