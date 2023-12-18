import java.util.Scanner;

public class KiThi{
	private String NgayBatDau;
	private String NgayKetThuc;
	private String KiThi;
	private String MaKT;
	public KiThi() {
		//Mặc định 
	}
	
	public KiThi(String ngayBatDau, String ngayKetThuc, String kiThi) {

		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
		KiThi = kiThi;
	}



	public void Nhap() {
		Scanner Sc = new Scanner(System.in);
		System.out.println("Nhập Ngày bắt đầu thi:");
		NgayBatDau = Sc.nextLine();
		System.out.println("Nhập Ngày kết thúc thi:");
		NgayKetThuc = Sc.nextLine();
		System.out.println("Nhập Kì thi:");
		KiThi = Sc.nextLine();

	}
	
	public void Xuat() {
		System.out.println("Kì thi:" + this.KiThi);
		System.out.println("Ngày bắt đầu thi:" + this.NgayBatDau);
		System.out.println("Ngày kết thúc thi:"+ this.NgayKetThuc);
		System.out.println("Mã kì thi:" + this.MaKT);
		
	}
	
	
	public String getNgayBatDau() {
		return NgayBatDau;
	}
	public void setNgayBatDau(String ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}
	public String getNgayKetThuc() {
		return NgayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
	public String getKiThi() {
		return KiThi;
	}
	public void setKiThi(String kiThi) {
		KiThi = kiThi;
	}
	@Override
	public String toString() {
		return "KiThi [NgayBatDau=" + NgayBatDau + ", NgayKetThuc=" + NgayKetThuc + ", KiThi=" + KiThi + "]";
	}
	
	public static void main(String[] args) {
		KiThi Kt = new KiThi();
		Kt.Nhap();
		Kt.Xuat();
	}
}
