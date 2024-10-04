package app.giao_dien;


import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class test extends  JTable{
        public test(TableModel model) {
            super(model);
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
            super.paint(g2);
            g2.dispose();
        }

        @Override
        public boolean isOpaque() {
            return false;
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Rounded JTable Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            String[] columnNames = {"STT", "Mã NV", "Họ và tên", "Ngày sinh", "Email"};
            Object[][] data = {
                    {"1", "NV01", "Nguyễn Văn A", "01/01/1990", "a@example.com"},
                    {"2", "NV02", "Trần Thị B", "02/02/1991", "b@example.com"}
            };

            TableModel model = new DefaultTableModel(data, columnNames);
            JTable table = new test(model);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);

            frame.add(scrollPane);
            frame.setSize(500, 300);
            frame.setVisible(true);
        }


}
