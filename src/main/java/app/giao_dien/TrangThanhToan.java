package app.giao_dien;
import app.dao.Ghe_DAO;
import app.dao.HoaDon_DAO;
import app.dao.Toa_DAO;
import app.dieu_khien.HanhDong_TrangThanhToan;
import app.phan_tu_tuy_chinh.CustomCellRenderer;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.time.LocalDate;
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
    public JTextField thanhTienNhan;
    public JRadioButton radioChuyenKhoan;
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
    public Toa_DAO toaDoa;
    public HoaDon_DAO hdDao;
    public Ghe_DAO gheDao;
    public List<Ve> danhSachVe;
    public List<KhachHang> dsKh;
    public List<Ghe> dsGheDat;
    public DaiNgo daiNgo;
    public Double tongTien;
    public String maNV;

    public PhongChuMoi phongTuyChinh = new PhongChuMoi();
    public Color xanhBrandeis = new Color(0, 112, 255);

    public ActionListener hanhDong;
    public MouseListener thaoTacChuot;

    public TrangThanhToan(List<Ve> dsVe, List<KhachHang> dsKh, List<Ghe> dsGhe) {
        super();
        this.danhSachVe = dsVe;
        this.dsKh = dsKh;
        this.dsGheDat = dsGhe;
        this.toaDoa = new Toa_DAO();
        this.hdDao = new HoaDon_DAO();
        this.gheDao = new Ghe_DAO();
        this.hanhDong = new HanhDong_TrangThanhToan(this);
        this.thaoTacChuot = new HanhDong_TrangThanhToan(this);
        this.tongTien = 0.0;

        for (int i = 0 ; i < this.danhSachVe.size() ; i++) {
            this.tongTien += this.danhSachVe.get(i).getGiaVe() * (1 - (this.danhSachVe.get(i).getLoaiDoiTuong().equals("Người Lớn") ? 0.0 : 0.025));
        }

        hienThi();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void datMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String layMaNV() {
        return this.maNV;
    }

    private void hienThi() {
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
        thanhTienNhan = new JTextField();
        PanelPhuongThucThanhToan = new JPanel();
        lbPhuongThucThanhToan = new JLabel();
        radioTienMat = new JRadioButton();
        radioChuyenKhoan = new JRadioButton();
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
                        "STT", "Tên Khách Hàng", "Loại Vé", "Số Hiệu", "Toa", "Loại Ghế", "Vị Trí", "Giá Vé"
                }
        ) {
            Class[] types = new Class[]{
                    Integer.class, String.class, String.class,  String.class,  String.class, String.class, String.class, Float.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };

        for (int i = 0 ; i < this.danhSachVe.size() ; i++) {

            KhachHang kh = null;

            for (int j = 0 ; j < dsKh.size() ; j++) {
                if (danhSachVe.get(i).getMaKhachHang().equals(dsKh.get(j).getMaKH())) {
                    kh = dsKh.get(j);
                }
            }

            Ghe ghe = null;

            for (int j = 0 ; j < dsGheDat.size() ; j++) {
                if (danhSachVe.get(i).getMaGhe().equals(dsGheDat.get(j).getMaGhe())) {
                    ghe = dsGheDat.get(j);
                }
            }

            Toa toa = this.toaDoa.ChonTheoMa(ghe.getMaToa());

            Object[] duLieu = {
                    String.valueOf(i + 1),                                                         // Thứ tự
                    //this.danhSachVe.get(i).getMaVe(),                                                // Mã vé
                    kh.getTenKH(),                                                                   // Họ tên khách hàng
                    this.danhSachVe.get(i).getLoaiDoiTuong(),                                        // Loại đối tượng
                    //(int) this.danhSachVe.get(i).getGiaVe(),                                         // Giá vé
                    /*this.danhSachVe.get(i).getGaKhoiHanh(),                                          // Ga xuất phát
                    this.danhSachVe.get(i).getGaKetThuc(),                                           // Ga đích
                    this.danhSachVe.get(i).getNgayDatVe().getYear() + "-" +
                        this.danhSachVe.get(i).getNgayDatVe().getMonth().getValue() + "-" +
                            this.danhSachVe.get(i).getNgayDatVe().getDayOfMonth(),                                           // Ngày đặt vé
                    this.danhSachVe.get(i).getNgayKhoiHanh().getYear() + "-" +                       // Ngày khởi hành
                            this.danhSachVe.get(i).getNgayKhoiHanh().getMonth().getValue() + "-" +
                                this.danhSachVe.get(i).getNgayKhoiHanh().getDayOfMonth(),*/
                    toa.getSoHieu(),                                                                 // Số hiệu tàu
                    /*this.danhSachVe.get(i).getNgayKhoiHanh().toLocalTime().getHour() + ":" +         // Giờ xuất phát
                            this.danhSachVe.get(i).getNgayKhoiHanh().toLocalTime().getMinute(),*/
                    toa.getTenToa(),
                    ghe.getLoaiGhe().toString(), //ghe.getMaToa(),                                    // Loại ghế                           // Mã toa
                    ghe.getSoGhe(),                                                                   // Số ghế
                    (int) this.danhSachVe.get(i).getGiaVe(),
            };

            model.addRow(duLieu);
        }

        danhSachVeThanhToan = new JTable(model);
        danhSachVeThanhToan.addMouseListener(thaoTacChuot);
        danhSachVeThanhToan.setDefaultRenderer(Object.class, new CustomCellRenderer());
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

        lbTongTien.setForeground(new java.awt.Color(0, 112, 255));
        lbTongTien.setText("Tổng Tiền:");

        lbKhuyenMai.setForeground(new java.awt.Color(0, 112, 255));
        lbKhuyenMai.setText("Khuyến Mãi:");

        lbVAT.setForeground(new java.awt.Color(0, 112, 255));
        lbVAT.setText("Thuế VAT:");

        tfThanhTien.addActionListener(this.hanhDong);

        tfTongTien.setText(String.valueOf(this.tongTien));
        tfTongTien.setEditable(false);

        int soLuong = this.danhSachVe.size();
        this.daiNgo = DaiNgo.GIAMGIAKHONGPHANTRAM;

        if (4 <= soLuong && soLuong < 10) {
            daiNgo = DaiNgo.GIAMGIANAMPHANTRAM;
        }

        if (10 <= soLuong && soLuong < 15) {
            daiNgo = DaiNgo.GIAMGIAMUOIPHANTRAM;
        }

        if (15 <= soLuong) {
            daiNgo = DaiNgo.GIAMGIAHAIMUOIPHANTRAM;
        }

        tfKhuyenMai.setText(daiNgo.toString());
        tfKhuyenMai.setEditable(false);

        tfVAT.setText("0%");
        tfVAT.setEditable(false);

        double thanhTien = this.tongTien * (1 - daiNgo.getValue());
        //double thanhTien = tongTien * (1 - 0.05);
        tfThanhTien.setText(String.valueOf(thanhTien));
        tfThanhTien.setEditable(false);

        tfTraLai.setEditable(false);

        javax.swing.GroupLayout PanelThanhToan1Layout = new javax.swing.GroupLayout(PanelThanhToan1);
        PanelThanhToan1.setLayout(PanelThanhToan1Layout);
        PanelThanhToan1Layout.setHorizontalGroup(
                PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelThanhToan1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                        .addComponent(lbVAT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(tfKhuyenMai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfVAT))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelThanhToan1Layout.setVerticalGroup(
                PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelThanhToan1Layout.createSequentialGroup()
                                .addContainerGap(8, Short.MAX_VALUE)
                                .addGroup(PanelThanhToan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbTongTien)
                                        .addComponent(tfTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        lbThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbThanhTien.setForeground(new java.awt.Color(0, 112, 255));
        lbThanhTien.setText("THÀNH TIỀN:");

        lbTienNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTienNhan.setForeground(new java.awt.Color(0, 112, 255));
        lbTienNhan.setText("TIỀN NHẬN:");

        lnTraLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lnTraLai.setForeground(new java.awt.Color(0, 112, 255));
        lnTraLai.setText("TRẢ LẠI:");

        tfTraLai.addActionListener(hanhDong);

        javax.swing.GroupLayout PanelTongTienLayout = new javax.swing.GroupLayout(PanelTongTien);
        PanelTongTien.setLayout(PanelTongTienLayout);
        PanelTongTienLayout.setHorizontalGroup(
                PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTongTienLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbTienNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lnTraLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(PanelTongTienLayout.createSequentialGroup()
                                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(thanhTienNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false))))));
        PanelTongTienLayout.setVerticalGroup(
                PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTongTienLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbThanhTien)
                                        .addComponent(tfThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelTongTienLayout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(lbTienNhan))
                                        .addGroup(PanelTongTienLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(thanhTienNhan))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                )
                                .addGap(18, 18, 18)
                                .addGroup(PanelTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lnTraLai)
                                        .addComponent(tfTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
        );
;
        lbPhuongThucThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPhuongThucThanhToan.setForeground(new java.awt.Color(0, 112, 255));
        lbPhuongThucThanhToan.setText("Chọn Phương Thức Thanh Toán:");

        radioTienMat.setForeground(new java.awt.Color(0, 112, 255));
        radioTienMat.setText("Tiền Mặt (Cash)");
        radioTienMat.addActionListener(hanhDong);
        radioTienMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTienMatActionPerformed(evt);
            }
        });

        radioChuyenKhoan.setForeground(new java.awt.Color(0, 112, 255));
        radioChuyenKhoan.setText("Chuyển Khoản (Banking)");
        radioChuyenKhoan.addActionListener(hanhDong);
        radioChuyenKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioChuyenKhoanActionPerformed(evt);
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
                                        .addComponent(radioChuyenKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(radioChuyenKhoan)
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        ButtonThanhToan.setBackground(new java.awt.Color(0, 112, 255));
        ButtonThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ButtonThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        ButtonThanhToan.addActionListener(hanhDong);
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

    private void radioChuyenKhoanActionPerformed(java.awt.event.ActionEvent evt) {
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