package app.dieu_khien;

import app.giao_dien.TrangDatVe;
import app.giao_dien.TrangSoDoGheMemDieuHoa;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HanhDong_TrangSoDoGheMemDieuHoa implements ItemListener {
    TrangSoDoGheMemDieuHoa trangSoDoGheMemDieuHoa;

    public HanhDong_TrangSoDoGheMemDieuHoa(TrangSoDoGheMemDieuHoa trangSoDoGheMemDieuHoa) {
        this.trangSoDoGheMemDieuHoa = trangSoDoGheMemDieuHoa;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        CardLayout cardLayout = (CardLayout) this.trangSoDoGheMemDieuHoa.trangChua.getLayout();

        if (e.getStateChange() == ItemEvent.SELECTED) {
            String loaiGheDaChon = (String) e.getItem();

            switch (loaiGheDaChon) {
                case "D1":
                    cardLayout.show(this.trangSoDoGheMemDieuHoa.trangChua, "D1");
                    break;
                case "A4":
                    cardLayout.show(this.trangSoDoGheMemDieuHoa.trangChua, "A4");
                    break;
            }
        }
    }
}
