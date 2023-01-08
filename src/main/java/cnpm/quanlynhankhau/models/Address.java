package cnpm.quanlynhankhau.models;

public class Address {
    public String thanhPho;
    public String quan;
    public String duongPho;
    public String soNha;


    @Override
    public String toString() {
        var x = new StringBuilder();
        if (soNha != null) x.append("Số ").append(soNha).append(", ");
        if (duongPho != null) x.append("Đường ").append(duongPho).append(", ");
        if (quan != null) x.append("Quận ").append(quan).append(", ");
        if (thanhPho != null) x.append("Thành phố ").append(thanhPho).append(".");

        return x.toString();
    }
}
