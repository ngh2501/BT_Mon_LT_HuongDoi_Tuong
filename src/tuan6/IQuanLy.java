package tuan6;

import java.util.List;
import java.util.Map;

public interface IQuanLy<T> {

    // CRUD
    boolean them(T t);
    boolean xoa(String ma);
    boolean sua(String ma, T tMoi);

    // Tìm kiếm
    List<T> timKiemTheoTen(String ten);
    List<T> timKiemTheoMa(String prefix);

    // Sắp xếp
    List<T> sapXepTheoLuong();
    List<T> sapXepTheoTen();

    // Thống kê và nhóm (Map)
    Map<String, Double> thongKeLuongTheoLoai();
    Map<String, List<T>> groupByLoai();
    Map<String, List<T>> groupByPhongBan();

    // Lọc
    List<T> locLuongTren(double mucLuong);
    List<T> timTheoChucVu(ChucVu chucVu);
}
