package app.giao_dien;

import app.dao.NhanVien_DAO;
import app.dieu_khien.HanhDong_TrangThongKeTienThuong;
import app.phan_tu_tuy_chinh.TaoFileExcelTienThuongNhanVienTrongNam;
import app.thuc_the.NhanVien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class TrangThongKeTienThuong extends JFrame {
    public javax.swing.JButton button_InBanThongKe;
    private javax.swing.JLabel label_TieuDe;
    private javax.swing.JPanel panel_DanhSachThongKe;
    private javax.swing.JPanel panel_TieuDe;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;

    private DefaultTableModel model;

    private ActionListener ac;
    private int nam ;
    private int thang;
    private Map<String, Double> danhSachDoanhThu;
    String link = "";
    public TrangThongKeTienThuong( Map<String, Double> danhSachDoanhThu, int nam , int thang, Object object){
        panel_TieuDe = new javax.swing.JPanel();
        label_TieuDe = new javax.swing.JLabel();
        panel_DanhSachThongKe = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        button_InBanThongKe = new javax.swing.JButton();
        this.danhSachDoanhThu = danhSachDoanhThu;
        this.nam = nam;
        this.thang = thang;

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("assets/icon.png");
        setIconImage(icon.getImage());
        this.setResizable(false);
        //this.setLocationRelativeTo(null);
        model = new DefaultTableModel(null,
                new String [] {
                        "Mã Số", "Họ Và Tên", "Doanh Thu", "Thưởng (%)", "Thành Tiền"
                }
        );

        label_TieuDe.setText("Thống Kê Tiền Thưởng Nhân Viên");

        javax.swing.GroupLayout panel_TieuDeLayout = new javax.swing.GroupLayout(panel_TieuDe);
        panel_TieuDe.setLayout(panel_TieuDeLayout);
        panel_TieuDeLayout.setHorizontalGroup(
                panel_TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_TieuDeLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(label_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_TieuDeLayout.setVerticalGroup(
                panel_TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_TieuDeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                .addContainerGap())
        );

        table.setModel(model);
        scrollPane.setViewportView(table);

        button_InBanThongKe.setText("In Thông Kê");

        javax.swing.GroupLayout panel_DanhSachThongKeLayout = new javax.swing.GroupLayout(panel_DanhSachThongKe);
        panel_DanhSachThongKe.setLayout(panel_DanhSachThongKeLayout);
        panel_DanhSachThongKeLayout.setHorizontalGroup(
                panel_DanhSachThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_DanhSachThongKeLayout.createSequentialGroup()
                                .addGroup(panel_DanhSachThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel_DanhSachThongKeLayout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel_DanhSachThongKeLayout.createSequentialGroup()
                                                .addGap(185, 185, 185)
                                                .addComponent(button_InBanThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(53, Short.MAX_VALUE))
        );
        panel_DanhSachThongKeLayout.setVerticalGroup(
                panel_DanhSachThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_DanhSachThongKeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_InBanThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel_DanhSachThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panel_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel_DanhSachThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        pack();
        this.setLocationRelativeTo(null);
        if(object == TrangChuaThongKeNhanVienTheoNam.class){
            dayDuLieuVaoTable();
            this.link = "ThongKe/TienThuong_BieuDoCot_Nam"+this.nam+".xlsx";
        }
        else{
            dayDuLieuVaoTable_DoanhThuThang();
            this.link = "ThongKe/TienThuong_BieuDoCot_Nam"+this.nam+"_Thang"+this.thang+".xlsx";
        }
        this.ac = new HanhDong_TrangThongKeTienThuong(this);
        this.button_InBanThongKe.addActionListener(ac);
    }

    private void dayDuLieuVaoTable(){
        this.model.setRowCount(0);
        int  stt = 1;
        for (String key : this.danhSachDoanhThu.keySet()){
            String maNV = key;
            double doanhThu = this.danhSachDoanhThu.get(key);
            NhanVien nv = NhanVien_DAO.layNhanVienTheo_MaNhanVien(maNV);
            String hoTen = nv.getTenNV();
            double percentage = 0;
            if(stt == 1){
                percentage = 0.045;
            }
            else if(stt == 2){
                percentage = 0.04;
            }
            else if(stt == 3){
                percentage = 0.035;
            }
            else {
                percentage = 0.03;
            }
            double thanhTien = doanhThu * percentage;
            // Sử dụng Locale của Việt Nam
            Locale vietnamLocale = new Locale("vi", "VN");

            // Tạo đối tượng NumberFormat để định dạng tiền tệ
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);

            Object object[]= {
                    maNV, hoTen, currencyFormatter.format(doanhThu), percentage,currencyFormatter.format(thanhTien)
            };
 
            this.model.addRow(object);
            stt+=1;
        }
    }
    private void dayDuLieuVaoTable_DoanhThuThang(){
        this.model.setRowCount(0);
        int  stt = 1;
        for (String key : this.danhSachDoanhThu.keySet()){
            String maNV = key;
            double doanhThu = this.danhSachDoanhThu.get(key);
            NhanVien nv = NhanVien_DAO.layNhanVienTheo_MaNhanVien(maNV);
            String hoTen = nv.getTenNV();
            double percentage = 0;
            if(stt == 1){
                percentage =  0.2;
            }
            else if(stt == 2){
                percentage = 0.17;
            }
            else if(stt == 3){
                percentage = 0.15;
            }
            else {
                percentage = 0.1;
            }
            double thanhTien = doanhThu * percentage;
            // Sử dụng Locale của Việt Nam
            Locale vietnamLocale = new Locale("vi", "VN");

            // Tạo đối tượng NumberFormat để định dạng tiền tệ
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);

            Object object[]= {
                    maNV, hoTen, currencyFormatter.format(doanhThu), percentage,currencyFormatter.format(thanhTien)
            };
 
            this.model.addRow(object);
            stt+=1;
        }
    }
    //ThongKe/DoanhThuNhaGa_BieuDoCot.xlsx
    public void xuatFileExcel(){
        if(JOptionPane.showConfirmDialog(null, "Bạn Có Muốn Xuất File Thống Kê Không?","Question", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION){
            new TaoFileExcelTienThuongNhanVienTrongNam().TaoFileExcelTienThuongNhanVienTrongNam(this.danhSachDoanhThu, this.link, this.nam, this.thang);
        }
    }
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());

                    // Cấu hình thuộc tính Nimbus
                    UIManager.put("control", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu nền
                    UIManager.put("nimbusBase", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu cơ bản
                    UIManager.put("nimbusBorder", new javax.swing.plaf.ColorUIResource(0, 112, 255)); // Màu viền
                    UIManager.put("nimbusLightBackground", new javax.swing.plaf.ColorUIResource(255, 255, 255)); // Màu nền sáng
                    UIManager.put("nimbusFocus", new javax.swing.plaf.ColorUIResource(0, 112, 255)); // Màu focus
                    UIManager.put("textForeground", new Color(0, 112, 255)); // Màu chữ
                    UIManager.put("ComboBox.foreground", new Color(0, 112, 255)); // Màu chữ cho JComboBox
                    UIManager.put("ComboBox.background", new Color(255, 255, 255));
                    UIManager.put("JCalendar.border", new Color(255, 255, 255));

                    // Đặt màu nền và màu chữ khi chọn cho JTextField
                    UIManager.put("TextField.selectionBackground", new Color(0, 112, 255)); // Màu nền khi chọn
                    UIManager.put("TextField.selectionForeground", new Color(255, 255, 255)); // Màu chữ khi chọncho JComboBox

                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Sau đó, khởi chạy giao diện của bạn
        java.awt.EventQueue.invokeLater(() -> {
           //new TrangThongKeTienThuong(null).setVisible(true);
        });
    }
}
