
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DeThi extends HocPhan {
    private DanhSachCauHoi danhSachCauHoi = new DanhSachCauHoi();
    private String maDeThi;
    private String tenMonThi;
    private int thoiGian;
    private int soCau;
    private int index[];
    public DeThi() {
        super();
    };
    public DeThi(String maDeThi, String tenMonThi, int thoiGian, int soCau, String maHocPhan, String tenHocPhan, int tinChi) {
        super(maHocPhan,tenHocPhan,tinChi);
        this.maDeThi = maDeThi;
        this.tenMonThi = tenMonThi;
        this.thoiGian = thoiGian;
        this.soCau = soCau;
    }
    public DanhSachCauHoi getDanhSachCauHoi() {
        return danhSachCauHoi;
    }
    public String getMaDeThi() {
        return this.maDeThi;
    }
    public String getTenMonThi() {
        return this.tenMonThi;
    }
    public int getThoiGian() {
        return this.thoiGian;
    }
    public int getSoCau() {
        return this.soCau;
    }
    public int[] getIndex() {
        return index;
    }
    public void setTenMonThi(String tenMon){
        this.tenMonThi = tenMon;
    }
    public void setMaDeThi(String maDeThi) {
        this.maDeThi = maDeThi;
    }
    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }
    public void setSoCau(int soCau) {
        this.soCau = soCau;
    }
    public void setIndex( int index[]) {
        this.index = index;
    }
    public void NhapMaDeThi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma de thi :");
        this.maDeThi = scanner.nextLine();
        if(!KiemTraThongTin(this.maDeThi)){
            System.out.println("Ma de thi khong hop le!");
            NhapMaDeThi();
        }
    }
    public void NhapTenMonThi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ten mon thi:");
        this.tenMonThi = scanner.nextLine();
        if(!KiemTraThongTin(this.tenMonThi)){
            System.out.println("Ten mon thi khong hop le!");
            NhapTenMonThi();
        }     
    }
    public void NhapThoiGian(){
        int tmp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi nhap thoi gian thi :");
        tmp = scanner.nextInt();
        if(tmp > 0){
        this.thoiGian = tmp;
        }
        else {
            System.out.println("Thoi gian khong hop le!");
            NhapThoiGian();
        }

    }
    public void NhapSoCau() {
        int tmp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi nhap so cau cho mon thi :");
        tmp = scanner.nextInt();
        if (tmp > 0) {
            this.soCau = tmp;
        } else {
            System.out.println("So cau khong hop le! Nhap lai.");
            NhapSoCau(); 
        }
    }
    public boolean KiemTraThongTin(String thongTin) {
        return thongTin != null && !thongTin.trim().isEmpty();
    }
    public void NhapThongTinDeThi(){
       // super.capNhat();
        NhapMaDeThi();
        NhapTenMonThi();
        NhapSoCau();
        NhapThoiGian();
    }
    public void XuatThongTinDeThi() {
        //this.XuatThongTinHocPhan();
        System.out.println("Mã Đề Thi: " + this.maDeThi);
        System.out.println("Tên Môn Thi: " +this.tenMonThi);
        System.out.println("Thời Gian: " + this.thoiGian + " Phút");
        System.out.println("Số Câu : "+ this.soCau);
    }
    public void HienThiDeThi(){    
        XuatThongTinDeThi(); 
        MonThi(this.tenMonThi.concat(".txt"));
        NoiDungDeThi();
    }
   public void NoiDungDeThi(){ 
      for(int i = 0; i < this.soCau; i++) {
        int Index = i + 1;
        System.out.print("Câu hỏi " + Index + " ");
        this.danhSachCauHoi.XuatCauHoiTheoViTri(index[i]);
      }   
   }
   public void MonThi(String documentsIn){
       this.danhSachCauHoi.docFile(documentsIn);
       index = new int[this.danhSachCauHoi.getN()];
       LayNgauNhienCauHoi();
   }
   public void LayNgauNhienCauHoi(){
        Random random = new Random();
        for(int i = 0; i < this.soCau; i++){
            index[i] = random.nextInt(this.danhSachCauHoi.getN());
            for(int j = 0; j < i; j++){
                  if(index[j] == index[i]){ 
                    i = i - 1;    
            }
        }
   }
}
    public void XoaCauHoiDeThiTheoID() {
        Scanner scanner = new Scanner(System.in);
        String idTmp;
        System.out.println("Mời Nhập ID Câu Hỏi Cần Xóa!");
        idTmp = scanner.nextLine();
        for(int i = 0; i < soCau; i++) {
            if(danhSachCauHoi.getCh()[index[i]].getIdCau().equals(idTmp)){  
                for(int j = i; j < soCau - 1; j ++) {
                    index[j] = index[j + 1];
                }
                soCau--;
                System.out.println("Xóa Câu Hỏi Thành Công");        
                return;   
            }
        }
        System.out.println("Không Tìm Thấy Câu Hỏi Trong Danh Sách Có ID Như Trên!");
        return;
    }
    public void XoaCauHoiDeThiTheoID(String id) {
        for(int i = 0; i < soCau; i++) {
            if(danhSachCauHoi.getCh()[index[i]].getIdCau().equals(id)){  
                for(int j = i; j < soCau - 1; j ++) {
                    index[j] = index[j + 1];
                }
                soCau--;
                System.out.println("Xóa Câu Hỏi Thành Công");        
                return;   
            }
        }
        System.out.println("Không Tìm Thấy Câu Hỏi Trong Danh Sách Có ID Như Trên!");
        return;
    }
    public void ThayDoiCauHoiDeThiID() {
        Scanner scanner = new Scanner(System.in);
        String idTmp;
        System.out.println("Mời Nhập ID Câu Hỏi Cần Thay Đổi!");
        idTmp = scanner.nextLine();
           for(int i = 0; i < soCau; i++) {
            if(danhSachCauHoi.getCh()[index[i]].getIdCau().equals(idTmp)){  
               danhSachCauHoi.getCh()[index[i]].nhap();
                System.out.println("Thay Đổi Câu Hỏi Thành Công!");        
                return;   
            }
        }
        System.out.println("Không Tìm Thấy Câu Hỏi Trong Danh Sách Có ID Như Trên!");
        return;
    }
     public void ThayDoiCauHoiDeThiID(String id) {
           for(int i = 0; i < soCau; i++) {
            if(danhSachCauHoi.getCh()[index[i]].getIdCau().equals(id)){  
               danhSachCauHoi.getCh()[index[i]].nhap();
                System.out.println("Thay Đổi Câu Hỏi Thành Công!");        
                return;   
            }
        }
        System.out.println("Không Tìm Thấy Câu Hỏi Trong Danh Sách Có ID Như Trên!");
        return;
    }
    public void XoaCauHoiDeThiViTri(){
        Scanner scanner = new Scanner(System.in);
        int indexTmp;
        System.out.println("Mời Nhập Vị Trí Câu Hỏi Cần Xóa!");
        indexTmp = scanner.nextInt();
        if(indexTmp <= 0) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
        if(indexTmp > soCau ) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
        indexTmp = indexTmp - 1;
         for(int j = indexTmp; j < soCau - 1 ; j ++) {
                index[j] = index[j + 1]; 
        }
         soCau--;
         System.out.println("Xóa Câu Hỏi Thành Công!");        
         return;  
    }
    
        public void XoaCauHoiDeThiViTri(int Index){

        if(Index<= 0) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
        if(Index > soCau ) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
        Index = Index - 1;
         for(int j = Index; j < soCau - 1 ; j ++) {
                index[j] = index[j + 1]; 
        }
         soCau--;
         System.out.println("Xóa Câu Hỏi Thành Công!");        
         return;  
    }
        public void ThayDoiCauHoiDeThiViTri(){
        Scanner scanner = new Scanner(System.in);
        int indexTmp;
        System.out.println("Mời Nhập Vị Trí Câu Hỏi Cần Thay Đổi");
        indexTmp = scanner.nextInt();
        if(indexTmp < 1) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
        if(indexTmp > soCau ) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
          indexTmp = indexTmp - 1;
          danhSachCauHoi.getCh()[index[indexTmp]].nhap();
          System.out.println("Thay Đổi Câu Hỏi Thành Công!");        
          return;  
    }
      public void ThayDoiCauHoiDeThiViTri(int indexTmp){
        if(indexTmp < 1) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
        if(indexTmp > soCau ) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
          indexTmp = indexTmp - 1;
          danhSachCauHoi.getCh()[index[indexTmp]].nhap();
          System.out.println("Thay Đổi Câu Hỏi Thành Công!");        
          return;  
    }
    public void ThemCauHoiVaoDeThiViTri() {
        Scanner scanner = new Scanner(System.in);
        int indexTmp; int listTmp;
        System.out.println("Mời Nhập Vị Trí Câu Hỏi Cần Thêm Vào Đề Thi!");
        indexTmp = scanner.nextInt();  
        System.out.println("Mời Nhập Vị Trí Câu Hỏi Được Lấy Từ Danh Sách Câu Hỏi");
        listTmp = scanner.nextInt();
        if(indexTmp < 1) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
        else if(indexTmp > soCau) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
        else {
            indexTmp = indexTmp - 1;
        }

        if(listTmp < 1) {
            System.out.println("Vị Trí Câu Hỏi Không Có Trong Danh Sách");
            return;
        }
        else if(listTmp > danhSachCauHoi.getN()) {
            System.out.println("Vị Trí Câu Hỏi Không Có Trong Danh Sách");
            return;
        } 
        else{
            listTmp = listTmp - 1;
        }
        for(int i = 0; i < soCau; i++) {
            if(index[i] == listTmp){
            System.out.println("Thêm Câu Hỏi Không Thành Công Do Đề Thi Sẽ Có Các Câu Hỏi Giống Nhau");
            return;
            }
        }
        for(int i = soCau ; i > indexTmp; i--) {
            index[i] = index[i - 1];
        }
        soCau ++;
        index[indexTmp] = listTmp ;
        System.out.println("Thêm Thành Công Câu Hỏi Vào Đề Thi!"); 
        return;
    }
        public void ThemCauHoiVaoDeThiViTri(int indexTmp,int listTmp) {
        if(indexTmp < 1) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
        else if(indexTmp > soCau) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        }
        else {
            indexTmp = indexTmp - 1;
        }

        if(listTmp < 1) {
            System.out.println("Vị Trí Câu Hỏi Không Có Trong Danh Sách");
            return;
        }
        else if(listTmp > danhSachCauHoi.getN()) {
            System.out.println("Vị Trí Câu Hỏi Không Có Trong Danh Sách");
            return;
        } 
        else{
            listTmp = listTmp - 1;
        }
        for(int i = 0; i < soCau; i++) {
            if(index[i] == listTmp){
            System.out.println("Thêm Câu Hỏi Không Thành Công Do Đề Thi Sẽ Có Các Câu Hỏi Giống Nhau");
            return;
            }
        }
        for(int i = soCau ; i > indexTmp; i--) {
            index[i] = index[i - 1];
        }
        soCau ++;
        index[indexTmp] = listTmp ;
        System.out.println("Thêm Thành Công Câu Hỏi Vào Đề Thi!"); 
        return;
    }
    public void ThemCauHoiVaoDeThiID() {
        Scanner scanner = new Scanner(System.in);
        int indexTmp;
        String listID;
        int indexList = -1;
        
        System.out.println("Mời Nhập Vị Trí Câu Hỏi Cần Thêm Vào Đề Thi!");
        indexTmp = scanner.nextInt();
        scanner.nextLine();
    
        System.out.println("Mời Nhập ID Câu Hỏi Được Lấy Từ Danh Sách Câu Hỏi");
        listID = scanner.nextLine();
    
        // Kiểm tra vị trí hợp lệ
        if (indexTmp < 1 || indexTmp > soCau) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        } else {
            indexTmp = indexTmp - 1;
        }
    
        // Tìm kiếm câu hỏi trong danh sách
        for (int i = 0; i < danhSachCauHoi.getN(); i++) {
            if (danhSachCauHoi.getCh()[i].getIdCau().equals(listID)) {
                indexList = i;
                break;
            }
        }
        if(indexList == -1) {
            System.out.println("Câu Hỏi Không Có Trong Danh Sách");
            return;
        }
        // Kiểm tra câu hỏi đã tồn tại trong đề thi chưa
        for (int i = 0; i < soCau; i++) {
            if (index[i] == indexList) {
                System.out.println("Câu Hỏi Đã Có Trong Đề Thi");
                return;
            }
        }
        // Thêm câu hỏi vào đề thi
        for (int i = soCau ; i > indexTmp; i--) {
            index[i] = index[i - 1];
        }
        soCau++;
        index[indexTmp] = indexList;
        System.out.println("Thêm Thành Công Câu Hỏi Vào Đề Thi!");
    }
     public void ThemCauHoiVaoDeThiID(int indexTmp, String listID) {
        int indexList = -1;
        // Kiểm tra vị trí hợp lệ
        if (indexTmp < 1 || indexTmp > soCau) {
            System.out.println("Vị Trí Câu Hỏi Trong Đề Thi Không Hợp Lệ!");
            return;
        } else {
            indexTmp = indexTmp - 1;
        }
    
        // Tìm kiếm câu hỏi trong danh sách
        for (int i = 0; i < danhSachCauHoi.getN(); i++) {
            if (danhSachCauHoi.getCh()[i].getIdCau().equals(listID)) {
                indexList = i;
                break;
            }
        }
        if(indexList == -1) {
            System.out.println("Câu Hỏi Không Có Trong Danh Sách");
            return;
        }
        // Kiểm tra câu hỏi đã tồn tại trong đề thi chưa
        for (int i = 0; i < soCau; i++) {
            if (index[i] == indexList) {
                System.out.println("Câu Hỏi Đã Có Trong Đề Thi");
                return;
            }
        }
        // Thêm câu hỏi vào đề thi
        for (int i = soCau ; i > indexTmp; i--) {
            index[i] = index[i - 1];
        }
        soCau++;
        index[indexTmp] = indexList;
        System.out.println("Thêm Thành Công Câu Hỏi Vào Đề Thi!");
    }
    public void FileOutPut(String documString) {
        try {
			FileWriter file = new FileWriter(documString);
			BufferedWriter buffer = new BufferedWriter(file);
			buffer.write("Số lượng câu hỏi:" + soCau);
			buffer.newLine();
			for(int i = 0; i < soCau; i++) {
                buffer.write(getDanhSachCauHoi().getCh()[getIndex()[i]].getIdCau());
				buffer.newLine();
				buffer.write(getDanhSachCauHoi().getCh()[getIndex()[i]].getNoiDungCau());
				buffer.newLine();
				buffer.write(getDanhSachCauHoi().getCh()[getIndex()[i]].getPhuongAnA());
				buffer.newLine();
				buffer.write(getDanhSachCauHoi().getCh()[getIndex()[i]].getPhuongAnB());
				buffer.newLine();
				buffer.write(getDanhSachCauHoi().getCh()[getIndex()[i]].getPhuongAnC());
				buffer.newLine();
				buffer.write(getDanhSachCauHoi().getCh()[getIndex()[i]].getPhuongAnD());
				buffer.newLine();
				buffer.write(getDanhSachCauHoi().getCh()[getIndex()[i]].getDapAn());
				buffer.newLine();
            }
			buffer.close();
			file.close();
		} catch (IOException e) {
			System.out.println("Xảy Ra Lỗi Trong Quá Trình Ghi File!");
		}
	}
       public void FileInPut(String dString) {
            try (FileReader file = new FileReader(dString);
				BufferedReader buffer = new BufferedReader(file)) {
			soCau = 0; 
           // index = new int[soCau + 1];
			getDanhSachCauHoi().setCh(new CauHoi[1]);
			String[] data = new String[7]; 
			String line = buffer.readLine(); 
			while (true) {
				data[0] = buffer.readLine(); 
				if (data[0] == null)
					break; 
				soCau++;
                getDanhSachCauHoi().setCh(Arrays.copyOf(getDanhSachCauHoi().getCh(), soCau));
                data[1] = buffer.readLine();
				data[2] = buffer.readLine();
				data[3] = buffer.readLine();
				data[4] = buffer.readLine();
				data[5] = buffer.readLine();
				data[6] = buffer.readLine();
				danhSachCauHoi.getCh()[soCau - 1] = new CauHoi(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
			}
            index = new int[soCau];
            for(int i = 0; i < soCau; i++) {
                index[i] = i;
            }
			buffer.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("Loi khi mo File!");
		}
       }

 public static void main(String[] args){
    DeThi deThi = new DeThi();
    deThi.NhapThongTinDeThi();
    deThi.HienThiDeThi();
 }
}