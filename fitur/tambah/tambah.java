package fitur.tambah;

import java.util.Scanner;
import record.Barang;

public class tambah {

    private static int readInt(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return value;
    }

    private static double readDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return value;
    }

    public static void tambahData(Barang[] daftarBarang, int jumlahBarang) {
        Scanner scanner = new Scanner(System.in);
        // Input data barang
        int id = readInt(scanner, "Masukkan ID Barang: ");
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Merek Barang: ");
        String merek = scanner.nextLine();

        System.out.print("Masukkan Kategori Barang: ");
        String kategori = scanner.nextLine();

        double harga = readDouble(scanner, "Masukkan Harga Barang: ");
        int stok = readInt(scanner, "Masukkan Stok Barang: ");
        System.out.print("Masukkan Tanggal Kadaluarsa (YYYY-MM-DD): ");
        String tanggalKadaluarsa = scanner.nextLine();

        // Tambahkan ke array
        Barang barang = new Barang(id, nama, merek, kategori, harga, stok, tanggalKadaluarsa);
        daftarBarang[jumlahBarang] = barang;
        jumlahBarang++;
        System.out.println("Barang berhasil ditambahkan!");
    }
}