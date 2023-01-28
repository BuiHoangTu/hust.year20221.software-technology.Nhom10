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
        String strDiaChi =  text.toString();

        int soIndex, soNextIndext = -1; 
        do {
            soIndex = soNextIndext;    
            soNextIndext = strDiaChi.indexOf("Số ", soNextIndext + 1);
        } while (soNextIndext >= 0); 
        
        int duongIndex, duongNextIndext = -1; 
        do {
            duongIndex = duongNextIndext;    
            duongNextIndext = strDiaChi.indexOf("Đường ", duongNextIndext + 1);
        } while (duongNextIndext >= 0); 

        int quanIndex, quanNextIndext = -1; 
        do {
            quanIndex = quanNextIndext;    
            quanNextIndext = strDiaChi.indexOf("Quận ", quanNextIndext + 1);
        } while (quanNextIndext >= 0); 

        int phoIndex, phoNextIndext = -1; 
        do {
            phoIndex = phoNextIndext;    
            phoNextIndext = strDiaChi.indexOf("Thành phố ", phoNextIndext + 1);
        } while (phoNextIndext >= 0); 

        int begin, end;
        String ghiChu = null;
        if (soIndex != 0 && duongIndex != 0 && quanIndex != 0 && phoIndex != 0) {
            begin = 0;

            if (soIndex > 0) {
                end = soIndex - 2; // bỏ dấu phẩy 
            } else if (duongIndex > 0) {
                end = duongIndex - 2;
            } else if (quanIndex > 0) {
                end = quanIndex - 2; 
            } else if (phoIndex > 0) {
                end = phoIndex - 2; 
            } else if (!strDiaChi.isEmpty()) {
                end = strDiaChi.length() - 1;
            } else {
                end = 0;
            }

            ghiChu = strDiaChi.substring(begin, end);
        }

        String so = null;
        if (soIndex >= 0) {
            begin = soIndex + 3;

            if (duongIndex > 0) {
                end = duongIndex - 2;
            } else if (quanIndex > 0) {
                end = quanIndex - 2; 
            } else if (phoIndex > 0) {
                end = phoIndex - 2; 
            } else {
                end = strDiaChi.length() - 1;
            }

            so = strDiaChi.substring(begin, end);
        }

        String duong = null;
        if (duongIndex >= 0) {
            begin = duongIndex + 6;

            if (quanIndex > 0) {
                end = quanIndex - 2; 
            } else if (phoIndex > 0) {
                end = phoIndex - 2; 
            } else {
                end = strDiaChi.length() - 1;
            }

            duong = strDiaChi.substring(begin, end);
        }

        String quan = null;
        if (quanIndex >= 0) {
            begin = quanIndex + 5;

            if (phoIndex > 0) {
                end = phoIndex - 2; 
            } else {
                end = strDiaChi.length() - 1;
            }

            quan = strDiaChi.substring(begin, end);
        }

        String pho = null;
        if (phoIndex >= 0) {
            begin = phoIndex + 10;

            end = strDiaChi.length() - 1;

            pho = strDiaChi.substring(begin, end);
        }

        return new DiaChi(pho, quan, duong, so, ghiChu);
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
        if (ghiChu != null && ! ghiChu.trim().isEmpty()) x.append(ghiChu);
        if (soNha != null && !soNha.trim().isEmpty()) x.append(", ").append("Số ").append(soNha);
        if (duongPho != null && !duongPho.trim().isEmpty()) x.append(", ").append("Đường ").append(duongPho);
        if (quan != null && !quan.trim().isEmpty()) x.append(", ").append("Quận ").append(quan);
        if (thanhPho != null && !thanhPho.trim().isEmpty()) x.append(", ").append("Thành phố ").append(thanhPho);

        if (
                (ghiChu != null && !ghiChu.trim().isEmpty()) ||
                (soNha != null && !soNha.trim().isEmpty()) ||
                (duongPho != null && !duongPho.trim().isEmpty()) ||
                (quan != null && !quan.trim().isEmpty()) ||
                (thanhPho != null && !thanhPho.trim().isEmpty())
        ) x.append(".");

        return x.toString();
    }
}
