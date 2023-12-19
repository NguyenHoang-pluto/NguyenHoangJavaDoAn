import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachDeThi  {
    private DeThi[] monThi;
    private int soLuong;
    public DeThi[] getMonThi() {
        return monThi;
    }
    public void setMonThi(DeThi[] monThi) {
        this.monThi = monThi;
    }
    public DanhSachDeThi() {
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void ReadFile() {
		try (FileReader file = new FileReader("DanhSachDeThi.txt");
				BufferedReader buffer = new BufferedReader(file)) {
			this.soLuong = 0;
			this.monThi = new DeThi[1]; 
			String[] data = new String[7]; 
			while (true) {
				data[0] = buffer.readLine();
				if (data[0] == null) {
                    break; 					
                }
				this.soLuong++; 
				this.monThi = Arrays.copyOf(monThi, soLuong); 
				data[1] = buffer.readLine();
				data[2] = buffer.readLine();
				data[3] = buffer.readLine();
				data[4] = buffer.readLine();
				data[5] = buffer.readLine();
				data[6] = buffer.readLine();
	            int parsedData2 = Integer.parseInt(data[2]);
                int parsedData3 = Integer.parseInt(data[3]);
                int parsedData6 = Integer.parseInt(data[6]);
				this.monThi[soLuong - 1] = new DeThi(data[0], data[1], parsedData2, parsedData3, data[4], data[5], parsedData6);
			}
			buffer.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("Loi khi mo File!");
		}
	}
	public void ReadFile(String document) {
		try (FileReader file = new FileReader("documen");
				BufferedReader buffer = new BufferedReader(file)) {
			this.soLuong = 0;
			this.monThi = new DeThi[1]; 
			String[] data = new String[7]; 
			while (true) {
				data[0] = buffer.readLine();
				if (data[0] == null) {
                    break; 					
                }
				this.soLuong++; 
				this.monThi = Arrays.copyOf(monThi, soLuong); 
				data[1] = buffer.readLine();
				data[2] = buffer.readLine();
				data[3] = buffer.readLine();
				data[4] = buffer.readLine();
				data[5] = buffer.readLine();
				data[6] = buffer.readLine();
	            int parsedData2 = Integer.parseInt(data[2]);
                int parsedData3 = Integer.parseInt(data[3]);
                int parsedData6 = Integer.parseInt(data[6]);
				this.monThi[soLuong - 1] = new DeThi(data[0], data[1], parsedData2, parsedData3, data[4], data[5], parsedData6);
			}
			buffer.close();
			file.close();
		} catch (IOException ex) {
			System.out.println("Loi khi mo File!");
		}
	}
	public void writeFile() {
		try {
			FileWriter fw = new FileWriter("DanhSachDeThi.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < soLuong; i++) {
				bw.write(String.valueOf(getMonThi()[i].getMaDeThi()));
				bw.newLine();
				bw.write(getMonThi()[i].getTenMonThi());
				bw.newLine();
				bw.write(String.valueOf(getMonThi()[i].getThoiGian()));
				bw.newLine();
				bw.write(String.valueOf(getMonThi()[i].getSoCau()));
				bw.newLine();
				bw.write(String.valueOf(getMonThi()[i].getMaHocPhan()));
				bw.newLine();
				bw.write(getMonThi()[i].getTenHocPhan());
				bw.newLine();
				bw.write(String.valueOf(getMonThi()[i].getTinChi()));
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Lỗi Viết Vào File");
		}
	}
		public void writeFile(String doString) {
		try {
			FileWriter fw = new FileWriter("doString");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < soLuong; i++) {
				bw.write(String.valueOf(getMonThi()[i].getMaDeThi()));
				bw.newLine();
				bw.write(getMonThi()[i].getTenMonThi());
				bw.newLine();
				bw.write(String.valueOf(getMonThi()[i].getThoiGian()));
				bw.newLine();
				bw.write(String.valueOf(getMonThi()[i].getSoCau()));
				bw.newLine();
				bw.write(String.valueOf(getMonThi()[i].getMaHocPhan()));
				bw.newLine();
				bw.write(getMonThi()[i].getTenHocPhan());
				bw.newLine();
				bw.write(String.valueOf(getMonThi()[i].getTinChi()));
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println("Lỗi Viết Vào File");
		}
	}
	public void TaoDeThi() {
		Scanner scanner = new Scanner(System.in);
		String document = scanner.nextLine();
		System.out.println("1");
		System.out.println("Mời Nhập Môn Thi Mới");
		try {
			FileWriter fr = new FileWriter(document+".txt");
			BufferedWriter bw = new BufferedWriter(fr);

			bw.close();
			fr.close();
			
		} catch (Exception e) {
			System.out.println("Xảy ra lỗi trong quá trình tạo đề thi");
			return;
		}
	}
    public static void main(String[] args) {
        DanhSachDeThi ds = new DanhSachDeThi();
        ds.ReadFile();
        System.out.println( ds.getMonThi()[0].getTenMonThi());
    } 
}
