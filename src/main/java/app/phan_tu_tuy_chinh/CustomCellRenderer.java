package app.phan_tu_tuy_chinh;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {
    public CustomCellRenderer() {
        setBorder(BorderFactory.createEmptyBorder()); // Loại bỏ khung viền
        setHorizontalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(row % 2 == 0 ? Color.GRAY : Color.WHITE); // Đặt màu nền xanh dương cho các hàng chẵn
        c.setBackground(Color.WHITE); // Đặt màu nền nếu cần
        return c;
    }
}