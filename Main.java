import java.util.Scanner;
import fitur.login.login;
import fitur.ubah.ubah;
import fitur.hapus.hapus;

public class Main {

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
                    System.out.println("login berhasil. Terima kasih!");
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
               System.out.print("Pilih menu (1): ");
   
               int choice = sc.nextInt();
               sc.nextLine(); // Membersihkan newline setelah sc angka
   
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
               }
           }
           sc.close();
    }
}
