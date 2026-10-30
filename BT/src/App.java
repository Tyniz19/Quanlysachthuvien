import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- NHAP THONG TIN SACH ---");
        
        System.out.print("Nhap ma sach: ");
        String maSach = scanner.nextLine();

        System.out.print("Nhap ten sach: ");
        String tenSach = scanner.nextLine();

        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();

        System.out.print("Nhap nam xuat ban: ");
        int namXuatBan = scanner.nextInt();

        System.out.print("Nhap don gia: ");
        double donGia = scanner.nextDouble();

        System.out.print("Nhap so luong: ");
        int soLuong = scanner.nextInt();
        System.out.println("\nChon loai sach:");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Nhap lua chon cua ban (1-4): ");
        int loaiSach = scanner.nextInt();

        System.out.println("\n--- KET QUA KIEM TRA VA PHAN LOAI ---");

        boolean hopLe = true;
        if (donGia <= 0 || soLuong < 0 || namXuatBan <= 0 || namXuatBan > 2026) {
            System.out.println("Trang thai: Thong tin sach KHONG hop le!");
            hopLe = false;
        } else {
            System.out.println("Trang thai: Thong tin sach hop le.");
        }

        // BÀI 2, 3, 4: Chỉ tiếp tục phân loại nếu dữ liệu ở Bài 1 hợp lệ
        if (hopLe == true) {
            
            // BÀI 2: Phân loại giá (Dùng if-else)
            System.out.print("Phan loai gia: ");
            if (donGia < 50000) {
                System.out.println("Sach gia thap");
            } else if (donGia <= 100000) {
                System.out.println("Sach gia trung binh");
            } else if (donGia <= 200000) {
                System.out.println("Sach gia cao");
            } else {
                System.out.println("Sach gia dac biet");
            }

            // BÀI 3: Phân loại tồn kho (Dùng if-else)
            System.out.print("Tinh trang kho: ");
            if (soLuong == 0) {
                System.out.println("Het sach");
            } else if (soLuong >= 1 && soLuong <= 5) {
                System.out.println("Sap het");
            } else if (soLuong >= 6 && soLuong <= 20) {
                System.out.println("Con it");
            } else { // soLuong > 20
                System.out.println("Con nhieu");
            }

            // BÀI 4: Chọn loại sách (Dùng switch-case)
            System.out.print("Loai sach: ");
            switch (loaiSach) {
                case 1:
                    System.out.println("Sach giao khoa");
                    break;
                case 2:
                    System.out.println("Sach tham khao");
                    break;
                case 3:
                    System.out.println("Sach chuyen nganh");
                    break;
                case 4:
                    System.out.println("Sach khac");
                    break;
                default:
                    System.out.println("Lua chon khong hop le (Khong xac dinh)");
                    break;
            }
        }

        scanner.close();
    }
}