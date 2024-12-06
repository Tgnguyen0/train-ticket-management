package app.giao_dien;

import app.dao.HoaDon_DAO;
import app.dieu_khien.HanhDong_TrangThongKeDoanhThuNhaGa;
import app.phan_tu_tuy_chinh.BieuDoCot;
import app.phan_tu_tuy_chinh.BieuDoTron;
import app.phan_tu_tuy_chinh.CustomCellRenderer;
import app.phan_tu_tuy_chinh.CustomHeaderRenderer;
import app.phong_chu_moi.PhongChuMoi;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
public class TrangChuaThongKeDoanhThuNhaGa extends JPanel {
    Logger logger = LoggerFactory.getLogger(TrangChuaThongKeDoanhThuNhaGa.class);
    public  JButton buttonThongKeNam;
    public  JButton buttonThongKeThang;
    public  JPanel colorDoanhThuNam;
    public  JPanel colorDoanhThuNam1;
    public  JComboBox<String> danhSachNam;
    public  JComboBox<String> danhSachNamKetThuc;
    public  JComboBox<String> danhSachNamXuatPhat;
    public  JComboBox<String> danhSachThang;
    public  JLabel labelDoanhThuNam;
    public  JLabel labelDoanhThuThangCuaNam;
    public  JLabel labelNam;
    public  JLabel labelNamKetThuc;
    public  JLabel labelNamXuatPhat;
    public  JLabel labelNote;
    public  JLabel labelThang;
    public  JScrollPane scrollPaneDanhSachDoanhThuCacNam;
    public  JScrollPane scrollPaneTrangChuaDoanhThuThang;
    public  JTable tableDanhSachDoanhThuCacNam;
    public  JTable tableDoanhThuThang;
    public  JPanel trangChuaBieuDoCot;
    public  JPanel trangChuaBieuDoTron;
    public  JPanel trangChuaCacNutThongKeNam;
    public  JPanel trangChuaCacNutThongKeThang;
    public  JPanel trangChuaCacThongTinThongKeNam;
    public  JPanel trangChuaCacThongTinThongKeThang;
    public  JPanel trangChuaDoanhThu;
    public  JPanel trangChuaDoanhThuCacNam;
    public  JPanel trangChuaNutChonNam;
    public  JPanel trangChuaNutChonNamKetThuc;
    public  JPanel trangChuaNutChonNamXuatPhat;
    public  JPanel trangChuaNutChonThang;
    public  JPanel trangChuaNutChonThongKeNam;
    public  JPanel trangChuaNutThongKeThang;
    public  JPanel trangChuaThongTinChuYBieuDoTron;
    public  JPanel trangChuaThongTinThongKeDoanhThuThang;
    public  JPanel trangChuaThongKeDoanhThuNam;
    public  JPanel trangChuaThongKeDoanhThuThang;

    public DefaultComboBoxModel<String> modelNam_TrongThongKeThang;
    public DefaultTableModel modelTable_DoanhThuThang;
    public DefaultTableModel modelTable_DoanhThuNam;
    public DefaultComboBoxModel<String> modelThang_TrongThongKeThang;

    public DefaultComboBoxModel<String> modelNamXuatPhat;
    public DefaultComboBoxModel<String> modelNamKetThuc;
    ActionListener ac ;
    MouseListener mouse;
    MouseAdapter mouseAdapter;
    public double[] doanhThuThang_Nam;
    public BieuDoTron chartPanel;
    public Color[] colors;
    public JButton buttonThongKeDoanhThuThangCuaNhanVien;
    public JButton buttonThongKeDoanhThuNamCuaNhanVien;
    public JPanel trangChuaButtonChuyenTrang;
    public JLabel labelThongKe;
    public TrangDinhHuong trangDinhHuong;
    public BieuDoCot barChartExample;
    public Color xanhBrandeis = new Color(0, 112, 255);
    public  Color trang = new Color(255, 255, 255);
    public JButton buttonDuDoanDoanhThu;

    public TrangChuaThongKeDoanhThuNhaGa(TrangDinhHuong mainFrame){
        this.trangDinhHuong = mainFrame;
        trangChuaThongKeDoanhThuThang = new JPanel();
        trangChuaCacThongTinThongKeThang = new  JPanel();
        trangChuaCacNutThongKeThang = new  JPanel();
        trangChuaNutChonThang = new  JPanel();
        labelThongKe = new JLabel();
        labelThang = new  JLabel();
        danhSachThang = new  JComboBox<>();
        trangChuaNutChonNam = new  JPanel();
        labelNam = new  JLabel();
        danhSachNam = new  JComboBox<>();
        trangChuaNutThongKeThang = new  JPanel();
        buttonThongKeThang = new  JButton();
        trangChuaDoanhThu = new  JPanel();
        scrollPaneTrangChuaDoanhThuThang = new  JScrollPane();
        tableDoanhThuThang = new  JTable();
        trangChuaThongTinThongKeDoanhThuThang = new  JPanel();
        trangChuaBieuDoTron = new  JPanel();
        trangChuaThongTinChuYBieuDoTron = new  JPanel();
        labelNote = new  JLabel();
        colorDoanhThuNam = new  JPanel();
        labelDoanhThuNam = new  JLabel();
        colorDoanhThuNam1 = new  JPanel();
        labelDoanhThuThangCuaNam = new  JLabel();
        buttonThongKeDoanhThuThangCuaNhanVien = new JButton();
        buttonThongKeDoanhThuNamCuaNhanVien = new JButton();
        trangChuaButtonChuyenTrang = new JPanel();
        trangChuaThongKeDoanhThuNam = new  JPanel();
        trangChuaCacThongTinThongKeNam = new  JPanel();
        trangChuaCacNutThongKeNam = new  JPanel();
        trangChuaNutChonNamXuatPhat = new  JPanel();
        labelNamXuatPhat = new  JLabel();
        danhSachNamXuatPhat = new  JComboBox<>();
        trangChuaNutChonNamKetThuc = new  JPanel();
        labelNamKetThuc = new  JLabel();
        danhSachNamKetThuc = new  JComboBox<>();
        trangChuaNutChonThongKeNam = new  JPanel();
        buttonThongKeNam = new  JButton();
        trangChuaDoanhThuCacNam = new  JPanel();
        scrollPaneDanhSachDoanhThuCacNam = new  JScrollPane();
        tableDanhSachDoanhThuCacNam = new  JTable();
        trangChuaBieuDoCot = new  JPanel();
        modelNam_TrongThongKeThang = new DefaultComboBoxModel<>();
        modelThang_TrongThongKeThang = new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" ,"12"});
        modelTable_DoanhThuThang = new DefaultTableModel(new String[]{"Tháng", "Năm", "Số Vé", "Doanh Thu"}, 0){
        @Override
        public boolean isCellEditable(int data, int columnName) {
            return false;
        }};
        modelTable_DoanhThuNam = new DefaultTableModel( new String [] {"Năm", "Số Vé", "Doanh Thu"}, 0){
            @Override
            public boolean isCellEditable(int data, int columnName) {
                return false;
            }};
        modelNamXuatPhat = new DefaultComboBoxModel<>();
        modelNamKetThuc = new DefaultComboBoxModel<>();
        //setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

        /*
        trang chứa thống kê doanh thu theo tháng của nhà ga
        */

        thietLap_TrangChuaNutChonThang();
        thietLap_TrangChuaNutChonNam();

        thietLap_TrangChuaNutThongKeThang();

        thietLap_TrangChuaCacNutThongKeThang();

        thietLap_TrangChuaDoanhThu();

        thietLap_TrangChuaCacThongTinThang();

        thietLap_TrangChuaThongTinChuYBieuDoTron();
        thietLap_TrangChuaButtonChuyenTrang();
        thietLap_TrangChuaDoanhThuThang();

        /*

         */
        thietLap_TrangChuaNutChonNamXuatPhat();
        thietLap_TrangChuaNamKetThuc();
        thietLap_TrangChuaNutChonThongKeNam();
        thietLap_TrangChuaCacNutThongKeNam();
        thietLap_TrangChuaDoanhThuCacNam();
        thietLap_TrangChuaCacThongTinThongKeNam();
        thietLap_TrangChuaThongKeDoanhThuNam();
        thietLap_TrangChuaThongKeDoanhThuNhaGa();

        /*
            chuẩn bị dữ liệu cho trang giao diện
         */

        dayDanhSachCacNamLenTrangGiaoDien();
        tinhDoanhThuNhaGaTrongThang();
        taoBieuDoTronCuaDoanhThang();
        taoBieuDoCotDoanhThuCacNam();
        tinhDoanhThuNhaGaTrongCacNam();

        /*
            thêm các hành động vào trong chức năng
         */
        themHanhDongChoCacChucNang();
        trangChuaBieuDoCot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Xử lý khi người dùng nhấp vào JPanel
                System.out.println("JPanel đã được nhấp!");
            }
        });
    }


    public void thietLap_TrangChuaNutChonThang(){
        labelThang.setText("Tháng:");
        labelThang.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        danhSachThang.setModel(modelThang_TrongThongKeThang);
        int currentMonth = LocalDate.now().getMonthValue(); // This returns the current month (1-12)
        danhSachThang.setSelectedItem(String.valueOf(currentMonth));
        danhSachThang.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                // Gọi phương thức mặc định để thiết lập label
                javax.swing.JLabel renderer = (javax.swing.JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Căn giữa chữ trong JComboBox
                renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                renderer.setFont(new Font("Arial", Font.PLAIN, 13));
                // Kiểm tra nếu mục được chọn hoặc có con trỏ chuột đang chỉ vào
                if (isSelected || cellHasFocus) {
                    renderer.setBackground(xanhBrandeis); // Màu nền xanh
                    renderer.setForeground(trang); // Màu chữ trắng
                } else {
                    renderer.setBackground(trang); // Màu nền trắng khi không chọn
                    renderer.setForeground(xanhBrandeis); // Màu chữ đen khi không chọn
                }
                return renderer;
            }
        });
        javax.swing.GroupLayout trangChuaNutChonThangLayout = new javax.swing.GroupLayout(trangChuaNutChonThang);
        trangChuaNutChonThang.setLayout(trangChuaNutChonThangLayout);
        trangChuaNutChonThangLayout.setHorizontalGroup(
                trangChuaNutChonThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonThangLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelThang, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
                        .addGroup(trangChuaNutChonThangLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(danhSachThang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaNutChonThangLayout.setVerticalGroup(
                trangChuaNutChonThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonThangLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelThang)
                                .addGap(18, 18, 18)
                                .addComponent(danhSachThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );
    }
    public void thietLap_TrangChuaNutChonNam(){
        labelNam.setText("Năm:");
        labelNam.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        danhSachNam.setModel(modelNam_TrongThongKeThang);
        danhSachNam.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                // Gọi phương thức mặc định để thiết lập label
                javax.swing.JLabel renderer = (javax.swing.JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Căn giữa chữ trong JComboBox
                renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                renderer.setFont(new Font("Arial", Font.PLAIN, 13));
                // Kiểm tra nếu mục được chọn hoặc có con trỏ chuột đang chỉ vào
                if (isSelected || cellHasFocus) {
                    renderer.setBackground(xanhBrandeis); // Màu nền xanh
                    renderer.setForeground(trang); // Màu chữ trắng
                } else {
                    renderer.setBackground(trang); // Màu nền trắng khi không chọn
                    renderer.setForeground(xanhBrandeis); // Màu chữ đen khi không chọn
                }
                return renderer;
            }
        });
        javax.swing.GroupLayout trangChuaNutChonNamLayout = new javax.swing.GroupLayout(trangChuaNutChonNam);
        trangChuaNutChonNam.setLayout(trangChuaNutChonNamLayout);
        trangChuaNutChonNamLayout.setHorizontalGroup(
                trangChuaNutChonNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonNamLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelNam, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
                        .addGroup(trangChuaNutChonNamLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(danhSachNam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaNutChonNamLayout.setVerticalGroup(
                trangChuaNutChonNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonNamLayout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addComponent(labelNam)
                                .addGap(18, 18, 18)
                                .addComponent(danhSachNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );
    }
    public void thietLap_TrangChuaNutThongKeThang(){
        buttonThongKeThang.setText("Thống Kê:");
        buttonThongKeThang.setForeground(this.trang);
        buttonThongKeThang.setBackground(this.xanhBrandeis);
        buttonThongKeThang.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));

        javax.swing.GroupLayout trangChuaNutThongKeThangLayout = new javax.swing.GroupLayout(trangChuaNutThongKeThang);
        trangChuaNutThongKeThang.setLayout(trangChuaNutThongKeThangLayout);
        trangChuaNutThongKeThangLayout.setHorizontalGroup(
                trangChuaNutThongKeThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaNutThongKeThangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(buttonThongKeThang, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaNutThongKeThangLayout.setVerticalGroup(
                trangChuaNutThongKeThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaNutThongKeThangLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonThongKeThang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );
    }
    public void thietLap_TrangChuaCacNutThongKeThang(){
        trangChuaCacNutThongKeThang.setPreferredSize(new java.awt.Dimension(550, 200));
        javax.swing.GroupLayout trangChuaCacNutThongKeThangLayout = new javax.swing.GroupLayout(trangChuaCacNutThongKeThang);
        trangChuaCacNutThongKeThang.setLayout(trangChuaCacNutThongKeThangLayout);
        trangChuaCacNutThongKeThangLayout.setHorizontalGroup(
                trangChuaCacNutThongKeThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacNutThongKeThangLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(trangChuaNutChonThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChuaNutChonNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                .addComponent(trangChuaNutThongKeThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
        );
        trangChuaCacNutThongKeThangLayout.setVerticalGroup(
                trangChuaCacNutThongKeThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaCacNutThongKeThangLayout.createSequentialGroup()
                                .addContainerGap(30, Short.MAX_VALUE)
                                .addGroup(trangChuaCacNutThongKeThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChuaNutThongKeThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaNutChonNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaNutChonThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
        );
    }
    public void thietLap_TrangChuaDoanhThu(){
        tableDoanhThuThang.setModel(modelTable_DoanhThuThang);
        tableDoanhThuThang.getTableHeader().setReorderingAllowed(false);
        tableDoanhThuThang.setRowHeight(20);
        tableDoanhThuThang.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 12));
        JTableHeader header = tableDoanhThuThang.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setDefaultRenderer(new CustomHeaderRenderer());
        tableDoanhThuThang.setDefaultRenderer(Object.class, new CustomCellRenderer());
        scrollPaneTrangChuaDoanhThuThang.setViewportView(tableDoanhThuThang);
        scrollPaneTrangChuaDoanhThuThang.setBorder(BorderFactory.createLineBorder(this.xanhBrandeis));

        javax.swing.GroupLayout trangChuaDoanhThuLayout = new javax.swing.GroupLayout(trangChuaDoanhThu);
        trangChuaDoanhThu.setLayout(trangChuaDoanhThuLayout);
        trangChuaDoanhThuLayout.setHorizontalGroup(
                trangChuaDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDoanhThuLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(scrollPaneTrangChuaDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaDoanhThuLayout.setVerticalGroup(
                trangChuaDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDoanhThuLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(scrollPaneTrangChuaDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaCacThongTinThang(){
        javax.swing.GroupLayout trangChuaCacThongTinThongKeThangLayout = new javax.swing.GroupLayout(trangChuaCacThongTinThongKeThang);
        trangChuaCacThongTinThongKeThang.setLayout(trangChuaCacThongTinThongKeThangLayout);
        trangChuaCacThongTinThongKeThangLayout.setHorizontalGroup(
                trangChuaCacThongTinThongKeThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaCacNutThongKeThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangChuaDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        trangChuaCacThongTinThongKeThangLayout.setVerticalGroup(
                trangChuaCacThongTinThongKeThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacThongTinThongKeThangLayout.createSequentialGroup()
                                .addComponent(trangChuaCacNutThongKeThang, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }
    public void thietLap_TrangChuaThongTinChuYBieuDoTron(){
        labelNote.setText("Chú Thích:");
        labelNote.setPreferredSize(new Dimension(300, 20));
        labelNote.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 15));
        colorDoanhThuNam1.setBackground(Color.BLUE);
        colorDoanhThuNam1.setPreferredSize(new java.awt.Dimension(20, 25));

        javax.swing.GroupLayout colorDoanhThuNam1Layout = new javax.swing.GroupLayout(colorDoanhThuNam1);
        colorDoanhThuNam1.setLayout(colorDoanhThuNam1Layout);
        colorDoanhThuNam1Layout.setHorizontalGroup(
                colorDoanhThuNam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 20, Short.MAX_VALUE)
        );
        colorDoanhThuNam1Layout.setVerticalGroup(
                colorDoanhThuNam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        labelDoanhThuNam.setText("Tổng Doanh Thu Của Năm");
        labelDoanhThuNam.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        labelDoanhThuNam.setPreferredSize(new Dimension(300, 20));

        colorDoanhThuNam.setBackground(Color.GRAY);
        colorDoanhThuNam.setPreferredSize(new java.awt.Dimension(20, 25));

        javax.swing.GroupLayout colorDoanhThuNamLayout = new javax.swing.GroupLayout(colorDoanhThuNam);
        colorDoanhThuNam.setLayout(colorDoanhThuNamLayout);
        colorDoanhThuNamLayout.setHorizontalGroup(
                colorDoanhThuNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 20, Short.MAX_VALUE)
        );
        colorDoanhThuNamLayout.setVerticalGroup(
                colorDoanhThuNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        labelDoanhThuThangCuaNam.setText("Tổng Doanh Thu Của Tháng Trong Năm");
        labelDoanhThuThangCuaNam.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));

        javax.swing.GroupLayout trangChuaThongTinChuYBieuDoTronLayout = new javax.swing.GroupLayout(trangChuaThongTinChuYBieuDoTron);
        trangChuaThongTinChuYBieuDoTron.setLayout(trangChuaThongTinChuYBieuDoTronLayout);
        trangChuaThongTinChuYBieuDoTronLayout.setHorizontalGroup(
                trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createSequentialGroup()
                                .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(labelNote, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(colorDoanhThuNam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(colorDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelDoanhThuThangCuaNam, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE) // Điều chỉnh chiều rộng của label
                                                        .addComponent(labelDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10))
        );
        trangChuaThongTinChuYBieuDoTronLayout.setVerticalGroup(
                trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(labelNote)
                                .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaThongTinChuYBieuDoTronLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(labelDoanhThuThangCuaNam, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(colorDoanhThuNam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(colorDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 48, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaButtonChuyenTrang(){
        buttonThongKeDoanhThuThangCuaNhanVien.setText("Thống Kê Doanh Thu Tháng Của Nhân Viên");
        buttonThongKeDoanhThuThangCuaNhanVien.setForeground(this.trang);
        buttonThongKeDoanhThuThangCuaNhanVien.setBackground(this.xanhBrandeis);
        buttonThongKeDoanhThuThangCuaNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));

        buttonThongKeDoanhThuNamCuaNhanVien.setText("Thống Kê Doanh Thu Năm Của Nhân Viên");
        buttonThongKeDoanhThuNamCuaNhanVien.setForeground(this.trang);
        buttonThongKeDoanhThuNamCuaNhanVien.setBackground(this.xanhBrandeis);
        buttonThongKeDoanhThuNamCuaNhanVien.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));

        buttonDuDoanDoanhThu = new JButton();
        buttonDuDoanDoanhThu.setText("Dự Đoán Doanh Thu");
        buttonDuDoanDoanhThu.setForeground(this.trang);
        buttonDuDoanDoanhThu.setBackground(this.xanhBrandeis);
        buttonDuDoanDoanhThu.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));

        javax.swing.GroupLayout trangChuaButtonChuyenTrangLayout = new javax.swing.GroupLayout(trangChuaButtonChuyenTrang);
        trangChuaButtonChuyenTrang.setLayout(trangChuaButtonChuyenTrangLayout);
        trangChuaButtonChuyenTrangLayout.setHorizontalGroup(
                trangChuaButtonChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaButtonChuyenTrangLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(trangChuaButtonChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(buttonThongKeDoanhThuThangCuaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                        .addComponent(buttonThongKeDoanhThuNamCuaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonDuDoanDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaButtonChuyenTrangLayout.setVerticalGroup(
                trangChuaButtonChuyenTrangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaButtonChuyenTrangLayout.createSequentialGroup()
                                .addComponent(buttonThongKeDoanhThuThangCuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonThongKeDoanhThuNamCuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDuDoanDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );


    }
    public void thietLap_TrangChuaDoanhThuThang(){
        trangChuaThongKeDoanhThuThang.setPreferredSize(new java.awt.Dimension(1200, 400));
        javax.swing.GroupLayout trangChuaThongTinThongKeDoanhThuThangLayout = new javax.swing.GroupLayout(trangChuaThongTinThongKeDoanhThuThang);
        trangChuaThongTinThongKeDoanhThuThang.setLayout(trangChuaThongTinThongKeDoanhThuThangLayout);
        trangChuaThongTinThongKeDoanhThuThangLayout.setHorizontalGroup(
                trangChuaThongTinThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinThongKeDoanhThuThangLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(trangChuaBieuDoTron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(trangChuaThongTinThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChuaThongTinChuYBieuDoTron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaButtonChuyenTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        trangChuaThongTinThongKeDoanhThuThangLayout.setVerticalGroup(
                trangChuaThongTinThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinThongKeDoanhThuThangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChuaButtonChuyenTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaThongTinChuYBieuDoTron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaThongTinThongKeDoanhThuThangLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaBieuDoTron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        labelThongKe.setText("Thống Kê Doanh Thu Nhà Ga");
        labelThongKe.setFont(new Font("Arial", Font.BOLD, 16));

        javax.swing.GroupLayout trangChuaThongKeDoanhThuThangLayout = new javax.swing.GroupLayout(trangChuaThongKeDoanhThuThang);
        trangChuaThongKeDoanhThuThang.setLayout(trangChuaThongKeDoanhThuThangLayout);
        trangChuaThongKeDoanhThuThangLayout.setHorizontalGroup(
                trangChuaThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongKeDoanhThuThangLayout.createSequentialGroup()
                                .addGroup(trangChuaThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChuaCacThongTinThongKeThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(trangChuaThongKeDoanhThuThangLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(labelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaThongTinThongKeDoanhThuThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaThongKeDoanhThuThangLayout.setVerticalGroup(
                trangChuaThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongKeDoanhThuThangLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(trangChuaThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(trangChuaThongTinThongKeDoanhThuThang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaThongKeDoanhThuThangLayout.createSequentialGroup()
                                                .addComponent(labelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(trangChuaCacThongTinThongKeThang, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaNutChonNamXuatPhat(){
        labelNamXuatPhat.setText("Năm Xuất Phát:");
        labelNamXuatPhat.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));
        danhSachNamXuatPhat.setModel(modelNamXuatPhat);
        danhSachNamXuatPhat.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                // Gọi phương thức mặc định để thiết lập label
                javax.swing.JLabel renderer = (javax.swing.JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Căn giữa chữ trong JComboBox
                renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                renderer.setFont(new Font("Arial", Font.PLAIN, 13));
                // Kiểm tra nếu mục được chọn hoặc có con trỏ chuột đang chỉ vào
                if (isSelected || cellHasFocus) {
                    renderer.setBackground(xanhBrandeis); // Màu nền xanh
                    renderer.setForeground(trang); // Màu chữ trắng
                } else {
                    renderer.setBackground(trang); // Màu nền trắng khi không chọn
                    renderer.setForeground(xanhBrandeis); // Màu chữ đen khi không chọn
                }
                return renderer;
            }
        });
        javax.swing.GroupLayout trangChuaNutChonNamXuatPhatLayout = new javax.swing.GroupLayout(trangChuaNutChonNamXuatPhat);
        trangChuaNutChonNamXuatPhat.setLayout(trangChuaNutChonNamXuatPhatLayout);
        trangChuaNutChonNamXuatPhatLayout.setHorizontalGroup(
                trangChuaNutChonNamXuatPhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonNamXuatPhatLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelNamXuatPhat, 120, 120, javax.swing.GroupLayout.PREFERRED_SIZE) // Tăng kích thước cho label
                                .addContainerGap(18, Short.MAX_VALUE))
                        .addGroup(trangChuaNutChonNamXuatPhatLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(danhSachNamXuatPhat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaNutChonNamXuatPhatLayout.setVerticalGroup(
                trangChuaNutChonNamXuatPhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonNamXuatPhatLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelNamXuatPhat)
                                .addGap(18, 18, 18)
                                .addComponent(danhSachNamXuatPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );
    }
    public void thietLap_TrangChuaNamKetThuc(){
        labelNamKetThuc.setText("Năm Kết Thúc:");
        labelNamKetThuc.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 13));

        danhSachNamKetThuc.setModel(modelNamKetThuc);
        danhSachNamKetThuc.setRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(
                    javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                // Gọi phương thức mặc định để thiết lập label
                javax.swing.JLabel renderer = (javax.swing.JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Căn giữa chữ trong JComboBox
                renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                renderer.setFont(new Font("Arial", Font.PLAIN, 13));
                // Kiểm tra nếu mục được chọn hoặc có con trỏ chuột đang chỉ vào
                if (isSelected || cellHasFocus) {
                    renderer.setBackground(xanhBrandeis); // Màu nền xanh
                    renderer.setForeground(trang); // Màu chữ trắng
                } else {
                    renderer.setBackground(trang); // Màu nền trắng khi không chọn
                    renderer.setForeground(xanhBrandeis); // Màu chữ đen khi không chọn
                }
                return renderer;
            }
        });

        javax.swing.GroupLayout trangChuaNutChonNamKetThucLayout = new javax.swing.GroupLayout(trangChuaNutChonNamKetThuc);
        trangChuaNutChonNamKetThuc.setLayout(trangChuaNutChonNamKetThucLayout);
        trangChuaNutChonNamKetThucLayout.setHorizontalGroup(
                trangChuaNutChonNamKetThucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonNamKetThucLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelNamKetThuc, 120, 120, javax.swing.GroupLayout.PREFERRED_SIZE) // Tăng kích thước cho label
                                .addContainerGap(18, Short.MAX_VALUE))
                        .addGroup(trangChuaNutChonNamKetThucLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(danhSachNamKetThuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaNutChonNamKetThucLayout.setVerticalGroup(
                trangChuaNutChonNamKetThucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonNamKetThucLayout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addComponent(labelNamKetThuc)
                                .addGap(18, 18, 18)
                                .addComponent(danhSachNamKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
        );
    }
    public void thietLap_TrangChuaNutChonThongKeNam(){
        buttonThongKeNam.setText("Thống Kê");
        buttonThongKeNam.setForeground(this.trang);
        buttonThongKeNam.setBackground(this.xanhBrandeis);
        buttonThongKeNam.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.BOLD, 14));

        javax.swing.GroupLayout trangChuaNutChonThongKeNamLayout = new javax.swing.GroupLayout(trangChuaNutChonThongKeNam);
        trangChuaNutChonThongKeNam.setLayout(trangChuaNutChonThongKeNamLayout);
        trangChuaNutChonThongKeNamLayout.setHorizontalGroup(
                trangChuaNutChonThongKeNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaNutChonThongKeNamLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(buttonThongKeNam, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaNutChonThongKeNamLayout.setVerticalGroup(
                trangChuaNutChonThongKeNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaNutChonThongKeNamLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonThongKeNam, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );

    }
    public void thietLap_TrangChuaCacNutThongKeNam(){
        trangChuaCacNutThongKeNam.setPreferredSize(new java.awt.Dimension(550, 200));
        javax.swing.GroupLayout trangChuaCacNutThongKeNamLayout = new javax.swing.GroupLayout(trangChuaCacNutThongKeNam);
        trangChuaCacNutThongKeNam.setLayout(trangChuaCacNutThongKeNamLayout);
        trangChuaCacNutThongKeNamLayout.setHorizontalGroup(
                trangChuaCacNutThongKeNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacNutThongKeNamLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(trangChuaNutChonNamXuatPhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(trangChuaNutChonNamKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaNutChonThongKeNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
        );
        trangChuaCacNutThongKeNamLayout.setVerticalGroup(
                trangChuaCacNutThongKeNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaCacNutThongKeNamLayout.createSequentialGroup()
                                .addContainerGap(30, Short.MAX_VALUE)
                                .addGroup(trangChuaCacNutThongKeNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(trangChuaNutChonThongKeNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaNutChonNamKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(trangChuaNutChonNamXuatPhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
        );
    }
    public void thietLap_TrangChuaDoanhThuCacNam(){
        tableDanhSachDoanhThuCacNam.setModel(modelTable_DoanhThuNam);
        tableDanhSachDoanhThuCacNam.getTableHeader().setReorderingAllowed(false);
        tableDanhSachDoanhThuCacNam.setRowHeight(20);
        tableDanhSachDoanhThuCacNam.setFont((new PhongChuMoi()).layPhongRobotoMonoReg(Font.PLAIN, 12));
        JTableHeader header = tableDanhSachDoanhThuCacNam.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setDefaultRenderer(new CustomHeaderRenderer());
        tableDanhSachDoanhThuCacNam.setDefaultRenderer(Object.class, new CustomCellRenderer());
        scrollPaneDanhSachDoanhThuCacNam.setViewportView(tableDanhSachDoanhThuCacNam);
        scrollPaneDanhSachDoanhThuCacNam.setBorder(BorderFactory.createLineBorder(this.xanhBrandeis));

        javax.swing.GroupLayout trangChuaDoanhThuCacNamLayout = new javax.swing.GroupLayout(trangChuaDoanhThuCacNam);
        trangChuaDoanhThuCacNam.setLayout(trangChuaDoanhThuCacNamLayout);
        trangChuaDoanhThuCacNamLayout.setHorizontalGroup(
                trangChuaDoanhThuCacNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDoanhThuCacNamLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(scrollPaneDanhSachDoanhThuCacNam, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaDoanhThuCacNamLayout.setVerticalGroup(
                trangChuaDoanhThuCacNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaDoanhThuCacNamLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(scrollPaneDanhSachDoanhThuCacNam, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    public void thietLap_TrangChuaCacThongTinThongKeNam(){
        javax.swing.GroupLayout trangChuaCacThongTinThongKeNamLayout = new javax.swing.GroupLayout(trangChuaCacThongTinThongKeNam);
        trangChuaCacThongTinThongKeNam.setLayout(trangChuaCacThongTinThongKeNamLayout);
        trangChuaCacThongTinThongKeNamLayout.setHorizontalGroup(
                trangChuaCacThongTinThongKeNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaCacNutThongKeNam, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                        .addComponent(trangChuaDoanhThuCacNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        trangChuaCacThongTinThongKeNamLayout.setVerticalGroup(
                trangChuaCacThongTinThongKeNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaCacThongTinThongKeNamLayout.createSequentialGroup()
                                .addComponent(trangChuaCacNutThongKeNam, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaDoanhThuCacNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    public void thietLap_TrangChuaThongKeDoanhThuNam(){
        javax.swing.GroupLayout trangChuaThongKeDoanhThuNamLayout = new javax.swing.GroupLayout(trangChuaThongKeDoanhThuNam);
        trangChuaThongKeDoanhThuNam.setLayout(trangChuaThongKeDoanhThuNamLayout);

        trangChuaThongKeDoanhThuNamLayout.setHorizontalGroup(
                trangChuaThongKeDoanhThuNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongKeDoanhThuNamLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChuaCacThongTinThongKeNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaBieuDoCot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(55) // Thêm khoảng cách 10px bên phải của trangChuaBieuDoCot
                                .addContainerGap())
        );

        trangChuaThongKeDoanhThuNamLayout.setVerticalGroup(
                trangChuaThongKeDoanhThuNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongKeDoanhThuNamLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChuaBieuDoCot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaThongKeDoanhThuNamLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaCacThongTinThongKeNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
        );

    }
    public void thietLap_TrangChuaThongKeDoanhThuNhaGa(){
//        this.setPreferredSize(new java.awt.Dimension(1200, 600));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 100, Short.MAX_VALUE)
                                .addComponent(trangChuaThongKeDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 100, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 100, Short.MAX_VALUE)
                                .addComponent(trangChuaThongKeDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 100, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(20) // Khoảng cách từ cạnh trên
                        .addComponent(trangChuaThongKeDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50) // Khoảng cách giữa hai JPanel
                        .addComponent(trangChuaThongKeDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20) // Khoảng cách từ cạnh dưới
        );
//        pack();
    }
    public void dayDanhSachCacNamLenTrangGiaoDien(){
        ArrayList<String> danhSach =  HoaDon_DAO.layToanBoNamTuHoaDon();
        danhSachNam.setSelectedItem(-1);
        danhSachNamXuatPhat.setSelectedItem(-1);
        danhSachNamKetThuc.setSelectedItem(-1);
        for (String nam:danhSach) {
            modelNam_TrongThongKeThang.addElement(nam);
            modelNamXuatPhat.addElement(nam);
            modelNamKetThuc.addElement(nam);
        }
        danhSachNamXuatPhat.setSelectedIndex(0);
        danhSachNamKetThuc.setSelectedIndex(modelNamKetThuc.getSize()-1);
        danhSachNam.setSelectedIndex(modelNam_TrongThongKeThang.getSize()-1);
    }

    public void taoBieuDoTronCuaDoanhThang(){
        trangChuaBieuDoTron.removeAll();
        int thang =  Integer.parseInt((String) this.danhSachThang.getSelectedItem());
        int nam = Integer.parseInt((String) this.danhSachNam.getSelectedItem());
        int soLuongVe = HoaDon_DAO.tongSoLuongCuaThang_Nam(nam, thang);
        double doanhThuNam = HoaDon_DAO.tongDoanhThuCuaNam(nam);
        double doanhThuThang = HoaDon_DAO.tongDoanhThuCuaThang_Nam(nam, thang);
        double phanTramDoanhThuThang = doanhThuThang / doanhThuNam * 100;
        this.doanhThuThang_Nam = new double[]{100, phanTramDoanhThuThang};
        this.colors =   new Color[]{Color.GRAY, Color.BLUE};
        this.chartPanel = new BieuDoTron(doanhThuThang_Nam, colors, thang+"", nam+"", soLuongVe+"", doanhThuThang+"");
        chartPanel.setPreferredSize(new Dimension(200, 200));
        javax.swing.GroupLayout trangChuaBieuDoTronLayout = new javax.swing.GroupLayout(trangChuaBieuDoTron);
        trangChuaBieuDoTron.setLayout(trangChuaBieuDoTronLayout);

        // Đặt biểu đồ ở vị trí trung tâm của trangChuaBieuDoTron
        trangChuaBieuDoTronLayout.setHorizontalGroup(
                trangChuaBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        trangChuaBieuDoTronLayout.setVerticalGroup(
                trangChuaBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        trangChuaBieuDoTron.revalidate();
        trangChuaBieuDoTron.repaint();
    }

    public void tinhDoanhThuNhaGaTrongThang(){
        int thang =  Integer.parseInt((String) this.danhSachThang.getSelectedItem());
        int nam = Integer.parseInt((String) this.danhSachNam.getSelectedItem());

        double doanhThuThang = HoaDon_DAO.tongDoanhThuCuaThang_Nam(nam, thang);
        DecimalFormat df = new DecimalFormat("#,###.##");
        //logger.info(doanhThuThang+"");
        int soLuongVe = HoaDon_DAO.tongSoLuongCuaThang_Nam(nam, thang);

        Object[] value = {thang+"", nam+"", soLuongVe+"", df.format(doanhThuThang)};
        modelTable_DoanhThuThang.setRowCount(0);
        modelTable_DoanhThuThang.addRow(value);
    }
    public void taoBieuDoCotDoanhThuCacNam(){
        this.trangChuaBieuDoCot.removeAll();
        int namXuatPhat = Integer.parseInt((String) this.danhSachNamXuatPhat.getSelectedItem());
        int namKetThuc =  Integer.parseInt((String) this.danhSachNamKetThuc.getSelectedItem());
        Map<String, Double> danhSachDoanhThu;
        if(namXuatPhat > namKetThuc){
            JOptionPane.showMessageDialog(null, "Năm Kết Thúc Phải Lớn Hơn Năm Xuất Phát", "Cảnh Báo",JOptionPane.ERROR_MESSAGE);
            danhSachDoanhThu = HoaDon_DAO.layDoanhThuCacNam(0, 0);
            this.barChartExample = new BieuDoCot(danhSachDoanhThu, TrangChuaThongKeDoanhThuNhaGa.class);
        }
        else {
            danhSachDoanhThu = HoaDon_DAO.layDoanhThuCacNam(namXuatPhat, namKetThuc);
        }

        this.barChartExample = new BieuDoCot(danhSachDoanhThu, TrangChuaThongKeDoanhThuNhaGa.class);

        barChartExample.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Biểu đồ cột đã được nhấp!");
            }
        });

        javax.swing.GroupLayout trangChuaBieuDoCotLayout = new javax.swing.GroupLayout(trangChuaBieuDoCot);
        trangChuaBieuDoCot.setLayout(trangChuaBieuDoCotLayout);
        trangChuaBieuDoCotLayout.setHorizontalGroup(
                trangChuaBieuDoCotLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(barChartExample, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        trangChuaBieuDoCotLayout.setVerticalGroup(
                trangChuaBieuDoCotLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(barChartExample, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        this.trangChuaBieuDoCot.revalidate();
        this.trangChuaBieuDoCot.repaint();
    }
    public void tinhDoanhThuNhaGaTrongCacNam(){
        int namXuatPhat = Integer.parseInt((String) this.danhSachNamXuatPhat.getSelectedItem());
        int namKetThuc =  Integer.parseInt((String) this.danhSachNamKetThuc.getSelectedItem());

        Map<String, Double> danhSachDoanhThu = HoaDon_DAO.layDoanhThuCacNam(namXuatPhat, namKetThuc);
        DecimalFormat df = new DecimalFormat("#,###.##");

        this.modelTable_DoanhThuNam.setRowCount(0);
        for (String i : danhSachDoanhThu.keySet()) {
            Double doanhThu = danhSachDoanhThu.get(i); // Lấy giá trị từ bản đồ
            // Kiểm tra nếu giá trị không null
            if (doanhThu != null) {
                int soLuongVe = HoaDon_DAO.tongSoLuongCuaNam(Integer.parseInt(i));
                Object[] objects = {i, soLuongVe+"", df.format(doanhThu)};
                this.modelTable_DoanhThuNam.addRow(objects);
            }
        }
    }

    public void duDoanDoanhThuCuaNhaGa(){
            Map<Integer, Double> doanhThuNhaGa = HoaDon_DAO.layDoanhThuTungNam();
            TrangDuDoanDoanhThu.thietLapDuDoanDoanhThu(doanhThuNhaGa);
    }

    public void themHanhDongChoCacChucNang(){
        this.ac = new HanhDong_TrangThongKeDoanhThuNhaGa(this);
        this.mouse = new HanhDong_TrangThongKeDoanhThuNhaGa(this);
        this.mouseAdapter = new HanhDong_TrangThongKeDoanhThuNhaGa(this);
        this.buttonThongKeThang.addActionListener(ac);
        this.buttonThongKeNam.addActionListener(ac);
        this.buttonThongKeDoanhThuNamCuaNhanVien.addActionListener(ac);
        this.buttonThongKeDoanhThuThangCuaNhanVien.addActionListener(ac);
        this.buttonDuDoanDoanhThu.addActionListener(ac);
    }

}
