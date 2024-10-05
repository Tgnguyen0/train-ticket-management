package app.phan_tu_tuy_chinh;

import javax.swing.*;
import java.awt.*;

public class CustomComboBoxRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (isSelected) {
            c.setBackground(new Color(0, 112, 255)); // Màu nền khi chọn
            c.setForeground(new Color(255, 255, 255)); // Màu chữ khi chọn
        } else {
            c.setBackground(new Color(255, 255, 255)); // Màu nền mặc định
            c.setForeground(new Color(0, 112, 255)); // Màu chữ mặc định
        }
        return c;
    }
}
