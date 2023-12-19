import java.util.Scanner;


public  class HocPhan {
    protected String MaHocPhan;
    protected String TenHocPhan;
    protected int TinChi;
    HocPhan(){}
    public HocPhan(String MaHocPhan, String TenHocPhan, int TinChi){
        this.MaHocPhan = MaHocPhan;
        this.TenHocPhan = TenHocPhan;
        this.TinChi = TinChi;
      
    }
    public void loaiHocPhan() {
        System.out.println("");
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
        
  }
    