package app.thuc_the;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MaKhachHangTuDong {
    private static String ngayCuoiCung;
    private static int soCuoiTrongMa;
    private static final int SO_CUOI_LON_NHAT = 999;

    // Lưu trữ ngày và số thứ tự vào cơ sở dữ liệu giả định
    private Map<String, Integer> sequenceMap;

    public MaKhachHangTuDong() {
        sequenceMap = new HashMap<>();
        ngayCuoiCung = getCurrentDate();
    }

    // Hàm trả về ngày hiện tại dưới dạng chuỗi "yyyyMMdd"
    private static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }

    // Hàm tạo mã khách hàng
    public static String taoMaKhachHangTuDong() {
        String currentDate = getCurrentDate();

        // Kiểm tra nếu ngày hiện tại khác với ngày lưu trữ trước đó
        if (!currentDate.equals(ngayCuoiCung)) {
            soCuoiTrongMa = 0; // Reset số thứ tự khi qua ngày mới
            ngayCuoiCung = currentDate;
        }

        // Tăng số thứ tự
        soCuoiTrongMa++;

        // Đảm bảo số thứ tự không vượt quá giới hạn
        if (soCuoiTrongMa > SO_CUOI_LON_NHAT) {
            throw new IllegalStateException("Số thứ tự vượt quá giới hạn.");
        }

        // Định dạng mã khách hàng: "KH" + năm + tháng + ngày + số thứ tự
        String year = currentDate.substring(0, 4);
        String month = currentDate.substring(4, 6);
        String day = currentDate.substring(6, 8);

        return String.format("KH%s%s%s%03d", year, month, day, soCuoiTrongMa);
    }
}