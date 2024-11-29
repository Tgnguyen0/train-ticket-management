package app.giao_dien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class TrangLichSuTruc extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrangLichSuTruc frame = new TrangLichSuTruc();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TrangLichSuTruc() {
        setSize(1120, 848);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_lichSuTruc = new JLabel("Lịch sử trực");
        label_lichSuTruc.setBounds(5, 5, 1101, 49);
        label_lichSuTruc.setHorizontalAlignment(SwingConstants.CENTER);
        label_lichSuTruc.setFont(new Font("Tahoma", Font.PLAIN, 40));
        contentPane.add(label_lichSuTruc);

        JLabel label_maNV = new JLabel("Mã nhân viên:");
        label_maNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label_maNV.setBounds(5, 76, 154, 31);
        contentPane.add(label_maNV);

        JSeparator separator = new JSeparator();
        separator.setBounds(5, 64, 1101, 2);
        contentPane.add(separator);

        JLabel label_hienMaNV = new JLabel("<<mã nhân viên>>");
        label_hienMaNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label_hienMaNV.setBounds(169, 76, 221, 31);
        contentPane.add(label_hienMaNV);

        JLabel label_tenNV = new JLabel("Tên nhân viên:");
        label_tenNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label_tenNV.setBounds(467, 76, 163, 31);
        contentPane.add(label_tenNV);

        JLabel label_hienTenNV = new JLabel("<<tên nhân viên>>");
        label_hienTenNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label_hienTenNV.setBounds(640, 76, 222, 31);
        contentPane.add(label_hienTenNV);

        JTable table = new JTable();

        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "STT", "Mã ca", "Thời gian bắt đầu", "Thời gian kết ca"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);


        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setBounds(0, 0, 1, 1);

        JScrollPane scrollPane_table = new JScrollPane(table);
        scrollPane_table.setBounds(5, 489, 1101, 322);
        contentPane.add(scrollPane_table);

        JPanel panel_chiTietCaTruc = new JPanel();
        panel_chiTietCaTruc.setBorder(new TitledBorder(null, "Chi ti\u1EBFt ca tr\u1EF1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_chiTietCaTruc.setBounds(5, 152, 1101, 287);
        contentPane.add(panel_chiTietCaTruc);
        panel_chiTietCaTruc.setLayout(null);

        JLabel labe_tongHD = new JLabel("Tổng hoá đơn:");
        labe_tongHD.setBounds(10, 34, 162, 31);
        panel_chiTietCaTruc.add(labe_tongHD);
        labe_tongHD.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_hienTongHD = new JLabel("<<Tổng hoá đơn>>");
        label_hienTongHD.setBounds(182, 34, 226, 31);
        panel_chiTietCaTruc.add(label_hienTongHD);
        label_hienTongHD.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_tongTienCaTruoc = new JLabel("Tổng tiền ca trước:");
        label_tongTienCaTruoc.setBounds(10, 75, 215, 31);
        panel_chiTietCaTruc.add(label_tongTienCaTruoc);
        label_tongTienCaTruoc.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_hienTienCaTruoc = new JLabel("<<Tổng tiền ca trước>>");
        label_hienTienCaTruoc.setBounds(235, 75, 274, 31);
        panel_chiTietCaTruc.add(label_hienTienCaTruoc);
        label_hienTienCaTruoc.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_tongTienHT = new JLabel("Tổng tiền hệ thống:");
        label_tongTienHT.setBounds(10, 116, 226, 31);
        panel_chiTietCaTruc.add(label_tongTienHT);
        label_tongTienHT.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_hienTongTienHT = new JLabel("<<Tổng tiền hệ thống>>");
        label_hienTongTienHT.setBounds(235, 116, 282, 31);
        panel_chiTietCaTruc.add(label_hienTongTienHT);
        label_hienTongTienHT.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_tongTienThucThu = new JLabel("Tổng tiền thực thu:");
        label_tongTienThucThu.setBounds(10, 157, 226, 31);
        panel_chiTietCaTruc.add(label_tongTienThucThu);
        label_tongTienThucThu.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_hienTongThucThu = new JLabel("<<Tổng tiền thực thu>>");
        label_hienTongThucThu.setBounds(235, 157, 282, 31);
        panel_chiTietCaTruc.add(label_hienTongThucThu);
        label_hienTongThucThu.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_chenhLech = new JLabel("Chênh lệch:");
        label_chenhLech.setBounds(57, 227, 159, 37);
        panel_chiTietCaTruc.add(label_chenhLech);
        label_chenhLech.setFont(new Font("Tahoma", Font.PLAIN, 30));

        JLabel label_hienChenhLech = new JLabel("<<Chênh lệch>>");
        label_hienChenhLech.setBounds(235, 227, 238, 37);
        panel_chiTietCaTruc.add(label_hienChenhLech);
        label_hienChenhLech.setFont(new Font("Tahoma", Font.PLAIN, 30));

        JLabel label_tongVAT = new JLabel("Tổng tiền thuế VAT:");
        label_tongVAT.setBounds(556, 34, 221, 31);
        panel_chiTietCaTruc.add(label_tongVAT);
        label_tongVAT.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_hienTongVAT = new JLabel("<<Tổng tiền thuế>>");
        label_hienTongVAT.setBounds(787, 34, 274, 31);
        panel_chiTietCaTruc.add(label_hienTongVAT);
        label_hienTongVAT.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_tongGiamGia = new JLabel("Tổng tiền giảm giá:");
        label_tongGiamGia.setBounds(556, 75, 213, 31);
        panel_chiTietCaTruc.add(label_tongGiamGia);
        label_tongGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 25));

        JLabel label_hienTongGiamGia = new JLabel("<<Tổng giảm giá>>");
        label_hienTongGiamGia.setBounds(787, 75, 230, 31);
        panel_chiTietCaTruc.add(label_hienTongGiamGia);
        label_hienTongGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 25));
    }
}
