/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package thuchanh.lap2;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static void nhapTK(Account tk) {
        System.out.println("Nhap so tai khoan: ");
        tk.setsoTK(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhap ten tai khoan: ");
        tk.setTenTK(sc.nextLine());
        tk.setsoTienTrongTK(50);
    }
    public static void main(String[] args) {
        Account a[] = null;
        int k, b, n = 0;
        long s, d, c, f;
        boolean flag = true;
        do {
            System.out.println("Ban chon lam gi: ");
            System.out.println("""
                               1.Nhap thong tin cua cac khach hang
                               2.Xuat danh sach thong tin cua cac khach hang
                               3.Nap tien
                               4.Rut tien
                               5 Dao han
                               6.Chuyen khoan
                               So khac \u0111e thoat""");
            b = sc.nextInt();
            switch (b) {
                case 1:
                    System.out.println("Nhap so luong khach hang ban muon nhap: ");
                    n = sc.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Khach hang so: " + (i+1));
                        a[i] = new Account();
                        nhapTK(a[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-20s\n", "soTK", "tenTK", "soTienTrongTK");
                    for (int i = 0; i < n; i++) {
                        a[i].inTK();
                    }
                    break;
                case 3:
                    System.out.println("Nhap so tai khoan khach hang can nap tien: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].napTien();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhap so tai khoan khach hang can rut tien: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].rutTien();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Nhap so tai khoan khach hang can đao han: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].daoHan();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 6:
                    double chuyen,
                            nhan,
                            tienChuyen;
                    System.out.print("Nhap so tai khoan khach hang chuyen tien: ");
                    s = sc.nextLong();
                    System.out.print("Nhap so tai khoan khach hang nhan tien: ");
                    c = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            chuyen = a[i].getSoTienTrongTK();
                            for (int j = 0; j < n; j++) {
                                f = a[j].getSoTK();
                                if (c == f) {
                                    nhan = a[j].getSoTienTrongTK();
                                    System.out.println("Nhap so tien can chuyen");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen) {
                                        chuyen = chuyen - tienChuyen;
                                        nhan = nhan + tienChuyen;
                                        a[i].setSoTienTrongTK(chuyen);
                                        a[j].setSoTienTrongTK(nhan);
                                        System.out.println("Tai khoan so " + d + " vua chuyen: $" + tienChuyen);
                                        System.out.println("Tài khoan so " + f + " vua nhan: $" + tienChuyen);
                                    } else {
                                        System.out.println("So tien nhap kong hop le!");
                                    }
                                } else {
                                    System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                default:
                    System.out.println("Bye!!");
                    flag = false;
                    break;
            }
        } while (flag);
}
}

