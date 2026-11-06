import java.util.Scanner;

class Sach {
    String maSach;
    String tenSach;
    int soLuong;
    double gia;

    public Sach() {}

    public void nhapSach(Scanner sc) {
        System.out.print("Nhap ma sach: ");
        maSach = sc.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach = sc.nextLine();
        System.out.print("Nhap so luong: ");
        soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap gia tien: ");
        gia = Double.parseDouble(sc.nextLine());
    }

    public void xuatSach() {
        System.out.printf("Ma: %-10s | Ten: %-20s | So luong: %-5d | Gia: %,.2f%n", 
                          maSach, tenSach, soLuong, gia);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sach[] danhSach = null;
        int n = 0;
        int luaChon;

        do {
            System.out.println("\n========== QUAN LY THU VIEN ==========");
            System.out.println("1. Nhap danh sach n cuon sach");
            System.out.println("2. Tinh tong so luong va gia tri");
            System.out.println("3. Tim sach theo ma");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("========================================");
            System.out.print("Vui long chon chuc nang (0-3): ");
            
            while (!sc.hasNextInt()) {
                System.out.print("Lua chon khong hop le. Vui long nhap so: ");
                sc.next();
            }
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap so luong sach: ");
                    n = Integer.parseInt(sc.nextLine());
                    danhSach = new Sach[n];
                    
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Nhap thong tin cuon sach thu " + (i + 1) + " ---");
                        danhSach[i] = new Sach();
                        danhSach[i].nhapSach(sc);
                    }
                    System.out.println("=> Da nhap xong danh sach!");
                    break;

                case 2:
                    if (danhSach == null || danhSach.length == 0) {
                        System.out.println("Chua co du lieu sach. Vui long chon 1 de nhap!");
                    } else {
                        int tongSoLuong = 0;
                        double tongGiaTri = 0;
                        for (int i = 0; i < n; i++) {
                            tongSoLuong += danhSach[i].soLuong;
                            tongGiaTri += (danhSach[i].soLuong * danhSach[i].gia);
                        }
                        System.out.println("\n--- THONG KE ---");
                        System.out.println("Tong so luong sach: " + tongSoLuong);
                        System.out.printf("Tong gia tri sach: %,.2f VND\n", tongGiaTri);
                    }
                    break;

                case 3:
                    if (danhSach == null || danhSach.length == 0) {
                        System.out.println("Chua co du lieu sach. Vui long chon 1 de nhap!");
                    } else {
                        System.out.print("Nhap ma sach can tim: ");
                        String maTimKiem = sc.nextLine();
                        boolean timThay = false;

                        System.out.println("\n--- KET QUA TIM KIEM ---");
                        for (int i = 0; i < n; i++) {
                            if (danhSach[i].maSach.equalsIgnoreCase(maTimKiem)) {
                                danhSach[i].xuatSach();
                                timThay = true;
                                break; 
                            }
                        }
                        if (!timThay) {
                            System.out.println("Khong tim thay sach co ma: " + maTimKiem);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Da thoat chuong trinh. Tam biet!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
                    break;
            }
        } while (luaChon != 0);

        sc.close();
    }
}