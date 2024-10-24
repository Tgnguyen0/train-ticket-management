package app.giao_dien;

import javax.swing.*;
import java.awt.*;

public class TrangChuaThongKeDoanhThuNhaGa extends JFrame {
    private  JButton buttonThongKeNam;
    private  JButton buttonThongKeThang;
    private  JPanel colorDoanhThuNam;
    private  JPanel colorDoanhThuNam1;
    private  JComboBox<String> danhSachNam;
    private  JComboBox<String> danhSachNamKetThuc;
    private  JComboBox<String> danhSachNamXuatPhat;
    private  JComboBox<String> danhSachThang;
    private  JLabel labelDoanhThuNam;
    private  JLabel labelDoanhThuThangCuaNam;
    private  JLabel labelNam;
    private  JLabel labelNamKetThuc;
    private  JLabel labelNamXuatPhat;
    private  JLabel labelNote;
    private  JLabel labelThang;
    private  JScrollPane scrollPaneDanhSachDoanhThuCacNam;
    private  JScrollPane scrollPaneTrangChuaDoanhThuThang;
    private  JTable tableDanhSachDoanhThuCacNam;
    private  JTable tableDoanhThuThang;
    private  JPanel trangChuaBieuDoCot;
    private  JPanel trangChuaBieuDoTron;
    private  JPanel trangChuaCacNutThongKeNam;
    private  JPanel trangChuaCacNutThongKeThang;
    private  JPanel trangChuaCacThongTinThongKeNam;
    private  JPanel trangChuaCacThongTinThongKeThang;
    private  JPanel trangChuaDoanhThu;
    private  JPanel trangChuaDoanhThuCacNam;
    private  JPanel trangChuaNutChonNam;
    private  JPanel trangChuaNutChonNamKetThuc;
    private  JPanel trangChuaNutChonNamXuatPhat;
    private  JPanel trangChuaNutChonThang;
    private  JPanel trangChuaNutChonThongKeNam;
    private  JPanel trangChuaNutThongKeThang;
    private  JPanel trangChuaThongTinChuYBieuDoTron;
    private  JPanel trangChuaThongTinThongKeDoanhThuThang;
    private  JPanel trangChuaThongKeDoanhThuNam;
    private  JPanel trangChuaThongKeDoanhThuThang;


    public TrangChuaThongKeDoanhThuNhaGa(){
        trangChuaThongKeDoanhThuThang = new JPanel();
        trangChuaCacThongTinThongKeThang = new  JPanel();
        trangChuaCacNutThongKeThang = new  JPanel();
        trangChuaNutChonThang = new  JPanel();
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

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

        /*
        trang chứa thống kê doanh thu theo tháng của nhà ga
        */

        thietLap_TrangChuaNutChonThang();
        thietLap_TrangChuaNutChonNam();

        thietLap_TrangChuaNutThongKeThang();

        thietLap_TrangChuaCacNutThongKeThang();

        thietLap_TrangChuaDoanhThu();

        thietLap_TrangChuaCacThongTinThang();
        thietLap_TrangChuaBieuDoTron();
        thietLap_TrangChuaThongTinChuYBieuDoTron();
        thietLap_TrangChuaDoanhThuThang();

        /*

         */
        thietLap_TrangChuaNutChonNamXuatPhat();
        thietLap_TrangChuaNamKetThuc();
        thietLap_TrangChuaNutChonThongKeNam();
        thietLap_TrangChuaCacNutThongKeNam();
        thietLap_TrangChuaDoanhThuCacNam();
        thietLap_TrangChuaCacThongTinThongKeNam();
        thietLap_TrangChuaBieuDoCot();
        thietLap_TrangChuaThongKeDoanhThuNam();
        thietLap_TrangChuaThongKeDoanhThuNhaGa();
    }


    private void thietLap_TrangChuaNutChonThang(){
        labelThang.setText("jLabel1");

        danhSachThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

    private void thietLap_TrangChuaNutChonNam(){
        labelNam.setText("jLabel1");

        danhSachNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

    private void thietLap_TrangChuaNutThongKeThang(){
        buttonThongKeThang.setText("jButton1");

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
    private void thietLap_TrangChuaCacNutThongKeThang(){
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

    private void thietLap_TrangChuaDoanhThu(){
        tableDoanhThuThang.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        scrollPaneTrangChuaDoanhThuThang.setViewportView(tableDoanhThuThang);

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
                                .addComponent(scrollPaneTrangChuaDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void thietLap_TrangChuaCacThongTinThang(){
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

    private void thietLap_TrangChuaBieuDoTron(){
        javax.swing.GroupLayout trangChuaBieuDoTronLayout = new javax.swing.GroupLayout(trangChuaBieuDoTron);
        trangChuaBieuDoTron.setLayout(trangChuaBieuDoTronLayout);
        trangChuaBieuDoTronLayout.setHorizontalGroup(
                trangChuaBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 403, Short.MAX_VALUE)
        );
        trangChuaBieuDoTronLayout.setVerticalGroup(
                trangChuaBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 262, Short.MAX_VALUE)
        );
    }

    private void thietLap_TrangChuaThongTinChuYBieuDoTron(){
        labelNote.setText("jLabel2");

        javax.swing.GroupLayout colorDoanhThuNamLayout = new javax.swing.GroupLayout(colorDoanhThuNam);
        colorDoanhThuNam.setLayout(colorDoanhThuNamLayout);
        colorDoanhThuNamLayout.setHorizontalGroup(
                colorDoanhThuNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 30, Short.MAX_VALUE)
        );
        colorDoanhThuNamLayout.setVerticalGroup(
                colorDoanhThuNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        labelDoanhThuNam.setText("jLabel4");

        javax.swing.GroupLayout colorDoanhThuNam1Layout = new javax.swing.GroupLayout(colorDoanhThuNam1);
        colorDoanhThuNam1.setLayout(colorDoanhThuNam1Layout);
        colorDoanhThuNam1Layout.setHorizontalGroup(
                colorDoanhThuNam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        colorDoanhThuNam1Layout.setVerticalGroup(
                colorDoanhThuNam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 25, Short.MAX_VALUE)
        );

        labelDoanhThuThangCuaNam.setText("jLabel4");

        javax.swing.GroupLayout trangChuaThongTinChuYBieuDoTronLayout = new javax.swing.GroupLayout(trangChuaThongTinChuYBieuDoTron);
        trangChuaThongTinChuYBieuDoTron.setLayout(trangChuaThongTinChuYBieuDoTronLayout);
        trangChuaThongTinChuYBieuDoTronLayout.setHorizontalGroup(
                trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createSequentialGroup()
                                .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(labelNote, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createSequentialGroup()
                                                                .addComponent(colorDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 5, Short.MAX_VALUE))
                                                        .addComponent(colorDoanhThuNam1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(trangChuaThongTinChuYBieuDoTronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelDoanhThuThangCuaNam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelDoanhThuNam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
    private void thietLap_TrangChuaDoanhThuThang(){
        trangChuaThongKeDoanhThuThang.setPreferredSize(new java.awt.Dimension(1200, 400));

        javax.swing.GroupLayout trangChuaThongTinThongKeDoanhThuThangLayout = new javax.swing.GroupLayout(trangChuaThongTinThongKeDoanhThuThang);
        trangChuaThongTinThongKeDoanhThuThang.setLayout(trangChuaThongTinThongKeDoanhThuThangLayout);
        trangChuaThongTinThongKeDoanhThuThangLayout.setHorizontalGroup(
                trangChuaThongTinThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinThongKeDoanhThuThangLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(trangChuaBieuDoTron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaThongTinChuYBieuDoTron, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        trangChuaThongTinThongKeDoanhThuThangLayout.setVerticalGroup(
                trangChuaThongTinThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongTinThongKeDoanhThuThangLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(trangChuaThongTinChuYBieuDoTron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trangChuaThongTinThongKeDoanhThuThangLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(trangChuaBieuDoTron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout trangChuaThongKeDoanhThuThangLayout = new javax.swing.GroupLayout(trangChuaThongKeDoanhThuThang);
        trangChuaThongKeDoanhThuThang.setLayout(trangChuaThongKeDoanhThuThangLayout);
        trangChuaThongKeDoanhThuThangLayout.setHorizontalGroup(
                trangChuaThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongKeDoanhThuThangLayout.createSequentialGroup()
                                .addComponent(trangChuaCacThongTinThongKeThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaThongTinThongKeDoanhThuThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trangChuaThongKeDoanhThuThangLayout.setVerticalGroup(
                trangChuaThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongKeDoanhThuThangLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(trangChuaThongKeDoanhThuThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(trangChuaThongTinThongKeDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trangChuaCacThongTinThongKeThang, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
    }


    private void thietLap_TrangChuaNutChonNamXuatPhat(){
        labelNamXuatPhat.setText("jLabel1");

        danhSachNamXuatPhat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout trangChuaNutChonNamXuatPhatLayout = new javax.swing.GroupLayout(trangChuaNutChonNamXuatPhat);
        trangChuaNutChonNamXuatPhat.setLayout(trangChuaNutChonNamXuatPhatLayout);
        trangChuaNutChonNamXuatPhatLayout.setHorizontalGroup(
                trangChuaNutChonNamXuatPhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonNamXuatPhatLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelNamXuatPhat, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void thietLap_TrangChuaNamKetThuc(){
        labelNamKetThuc.setText("jLabel1");

        danhSachNamKetThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout trangChuaNutChonNamKetThucLayout = new javax.swing.GroupLayout(trangChuaNutChonNamKetThuc);
        trangChuaNutChonNamKetThuc.setLayout(trangChuaNutChonNamKetThucLayout);
        trangChuaNutChonNamKetThucLayout.setHorizontalGroup(
                trangChuaNutChonNamKetThucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaNutChonNamKetThucLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(labelNamKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void thietLap_TrangChuaNutChonThongKeNam(){
        buttonThongKeNam.setText("jButton1");

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
    private void thietLap_TrangChuaCacNutThongKeNam(){
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

    private void thietLap_TrangChuaDoanhThuCacNam(){
        tableDanhSachDoanhThuCacNam.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        scrollPaneDanhSachDoanhThuCacNam.setViewportView(tableDanhSachDoanhThuCacNam);

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

    private void thietLap_TrangChuaCacThongTinThongKeNam(){
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

    private void thietLap_TrangChuaBieuDoCot(){
        javax.swing.GroupLayout trangChuaBieuDoCotLayout = new javax.swing.GroupLayout(trangChuaBieuDoCot);
        trangChuaBieuDoCot.setLayout(trangChuaBieuDoCotLayout);
        trangChuaBieuDoCotLayout.setHorizontalGroup(
                trangChuaBieuDoCotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        trangChuaBieuDoCotLayout.setVerticalGroup(
                trangChuaBieuDoCotLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 292, Short.MAX_VALUE)
        );
    }

    private void thietLap_TrangChuaThongKeDoanhThuNam(){
        javax.swing.GroupLayout trangChuaThongKeDoanhThuNamLayout = new javax.swing.GroupLayout(trangChuaThongKeDoanhThuNam);
        trangChuaThongKeDoanhThuNam.setLayout(trangChuaThongKeDoanhThuNamLayout);
        trangChuaThongKeDoanhThuNamLayout.setHorizontalGroup(
                trangChuaThongKeDoanhThuNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(trangChuaThongKeDoanhThuNamLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(trangChuaCacThongTinThongKeNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaBieuDoCot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private void thietLap_TrangChuaThongKeDoanhThuNhaGa(){
//        this.setPreferredSize(new java.awt.Dimension(1200, 600));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(trangChuaThongKeDoanhThuThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangChuaThongKeDoanhThuNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(trangChuaThongKeDoanhThuThang, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(trangChuaThongKeDoanhThuNam, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
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
            new TrangChuaThongKeDoanhThuNhaGa().setVisible(true);
        });

    }
}
