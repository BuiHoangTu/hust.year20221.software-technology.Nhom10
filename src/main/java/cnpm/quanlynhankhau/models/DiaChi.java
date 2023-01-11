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
     	output = output.replaceAll("(?i)Số", "");
     	output = output.replaceAll("(?i)Đường", "");
     	output = output.replaceAll("(?i)Quận", "");
     	output = output.replaceAll("(?i)Thành phố", "");
     	output = output.replace('.' , ' ');
 
     	String[] splited = output.split("[,]", 0);
     	ghiChu1 = splited[0].strip();
     	soNha1 = splited[1].strip();
     	duongPho1 = splited[2].strip();
     	quan1 = splited[3].strip();
     	thanhPho1 = splited[4].strip();
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
        if ((ghiChu != null) && (!ghiChu.isBlank())) x.append(ghiChu);
        x.append(", ");
        if ((soNha != null) && (!soNha.isBlank())) x.append("Số ").append(soNha);
        x.append(", ");
        if ((duongPho != null) && (!duongPho.isBlank())) x.append("Đường ").append(duongPho);
        x.append(", ");
        if ((quan != null) && (!quan.isBlank())) x.append("Quận ").append(quan);
        x.append(", ");
        if ((thanhPho != null) && (!thanhPho.isBlank())) x.append("Thành phố ").append(thanhPho).append(".");

        return x.toString();
    }
    public static void main(String[] args) {
    	String thanhPho1 = null, quan1 = null, duongPho1 = null, soNha1 = null, ghiChu1 = null;
    	String test = new String();
    	test = ", , Đường Giải Phóng, Quận Hai Bà Trưng, Thành phố Hà Nội";
    	DiaChi test1 = new DiaChi(thanhPho1, quan1, duongPho1, soNha1, ghiChu1);
    	test1 = parse(test);
    	System.out.println(test1.toString());
    	test1= parse(test1.toString());
    	System.out.println(test1.ghiChu +"-"+ test1.soNha +"-"+ test1.duongPho +"-"+ test1.quan +"-"+ test1.thanhPho);
    	
    }
}
