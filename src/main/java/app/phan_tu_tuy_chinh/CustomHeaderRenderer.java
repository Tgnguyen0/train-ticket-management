package app.phan_tu_tuy_chinh;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomHeaderRenderer extends DefaultTableCellRenderer {
    public CustomHeaderRenderer() {
        setHorizontalAlignment(CENTER);
        setBorder(BorderFactory.createEmptyBorder()); // Loại bỏ khung viền
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setFont(c.getFont().deriveFont(Font.BOLD));
        return c;
    }
}
