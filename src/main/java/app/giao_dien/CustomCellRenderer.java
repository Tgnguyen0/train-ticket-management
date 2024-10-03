package app.giao_dien;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {
    public CustomCellRenderer() {
//        setBorder(BorderFactory.createEmptyBorder()); // Loại bỏ khung viền
        setHorizontalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // gỡ bỏ đường viền mỗi khi click vào ô
        ((JComponent) c).setBorder(BorderFactory.createEmptyBorder());
        c.setBackground(row % 2 == 0 ? Color.decode("#E9E9E9"): Color.WHITE); // Đặt màu nền xanh dương cho các hàng chẵn
//        c.setBackground(Color.BLUE); // Đặt màu nền nếu cần
        if (isSelected) {
            c.setBackground(Color.CYAN);  // Màu nền cho hàng được chọn (bạn có thể đổi màu)
    }
        return c;
    }
}