import java.util.Scanner;

public class App {
	private static Scanner scan = new Scanner(System.in);
    public static DanhSachCauHoi DSCH = new DanhSachCauHoi();
    public static DanhSachGiaoVien DSGV = new DanhSachGiaoVien();
    public static StudentList DSSV = new StudentList();
    public static DanhSachDeThi DSDT = new DanhSachDeThi();
    public static DanhSachKetQua DSKQ = new DanhSachKetQua();
    public static int MatKhau = 12345678;
    public static int id;
    public static DeThi deThi = new DeThi();
    public static Thi thi = new Thi();
    public static DapAnMonThi dapAn = new DapAnMonThi();
    public static void clearScreen(){
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------UNG DUNG QUAN LY THI TRAC NGHIEM--------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public static void DangNhap(){
        int m;
        do{
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------UNG DUNG QUAN LY THI TRAC NGHIEM--------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("ID cua ban:");
            id = Integer.parseInt(scan.nextLine());
            System.out.println("Mat khau:");
            m = Integer.parseInt(scan.nextLine());
            if(id <= DSSV.getN() && m == 12345678) {
            	MenuSinhVien();
            } else {
            	System.out.println("Sai thông tin đăng nhập mời bạn nhập lại");
            }
        }while(true);
        
    }
    public static void DangNhapAdmin() {
    	int m;
do{
        	
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------UNG DUNG QUAN LY THI TRAC NGHIEM--------------------------------------");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("ID cua giang vien:");
            id = Integer.parseInt(scan.nextLine());
            System.out.println("Mat khau:");
            m = Integer.parseInt(scan.nextLine());
            
            if(id <= DSGV.getN() && m == 123456) {
            	menuAdmin();
            } else {
            	System.out.println("Sai thong tin đang nhập moi ban nhap lai");
            }
        }while(true);
    }
    
    public static void ThongTinSinhVien() {
    	DSSV.searchId(id - 1);
    	clearScreen();
    	MenuSinhVien();
    }
    
    public static void CapNhatThongTinSinhVien() {
    	DSSV.updateInfo(id);
    	clearScreen();
    	MenuSinhVien();
    }
    public static void MenuSinhVien(){
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
           System.out.println("1.Vào Thi");
           System.out.println("2.Xem Thông Tin");
           System.out.println("3.Cập Nhật Thông Tin");
           System.out.println("4.Đăng Xuất");
            option = scanner.nextInt();
           if(option == 1){
        	   while (true) {
        	     System.out.println("Chọn Môn Bạn Muốn Thi"); 
                 System.out.println("1.Môn Triết Học");
                 System.out.println("2.Môn Kiến Trúc Máy Tính");
                 System.out.println("3.Môn Mạng Máy Tính");
                 System.out.println("4.Môn Kinh Tế Vĩ Mô");
                 System.out.println("5.Quay Lai");
                 System.out.println("6.Trang Chủ");
                 option = scanner.nextInt();
                 if(option == 1) {
                    thi.getDetThi().setMaDeThi(DSDT.getMonThi()[0].getMaDeThi());
                    thi.getDetThi().setTenMonThi(DSDT.getMonThi()[0].getTenMonThi());
                    thi.getDetThi().setThoiGian(DSDT.getMonThi()[0].getThoiGian());
                    thi.getDetThi().FileInPut("DeThiTrietHoc.txt");
                    thi.LamDeThi();
                    MenuSinhVien();
                 } else if(option ==2) {
                    thi.getDetThi().setMaDeThi(DSDT.getMonThi()[1].getMaDeThi());
                    thi.getDetThi().setTenMonThi(DSDT.getMonThi()[1].getTenMonThi());
                    thi.getDetThi().setThoiGian(DSDT.getMonThi()[1].getThoiGian());
                    thi.getDetThi().FileInPut("DeThiKienTrucMayTinh.txt");
                    thi.LamDeThi();
                    MenuSinhVien();
                 }
                 else if(option==3) {
                    thi.getDetThi().setMaDeThi(DSDT.getMonThi()[2].getMaDeThi());
                    thi.getDetThi().setTenMonThi(DSDT.getMonThi()[2].getTenMonThi());
                    thi.getDetThi().setThoiGian(DSDT.getMonThi()[2].getThoiGian());
                    thi.getDetThi().FileInPut("DeThiMangMayTinh.txt");
                    thi.LamDeThi();
                    MenuSinhVien();
                 }
                 else if(option==4) {
                    thi.getDetThi().setMaDeThi(DSDT.getMonThi()[3].getMaDeThi());
                    thi.getDetThi().setTenMonThi(DSDT.getMonThi()[3].getTenMonThi());
                    thi.getDetThi().setThoiGian(DSDT.getMonThi()[3].getThoiGian());
                    thi.getDetThi().FileInPut("DeThiKinhTeViMo.txt");
                    thi.LamDeThi();
                    MenuSinhVien();
                 }
                 else if(option == 5) {
                    MenuSinhVien();
                 }
                 else if(option == 6) {
                    MenuSinhVien();
                 }
                 else{
                    System.out.println("Lựa chọn không hợp lệ");
                 }
               }
           } else if(option == 2){
            System.out.println("Thông Tin Sinh Viên");
            ThongTinSinhVien();
 
           } else if(option == 3){
             System.out.println("Moi Cap nhat thong tin");
             CapNhatThongTinSinhVien();
        }  else if(option == 4){
            ThongThiTracNghiem();
        }
         System.out.println("Khong Hop Le Moi Nhap Lai");
        }
    }
    public static void menuAdmin() {
    	Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
            clearScreen();
           System.out.println("1.Danh sách học sinh");
           System.out.println("2.Danh sách giảng viên");
           System.out.println("3.Danh sách câu hỏi");
           System.out.println("4.Cập nhật danh sách câu hỏi");
           System.out.println("5.Cập nhật danh sách học sinh");
           System.out.println("6.Cập nhật danh sách giảng viên");
           System.out.println("7.Thống kê theo khoa");
           System.out.println("8.Thống kê theo kì thi");
           System.out.println("9.Thống kê theo khoản điểm");
           System.out.println("10.Thống kê giáo viên");
           System.out.println("11.Danh Sách Đề Thi");
           System.out.println("12.Đăng xuất");
            option = scanner.nextInt();
           if(option == 1){
        	   System.out.println("Danh sách học sinh");
        	   clearScreen();
        	   DSSV.printList();
        	   menuAdmin();
           } else if(option == 2){
               System.out.println("Danh sách giảng viên");
               DSGV.xuatDS();
               menuAdmin();
           } else if(option == 3){
               DanhSachMonHoc();
               menuAdmin();
           }  else if(option == 4) {
        	    System.out.println("Cập nhật danh sách câu hỏi");
             	ThayDoiNoiDungDanhSach();
        	}
       		else if(option == 5) {
        	System.out.println("Cập nhật danh sách học sinh");
       		}
       		else if(option == 6) {
        	System.out.println("Cập nhật danh sách giảng viên");
        	}
            else if(option == 7){
                return;
                       System.out.println("Nhập vào khoa mà bạn muốn thống kê điểm số");
                       String khoa = scanner.next();
                       DSKQ.khoaStatistic(khoa);
                       menuAdmin();
                   } else if(option == 8) {
                       System.out.println("Nhập vào kì thi mà bạn muốn thống kê điểm số");
                       String kithi = scanner.next();
                       DSKQ.hkStatistic(kithi);
                       menuAdmin();
                   } else if(option == 9) {
                       clearScreen();
                       DSKQ.ReadFile();
                       DSKQ.DisplayStatistic();
                       menuAdmin();
                   } else if (option == 10) {
                       DSGV.statistics();
                       menuAdmin();
                   }
            else if(option == 11) {
                 System.out.println("Kết Thúc Chương Trình");
                System.exit(0);
            }
         System.out.println("Khong Hop Le Moi Nhap Lai");
        }
    }
    public static void DanhSachDeThi() {
        while(true) {
            System.out.println("===================================START===========================================");
            System.err.println("1.Danh Sách Câu Hỏi Thi Môn Triết Học");
            System.out.println("2.Danh Sách Câu Hỏi Thi Môn Kiến Trúc Máy Tính");
            System.out.println("3.Danh Sách Câu Hỏi Thi Mạng Máy Tính");
            System.out.println("4.Danh Sách Câu Hỏi Thi Môn Kinh Tế Vĩ Mô");
            System.out.println("5.Quay Lại");
            System.out.println("6.Quay Về Trang Chủ");
            System.out.println("====================================END============================================");
            Scanner scanner = new Scanner(System.in);
            int option;
            option = scanner.nextInt();
            if(option == 1) {
               //DSDT.ReadFile();
               //DSDT.getMonThi()[0].MonThi("TrietHoc.txt");
               ChiTietMonThi("TrietHoc.txt",0);
              // DSDT.getMonThi()[0].FileOutPut("DeThiTrietHoc.txt");
               DanhSachDeThi();
            }
            else if(option == 2) {
               //DSDT.ReadFile();
               //DSDT.getMonThi()[1].MonThi("KienTrucMayTinh.txt");
               ChiTietMonThi("KienTrucMayTinh.txt",1);
             //  DSDT.getMonThi()[1].FileOutPut("DeThiKienTrucMayTinh.txt");
               DanhSachDeThi();
            }
            else if(option == 3){
              // DSDT.ReadFile();
               //DSDT.getMonThi()[2].MonThi("MangMayTinh.txt");
               ChiTietMonThi("MangMayTinh.txt",2);
               //DSDT.getMonThi()[2].FileOutPut("DeThiMangMayTinh.txt");
               DanhSachDeThi();
            }
            else if(option == 4) {
               //DSDT.ReadFile();
               //DSDT.getMonThi()[3].MonThi("KinhTeViMo.txt");
               ChiTietMonThi("KinhTeViMo.txt",3);
              // DSDT.getMonThi()[2].FileOutPut("DeThiKinhTeViMo.txt");
               DanhSachDeThi();
            }
            else if (option == 5){
                menuAdmin();
            }
            else if( option == 6) {
                menuAdmin();
            } else {
                System.out.println("Lựa Chọn Không Hợp Lệ");
            }

        }

    }
    public static void ChiTietMonThi(String documents, int index) {
        while (true) {
            System.out.println("=============================================START======================================");
            System.out.println("1.Xem Nội Dung Môn Thi");
            System.out.println("2.Xem Thông Tin Môn Tin");
            System.out.println("3.Xem Học Phần Môn  Thi");
            System.out.println("4.Thêm Câu Hỏi Vào Đề Thi");
            System.out.println("5.Xóa Câu Hỏi Trong Đề Thi");
            System.out.println("6.Thay Đổi Câu Hỏi Trong Đề Thi");
            System.out.println("7.Xem Đáp Án Đề Thi");
            System.out.println("8.Chỉnh Sửa Thông Tin Đề Thi");
            System.out.println("9.Quay Lại");
            System.out.println("10.Trang Chủ");
            System.out.println("==============================================END=======================================");
            Scanner scanner = new Scanner(System.in);
            int option ,luaChon , soLuong;
            option = scanner.nextInt();
            if(option == 1){
                     System.out.println("Tên Môn Thi : "+ DSDT.getMonThi()[index].getTenMonThi());
                     DSDT.getMonThi()[index].NoiDungDeThi();
                     ChiTietMonThi(documents,index);
            }
            else if(option == 2) {
              DSDT.getMonThi()[index].XuatThongTinDeThi();
              ChiTietMonThi(documents,index);
            }
            else if(option == 3){
             DSDT.getMonThi()[index].XuatThongTinHocPhan();
             ChiTietMonThi(documents,index);
            }
            else if(option == 4) {
                System.out.println("Bạn Muốn Thêm Theo Phương Thức Nào");
                System.err.println("1.Thêm Câu Hỏi Theo Vị Trí Trong Danh Sách");
                System.out.println("2.Thêm Câu Hỏi Theo ID Trong Danh Sách");
                luaChon = scanner.nextInt();
                if(luaChon == 1) {
                    System.out.println("Số Lượng Câu Hỏi Cần Thêm Là: ");
                    soLuong = scanner.nextInt();
                    for(int i = 0; i < soLuong; i++) {
                        DSDT.getMonThi()[index].ThemCauHoiVaoDeThiViTri();
                        DSDT.getMonThi()[index].FileOutPut("DeThi"+documents);
                    }
                } else if(luaChon == 2) {
                    System.out.println("Số Lượng Câu Hỏi Cần Thêm Là: ");
                    soLuong = scanner.nextInt();
                    for(int i = 0; i < soLuong; i++) {
                        DSDT.getMonThi()[index].ThemCauHoiVaoDeThiID();
                        DSDT.getMonThi()[index].FileOutPut("DeThi"+documents);
                    }
                }
                else {
                    System.out.println("Lựa Chọn Không Hợp Lệ!");
                    ChiTietMonThi(documents,index);
                }
                    ChiTietMonThi(documents,index);
            }
            else if(option == 5){
                System.out.println("Bạn Xóa Theo Phương Thức Nào");
                System.out.println("1.Xóa Câu Hỏi Theo Vị Trí Trong Đề Thi");
                System.out.println("2.Xóa Câu Hỏi Theo ID Trong Đề Thi");
                luaChon = scanner.nextInt();
                if(luaChon == 1) {
                    System.out.println("Số Lượng Câu Hỏi Cần Xóa Là: ");
                    soLuong = scanner.nextInt();
                    for(int i = 0; i < soLuong; i++) {
                        DSDT.getMonThi()[index].XoaCauHoiDeThiViTri();
                        DSDT.getMonThi()[index].FileOutPut("DeThi"+documents);
                    }
                } else if(luaChon == 2) {
                    System.out.println("Số Lượng Câu Hỏi Cần Xóa Là: ");
                    soLuong = scanner.nextInt();
                    for(int i = 0; i < soLuong; i++) {
                        DSDT.getMonThi()[index].XoaCauHoiDeThiTheoID();
                        DSDT.getMonThi()[index].FileOutPut("DeThi"+documents);
                    }
                }
                else {
                    System.out.println("Lựa Chọn Không Hợp Lệ!");
                    ChiTietMonThi(documents,index);
                }
                    ChiTietMonThi(documents,index);
            }
            else if(option == 6){
                System.out.println("Bạn Muốn Thay Đổi Theo Phương Thức Nào");
                System.err.println("1.Thay Đổi Câu Hỏi Theo Vị Trí Trong Đề Thi");
                System.out.println("2.Thay Đổi Câu Hỏi Theo ID Trong Đề Thi");
                luaChon = scanner.nextInt();
                if(luaChon == 1) {
                    System.out.println("Số Lượng Câu Hỏi Cần Thay Đổi Là: ");
                    soLuong = scanner.nextInt();
                    for(int i = 0; i < soLuong; i++) {
                        DSDT.getMonThi()[index].ThayDoiCauHoiDeThiViTri();
                        DSDT.getMonThi()[index].FileOutPut("DeThi"+documents);
                    }
                } else if(luaChon == 2) {
                    System.out.println("Số Lượng Câu Hỏi Cần Thây Đổi Là: ");
                    soLuong = scanner.nextInt();
                    for(int i = 0; i < soLuong; i++) {
                        DSDT.getMonThi()[index].ThayDoiCauHoiDeThiID();
                        DSDT.getMonThi()[index].FileOutPut("DeThi"+documents);
                    }
                }
                else {
                    System.out.println("Lựa Chọn Không Hợp Lệ!");
                    ChiTietMonThi(documents,index);
                }
                    ChiTietMonThi(documents,index);
            }
            else if(option == 7){
               dapAn.FileInPut("DeThi"+documents);
               dapAn.setMaDeThi(DSDT.getMonThi()[index].getMaDeThi());
               dapAn.setTenMonThi(DSDT.getMonThi()[index].getTenMonThi());
               dapAn.setThoiGian(DSDT.getMonThi()[index].getThoiGian());
               dapAn.XuatDapAnMonThi();
               ChiTietMonThi(documents,index);
            }
            else if(option == 8){
                ChinhSuaThongTinDeThi(documents,index);
                ChiTietMonThi(documents,index);
            }
            else if(option == 9) {
                  DanhSachDeThi();  
            } else if(option == 10) {
                  ThongThiTracNghiem();
            }
             else {
                System.out.println("Lựa Chọn Không Hợp Lệ");
            }
        }
    }
    public static void ChinhSuaThongTinDeThi(String documents,int index) {
        while (true) {
             System.out.println("1.Thay Đổi Số Câu Trong Đề Thi" );
             System.out.println("2.Thay Đổi Thời Gian Trong Đề Thi");
             System.out.println("3.Thay Đổi Mã Đề Thi");
             System.out.println("4.Thay Đổi Tên Đề Thi");
             System.out.println("5.Thay Đổi Mã Học Phần");
             System.out.println("6.Thay Đổi Tên Học Phần");
             System.out.println("7.Thay Đổi Tín Chỉ Học Phần");
             System.out.println("8.Quay Lại");
             System.out.println("9.Trang Chủ");
             Scanner scanner = new Scanner(System.in);
             int luaChon;
             luaChon = scanner.nextInt();
            if (luaChon == 1) {
                DSDT.getMonThi()[index].NhapSoCau();
                DSDT.writeFile();
                DSDT.ReadFile();
                ChinhSuaThongTinDeThi(documents,index);
            } else if(luaChon == 2) {
                DSDT.getMonThi()[index].NhapThoiGian();
                DSDT.writeFile();
                DSDT.ReadFile();
                ChinhSuaThongTinDeThi(documents,index);
            }
            else if(luaChon == 3) {
                DSDT.getMonThi()[index].NhapMaDeThi();
                DSDT.writeFile();
                DSDT.ReadFile();
                ChinhSuaThongTinDeThi(documents,index);
            }
            else if(luaChon == 4) {
                DSDT.getMonThi()[index].NhapTenMonThi();
                DSDT.writeFile();
                DSDT.ReadFile();
                ChinhSuaThongTinDeThi(documents,index);
            }
            else if(luaChon == 5) {
                DSDT.getMonThi()[index].NhapMaHocPhan();
                DSDT.writeFile();
                DSDT.ReadFile();
                ChinhSuaThongTinDeThi(documents,index);
            }
            else if(luaChon == 6) {
                DSDT.getMonThi()[index].NhapTenHocPhan();
                DSDT.writeFile();
                DSDT.ReadFile();
                ChinhSuaThongTinDeThi(documents,index);
            }
            else if(luaChon == 7) {
                DSDT.getMonThi()[index].NhapTinChi();
                DSDT.writeFile();
                DSDT.ReadFile();
                ChinhSuaThongTinDeThi(documents,index);
            }
            else if(luaChon == 8) {
                ChiTietMonThi(documents,index);
            }
            else if(luaChon== 9) {
                menuAdmin();
            }
            else {
                System.out.println("Lựa Chọn Không Hợp Lệ");
            }
        }
    }
    public static void DanhSachMonHoc() {
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
        System.out.println("=======================================================");
        System.out.println("Danh Sách Môn Học Bạn Muốn Xuất Ra Là:");
        System.out.println("1.Danh Sách Môn Triết Học");
        System.out.println("2.Danh Sách Môn Kiến Trúc Máy Tính");
        System.out.println("3.Danh Sách Môn Mạng Máy Tính");
        System.out.println("4.Danh Sách Môn Kinh Tế Vĩ Mô");
        System.out.println("5.Quay Lại");
        System.out.println("6.Trang Chủ");
        option = scanner.nextInt();
        if(option == 1){
            DSDT.getMonThi()[0].getDanhSachCauHoi().docFile("TrietHoc.txt"); 
            DSDT.getMonThi()[0].getDanhSachCauHoi().XuatCauHoiDS();
             DanhSachMonHoc();
        } 
        else if(option == 2){
            DSDT.getMonThi()[1].getDanhSachCauHoi().docFile("KienTrucMayTinh.txt");
            DSDT.getMonThi()[1].getDanhSachCauHoi().XuatCauHoiDS();
             DanhSachMonHoc();
        } 
        else if(option == 3){
          DSDT.getMonThi()[2].getDanhSachCauHoi().docFile("MangMayTinh.txt");
          DSDT.getMonThi()[2].getDanhSachCauHoi().XuatCauHoiDS();
           DanhSachMonHoc();
        } 
        else if(option == 4){
           DSDT.getMonThi()[3].getDanhSachCauHoi().docFile("KinhTeViMo.txt");
           DSDT.getMonThi()[3].getDanhSachCauHoi().XuatCauHoiDS();
            DanhSachMonHoc();
        } 
        else if(option == 5){
            menuAdmin();
        }
        else if(option == 6) {
             menuAdmin();
        }

        else {
            System.out.println("Lựa Chọn Của Bạn Không Hợp Lệ Vui Lòng Nhập Lại !!!");
        }
    }
    }
    public static void ThayDoiNoiDungDanhSach(){
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
        System.out.println("=======================================================");
        System.out.println("Danh Sách Môn Học Bạn Muốn Thay Đổi Là:");
        System.out.println("1.Danh Sách Môn Triết Học");
        System.out.println("2.Danh Sách Môn Kiến Trúc Máy Tính");
        System.out.println("3.Danh Sách Môn Mạng Máy Tính");
        System.out.println("4.Danh Sách Môn Kinh Tế Vĩ Mô");
        System.out.println("5.Quay Lại");
        System.out.println("6.Trở Về Trang chủ");
        option = scanner.nextInt();
        if(option == 1){
            DSDT.getMonThi()[0].getDanhSachCauHoi().docFile("TrietHoc.txt");
            PhuongThucCapNhat("TrietHoc.txt",0);
            ThayDoiNoiDungDanhSach();
        } 
        else if(option == 2){
            DSDT.getMonThi()[1].getDanhSachCauHoi().docFile("KienTrucMayTinh.txt");
            PhuongThucCapNhat("KienTrucMayTinh.txt",1);
            ThayDoiNoiDungDanhSach();
        } 
        else if(option == 3){
           DSDT.getMonThi()[2].getDanhSachCauHoi().docFile("MangMayTinh.txt");
           PhuongThucCapNhat("MangMayTinh.txt",2);
           ThayDoiNoiDungDanhSach();
        } 
        else if(option == 4){
          DSDT.getMonThi()[1].getDanhSachCauHoi().docFile("KinhTeViMo.txt");
          PhuongThucCapNhat("KinhTeViMo.txt",3);
        } 
        else if(option == 5){
            menuAdmin();
        }
        else if(option == 6) {
             menuAdmin();
        }
        else {
            System.out.println("Lựa Chọn Của Bạn Không Hợp Lệ Vui Lòng Nhập Lại !!!");
        }
    }
    }
    public static void CapNhatDanhSachTheoViTri(String document,int index) {
        Scanner scanner = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("======================================================");
            System.out.println("Nhập Lựa Chọn Thay Đổi Danh Sách Của Bạn");
            System.out.println("1.Tôi Muốn Thêm Câu Hỏi Vào Danh Sách");
            System.out.println("2.Tôi Muốn Xóa Câu Hỏi Khỏi Danh Sách");
            System.out.println("3.Tôi Muốn Thay Đổi Câu Hỏi Trong Sách");
            System.out.println("4.Quay Lại");
            System.out.println("5.Trở Về Trang chủ");
            option = scanner.nextInt();
        if(option == 1){
             ThemCauHoi(index);
             DSDT.getMonThi()[index].getDanhSachCauHoi().ghiFile(document);
             CapNhatDanhSachTheoViTri(document,index);
        } 
        else if(option == 2){
            XoaCauHoi(index);
            DSDT.getMonThi()[index].getDanhSachCauHoi().ghiFile(document);
            CapNhatDanhSachTheoViTri(document,index);
        } 
        else if(option == 3){
            SuaCauHoi(index);
            DSDT.getMonThi()[index].getDanhSachCauHoi().ghiFile(document);
            CapNhatDanhSachTheoViTri(document,index);
        } 
        else if(option == 4){
            PhuongThucCapNhat(document,index);
        } 
        else if(option == 5){
             menuAdmin();
        }else{
            System.out.println("Lựa Chọn Của Bạn Không Hợp Lệ Vui Lòng Nhập Lại !!!");
        }
        }
    }
    public static void CapNhatDanhSachTheoID(String document,int index){
        Scanner scanner = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("======================================================");
            System.out.println("Nhập Lựa Chọn Thay Đổi Danh Sách Của Bạn");
            System.out.println("1.Tôi Muốn Thêm Câu Hỏi Vào Danh Sách");
            System.out.println("2.Tôi Muốn Xóa Câu Hỏi Khỏi Danh Sách");
            System.out.println("3.Tôi Muốn Thay Đổi Câu Hỏi Trong Sách");
            System.out.println("4.Quay Lại");
            System.out.println("5.Trở Về Trang chủ");
            option = scanner.nextInt();
            scanner.nextLine();
        if(option == 1){
            ThemCauHoi(index);
            DSDT.getMonThi()[index].getDanhSachCauHoi().ghiFile(document);
            CapNhatDanhSachTheoID(document,index);
        } 
        else if(option == 2){
            System.out.println("Mời Nhập ID Câu Hỏi Cần Xóa");
            String ID = scanner.nextLine();
            DSDT.getMonThi()[index].getDanhSachCauHoi().XoaPhanTuTheoID(ID);
            DSDT.getMonThi()[index].getDanhSachCauHoi().ghiFile(document);
            CapNhatDanhSachTheoID(document,index);
        } 
        else if(option == 3){
            System.out.println("Mời Nhập ID Câu Hỏi Cần Chỉnh Sửa");
            String ID = scanner.nextLine();
            DSDT.getMonThi()[index].getDanhSachCauHoi().SuaPhanTuTheoID(ID);
            DSDT.getMonThi()[index].getDanhSachCauHoi().ghiFile(document);
            CapNhatDanhSachTheoID(document,index);
        } 
        else if(option == 4){
            PhuongThucCapNhat(document,index);
        } 
        else if(option == 5){
             menuAdmin();
        }else{
            System.out.println("Lựa Chọn Của Bạn Không Hợp Lệ Vui Lòng Nhập Lại !!!");
        }
        }
    }
    public static void PhuongThucCapNhat(String document, int index){
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
             System.out.println("====================================================================");
             System.out.println("1.Phương Thức Cập Nhật Theo ID Câu Hỏi");
             System.out.println("2.Phương Thức Cập Nhật Theo Vị Trí Câu Hỏi");
             System.out.println("3.Quay Lại");
             System.out.println("4.Trở Về Trang Chủ");
             option = scanner.nextInt();
             if (option == 1) {
                CapNhatDanhSachTheoID(document, index);
                PhuongThucCapNhat(document,index);
             } else if(option == 2) {
                CapNhatDanhSachTheoViTri(document,index);
                PhuongThucCapNhat(document,index);
             } else if (option == 3) {
                ThayDoiNoiDungDanhSach();
             } else if(option == 4) {
                menuAdmin();
             } else {
                System.out.println("Lựa Chọn Không Hợp Lệ !!!");
             }
        }
    }
    public static void ThemCauHoi(int in){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Số Lượng Câu Hỏi Cần Thêm:");
        int number = scanner.nextInt();
        for(int i = 0; i < number; i++) {   
            System.out.println("Xin Mời Nhập Vị Trí Cần Thêm Câu Hỏi Vào Danh Sách");
            System.out.println("Vị Trí Thứ : " );
            int index = scanner.nextInt();
            DSDT.getMonThi()[in].getDanhSachCauHoi().ThemPhanTuTheoViTri(index - 1);
        }
        System.out.println("Thêm Câu Hỏi Thành Công !");
    }
    public static void XoaCauHoi(int in){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Số Lượng Câu Hỏi Cần Xóa:");
        int number = scanner.nextInt();
        int starIndex[] = new int[number];
        for(int i = 0; i < number; i++) {
            System.out.println("Xin Mời Nhập Vị Trí Cần Xóa Câu Hỏi Vào Danh Sách");
            System.out.println("Vị Trí Thứ :");
            starIndex[i] = RangBuocViTri(in);
            if(i > 0 && starIndex[i] == (starIndex[i-1] + 1)){
                starIndex[i] = starIndex[i-1];
            }
        }
        for(int i = 0; i < number;i++) {
             DSDT.getMonThi()[in].getDanhSachCauHoi().XoaPhanTuTheoViTri(starIndex[i] - 1);
        }
            System.out.println("Xóa Câu Hỏi Thành Công !");
    }
    public static void SuaCauHoi(int in){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Số Lượng Câu Hỏi Cần Thay Đổi:");
        int number = scanner.nextInt();
        for(int i = 0; i < number; i++) {
            System.out.println("Xin Mời Nhập Vị Trí Cần Sửa Câu Hỏi Vào Danh Sách");
            System.out.println("Vị Trí Thứ :");
            int index = RangBuocViTri(in);
            DSDT.getMonThi()[in].getDanhSachCauHoi().SuaPhanTuTheoViTri(index - 1);
        }
        System.out.println("Sửa Câu Hỏi Thành Công !!!!");
    }
    public static int RangBuocViTri(int i){
        Scanner scanner = new Scanner(System.in);
        int index;
        index = scanner.nextInt();
        if(index <= 0 || index > DSDT.getMonThi()[i].getDanhSachCauHoi().getN()) {
            System.out.println("Vị Trí Câu Hỏi Không Hợp Lệ Xin Nhập Lại !!!");
            return RangBuocViTri(i);
        }
        return index;
    }
    public static void ThongThiTracNghiem(){
        Scanner scanner = new Scanner(System.in);
        int option;
        clearScreen();
        do{
     System.out.println("===============================================");
        System.out.println("Bạn muốn đăng nhập với tư cách gì: ");
        System.out.println("1.Tư cách sinh viên");
        System.out.println("2.Tư cách giáo viên");
        System.out.println("3.Kết Thúc Chương Trình");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                  DangNhap();
                    return;
                case 2:
                    DangNhapAdmin();
                    return;
                case 3:
                   return;
            }
            System.out.println("Khong hop le moi nhap lai");
        }while(true);
    }
    public static void main(String[] args) {
        DSDT.ReadFile();
        DSDT.getMonThi()[0].MonThi("TrietHoc.txt");
        DSDT.getMonThi()[0].FileOutPut("DeThiTrietHoc.txt");
        DSDT.getMonThi()[1].MonThi("KienTrucMayTinh.txt");
        DSDT.getMonThi()[1].FileOutPut("DeThiKienTrucMayTinh.txt");
        DSDT.getMonThi()[2].MonThi("MangMayTinh.txt");
        DSDT.getMonThi()[2].FileOutPut("DeThiMangMayTinh.txt");
        DSDT.getMonThi()[3].MonThi("KinhTeViMo.txt");
        DSDT.getMonThi()[3].FileOutPut("DeThiKinhTeViMo.txt");
    	DSGV.docFile("danhsachgiaovien");
    	DSSV.readFile("student-data.txt");
        App app = new App();
        app.ThongThiTracNghiem();
    }
}