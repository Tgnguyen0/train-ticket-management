package app.phan_tu_tuy_chinh;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomHeaderRenderer extends DefaultTableCellRenderer {
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color trang = new Color(255, 255, 255);

    public CustomHeaderRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER);
        setBackground(trang);
        setForeground(xanhBrandeis);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setFont(new Font("Arial", Font.BOLD, 12)); // Thay đổi font nếu muốn // Font cho header
        // Thiết lập viền cho header (giữ viền phía dưới)
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, xanhBrandeis));
        return c;
    }
}
