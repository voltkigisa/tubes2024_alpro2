package fitur.tambah;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class tambah {

    private static final String FILE_PATH = "barang.txt";

    public static void tambahData() {
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Input data barang
            System.out.print("Masukkan ID Barang: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Masukkan Nama Barang: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan Merek Barang: ");
            String merek = scanner.nextLine();

            System.out.print("Masukkan Kategori Barang: ");
            String kategori = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            int harga = scanner.nextInt();

            System.out.print("Masukkan Stok Barang: ");
            int stok = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Masukkan Tanggal Kadaluarsa (YYYY-MM-DD): ");
            String tanggalKadaluarsa = scanner.nextLine();

            // Format data barang
            String newBarang = String.format(
                "%d,\"%s\",\"%s\",\"%s\",%d,%d,\"%s\"",
                id, nama, merek, kategori, harga, stok, tanggalKadaluarsa
            );

            // Tambahkan ke file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.newLine(); // Tambahkan baris baru
                writer.write(newBarang);
            }

            // menampilkan hasilnya
            System.out.println("Barang berhasil ditambahkan!");
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menulis ke file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Input tidak valid: " + e.getMessage());
        }
    }
}
