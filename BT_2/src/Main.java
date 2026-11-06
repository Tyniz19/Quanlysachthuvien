import java.util.Scanner;
import java.util.ArrayList;

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
        ArrayList<Sach> danhSach = new ArrayList<>();
        int luaChon;

        do {
            System.out.println("\n========== QUAN LY THU VIEN (ARRAYLIST) ==========");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.println("==================================================");
            System.out.print("Vui long chon chuc nang (1-8): ");
            
            while (!sc.hasNextInt()) {
                System.out.print("Lua chon khong hop le. Vui long nhap so: ");
                sc.next();
            }
            luaChon = sc.nextInt();
            sc.nextLine(); 

            switch (luaChon) {
                case 1: 
                    System.out.println("\n--- Them sach moi ---");
                    Sach sachMoi = new Sach();
                    sachMoi.nhapSach(sc);
                    danhSach.add(sachMoi);
                    System.out.println("=> Da them sach thanh cong!");
                    break;

                case 2: 
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sach dang trong!");
                    } else {
                        System.out.println("\n--- DANH SACH CUON SACH ---");
                        for (Sach s : danhSach) {
                            s.xuatSach();
                        }
                    }
                    break;

                case 3: 
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sach dang trong!");
                    } else {
                        System.out.print("Nhap ma sach can tim: ");
                        String maTimKiem = sc.nextLine();
                        boolean timThay = false;
                        
                        for (Sach s : danhSach) {
                            if (s.maSach.equalsIgnoreCase(maTimKiem)) {
                                System.out.println("\n--- Ket qua tim kiem ---");
                                s.xuatSach();
                                timThay = true;
                                break;
                            }
                        }
                        if (!timThay) {
                            System.out.println("Khong tim thay sach co ma: " + maTimKiem);
                        }
                    }
                    break;

                case 4:
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sach dang trong!");
                    } else {
                        System.out.print("Nhap ma sach can xoa: ");
                        String maXoa = sc.nextLine();
                        boolean xoaThanhCong = false;
                        
                        for (int i = 0; i < danhSach.size(); i++) {
                            if (danhSach.get(i).maSach.equalsIgnoreCase(maXoa)) {
                                danhSach.remove(i);
                                System.out.println("=> Da xoa sach thanh cong!");
                                xoaThanhCong = true;
                                break;
                            }
                        }
                        if (!xoaThanhCong) {
                            System.out.println("Khong tim thay ma sach de xoa!");
                        }
                    }
                    break;

                case 5:
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sach dang trong!");
                    } else {
                        System.out.print("Nhap ma sach can sua: ");
                        String maSua = sc.nextLine();
                        boolean suaThanhCong = false;
                        
                        for (Sach s : danhSach) {
                            if (s.maSach.equalsIgnoreCase(maSua)) {
                                System.out.println("Nhap thong tin moi (Ma sach giu nguyen la " + s.maSach + "):");
                                System.out.print("Nhap ten sach: ");
                                s.tenSach = sc.nextLine();
                                System.out.print("Nhap so luong: ");
                                s.soLuong = Integer.parseInt(sc.nextLine());
                                System.out.print("Nhap gia tien: ");
                                s.gia = Double.parseDouble(sc.nextLine());
                                
                                System.out.println("=> Da cap nhat thong tin sach thanh cong!");
                                suaThanhCong = true;
                                break;
                            }
                        }
                        if (!suaThanhCong) {
                            System.out.println("Khong tim thay ma sach de sua!");
                        }
                    }
                    break;

                case 6:
                    int tongSL = 0;
                    for (Sach s : danhSach) {
                        tongSL += s.soLuong;
                    }
                    System.out.println("=> Tong so luong tat ca cac sach: " + tongSL);
                    break;

                case 7:
                    double tongGiaTri = 0;
                    for (Sach s : danhSach) {
                        tongGiaTri += (s.soLuong * s.gia);
                    }
                    System.out.printf("=> Tong gia tri tat ca cac sach: %,.2f VND\n", tongGiaTri);
                    break;

                case 8:
                    System.out.println("Da thoat chuong trinh. Tam biet!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai!");
                    break;
            }
        } while (luaChon != 8);

        sc.close();
    }
}