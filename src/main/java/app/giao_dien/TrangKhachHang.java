package app.giao_dien;


import app.dao.KhachHang_DAO;
import app.dieu_khien.HanhDong_TrangKhachHang;
import app.thuc_the.GIOI_TINH;
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

    public static final long serialVersionUID = 1L;
    public final JTextArea textArea_diaChi;
    public final JLabel label_hienThiMaKH;
    public JComboBox comboBox_gioiTinh;
    public JTable table;
    public JTable table_hangCho;
    public JTextField textField_HoTen;
    public JTextField textField_SDT;
    public JTextField textField_timTen;
    public JTextField textField_timSDT;
    public JTextField textField_email;
    public JTextField textField_timEmail;
    public ArrayList<KhachHang> dsKH;
    public static ArrayList<KhachHang> dsHangCho;
    public KhachHang_DAO khDao;

    /**
     * Create the panel.
     */
    public TrangKhachHang() {
        khDao = new KhachHang_DAO();
        HanhDong_TrangKhachHang hanhDong_trangKhachHang = new HanhDong_TrangKhachHang(this);

        setBorder(new LineBorder(new Color(0, 128, 255), 1, true));
        setSize(1400, 700);
        setLayout(new BorderLayout(0, 0));

        JLabel label_quanLyKH = new JLabel("<html><u>QUẢN LÝ KHÁCH HÀNG</u></html>");
        label_quanLyKH.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        label_quanLyKH.setBackground(new Color(0, 64, 128));
        label_quanLyKH.setForeground(new Color(0, 128, 255));
        label_quanLyKH.setHorizontalAlignment(SwingConstants.CENTER);
        label_quanLyKH.setFont(new Font("Bahnschrift", Font.BOLD, 40));
        add(label_quanLyKH);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setForeground(new Color(0, 0, 128));
        desktopPane.setBackground(new Color(0, 0, 128));
        add(desktopPane);
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
        panel_1.setBounds(10, 64, 980, 185);
        panel_thongTinKH.add(panel_1);
        panel_1.setLayout(null);

        JLabel label_maKH = new JLabel("Mã khách hàng:");
        label_maKH.setBounds(0, 0, 142, 25);
        panel_1.add(label_maKH);
        label_maKH.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textField_HoTen = new JTextField();
        textField_HoTen.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_HoTen.setBounds(152, 45, 227, 24);
        panel_1.add(textField_HoTen);
        textField_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_HoTen.setColumns(15);

        label_hienThiMaKH = new JLabel("<mã khách hàng>");
        label_hienThiMaKH.setBounds(152, 0, 152, 22);
        panel_1.add(label_hienThiMaKH);
        label_hienThiMaKH.setFont(new Font("Tahoma", Font.PLAIN, 18));

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
        textField_SDT.setBounds(152, 103, 227, 24);
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
        label_diaChi.setBounds(508, 44, 68, 25);
        panel_1.add(label_diaChi);
        label_diaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));

        textArea_diaChi = new JTextArea();
        textArea_diaChi.setBounds(589, 35, 390, 100);
        textArea_diaChi.setBorder(new LineBorder(new Color(0, 128, 255)));
        textArea_diaChi.setLineWrap(true);
        panel_1.add(textArea_diaChi);
        textArea_diaChi.setFont(new Font("Monospaced", Font.PLAIN, 15));

        JLabel label_email = new JLabel("Email:");
        label_email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_email.setBounds(0, 153, 55, 25);
        panel_1.add(label_email);

        textField_email = new JTextField();
        textField_email.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_email.setColumns(15);
        textField_email.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_email.setBounds(152, 157, 227, 24);
        panel_1.add(textField_email);

        JButton btn_capNhat = new JButton("Cập nhật");
        btn_capNhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_capNhat.setBounds(10, 10, 115, 33);
        panel_thongTinKH.add(btn_capNhat);

        JButton btn_lamMoi = new JButton("Làm mới");
        btn_lamMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_lamMoi.setBounds(135, 10, 115, 33);
        panel_thongTinKH.add(btn_lamMoi);

        JButton btn_themKH = new JButton("Thêm khách hàng");
        btn_themKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_themKH.setBounds(10, 269, 191, 33);
        panel_thongTinKH.add(btn_themKH);

        table_hangCho = new JTable();

        table_hangCho.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Mã khách hàng","Tên khách hàng"
                }
        ));


        JScrollPane scrollPane_1 = new JScrollPane(table_hangCho);
        scrollPane_1.setBounds(1123, 64, 372, 185);
        panel_thongTinKH.add(scrollPane_1);

        JLabel lblNewLabel = new JLabel("Hàng chờ:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(1123, 14, 92, 25);
        panel_thongTinKH.add(lblNewLabel);

        JButton btn_themHangCho = new JButton("Thêm vào hàng chờ");
        btn_themHangCho.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_themHangCho.setBounds(211, 269, 209, 33);
        panel_thongTinKH.add(btn_themHangCho);

        JButton btn_datVe = new JButton("Đặt vé");
        btn_datVe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_datVe.setBounds(1123, 269, 115, 33);
        panel_thongTinKH.add(btn_datVe);

        JButton btn_xoaKhoiHangCho = new JButton("Xoá khỏi hàng");
        btn_xoaKhoiHangCho.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btn_xoaKhoiHangCho.setBounds(1248, 269, 159, 33);
        panel_thongTinKH.add(btn_xoaKhoiHangCho);

        JPanel panel_table = new JPanel();
        panel_table.setBorder(null);
        panel_noiDung.add(panel_table);
        panel_table.setLayout(new BorderLayout(0, 0));

        table = new JTable();

        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "STT", "M\u00E3 kh\u00E1ch h\u00E0ng", "H\u1ECD v\u00E0 t\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Gi\u1EDBi t\u00EDnh", "Email", "Địa chỉ"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);

        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setBounds(0, 0, 1, 1);
        //khong cho chinh sua noi dung trong bang
        table.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(table);
        panel_table.add(scrollPane);

        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        panel.setBorder(null);
        panel_table.add(panel, BorderLayout.NORTH);

        JLabel label_timTen = new JLabel("Tìm tên:");
        label_timTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_timTen);

        textField_timTen = new JTextField();
        textField_timTen.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_timTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(textField_timTen);
        textField_timTen.setColumns(15);

        JLabel label_timSDT = new JLabel("Tìm số điện thoại:");
        label_timSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_timSDT);

        textField_timSDT = new JTextField();
        textField_timSDT.setBorder(new LineBorder(new Color(0, 128, 255)));
        textField_timSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(textField_timSDT);
        textField_timSDT.setColumns(10);

        JLabel label_timEmail = new JLabel("Tìm email:");
        label_timEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(label_timEmail);

        textField_timEmail = new JTextField();
        textField_timEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_timEmail.setColumns(15);
        textField_timEmail.setBorder(new LineBorder(new Color(0, 128, 255)));
        panel.add(textField_timEmail);

        JPanel panel_2 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
        flowLayout_1.setAlignment(FlowLayout.RIGHT);
        panel.add(panel_2);

        JButton btn_tim = new JButton("Tìm");
        panel_2.add(btn_tim);
        btn_tim.setForeground(new Color(255, 255, 255));
        btn_tim.setBackground(new Color(0, 128, 255));
        btn_tim.setFont(new Font("Tahoma", Font.PLAIN, 15));

        JButton btn_lamTrongDanhSach = new JButton("Làm trống danh sách");
        panel.add(btn_lamTrongDanhSach);
        btn_lamTrongDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton btn_xemToanBo = new JButton("Xem toàn bộ");
        btn_xemToanBo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(btn_xemToanBo);

        btn_tim.addActionListener( hanhDong_trangKhachHang);
        btn_lamTrongDanhSach.addActionListener(hanhDong_trangKhachHang);
        btn_xemToanBo.addActionListener(hanhDong_trangKhachHang);
        btn_lamMoi.addActionListener(hanhDong_trangKhachHang);
        btn_capNhat.addActionListener(hanhDong_trangKhachHang);
        btn_themKH.addActionListener(hanhDong_trangKhachHang);
        btn_themHangCho.addActionListener(hanhDong_trangKhachHang);
        btn_datVe.addActionListener(hanhDong_trangKhachHang);
        btn_xoaKhoiHangCho.addActionListener(hanhDong_trangKhachHang);

        table.addMouseListener(hanhDong_trangKhachHang);

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
    public JTable clearTable(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        return table;
    }

    public void layToanBoKhachHang() {
        //LAY DATABASE LEN TABLE
        KhachHang_DAO khachHang_dao = new KhachHang_DAO();
        this.dsKH = new ArrayList<KhachHang>();
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
            JOptionPane.showMessageDialog(null, "Số điện thoại phải đủ 10 số và không có ký tự đặc biệt!");
            return false;
        }
        return true;
    }
    public static boolean regexEmail(String email){
        String regex = "(^$)|(^[a-zA-ZÀ-ỹ0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$)";

        if(!email.matches(regex)){
            JOptionPane.showMessageDialog(null, "Email không được có khoảng trắng hoặc ký tự đặc biệt!");
            return false;
        }
        return true;
    }
    public static boolean regexTimTen (String tenKH){
        String regex = "^[\\p{L}]+(?:\\s+[\\p{L}'-]+)*$";
        //xoa khoang trang thua giua cac tu

        if(!tenKH.matches(regex)){
            JOptionPane.showMessageDialog(null, "Tên không được có ký tự đặc biệt hoặc số!");
            return false;
        }
        return true;
    }
    public static boolean regexTen(String tenKH){
        String regex = "^[\\p{L}]+(?:\\s+[\\p{L}'-]+)+$";
        //xoa khoang trang thua giua cac tu


        if(!tenKH.matches(regex)){
            JOptionPane.showMessageDialog(null, "Tên không được có ký tự đặc biệt, số hoặc chỉ có một từ!");
            return false;
        }
        return true;
    }
    public static boolean regexDiaChi(String diaChi){
        String regex = "^([\\p{L}0-9\\s,.-]+)?$";

        if(!diaChi.matches(regex)){
            JOptionPane.showMessageDialog(null, "Địa chỉ không được có ký tự đặc biệt!");
            return false;
        }
        return true;
    }

    public void hienKhachHangVuaThem(KhachHang khachHang){
        clearTable(table);
        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
        model.addRow(new Object[]{
                model.getRowCount() + 1, khachHang.getMaKH(), khachHang.getTenKH(), khachHang.getSoDT(), khachHang.getGioiTinh().getValue(), khachHang.getEmail(), khachHang.getDiaChi()
        });
    }

    public void themVaoHangCho(){
        String maKH = this.label_hienThiMaKH.getText();

        if(maKH.equals("<mã khách hàng>")) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng!");
            return;
        }

        String tenKH = this.textField_HoTen.getText();
        for(int i = 0; i < this.table_hangCho.getRowCount(); i++){
            if (this.table_hangCho.getValueAt(i, 0).equals(maKH)){
                JOptionPane.showMessageDialog(null, "Khách hàng đã có trong hàng chờ!");
                return;
            }
        }
        DefaultTableModel model = (DefaultTableModel) this.table_hangCho.getModel();
        model.addRow(new Object[]{maKH,tenKH});

    }



}
