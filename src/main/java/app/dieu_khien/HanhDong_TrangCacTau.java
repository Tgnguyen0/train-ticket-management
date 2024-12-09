package app.dieu_khien;

import app.dao.Tau_DAO;
import app.dao.Toa_DAO;
import app.giao_dien.*;
import app.phan_tu_tuy_chinh.NutAnh;
import app.thuc_the.Ghe;
import app.thuc_the.LichCapBenGa;
import app.thuc_the.TRANG_THAI_GHE;
import app.thuc_the.Toa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class HanhDong_TrangCacTau implements ActionListener, MouseListener, WindowListener {
    TrangCacTau trangSoDoChung;

    public HanhDong_TrangCacTau(TrangCacTau trangSoDoChung) {
        this.trangSoDoChung = trangSoDoChung;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cardLayout = (CardLayout) this.trangSoDoChung.trangChua.getLayout();
        String command = e.getActionCommand();

        switch (command) {
            case "VN5234":
                cardLayout.show(this.trangSoDoChung.trangChua, "Cac toa cua tau 1");
                break;
            case "VN5947":
                cardLayout.show(this.trangSoDoChung.trangChua, "Cac toa cua tau 2");
                break;
            case "VN7283":
                cardLayout.show(this.trangSoDoChung.trangChua, "Cac toa cua tau 3");
                break;
            case "VN9029":
                cardLayout.show(this.trangSoDoChung.trangChua, "Cac toa cua tau 4");
                break;
        }

        if (e.getSource() == this.trangSoDoChung.nutTau1) {
            this.trangSoDoChung.soHieuTauChon = this.trangSoDoChung.nutTau1.getActionCommand();
        }

        if (e.getSource() == this.trangSoDoChung.nutTau2) {
            this.trangSoDoChung.soHieuTauChon = this.trangSoDoChung.nutTau2.getActionCommand();
        }

        if (e.getSource() == this.trangSoDoChung.nutTau3) {
            this.trangSoDoChung.soHieuTauChon = this.trangSoDoChung.nutTau3.getActionCommand();
        }

        if (e.getSource() == this.trangSoDoChung.nutTau4) {
            this.trangSoDoChung.soHieuTauChon = this.trangSoDoChung.nutTau4.getActionCommand();
        }

        if (e.getSource() == this.trangSoDoChung.nutXacNhan) {
            if (!this.trangSoDoChung.gheDao.layDSGheDat().isEmpty()) {
                hienThiThongBao("Xác nhận ghế chọn thành công !", "Xác nhận thành công", JOptionPane.INFORMATION_MESSAGE);
                if (this.trangSoDoChung.trangGoc instanceof TrangDatVe) {
                    //((TrangDatVe) this.trangSoDoChung.trangGoc).datSoHieuDaChon(this.trangSoDoChung.soHieuTauChon);

                    LocalDateTime ngayKhoiHanh = ((TrangDatVe) this.trangSoDoChung.trangGoc).thanhNhapNgayDi.getDate()       // Lấy ngày khởi hành
                            .toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime();

                    // Lấy lịch tàu đó
                    LichCapBenGa lich = ((TrangDatVe) this.trangSoDoChung.trangGoc).lichDao.ChonTheoSoHieuNgayKHVaGa(
                            this.trangSoDoChung.soHieuTauChon,
                            ngayKhoiHanh,
                            this.trangSoDoChung.maGa
                    );

                    ((TrangDatVe) this.trangSoDoChung.trangGoc).thanhNhapGioDen.setText(lich.getGioKhoiHanh().getHour() +
                            ":" + lich.getGioKhoiHanh().getMinute());
                }

                if (this.trangSoDoChung.trangKhung instanceof TrangThongTinChiTietVeTau) {

                    for (Ghe ghe : this.trangSoDoChung.gheDao.layDSGheDat()) {

                        // Cập nhật lại số của ghế đã đặt
                        ((TrangThongTinChiTietVeTau) this.trangSoDoChung.trangKhung).textFieldGhe.setText(ghe.getSoGhe());

                        // Cập nhật lại loại ghế đã đặt
                        ((TrangThongTinChiTietVeTau) this.trangSoDoChung.trangKhung).textFieldLoaiVe.setText(ghe.getLoaiGhe().toString());

                        Toa toa = this.trangSoDoChung.toaDao.ChonTheoMa(ghe.getMaToa());

                        // Cập nhật lại tên toa của ghế đã đặt
                        ((TrangThongTinChiTietVeTau) this.trangSoDoChung.trangKhung).textFieldToa.setText(toa.getTenToa());

                        // Cập nhật lại số hiệu tàu mà toa thuộc về mà có ghế đã đặt
                        ((TrangThongTinChiTietVeTau) this.trangSoDoChung.trangKhung).textFieldSoHieu.setText(toa.getMaTau());
                    }
                }
            } else {
                //hienThiThongBao("Chưa có chọn ghế !", "Lỗi chọn ghế", JOptionPane.ERROR_MESSAGE);

                //((javax.swing.JFrame) e.getWindow()).setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            }

            this.trangSoDoChung.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();

        if (source == this.trangSoDoChung.nutTau1) {
            if (!this.trangSoDoChung.nutTau1.isEnabled()) {
                hienThiThongBao("Tàu không qua ga này vào ngày bạn chọn", "Lỗi lịch tàu", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Đặt ảnh cho nút tau1 và đặt lại ảnh gốc cho các nút còn lại
            this.trangSoDoChung.nutTau1.datAnhDangChon();

            if (!this.trangSoDoChung.nutTau2.isEnabled()) {
                this.trangSoDoChung.nutTau2.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau2.datAnhMacDinh();
            }

            if (!this.trangSoDoChung.nutTau3.isEnabled()) {
                this.trangSoDoChung.nutTau3.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau3.datAnhMacDinh();
            }

            if (!this.trangSoDoChung.nutTau4.isEnabled()) {
                this.trangSoDoChung.nutTau4.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau4.datAnhMacDinh();
            }
        }

        if (source == this.trangSoDoChung.nutTau2) {

            if (!this.trangSoDoChung.nutTau2.isEnabled()) {
                hienThiThongBao("Tàu không qua ga này vào ngày bạn chọn", "Lỗi lịch tàu", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Đặt ảnh cho nút tau2 và đặt lại ảnh gốc cho các nút còn lại
            this.trangSoDoChung.nutTau2.datAnhDangChon();

            if (!this.trangSoDoChung.nutTau1.isEnabled()) {
                this.trangSoDoChung.nutTau1.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau1.datAnhMacDinh();
            }

            if (!this.trangSoDoChung.nutTau3.isEnabled()) {
                this.trangSoDoChung.nutTau3.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau3.datAnhMacDinh();
            }

            if (!this.trangSoDoChung.nutTau4.isEnabled()) {
                this.trangSoDoChung.nutTau4.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau4.datAnhMacDinh();
            }
        }

        if (source == this.trangSoDoChung.nutTau3) {
            if (!this.trangSoDoChung.nutTau3.isEnabled()) {
                hienThiThongBao("Tàu không qua ga này vào ngày bạn chọn", "Lỗi lịch tàu", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Đặt ảnh cho nút tau3 và đặt lại ảnh gốc cho các nút còn lại
            this.trangSoDoChung.nutTau3.datAnhDangChon();

            if (!this.trangSoDoChung.nutTau1.isEnabled()) {
                this.trangSoDoChung.nutTau1.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau1.datAnhMacDinh();
            }

            if (!this.trangSoDoChung.nutTau2.isEnabled()) {
                this.trangSoDoChung.nutTau2.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau2.datAnhMacDinh();
            }

            if (!this.trangSoDoChung.nutTau4.isEnabled()) {
                this.trangSoDoChung.nutTau4.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau4.datAnhMacDinh();
            }
        }

        if (source == this.trangSoDoChung.nutTau4) {
            if (!this.trangSoDoChung.nutTau4.isEnabled()) {
                hienThiThongBao("Tàu không qua ga này vào ngày bạn chọn", "Lỗi lịch tàu", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Đặt ảnh cho nút tau4 và đặt lại ảnh gốc cho các nút còn lại
            this.trangSoDoChung.nutTau4.datAnhDangChon();

            if (!this.trangSoDoChung.nutTau1.isEnabled()) {
                this.trangSoDoChung.nutTau1.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau1.datAnhMacDinh();
            }

            if (!this.trangSoDoChung.nutTau2.isEnabled()) {
                this.trangSoDoChung.nutTau2.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau2.datAnhMacDinh();
            }

            if (!this.trangSoDoChung.nutTau3.isEnabled()) {
                this.trangSoDoChung.nutTau3.datAnhVoHieu();
            } else {
                this.trangSoDoChung.nutTau3.datAnhMacDinh();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Không sử dụng
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Không sử dụng
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Không sử dụng
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Không sử dụng
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // Tạo JLabel đầu tiên
        JLabel tieuDe1 = new JLabel("Bạn có chắc chắn muốn đóng cửa sổ không?");
        tieuDe1.setFont(this.trangSoDoChung.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 13)); // Cài đặt font nếu cần

        // Tạo JLabel thứ hai với màu đỏ
        JLabel tieuDe2 = new JLabel("Vì các ghế bạn chọn sẽ không được lưu!");
        tieuDe2.setFont(this.trangSoDoChung.phongTuyChinh.layPhongRobotoMonoReg(Font.BOLD, 13)); // Font in đậm
        tieuDe2.setForeground(Color.RED); // Màu đỏ

        // Tạo JPanel và thêm 2 JLabel vào
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Xếp các thành phần theo chiều dọc
        panel.add(tieuDe1);
        panel.add(tieuDe2);

        // Hiển thị JOptionPane với JPanel tùy chỉnh
        int xacNhan = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Xác nhận thoát",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE
        );

        // Xử lý phản hồi
        if (xacNhan == JOptionPane.YES_OPTION) {
            ((JFrame) e.getWindow()).dispose();
        } else {
            ((JFrame) e.getWindow()).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
        if (!this.trangSoDoChung.nutTau1.isEnabled() && !this.trangSoDoChung.nutTau2.isEnabled() &&
                !this.trangSoDoChung.nutTau3.isEnabled() && !this.trangSoDoChung.nutTau4.isEnabled()) {
            e.getWindow().dispose();

            hienThiThongBao("Ngày này không có tàu chạy qua !", "Lỗi chọn ngày", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    private void hienThiThongBao(String chuThich, String tieuDe, int message) {
        JLabel thongBao = new JLabel(chuThich);
        thongBao.setFont(this.trangSoDoChung.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

        JOptionPane hienThiLoi = new JOptionPane(thongBao, message);
        hienThiLoi.setForeground(this.trangSoDoChung.xanhBrandeis);

        JDialog hoiThoai = hienThiLoi.createDialog(tieuDe);
        ImageIcon bieuTuongTau = new ImageIcon("assets/icon.png");
        hoiThoai.setIconImage(bieuTuongTau.getImage());
        hoiThoai.setVisible(true);
    }
}
