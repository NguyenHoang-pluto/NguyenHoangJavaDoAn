import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachGiaoVien implements File, DuyetDS{
	private GiaoVien[] gv;
	private int n;
	public DanhSachGiaoVien() {
		
	}
	
	
	public DanhSachGiaoVien(GiaoVien[] giaoVien, int n) {
		gv = giaoVien;
		this.n = n;
	}

	public GiaoVien[] getGiaoVien() {
		return gv;
	}

	public void setGiaoVien(GiaoVien[] giaoVien) {
		gv = giaoVien;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public void timKiem() {
		// TODO Auto-generated method stub
	}
	public int timKiemid(String Maso){
        for (int i = 0; i < n; i++){
            if (gv[i].getId() == Maso)
                return i;
        }
        return -1;
    }
    public int timKiem(String Ten){
        for (int i = 0; i < n; i++){
            if ((gv[i].getLastName()).equalsIgnoreCase(Ten))
                return i;
        }
        return -1;
    }

	@Override
	public void sapXep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void themPT() {
		// TODO Auto-generated method stub
		n++;
		gv = Arrays.copyOf(gv, n);
		gv[n - 1] = new GiaoVien();
		gv[n - 1].nhap();
	}

	@Override
	public boolean xoaPT(int x) {
		if (x > n)  return false;
        n--;
        if (x > n)  return true;
        for (int i = x; i < n; i++){
            gv[i] = gv[i+1];
        }
        gv[n] = null;
        gv = Arrays.copyOf(gv, n);
        return true;
	}

	@Override
	 public void nhapDS() {
        String ho;
        String ten;
        String MaSo;
        String khoa;
        String NgaySinh;
        String GioiTinh;
        Scanner scan = new Scanner(System.in);
        do{   
            System.out.print("Nhap So Luong Giao Vien: ");
            n = Integer.parseInt(scan.nextLine());
        }while(n < 0);
        gv = new GiaoVien[n];
        for (int i = 0; i < n; i++){
            System.out.println("Giao Vien " + i);
            System.out.println("Nhập vào id của giáo viên:");
            MaSo = scan.nextLine();
            System.out.print("Nhap Ho: ");
            ho = scan.nextLine();
            System.out.print("Nhap Ten: ");
            ten = scan.nextLine();
            System.out.println("Nhap Ngay sinh: ");
            NgaySinh = scan.nextLine();
            System.out.println("Nhap vao khoa cua giao vien: ");
            khoa = scan.nextLine();
            System.out.println("Nhap Gioi Tinh: ");
            GioiTinh = scan.nextLine();
            gv[i] = new GiaoVien(MaSo,khoa,ho ,ten, GioiTinh,NgaySinh);
        }
    }

	@Override
	public void xuatDS() {
       
        System.out.printf("|%-10s|%-24s|%-15s|%-15s|%-12s|%s\n", "Ma So","khoa","ho", "Ten", "Ngay Sinh", "Gioi Tinh" );
        for (int i = 0; i < 70; i++)
            System.out.print("-");
        System.out.println();
        for (GiaoVien s : gv) {
            System.out.printf("|%-10s|%-24s|%-15s|%-15s|%-12s|%s\n",s.getId(), s.getKhoa(),s.getFirstName(),s.getLastName(), s.getdateOfBirth(), s.getGender());
        }
   	
	}

	@Override
	public void docFile() {
		// TODO Auto-generated method stub
		
	}
	public void docFile(String nameFile) {
		try (FileReader file = new FileReader(nameFile); 
	            BufferedReader buffer = new BufferedReader(file)) {
	                 n = 0;
	                 gv = new GiaoVien[1];
	                 String []data = new String[6];
	                 String line = buffer.readLine();
	                 System.out.println(line);
	                 while (true){
	                     data[0] = buffer.readLine();
	                     if (data[0] == null)
	                         break;
	                     n++;
	                     gv = Arrays.copyOf(gv, n);
	                     data[1] = buffer.readLine();
	                     data[2] = buffer.readLine();
	                     data[3] = buffer.readLine();
	                     data[4] = buffer.readLine();
	                     data[5] = buffer.readLine();
	                     gv[n-1] = new GiaoVien(data[0], data[1], data[2], data[3], data[4], data[5]);
	                 }
	                buffer.close();
	                file.close();
	        } catch (IOException ex) {
	            System.out.println("Loi khi mo File!");
	        }
	}

	@Override
	public void ghiFile() {
		// TODO Auto-generated method stub
	}
	 public void ghiFile(String nameFile) {
		 try {
				FileWriter file = new FileWriter(nameFile);
				BufferedWriter buffer = new BufferedWriter(file);
				buffer.write("Số lượng giáo viên:" + n);
				buffer.newLine();
				for(GiaoVien s : gv) {
					buffer.write(s.getId());
					buffer.newLine();
					buffer.write(s.getKhoa());
					buffer.newLine();
					buffer.write(s.getFirstName());
					buffer.newLine();
					buffer.write(s.getLastName());
					buffer.newLine();
					buffer.write(s.getdateOfBirth());
					buffer.newLine();
					buffer.write(s.getGender());
					buffer.newLine();
				}
				buffer.close();
				file.close();;
			} catch (IOException e) {
				System.out.println("Loi khi mo File!");
			}
	    }
	
	

}
