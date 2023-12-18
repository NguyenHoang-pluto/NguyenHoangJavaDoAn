

import java.util.Scanner;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Thi {
    private DeThi deThi = new DeThi();
    private String MaKiThi;
    private String TenKiThi;
    private String NgayBatDau;
    private String NgayKetThuc;
    private float diemSo;
    public Thi(){};
    public Thi(String MaKiThi, String TenKiThi, String NgayBatDau, String NgayKetThuc, float diemSo){
        this.MaKiThi = MaKiThi;
        this.TenKiThi = TenKiThi;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.diemSo = diemSo;
    }
    public DeThi getDetThi() {
    	return deThi;
    }
    public String getMaKiThi() {
        return MaKiThi;
    }
    public String getTenKiThi() {
        return TenKiThi;
    }
    public String getNgayBatDau() {
        return NgayBatDau;
    }
    public String getNgayKetThuc() {
        return NgayKetThuc;
    }
    public float getDiemSo(){
        return this.diemSo;
    }
    public void setMaKiThi(String MaKiThi) {
            this.MaKiThi = MaKiThi;
    }
    public void setTenKiThi(String TenKiThi) {
        this.TenKiThi = TenKiThi;
    }
    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }
    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }
    public void setDiemSo(float diem){
         this.diemSo = diem;
    }
    public void NhapMaKiThi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Mã Kì Thi: ");
        this.MaKiThi = scanner.nextLine();
        if (!KiemTraThongTin(this.MaKiThi)) {
            System.out.println("Mã kì thi không hợp lệ!");
            NhapMaKiThi();  
        }  
    }
    public void NhapTenKiThi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Tên Kì Thi: ");
        this.TenKiThi = scanner.nextLine();
        if (!KiemTraThongTin(this.TenKiThi)) {
            System.out.println("Tên kì thi không hợp lệ!");
            NhapTenKiThi();  
        }  
    }
    public void NhapNgayBatDau(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Ngày Bắt Đầu: ");
        this.NgayBatDau = scanner.nextLine();
        if(!KiemTraThongTin(this.NgayBatDau)||!KiemTraDinhDangNgay(this.NgayBatDau)){
            System.out.println("Định dạng ngày không hợp lệ");
            NhapNgayBatDau();
        }
}
    public void NhapNgayKetThuc(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhâp Ngày Kết Thúc: ");
        this.NgayKetThuc = scanner.nextLine();
        if(!KiemTraThongTin(this.NgayKetThuc)||!KiemTraDinhDangNgay(this.NgayKetThuc)){
            System.out.println("Định dạng ngày không hợp lệ");
            NhapNgayKetThuc();
        }
}
    public boolean KiemTraThongTin(String ThongTin){
        return ThongTin!= null && !ThongTin.trim().isEmpty();
    }
    public boolean KiemTraDinhDangNgay(String chuoiNgay){
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            df.setLenient(false);
            Date date = df.parse(chuoiNgay);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void LamDeThi(){
        int True = 0;
        this.deThi.XuatThongTinDeThi();
        // this.deThi.MonThi(doString);
        //this.deThi.NoiDungDeThi();
        int number = this.deThi.getSoCau();
        for(int i = 0; i < number; i++) {
            System.out.print("Câu hỏi " + (i+1));
            int index = deThi.getIndex()[i];
            this.deThi.getDanhSachCauHoi().getCh()[index].xuat();
            System.out.print("Chọn đáp án: ");
            String chonDapAn = NhapDapAn();
            if(chonDapAn.equals("A")){
                String dapAn = deThi.getDanhSachCauHoi().getCh()[index].getDapAn();
                String chon = deThi.getDanhSachCauHoi().getCh()[index].getPhuongAnA();
              if(dapAn.equals(chon)){
                True++;
              }
            }
            else if(chonDapAn.equals("B")){
               String dapAn = deThi.getDanhSachCauHoi().getCh()[index].getDapAn();
               String chon = deThi.getDanhSachCauHoi().getCh()[index].getPhuongAnB();
              if(dapAn.equals(chon)){
                True++;
              }
            }
             else if(chonDapAn.equals("C")){
                String dapAn = deThi.getDanhSachCauHoi().getCh()[index].getDapAn();
                String chon = deThi.getDanhSachCauHoi().getCh()[index].getPhuongAnC();
              if(dapAn.equals(chon)){
                True++;
              }
            }
             else if(chonDapAn.equals("D")){
               String dapAn = deThi.getDanhSachCauHoi().getCh()[index].getDapAn();
               String chon = deThi.getDanhSachCauHoi().getCh()[index].getPhuongAnD();
              if(dapAn.equals(chon)){
                True++;
              }
            };
        }
         diemSo = ((float)True/number)*10;
        System.out.println("Điểm số bài thi của bạn là:" + diemSo);
        if(diemSo >= 5){
            System.out.println("Số câu đúng: "+ True);
            System.out.println("Số câu sai: "+ (number - True));
          System.out.println("Xin chúc mừng bạn thông qua bài thi!");
        }
        else {
            System.out.println("Số câu đúng: "+ True);
            System.out.println("Số câu sai: "+ (number - True));
            System.out.println("Ban chưa đạt yêu cầu");
        }
    }
    public String NhapDapAn(){
        Scanner scanner = new Scanner(System.in);
        String dapAn = scanner.nextLine();
        if (!dapAn.equals("A") && !dapAn.equals("B") && !dapAn.equals("C") && !dapAn.equals("D")){
            System.out.println("Đáp án không hợp lệ xin nhập lại!");
           return NhapDapAn();
        }
        return dapAn;
    }
    public void NhapThongTinKiThi() {
        NhapMaKiThi();
        NhapTenKiThi();
        NhapNgayBatDau();
        NhapNgayKetThuc();
    }
    public void XuatThongTinKiThi() {
        System.out.println("=================================");
        System.out.println("========Thông Tin Kì Thi========= ");
        System.out.println("Mã kì thi: " + this.MaKiThi);
        System.out.println("Tên kì thi: " + this.TenKiThi);
        System.out.println("Ngày bắt đầu: " + this.NgayBatDau);
        System.out.println("Ngày kêt thúc: " + this.NgayKetThuc);
        System.out.println("=================================");
    }

}
