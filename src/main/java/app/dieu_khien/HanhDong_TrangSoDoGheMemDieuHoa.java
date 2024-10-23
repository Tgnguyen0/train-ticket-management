package app.dieu_khien;

import app.giao_dien.TrangSoDoGheMem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HanhDong_TrangSoDoGheMemDieuHoa implements ActionListener, MouseListener {
    TrangSoDoGheMem trangSoDoGheMemDieuHoa;
    String soGhe;

    public HanhDong_TrangSoDoGheMemDieuHoa(TrangSoDoGheMem trangSoDoGheMemDieuHoa) {
        this.trangSoDoGheMemDieuHoa = trangSoDoGheMemDieuHoa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton nutGhe = (JButton) e.getSource();
        String ghe = nutGhe.getText();

        // Nếu ghế đã chọn rồi, bỏ chọn (xóa khỏi Set và đổi màu lại)
        if (this.trangSoDoGheMemDieuHoa.gheDao.layDsGhe().contains(ghe)) {
            this.trangSoDoGheMemDieuHoa.gheDao.xoaGhe(ghe);
            nutGhe.setBackground(this.trangSoDoGheMemDieuHoa.xanhBrandeis);
        }
        // Nếu ghế chưa chọn, thêm vào Set và đổi màu thành đỏ (giới hạn 10 ghế)
        else {
            if (this.trangSoDoGheMemDieuHoa.gheDao.layDsGhe().size() < 10) {
                this.trangSoDoGheMemDieuHoa.gheDao.themGhe(ghe);
                nutGhe.setBackground(this.trangSoDoGheMemDieuHoa.doDo);
            } else {
                JOptionPane.showMessageDialog(this.trangSoDoGheMemDieuHoa, "Bạn chỉ có thể chọn tối đa 10 ghế.");
            }
        }

        System.out.println("Ghe da chon (Ghe Mem): " + this.trangSoDoGheMemDieuHoa.gheDao.layDsGhe());
        System.out.println(ghe);
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

    public String laySoGhe() {
        return this.soGhe;
    }
}
