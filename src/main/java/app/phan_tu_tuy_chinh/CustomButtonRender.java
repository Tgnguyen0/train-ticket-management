package app.phan_tu_tuy_chinh;

import app.phong_chu_moi.PhongChuMoi;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class CustomButtonRender extends JButton implements TableCellRenderer {
    public CustomButtonRender() {
        setOpaque(true);
        setPreferredSize(new Dimension(13, 12));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Tạo một JPanel với BoxLayout theo chiều dọc
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Tạo nút "Cập nhật" và "Xóa"
        JButton updateButton = new JButton("Sửa");
        JButton deleteButton = new JButton("Xóa");

        updateButton.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 10));
        deleteButton.setFont(new PhongChuMoi().layPhongRobotoMonoReg(Font.PLAIN, 10));
        // Đảm bảo các nút được căn giữa theo chiều ngang
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Thêm các nút vào panel

        panel.add(Box.createVerticalGlue());  // Tạo khoảng trống trước nút "Cập nhật" để căn giữa theo chiều dọc
        panel.add(Box.createVerticalStrut(2));
        panel.add(updateButton);
        panel.add(Box.createVerticalStrut(5));  // Khoảng cách giữa hai nút
        panel.add(deleteButton);
        panel.add(Box.createVerticalStrut(5));
        panel.add(Box.createVerticalGlue());  // Tạo khoảng trống sau nút "Xóa" để căn giữa theo chiều dọc

        // Thiết lập kích thước nút (nếu muốn)
        updateButton.setMaximumSize(new Dimension(60, 15));
        deleteButton.setMaximumSize(new Dimension(60, 15));

        return panel;
    }
}
