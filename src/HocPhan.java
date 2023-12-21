import java.util.Scanner;


public  class HocPhan {
    protected String MaHocPhan;
    protected String TenHocPhan;
    protected int TinChi;
    protected String loai;

    HocPhan() {
    }

    public HocPhan(String MaHocPhan, String TenHocPhan, int TinChi, String loai) {
        this.MaHocPhan = MaHocPhan;
        this.TenHocPhan = TenHocPhan;
        this.TinChi = TinChi;
        this.loai = loai;
    }
    public String getMaHocPhan() {
        return MaHocPhan;
    }
    public void setMaHocPhan(String MaHocPhan) {
        this.MaHocPhan = MaHocPhan;
    }
    public String getTenHocPhan() {
        return TenHocPhan;
    }

    public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

    public void setTenHocPhan(String TenHocPhan) {
        this.TenHocPhan = TenHocPhan;
    }

    public int getTinChi() {
        return TinChi;
    }

    public void setTinChi(int TinChi) {
        this.TinChi = TinChi;
    }
    public void capNhat() {
        Scanner scan = new Scanner(System.in);
        int n;
        do {
            System.out.println("Vui long chon muc can chinh sua");
            System.out.println("1.MaHocPhan\n2.TenHocPhan\n3.TinChi\n4. Thoat" );
            System.out.println("Chon: ");
            n = Integer.parseInt(scan.nextLine());
            switch (n) {
                case 1:
                    System.out.println("Nhap Ma Hoc Phan moi: ");
                    MaHocPhan = scan.nextLine();
                    break;
                case 2:
                    System.out.println("Nhap Ten Hoc Phan moi: ");
                    TenHocPhan = scan.nextLine();
                    break;
                case 3:
                    System.out.println("Nhap so Tin Chi moi: ");
                    TinChi = Integer.parseInt(scan.nextLine());
                    break;
                case 4: return;
                default:
                    System.out.println("Khong hop le!!!");
                    
            }
        } while (true);
    }
    public void NhapMaHocPhan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Mã Học Phần :");
        this.MaHocPhan = scanner.nextLine();
        if(!KiemTraThongTin(this.MaHocPhan)){
            System.out.println("Mã Học Phần Không Hợp lệ");
            NhapMaHocPhan();
        }     
    }
    public void NhapTenHocPhan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Tên Học Phần :");
        this.TenHocPhan = scanner.nextLine();
        if(!KiemTraThongTin(this.TenHocPhan)){
            System.out.println("Tên Học Phần Không Hợp lệ");
            NhapTenHocPhan();
        }     
    }
    public boolean KiemTraThongTin(String thongTin) {
        return thongTin != null && !thongTin.trim().isEmpty();
    }
    public void NhapTinChi() {
        int tmp;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi nhap so tin chi cho hoc phan :");
        tmp = scanner.nextInt();
        if (tmp > 0) {
            this.TinChi = tmp;
        } else {
            System.out.println("So cau khong hop le! Nhap lai.");
           NhapTinChi();
        }
    }

    public void XuatThongTinHocPhan(){
    System.out.println("Mã Học Phần : "+ this.MaHocPhan);
    System.out.println("Tên Học Phần : "+ this.TenHocPhan);
    System.out.println("Số Tín Chỉ : "+ this.TinChi);
    }
    public void XuatThongTinHocPhan() {
        System.out.println("Ma hoc phan : " + this.MaHocPhan);
        System.out.println("Ten hoc phan : " + this.TenHocPhan);
        System.out.println("So Tin Chi : " + this.TinChi);
    }

    public void GhiFile(String filename) throws IOException {
    	try {
			FileWriter file = new FileWriter(filename);
			BufferedWriter buffer = new BufferedWriter(file);
			String code = "1";
			String tinchi =  String.valueOf(TinChi);
				buffer.write(code);
				buffer.newLine();
				buffer.write(MaHocPhan);
				buffer.newLine();
				buffer.write(TenHocPhan);
				buffer.newLine();
				buffer.write(tinchi);
				buffer.newLine();
				buffer.write(loai);
				buffer.newLine();
			buffer.close();
			file.close();
			;
		} catch (IOException e) {
			System.out.println("Loi khi mo File!");
		}
    }
        
  }
    
