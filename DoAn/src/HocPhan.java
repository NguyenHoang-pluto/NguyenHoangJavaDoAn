import java.util.Scanner;


public  class HocPhan {
    protected int MaHocPhan;
    protected String TenHocPhan;
    protected int TinChi;
    
    HocPhan(){}
    public HocPhan(int MaHocPhan, String TenHocPhan, int TinChi){
        this.MaHocPhan = MaHocPhan;
        this.TenHocPhan = TenHocPhan;
        this.TinChi = TinChi;
    }
    public int getMaHocPhan() {
        return MaHocPhan;
    }

    public void setMaHocPhan(int MaHocPhan) {
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
                    MaHocPhan = Integer.parseInt(scan.nextLine());
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
    public void XuatThongTinHocPhan(){
    System.out.println("Ma hoc phan : "+ this.MaHocPhan);
    System.out.println("Ten hoc phan : "+ this.TenHocPhan);
    System.out.println("So Tin Chi : "+ this.TinChi);
    }
        
  }
    