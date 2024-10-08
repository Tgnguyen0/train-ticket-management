package app.phan_tu_tuy_chinh;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomHeaderRenderer extends DefaultTableCellRenderer {
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color trang = new Color(255, 255, 255);

    public CustomHeaderRenderer() {
        setHorizontalAlignment(CENTER);
        setBorder(BorderFactory.createEmptyBorder()); // Loại bỏ khung viền
//        setBackground(Color.WHITE);
//        setForeground(Color.WHITE);

        setBackground(trang);
        setForeground(xanhBrandeis);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setFont(c.getFont().deriveFont(3));
        return c;
    }
}
