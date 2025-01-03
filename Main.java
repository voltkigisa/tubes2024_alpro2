import java.util.Scanner;
import java.io.*;
import fitur.login.login;
import fitur.ubah.ubah;
import fitur.hapus.hapus;
import fitur.tambah.tambah;
import record.Barang;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static boolean isLoggedIn = false;
    private static Barang[] daftarBarang = new Barang[100]; // Array untuk menyimpan barang
    private static int jumlahBarang = 0; // Jumlah barang yang ada dalam array

    private static void Login() {
        System.out.println("=== Login Admin ===");
        if (login.loginuser()) {
            isLoggedIn = true;
            System.out.println("Login berhasil. Selamat datang!");
            startAgain();
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

    private static int readMenuChoice(Scanner scanner) {
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice >= 0 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Pilihan tidak valid. Masukkan angka 1-4.");
                    System.out.print("Pilih menu (1-4): ");
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
        System.out.println("4. Logout");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu : ");
        int choice = readMenuChoice(sc);
        return choice;
    }

    private static void startAgain() {
        while (true) {
            int choice = tampilMenu();
            switch (choice) {
                case 1:
                    // Jalankan fitur ubah
                    System.out.println("=== Fitur Ubah Data Barang ===");
                    boolean hasilUbah = ubah.ubahBarang(daftarBarang, jumlahBarang);
                    if (hasilUbah) {
                        System.out.println("Data barang berhasil diubah!");
                        saveBarang();
                    } else {
                        System.out.println("Proses ubah data gagal atau ID tidak ditemukan.");
                    }
                    break;
                case 2:
                    // Jalankan fitur hapus
                    System.out.println("=== Fitur Hapus Data Barang ===");
                    int idBarang = hapus.mintaIdBarang();
                    boolean berhasil = hapus.hapusData(daftarBarang, jumlahBarang, idBarang);
                    hapus.tampilHasil(berhasil);
                    saveBarang();
                    break;
                case 3:
                    // Jalankan fitur tambah
                    System.out.println("=== Fitur Tambah Data Barang ===");
                    tambah.tambahData(daftarBarang, jumlahBarang);
                    saveBarang();
                    break;
                case 4:
                    System.out.println("Logout berhasil. Sampai jumpa!");
                    isLoggedIn = false;
                    Login();
                    return; // Keluar dari loop dan kembali ke login
                case 0:
                    System.out.println("Keluar dari program. Sampai jumpa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void loadBarang() {
        try (BufferedReader br = new BufferedReader(new FileReader("barang.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Barang barang = Barang.fromString(line);
                daftarBarang[jumlahBarang++] = barang;
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }

    private static void saveBarang() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("barang.txt"))) {
            for (int i = 0; i < jumlahBarang; i++) {
                if (daftarBarang[i] != null) {
                    bw.write(daftarBarang[i].toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis ke file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Proses Login
        loadBarang();
        Login();
    }
}