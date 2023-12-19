class hocphanxahoi extends HocPhan {
	String diaDiemThucTe ;
	public String getDiaDiemThucTe() {
		return diaDiemThucTe;
	}


	public void setDiaDiemThucTe(String diaDiemThucTe) {
		this.diaDiemThucTe = diaDiemThucTe;
	}


	@Override
    public void XuatThongTinHocPhan() {
        super.XuatThongTinHocPhan(); 
        System.out.println("Địa điểm thực tế:Bảo Tàng" );
    }
}