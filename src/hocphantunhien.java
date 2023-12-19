public class hocphantunhien extends HocPhan{
	String diaDiemThucHanh;
     public String loaiHocPhan = "Học Phần tự Nhiên";

	 String getDiaDiemThucHanh() {
		return diaDiemThucHanh;
	}

	public void setDiaDiemThucHanh(String diaDiemThucHanh) {
		this.diaDiemThucHanh = diaDiemThucHanh;
	}
	@Override
    public void XuatThongTinHocPhan() {
        super.XuatThongTinHocPhan(); 
        System.out.println("Địa điểm thực tế:" + this.diaDiemThucHanh);
    }
}