import java.util.Scanner;
import fitur.login.login;
import fitur.ubah.ubah;
import fitur.hapus.hapus;
import fitur.tambah.tambah;
import fitur.tampil.tampil;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static boolean isLoggedIn = false;

    private static void Login() {
        while (!isLoggedIn) {
            System.out.println("=== Login Admin ===");
            if (login.loginuser()) {
                isLoggedIn = true;
                System.out.println("Login berhasil. Selamat datang!");
                tampilMenu();
            } else {
                System.out.println("Login gagal! Username atau password salah.");
                System.out.print("Coba lagi? (y/n): ");
                String retry = sc.nextLine();
                if (retry.equalsIgnoreCase("n")) {
                    System.out.println("Hubungi support jika perlu bantuan. Terima kasih!");
                    System.exit(0);
                    return; // Keluar dari program
                }
            }
        }
    }

    private static int readMenuChoice(Scanner scanner) {
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice >= 0 && choice <= 5) {
                    return choice;
                } else {
                    System.out.println("Pilihan tidak valid. Masukkan angka 1-5.");
                    System.out.print("Pilih menu (0-5): ");
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

    private static int tampilMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Ubah Data Barang");
        System.out.println("2. Hapus Data Barang");
        System.out.println("3. Tambah Data Barang");
        System.out.println("4. Tampil Data Barang");
        System.out.println("5. Logout");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu : ");
        int choice = readMenuChoice(sc);
        startAgain(choice);
        return choice;
    }

    private static void startAgain(int choice) {
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
                tampilMenu();
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            case 2:
                // Jalankan fitur hapus
                System.out.println("\n=== Fitur Hapus Data Barang ===");
                int idBarang = hapus.mintaIdBarang();
                // Menambahkan konfirmasi sebelum menghapus data
                if (hapus.konfirmasiHapus(idBarang)) {
                    boolean berhasil = hapus.hapusData(idBarang);
                } else {
                    System.out.println("Proses hapus data dibatalkan.");
                }
                tampilMenu();
                break;
            case 3:
                // Jalankan fitur tambah
                System.out.println("=== Fitur Tambah Data Barang ===");
                tambah.tambahData();
                tampilMenu();
                break;
            case 4:
                // Jalankan fitur tampil data
                System.out.println("4. Tampil Data Barang");
                tampil.tampilkanData();
                tampilMenu();
                break;
            case 5:
                System.out.println("Logout berhasil. Sampai jumpa!");
                isLoggedIn = false;
                Login();
                break;
            case 0:
                System.out.println("Keluar dari program. Sampai jumpa!");
                System.exit(choice);
                break;
        }
    }

    public static void main(String[] args) {
        // Proses Login
        Login();
    }
}
