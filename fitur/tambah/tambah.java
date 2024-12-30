package fitur.tambah;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class tambah {

    private static final String FILE_PATH = "barang.txt";

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

    public static void tambahData() {
        Scanner scanner = new Scanner(System.in);
        // Input data barang
        int id = readInt(scanner, "Masukkan ID Barang: ");
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Merek Barang: ");
        String merek = scanner.nextLine();

        System.out.print("Masukkan Kategori Barang: ");
        String kategori = scanner.nextLine();

        int harga = readInt(scanner, "Masukkan Harga Barang (Rp): ");
        int stok = readInt(scanner, "Masukkan Stok Barang(pcs): ");
        System.out.print("Masukkan Tanggal Kadaluarsa (YYYY-MM-DD): ");
        String tanggalKadaluarsa = scanner.nextLine();

        // Format data barang
        String newBarang = String.format(
                "%d,\"%s\",\"%s\",\"%s\",%d,%d,\"%s\"",
                id, nama, merek, kategori, harga, stok, tanggalKadaluarsa);

        // Tambahkan ke file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.newLine(); // Tambahkan baris baru
            writer.write(newBarang);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis ke file: " + e.getMessage());
        }

        System.out.println("Barang berhasil ditambahkan!");
    }
}
