package cnpm.quanlynhankhau.models;

/**
 * Class thể hiện vị trí
 */
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


    /**
     * Đổi text địa chỉ thành object DiaChi
     * @param text Địa chỉ dạng xâu
     * @return object DiaChi
     */
    public static DiaChi parse(CharSequence text) {
        // TODO parse dia chi theo format toString dưới
     	String thanhPho1 = null, quan1 = null, duongPho1 = null, soNha1 = null, ghiChu1 = null;
     	String output = String.valueOf(text);
     	output = output.replaceAll(" Số ", "");
     	output = output.replaceAll(" Đường ", "");
     	output = output.replaceAll(" Quận ", "");
     	output = output.replaceAll(" Thành Phố ", "");
 
     	String[] splited = output.split("[,]", 0);
     	ghiChu1 = splited[0];
     	soNha1 = splited[1];
     	duongPho1 = splited[2];
     	quan1 = splited[3];
     	thanhPho1 = splited[4];
		DiaChi x = new DiaChi(thanhPho1, quan1, duongPho1, soNha1, ghiChu1);
    	return x;
    }


    public DiaChi(String thanhPho, String quan, String duongPho, String soNha, String ghiChu) {
        this.thanhPho = thanhPho;
        this.quan = quan;
        this.duongPho = duongPho;
        this.soNha = soNha;
        this.ghiChu = ghiChu;
    }

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
    public static void main(String[] args) {
    	String thanhPho1 = null, quan1 = null, duongPho1 = null, soNha1 = null, ghiChu1 = null;
    	String test = new String();
    	test = "Đại Học Bách Khoa, Số 1, Đường Giải Phóng, Quận Hai Bà Trưng, Thành Phố Hà Nội";
    	DiaChi test1 = new DiaChi(thanhPho1, quan1, duongPho1, soNha1, ghiChu1);
    	test1 = parse(test);
    	System.out.print(test1.ghiChu +" "+ test1.soNha +" "+ test1.duongPho +" "+ test1.quan +" "+ test1.thanhPho);
    }
}
