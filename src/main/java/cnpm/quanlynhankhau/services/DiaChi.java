package models;

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
    	String thanhPho = null, quan = null, duongPho = null, soNha = null, ghiChu = null;
     	String output = String.valueOf(text);

     	String[] splited = output.split("[,]", 0);
     	int i = 0;
     	if(splited[0].contains("Số")) i = 1;
     	if(splited[0].contains("Đường")) i = 2;
     	if(splited[0].contains("Quận")) i = 3;
     	if(splited[0].contains("Thành phố")) i = 4;
     	
     	int j = 0;
     	for (String split : splited) {
     		if(i == 0) ghiChu = splited[j];
     		if(i == 1) { 
     			splited[j] = splited[j].replaceAll("Số", ""); 
     			while(splited[j].charAt(0) == ' ') splited[j] = splited[j].substring(1);
     			soNha = splited[j];
     		}
     		if(i == 2) { 
     			splited[j] = splited[j].replaceAll("Đường", ""); 
     			while(splited[j].charAt(0) == ' ') splited[j] = splited[j].substring(1);
     			duongPho = splited[j];
     		}
     		if(i == 3) { 
     			splited[j] = splited[j].replaceAll("Quận", ""); 
     			while(splited[j].charAt(0) == ' ') splited[j] = splited[j].substring(1);
     			quan = splited[j];
     		}
     		if(i == 4) { 
     			splited[j] = splited[j].replaceAll("Thành Phố", "");
     			while(splited[j].charAt(0) == ' ') splited[j] = splited[j].substring(1);
     			thanhPho = splited[j];
     		}
     		j++; i++;
     	}
     	
		DiaChi x = new DiaChi(thanhPho, quan, duongPho, soNha, ghiChu);
    	return x;
    }


    public DiaChi(String thanhPho, String quan, String duongPho, String soNha, String ghiChu) {
        this.thanhPho = thanhPho;
        this.quan = quan;
        this.duongPho = duongPho;
        this.soNha = soNha;
        this.ghiChu = ghiChu;
    }

    public static void main(String[] args) {
    	String thanhPho1 = null, quan1 = null, duongPho1 = null, soNha1 = null, ghiChu1 = null;
    	String test = new String();
    	test = "Số 3/155, Đường Giải Phóng, Quận Hai Bà Trưng, Thành Phố Hà Nội";
    	DiaChi test1 = new DiaChi(thanhPho1, quan1, duongPho1, soNha1, ghiChu1);
    	test1 = parse(test);
    	System.out.println(test1.toString());
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
}
