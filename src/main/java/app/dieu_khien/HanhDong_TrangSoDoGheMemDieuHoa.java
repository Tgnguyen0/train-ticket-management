package app.dieu_khien;

import app.giao_dien.TrangSoDoGheMem;
import app.phong_chu_moi.PhongChuMoi;
import app.thuc_the.Ghe;
import app.thuc_the.TRANG_THAI_GHE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HanhDong_TrangSoDoGheMemDieuHoa implements ActionListener, MouseListener {
    TrangSoDoGheMem trangSoDoGheMemDieuHoa;
    PhongChuMoi phongTuyChinh = new PhongChuMoi();
    String soGhe;

    public HanhDong_TrangSoDoGheMemDieuHoa(TrangSoDoGheMem trangSoDoGheMemDieuHoa) {
        this.trangSoDoGheMemDieuHoa = trangSoDoGheMemDieuHoa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton nutGhe = (JButton) e.getSource();
        int soGhe = Integer.parseInt(nutGhe.getActionCommand()) - 1; // -1 để chuyển từ ghế số sang chỉ số mảng
        Ghe ghe = this.trangSoDoGheMemDieuHoa.dsGhe.get(soGhe);

        System.out.println("Ghe mem " + "TRC THEM: " + ghe.getSoGhe() + " " + ghe.getMaToa());
        /*if (!this.trangSoDoGheMemDieuHoa.gheDao.layDSGheDat().isEmpty()) {
            for (Ghe gheTest : this.trangSoDoGheMemDieuHoa.gheDao.layDSGheDat()) {
                System.out.println("Ghe mem " + "TRC IF: " + gheTest.getSoGhe() + " " + gheTest.getMaToa());
            }
        }  else {
            System.out.println("Ghe mem rong");
        }*/

        // Nếu ghế đang trống, cho phép chọn hoặc bỏ chọn
        if (ghe.getTrangThai() == TRANG_THAI_GHE.Trong) {
            // Nếu ghế đã chọn rồi, bỏ chọn (xóa khỏi Set và đổi màu lại)
            if (this.trangSoDoGheMemDieuHoa.gheDao.layDSGheDat().contains(ghe)) {
                this.trangSoDoGheMemDieuHoa.gheDao.layDSGheDat().remove(ghe);

                if (!this.trangSoDoGheMemDieuHoa.gheDao.layDSGheDat().isEmpty()) {
                    for (Ghe gheTest : this.trangSoDoGheMemDieuHoa.gheDao.layDSGheDat()) {
                        System.out.println("Ghe mem " + "XOA GHE: " + gheTest.getSoGhe() + " " + gheTest.getMaToa());
                    }
                }  else {
                    System.out.println("Ghe mem rong");
                }


                nutGhe.setBackground(this.trangSoDoGheMemDieuHoa.xanhBrandeis);
            } else {
                //System.out.println(ghe.getMaGhe());
                //System.out.println(ghe.getSoGhe());
                //System.out.println(ghe.getMaToa());
                this.trangSoDoGheMemDieuHoa.gheDao.layDSGheDat().add(ghe);
                this.trangSoDoGheMemDieuHoa.gheDao.datGheChon(ghe);

                if (!this.trangSoDoGheMemDieuHoa.gheDao.layDSGheDat().isEmpty()) {
                    for (Ghe gheTest : this.trangSoDoGheMemDieuHoa.gheDao.layDSGheDat()) {
                        System.out.println("Ghe mem " + "THEM GHE: " + gheTest.getSoGhe() + " " + gheTest.getMaToa());
                    }
                }  else {
                    System.out.println("Ghe mem rong");
                }

                nutGhe.setBackground(this.trangSoDoGheMemDieuHoa.camNhuomDen);
            }
        } else {
            hienThiThongBao("Ghế đã đặt.", "Lỗi Chọn Ghế");
        }

        for (Ghe gheTest : this.trangSoDoGheMemDieuHoa.gheDao.layDSGheDat()) {
            System.out.println("Ghe mem " + "SAU CUNG: " + gheTest.getSoGhe() + " " + gheTest.getMaToa());
        }
    }

    // Phương thức hiển thị thông báo lỗi chung
    private void hienThiThongBao(String chuThich, String tieuDe) {
        JLabel thongBao = new JLabel(chuThich);
        thongBao.setFont(this.trangSoDoGheMemDieuHoa.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

        JOptionPane hienThiLoi = new JOptionPane(thongBao, JOptionPane.ERROR_MESSAGE);
        hienThiLoi.setForeground(this.trangSoDoGheMemDieuHoa.xanhBrandeis);

        JDialog hoiThoai = hienThiLoi.createDialog(tieuDe);
        ImageIcon bieuTuongTau = new ImageIcon("assets/icon.png");
        hoiThoai.setIconImage(bieuTuongTau.getImage());
        hoiThoai.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton nutDaChon = (JButton) e.getComponent();
        nutDaChon.setBackground(new Color(this.trangSoDoGheMemDieuHoa.xanhNhat.getRGB())); // Thay đổi màu khi hover
        nutDaChon.setBorder(this.trangSoDoGheMemDieuHoa.vienNhat);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton exitedButton = (JButton) e.getComponent();
        exitedButton.setBackground(new Color(this.trangSoDoGheMemDieuHoa.xanhBrandeis.getRGB())); // Khôi phục màu ban đầu khi di chuột ra khỏi nút
        exitedButton.setBorder(this.trangSoDoGheMemDieuHoa.vienDam);
    }
}
