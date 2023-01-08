package cnpm.quanlynhankhau.models;

public class DiaChi {
    public String thanhPho;
    public String quan;
    public String duongPho;
    public String soNha;

    /**
     * Ghi chú về địa điểm này
     * VD : Bệnh viện, Công An Phường
     */
    public String ghiChu;


    @Override
    public String toString() {
        var x = new StringBuilder();
        if (ghiChu != null) x.append(ghiChu).append(", ");
        if (soNha != null) x.append("Số ").append(soNha).append(", ");
        if (duongPho != null) x.append("Đường ").append(duongPho).append(", ");
        if (quan != null) x.append("Quận ").append(quan).append(", ");
        if (thanhPho != null) x.append("Thành phố ").append(thanhPho).append(".");

        return x.toString();
    }
}
