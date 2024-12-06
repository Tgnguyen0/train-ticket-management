package app.dieu_khien;

import app.dao.ChiTietHoaDon_DAO;
import app.giao_dien.TrangDatVe;
import app.giao_dien.TrangDinhHuong;
import app.giao_dien.TrangHoaDon;
import app.giao_dien.TrangThanhToan;
import app.phan_tu_tuy_chinh.TaoMaQR;
import app.thuc_the.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class HanhDong_TrangThanhToan implements ActionListener, MouseListener {
    TrangThanhToan trangThanhToan;
    Double tongTien;

    public HanhDong_TrangThanhToan(TrangThanhToan trangThanhToan) { this.trangThanhToan = trangThanhToan; }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Nếu chọn tiền mặt thì radioChuyenKhoan bỏ chọn
        if (e.getSource() == this.trangThanhToan.radioTienMat) {
            this.trangThanhToan.radioChuyenKhoan.setSelected(false);
        }

        // Nếu chọn chuyển khoản thì radioTienMat bỏ chọn
        if (e.getSource() == this.trangThanhToan.radioChuyenKhoan) {
            this.trangThanhToan.radioTienMat.setSelected(false);
        }

        // Nếu chọn tiền mặt và bấm nút thanh toán
        if (e.getSource() == this.trangThanhToan.ButtonThanhToan && this.trangThanhToan.radioTienMat.isSelected()) {
            xuLyThanhToan(true);
        }

        // Nếu chọn chuyển khoản và bấm nút thanh toán
        if (e.getSource() == this.trangThanhToan.ButtonThanhToan && this.trangThanhToan.radioChuyenKhoan.isSelected()) {
            xuLyThanhToan(false);
        }
    }

    public void xuLyThanhToan(boolean thanhToanTienMat) {
        double thanhTien = Double.parseDouble(this.trangThanhToan.tfThanhTien.getText());
        double tienNhan = Double.parseDouble(this.trangThanhToan.thanhTienNhan.getText());

        if (thanhTien > tienNhan) {
            hienThiThongBao("Tiền nhận phải lớn hơn tiền trả", "Lỗi nhận tiền", JOptionPane.ERROR_MESSAGE);

            return;
        }

        double tienTra = tienNhan - thanhTien;

        this.trangThanhToan.tfTraLai.setText(String.valueOf(tienTra));

        double tongTien = 0;
        for (int i = 0 ; i < this.trangThanhToan.danhSachVe.size() ; i++) {
            tongTien += this.trangThanhToan.danhSachVe.get(i).getGiaVe() * (1 - (this.trangThanhToan.danhSachVe.get(i).getLoaiDoiTuong().equals("Người Lớn") ? 0.0 : 0.025));
        }

        String maNV = this.trangThanhToan.layMaNV();

        HoaDon hd = new HoaDon(
                LocalDate.now(),
                thanhTien,
                this.trangThanhToan.dsKh.get(0).getMaKH(),
                maNV,
                this.trangThanhToan.danhSachVe.size(),
                tongTien,
                "Chưa In",
                this.trangThanhToan.daiNgo,
                0
        );

        if (!thanhToanTienMat) {
            // Tạo thông tin thanh toán
            String thongTinThanhToan = "Toi Tai Khoan:\n"
                    + "CONG TY CO PHAN DUONG SAT SAI GON\n"
                    + "ABCBank\n"
                    + "0123456789\n"
                    + "Thanh Tien: " + this.trangThanhToan.tfThanhTien.getText() + "\n"
                    + "Loi Nhan: T.Toan QR - tai Ga Go Vap GV - " + this.trangThanhToan.tfThanhTien.getText() + " - Ngay " + LocalDateTime.now();

            // Hiển thị mã QR với thông tin thanh toán mới khỏi tạo
            hienThiMaQR(thongTinThanhToan, "Thanh toán qua QR");
        }

        // Lưu hóa đơn vào cơ sở dữ liệu
        //this.trangThanhToan.hdDao.LuuHoaDon(hd);

        // Lưu vé vào Database
        /*for (Ve ve : this.trangThanhToan.danhSachVe) {
            ((TrangDatVe) this.trangThanhToan.trangDatVe).veDao.luuVe(ve);
        }*/

        // Lưu chi tiết hóa đơn
        /*for (Ve ve : this.trangThanhToan.danhSachVe) {
            ChiTietHoaDon cthd = new ChiTietHoaDon(ve.getMaVe(), hd.getMaHoaDon());
            ChiTietHoaDon_DAO.themCTHD(cthd);
        }*/

        // Cập nhật trạng thái ghế
        /*for (int i = 0 ; i < this.trangThanhToan.dsGheDat.size() ; i++) {
            this.trangThanhToan.gheDao.capNhatTrangThaiGhe(TRANG_THAI_GHE.Da_dat.getValue(), this.trangThanhToan.dsGheDat.get(i).getMaGhe());
        }*/

        // Thông báo thanh toán thành công và tiển trả lại
        hienThiThongBao("<html>Thanh toán thành công<br><b>Tiền thối: " + tienTra + " VND</b></html>", "Thông báo thành công", JOptionPane.INFORMATION_MESSAGE);

        this.trangThanhToan.dispose();

        //Đã thanh toán thì mới cho in vé
        ( (TrangDatVe) this.trangThanhToan.trangDatVe).veDao.datDSVeDaThanhToan(this.trangThanhToan.danhSachVe);

        // Xóa danh sách vé đã đặt
        ( (TrangDatVe) this.trangThanhToan.trangDatVe).veDao.xoaDSVeDat();

        // Xóa dòng trong bảng danh sách vé
        for (int i = ((TrangDatVe) this.trangThanhToan.trangDatVe).moHinhBang.getRowCount() - 1; i >= 0; i--) {
            ((TrangDatVe) this.trangThanhToan.trangDatVe).moHinhBang.removeRow(i);
        }

        // Xóa danh sách ghế đã đặt
        ((TrangDatVe) this.trangThanhToan.trangDatVe).gheDao.xoaDSGheChon();

        // Đặt thanh toán thành công để in vé được
        ((TrangDatVe) this.trangThanhToan.trangDatVe).datThanhToan(true);

        // Xóa ngày đặt
        ((TrangDatVe) this.trangThanhToan.trangDatVe).thanhNhapNgayDi.setDate(null);

        // Xóa giờ đi
        ((TrangDatVe) this.trangThanhToan.trangDatVe).thanhNhapGioDen.setText("");

        // Đặt hóa đơn bên trangHoaDon
        ((TrangHoaDon) TrangDinhHuong.getTrangChua().getComponent(2)).datHoaDonDTao(hd);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Ve ve = this.trangThanhToan.danhSachVe.get(this.trangThanhToan.danhSachVeThanhToan.getSelectedRow());

        if (ve.getLoaiDoiTuong().equals("Người Lớn")) {
            this.trangThanhToan.tfVAT.setText("2.5%");
        } else {
            this.trangThanhToan.tfVAT.setText("0%");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void hienThiThongBao(String chuThich, String tieuDe, int message) {
        JLabel thongBao = new JLabel(chuThich);
        thongBao.setFont(this.trangThanhToan.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 12));

        JOptionPane hienThiLoi = new JOptionPane(thongBao, message);
        hienThiLoi.setForeground(this.trangThanhToan.xanhBrandeis);

        JDialog hoiThoai = hienThiLoi.createDialog(tieuDe);
        ImageIcon bieuTuongTau = new ImageIcon("assets/icon.png");
        hoiThoai.setIconImage(bieuTuongTau.getImage());
        hoiThoai.setVisible(true);
    }

    // Hiển thị mã QR
    private void hienThiMaQR(String thongTinThanhToan, String tieuDe) {
        // Tạo nhãn công ty
        JLabel tieuDeCongTy = new JLabel("Công ty cổ phần Đường Sắt Sài Gòn");
        tieuDeCongTy.setFont(this.trangThanhToan.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 15));
        tieuDeCongTy.setHorizontalAlignment(SwingConstants.CENTER);

        // Tạo nhãn thông báo
        JLabel thongBao = new JLabel("Hãy quét mã để thanh toán");
        thongBao.setFont(this.trangThanhToan.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 15));
        thongBao.setHorizontalAlignment(SwingConstants.CENTER);

        // Tạo nhãn thông báo
        JLabel tieuDeCamOn = new JLabel("Xin chân thành cám ơn quý khách !");
        tieuDeCamOn.setFont(this.trangThanhToan.phongTuyChinh.layPhongRobotoMonoReg(Font.PLAIN, 15));
        tieuDeCamOn.setHorizontalAlignment(SwingConstants.CENTER);

        try {
            // Tạo ảnh QR từ thông tin thanh toán
            BufferedImage maQR = new TaoMaQR().generateQRCodeImage(thongTinThanhToan);

            // Tăng kích thước mã QR
            int doDai = 400; // Chiều rộng mới
            int doRong = 400; // Chiều cao mới
            Image anhMaQR = maQR.getScaledInstance(doDai, doRong, Image.SCALE_SMOOTH);

            // Chuyển thành ImageIcon để hiển thị
            ImageIcon bieuTuongQR = new ImageIcon(anhMaQR);

            // Tạo JLabel chứa mã QR
            JLabel nhanMaQR = new JLabel();
            nhanMaQR.setIcon(bieuTuongQR);
            nhanMaQR.setBorder(new LineBorder(Color.BLACK));
            nhanMaQR.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel trangChuaMa = new JPanel();
            trangChuaMa.setLayout(new BorderLayout(0, 10)); // Khoảng cách giữa các thành phần
            trangChuaMa.add(thongBao, BorderLayout.NORTH);
            trangChuaMa.add(nhanMaQR);

            // Tạo JPanel chứa cả thông báo và mã QR
            JPanel trangChua = new JPanel();
            trangChua.setLayout(new BorderLayout(10, 10)); // Khoảng cách giữa các thành phần
            trangChua.add(tieuDeCongTy, BorderLayout.NORTH);
            trangChua.add(trangChuaMa, BorderLayout.CENTER);
            trangChua.add(tieuDeCamOn, BorderLayout.SOUTH);

            trangChua.setPreferredSize(new Dimension(400, 400));

            // Hiển thị trong JOptionPane
            JOptionPane.showMessageDialog(
                    null,
                    trangChua,
                    tieuDe,
                    JOptionPane.PLAIN_MESSAGE
            );

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Không thể tạo mã QR.",
                    "Lỗi",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
