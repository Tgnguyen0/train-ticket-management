package app.phan_tu_tuy_chinh;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends DefaultTableCellRenderer {
    public Color xanhBrandeis = new Color(0, 112, 255);
    public Color trang = new Color(255, 255, 255);
    public Color xam200 = new Color(233, 236, 239); // https://getbootstrap.com/docs/5.0/utilities/colors/#:~:text=Convey%20meaning%20through%20color%20with%20a%20handful%20of%20color%20utility

    public CustomCellRenderer() {
        setBorder(BorderFactory.createEmptyBorder()); // Loại bỏ khung viền
        setHorizontalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(row % 2 == 0 ? xam200 : trang); // Đặt màu nền trắng cho các hàng chẵn
        return c;
    }
}