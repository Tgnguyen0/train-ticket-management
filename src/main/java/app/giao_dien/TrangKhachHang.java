package app.giao_dien;

import app.dao.KhachHang_DAO;
import app.dieu_khien.HanhDong_TrangKhachHang;
import app.thuc_the.KhachHang;

import javax.swing.*;
import java.awt.BorderLayout;

import java.awt.Font;

import java.awt.Color;


import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.table.DefaultTableModel;

import javax.swing.border.LineBorder;




public class TrangKhachHang extends JPanel {

    private static final long serialVersionUID = 1L;
    public final JTextArea textArea_diaChi;
    public final JLabel label_hienThiMaKH;
    public final JTextField textField_email;
    public final JComboBox comboBox_gioiTinh;
    private final JButton btn_lamMoiDSKH;
    public JTable table;
    public JTextField textField_HoTen;
    public JTextField textField_SDT;
    public JTextField textField_timTen;
    public JTextField textField_timSDT;
    private int soThuTuTable;
    public ArrayList<KhachHang> dsKH;


    /**
     * Create the panel.
     */
    public TrangKhachHang() {
        setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
        setLayout(new BorderLayout(10, 0));
        setSize(1200, 700);

        JLabel label_quanLyKH = new JLabel("<html><u>QUẢN LÝ KHÁCH HÀNG</u></html>");
        label_quanLyKH.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        label_quanLyKH.setBackground(new Color(0, 64, 128));
        label_quanLyKH.setForeground(new Color(0, 128, 255));
        label_quanLyKH.setHorizontalAlignment(SwingConstants.CENTER);
        label_quanLyKH.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        add(label_quanLyKH, BorderLayout.NORTH);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setForeground(new Color(0, 0, 128));
        desktopPane.setBackground(new Color(0, 0, 128));
        add(desktopPane, BorderLayout.CENTER);
        desktopPane.setLayout(new BorderLayout(0, 0));

        JPanel panel_cumTieuDe = new JPanel();
        panel_cumTieuDe.setBorder(null);
        desktopPane.add(panel_cumTieuDe, BorderLayout.NORTH);
        panel_cumTieuDe.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblThngTinKhch = new JLabel(" Thông tin khách hàng");
        lblThngTinKhch.setHorizontalAlignment(SwingConstants.LEFT);
        lblThngTinKhch.setFont(new Font("Tahoma", Font.PLAIN, 30));
        panel_cumTieuDe.add(lblThngTinKhch);

        JPanel panel_noiDung = new JPanel();
        desktopPane.add(panel_noiDung, BorderLayout.CENTER);
        panel_noiDung.setLayout(new GridLayout(2, 0, 0, 0));



        JPanel panel_thongTinKH = new JPanel();
        panel_thongTinKH.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
        panel_noiDung.add(panel_thongTinKH);
        panel_thongTinKH.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(89, 50, 943, 206);
        panel_thongTinKH.add(panel_1);
        panel_1.setLayout(null);

        JLabel label_maKH = new JLabel("Mã khách hàng:");
        label_maKH.setBounds(0, 0, 142, 25);
        panel_1.add(label_maKH);
        label_maKH.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_HoTen = new JTextField();
        textField_HoTen.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_HoTen.setBounds(152, 35, 296, 45);
        panel_1.add(textField_HoTen);
        textField_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_HoTen.setColumns(15);

        label_hienThiMaKH = new JLabel("<mã khách hàng>");
        label_hienThiMaKH.setBounds(152, 0, 165, 25);
        panel_1.add(label_hienThiMaKH);
        label_hienThiMaKH.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_hoTen = new JLabel("Họ và tên:");
        label_hoTen.setBounds(0, 44, 93, 25);
        panel_1.add(label_hoTen);
        label_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel label_sdt = new JLabel("Số điện thoại");
        label_sdt.setBounds(0, 99, 117, 25);
        panel_1.add(label_sdt);
        label_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_SDT = new JTextField();
        textField_SDT.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_SDT.setBounds(152, 90, 296, 45);
        panel_1.add(textField_SDT);
        textField_SDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_SDT.setColumns(15);

        JLabel lblGiiTnh = new JLabel("Giới tính:");
        lblGiiTnh.setBounds(508, 153, 82, 25);
        panel_1.add(lblGiiTnh);
        lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 20));

        comboBox_gioiTinh = new JComboBox();
        comboBox_gioiTinh.setBounds(602, 155, 82, 25);
        panel_1.add(comboBox_gioiTinh);
        comboBox_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox_gioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
        comboBox_gioiTinh.setMaximumRowCount(2);

        JLabel label_diaChi = new JLabel("Địa chỉ:");
        label_diaChi.setBounds(508, 0, 68, 25);
        panel_1.add(label_diaChi);
        label_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textArea_diaChi = new JTextArea();
        textArea_diaChi.setBounds(508, 35, 390, 100);
        textArea_diaChi.setBorder(new LineBorder(new Color(0, 128, 255)));
        textArea_diaChi.setLineWrap(true);
        panel_1.add(textArea_diaChi);
        textArea_diaChi.setFont(new Font("Monospaced", Font.PLAIN, 15));

        JPanel panel_table = new JPanel();
        panel_table.setBorder(null);
        panel_noiDung.add(panel_table);
        panel_table.setLayout(new BorderLayout(0, 0));



        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "STT", "Mã khách hàng", "Họ và tên", "Số điện thoại", "Giới tính","Email", "Địa chỉ"
                }

        ){
            @Override
            public boolean isCellEditable(int row, int column) {
                // Trả về false để không cho phép chỉnh sửa ô nào
                return false;
            }
        });

        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        table.setBounds(0, 0, 1, 1);

        table.getColumnModel().getColumn(0).setPreferredWidth(30); //cot stt
        table.getColumnModel().getColumn(1).setPreferredWidth(60); // cot maKH
        table.getColumnModel().getColumn(2).setPreferredWidth(150); // cot ten
        table.getColumnModel().getColumn(3).setPreferredWidth(50); // cot sdt
        table.getColumnModel().getColumn(4).setPreferredWidth(15); // cot gioi tinh
        table.getColumnModel().getColumn(5).setPreferredWidth(100); // cot email
        table.getColumnModel().getColumn(6).setPreferredWidth(300); // cot dia chi

        table.setShowGrid(true);

        this.layToanBoKhachHang();

        JScrollPane scrollPane = new JScrollPane(table);
        panel_table.add(scrollPane);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel_table.add(panel, BorderLayout.NORTH);

        JLabel label_timTen = new JLabel("Tìm theo tên:");
        label_timTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_timTen);

        textField_timTen = new JTextField();
        textField_timTen.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_timTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(textField_timTen);
        textField_timTen.setColumns(15);

        JLabel label_timSDT = new JLabel("Tìm theo số điện thoại:");
        label_timSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_timSDT);

        textField_timSDT = new JTextField();
        textField_timSDT.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_timSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(textField_timSDT);
        textField_timSDT.setColumns(10);

        JButton btn_tim = new JButton("Tìm");
        btn_tim.setForeground(new Color(255, 255, 255));
        btn_tim.setBackground(new Color(0, 128, 255));
        btn_tim.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(btn_tim);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(0, 128, 255)));
        desktopPane.add(panel_2, BorderLayout.WEST);
        panel_2.setLayout(new GridLayout(2, 1, 0, 0));

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3);
        panel_3.setLayout(new GridLayout(3, 1, 0, 0));

        JButton btn_capNhat = new JButton("Cập nhật");
        btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_capNhat.setForeground(new Color(255, 255, 255));
        btn_capNhat.setBackground(new Color(0, 128, 255));
        panel_3.add(btn_capNhat);

        JButton btn_XemLichSu = new JButton("Xem lịch sử đặt vé");
        btn_XemLichSu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_XemLichSu.setForeground(new Color(255, 255, 255));
        btn_XemLichSu.setBackground(new Color(0, 128, 255));
        panel_3.add(btn_XemLichSu);

        JButton btn_lamMoi = new JButton("Làm mới");
        btn_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_lamMoi.setForeground(new Color(255, 255, 255));
        btn_lamMoi.setBackground(new Color(0, 128, 255));
        panel_3.add(btn_lamMoi);

        JLabel label_email = new JLabel("Email:");
        label_email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_email.setBounds(0, 153, 55, 25);
        panel_1.add(label_email);

        textField_email = new JTextField();
        textField_email.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_email.setColumns(15);
        textField_email.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_email.setBounds(152, 145, 296, 45);
        panel_1.add(textField_email);

        JPanel panel_4 = new JPanel();
        panel_2.add(panel_4);
        panel_4.setLayout(new GridLayout(3, 1, 0, 0));

        btn_lamMoiDSKH = new JButton("Làm mới danh sách");
        btn_lamMoiDSKH.setForeground(Color.WHITE);
        btn_lamMoiDSKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_lamMoiDSKH.setBackground(new Color(0, 128, 255));

        panel_4.add(btn_lamMoiDSKH);
        JButton btn_themKH = new JButton("Thêm khách hàng");
        panel_4.add(btn_themKH);



        //*************************ADD ACTION LISTENER*************************

        HanhDong_TrangKhachHang hd = new HanhDong_TrangKhachHang(this);
        btn_lamMoi.addActionListener(hd);
        btn_capNhat.addActionListener(hd);
        table.addMouseListener(hd);
        btn_tim.addActionListener(hd);
        btn_lamMoiDSKH.addActionListener(hd);
        btn_themKH.addActionListener(hd);

        //*************************ADD ACTION LISTENER*************************
    }

    public void hienDanhSachKhachHangRaBang(ArrayList<KhachHang> dsKH) {
        Collections.sort(dsKH, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                return o1.chiLayTen().compareTo(o2.chiLayTen());
            }
        });
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.setRowCount(0);
        int soThuTuTable = 0;
        for (KhachHang kh : dsKH) {
            soThuTuTable++;
            model.addRow(new Object[]{
                    soThuTuTable, kh.getMaKH(), kh.getTenKH(), kh.getSoDT(), kh.getGioiTinh().getValue(), kh.getEmail(), kh.getDiaChi()
            });
        }
        ListSelectionModel selectionModel = this.table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void layToanBoKhachHang() {
        //LAY DATABASE LEN TABLE
        KhachHang_DAO khachHang_dao = new KhachHang_DAO();
        this.dsKH = new ArrayList<>();
        this.dsKH = khachHang_dao.layDanhSachKhachHang_KhangVersion();
        hienDanhSachKhachHangRaBang(this.dsKH);
    }

//    public void chonKhachHang() {
//        int row = table.getSelectedRow();
//        if (row == -1) {
//            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng trong bảng!");
//        } else {
//            label_hienThiMaKH.setText(table.getValueAt(row, 1).toString());
//            textField_HoTen.setText(table.getValueAt(row, 2).toString());
//            textField_SDT.setText(table.getValueAt(row, 3).toString());
//            if(table.getValueAt(row, 4).toString().equals("Nam")){
//                comboBox_gioiTinh.setSelectedIndex(0);
//            } else {
//                comboBox_gioiTinh.setSelectedIndex(1);
//            }
//            textField_email.setText(table.getValueAt(row, 5).toString());
//            textArea_diaChi.setText(table.getValueAt(row, 6).toString());
//        }
//    }


    public static boolean regexSDT(String sdt){
        String regex = "^[0-9]{10}$";
        if(!sdt.matches(regex)){
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
            return false;
        }
        return true;
    }
    public static boolean regexEmail(String email){
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        if(!email.matches(regex)){
            JOptionPane.showMessageDialog(null, "Email không hợp lệ");
            return false;
        }
        return true;
    }
    public static boolean regexTimTen (String tenKH){
        String regex = "^[\\p{L}]+(?:\\s+[\\p{L}'-]+)*$";
        //xoa khoang trang thua giua cac tu

        if(!tenKH.matches(regex)){
            JOptionPane.showMessageDialog(null, "Tên không hợp lệ");
            return false;
        }
        return true;
    }
    public static boolean regexTen(String tenKH){
        String regex = "^[\\p{L}]+(?:\\s+[\\p{L}'-]+)+$";
        //xoa khoang trang thua giua cac tu


        if(!tenKH.matches(regex)){
            JOptionPane.showMessageDialog(null, "Tên không hợp lệ");
            return false;
        }
        return true;
    }
    public static boolean regexDiaChi(String diaChi){
        String regex = "^([\\p{L}0-9\\s,.-]+)?$";

        if(!diaChi.matches(regex)){
            JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ");
            return false;
        }
        return true;
    }



}
