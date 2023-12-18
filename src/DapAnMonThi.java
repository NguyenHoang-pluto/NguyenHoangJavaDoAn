public class DapAnMonThi extends DeThi{
    public void XuatDapAnMonThi(){
        System.out.println("Thông tin môn thi:");
        this.XuatThongTinDeThi();
        System.out.println("Đáp án môn thi:" + this.getTenMonThi());
        for(int i = 0; i < getSoCau(); i++) {
            System.out.print("Câu hỏi: " + (i+1) );
            System.out.println(" Nội dung câu hỏi: "+ this.getDanhSachCauHoi().getCh()[i].getNoiDungCau());
            System.out.println("Đáp án đúng: " +this.getDanhSachCauHoi().getCh()[i].getDapAn());
        }  
    }
    public static void main(String[] args) {
        DapAnMonThi da = new DapAnMonThi();
        da.NhapThongTinDeThi();
        da.MonThi("TrietHoc.txt");
        da.XuatDapAnMonThi();
    }
}
