import java.util.Scanner;
import fitur.login.login;
import fitur.ubah.ubah;
import fitur.hapus.hapus;
import fitur.tambah.tambah;


public class Main {
    private static int readMenuChoice(Scanner scanner) {
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Pilihan tidak valid. Masukkan angka 1-3.");
                    System.out.print("Pilih menu (1-3): ");
                }
            } else {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // Clear invalid input
                } else {
                    break; // Tidak ada lagi input, keluar loop
                }
            }
        }
        throw new IllegalStateException("Tidak ada input valid yang tersedia.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isLoggedIn = false;

        // Proses Login
        do {
            System.out.println("=== Login Admin ===");
            if (login.loginuser()) {
                isLoggedIn = true;
                System.out.println("Login berhasil. Selamat datang!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
                System.out.print("Coba lagi? (y/n): ");
                String retry = sc.nextLine();
                if (retry.equalsIgnoreCase("n")) {
                    System.out.println("Hubungi support jika perlu bantuan. Terima kasih!");
                    return; // Keluar dari program
                }
            }
           // sc.close();
        } while (!isLoggedIn);

           // Main Menu
           boolean isRunning = true;
           while (isRunning) {
               System.out.println("\n=== Main Menu ===");
               System.out.println("1. Ubah Data Barang");
               System.out.println("2. Hapus Data Barang");
               System.out.println("3. Tambah Data Barang");
               System.out.print("Pilih menu (1-3): ");
               int choice = readMenuChoice(sc);   
               switch (choice) {
                   case 1:
                       // Jalankan fitur ubah
                       System.out.println("=== Fitur Ubah Data Barang ===");
                       boolean hasilUbah = ubah.ubahBarang();
                       if (hasilUbah) {
                           System.out.println("Data barang berhasil diubah!");
                       } else {
                           System.out.println("Proses ubah data gagal atau ID tidak ditemukan.");
                       }
                       break;
                   default:
                       System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                   case 2:
                    // Jalankan fitur hapus
                        int idBarang = hapus.mintaIdBarang();
                        boolean berhasil = hapus.hapusData(idBarang);
                        hapus.tampilHasil(berhasil);
                        break;
                     case 3:
                    // Jalankan fitur tambah
                	   System.out.println("=== Fitur Tambah Data Barang ===");   
                	   tambah.tambahData();
                       break;
                    }
                }
                sc.close();
        }
    }
