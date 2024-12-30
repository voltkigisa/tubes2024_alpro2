// DITAMBAHKAN KONFIRMASI HAPUS
package fitur.hapus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import record.recordBarang;

public class hapus {
    // Prosedur untuk meminta idBarang yang akan dihapus
    public static int mintaIdBarang() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID barang yang akan dihapus: ");
        int idBarang = scanner.nextInt();
        return idBarang;
    }

    public static boolean konfirmasiHapus(int idBarang) {
        File barang = new File("barang.txt");
        List<recordBarang> daftarBarang = new ArrayList<>();

        // Membaca data dari file barang.txt
        try (BufferedReader br = new BufferedReader(new FileReader(barang))) {
            String line;
            while ((line = br.readLine()) != null) {
                recordBarang barangObj = recordBarang.fromString(line);
                daftarBarang.add(barangObj);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
            return false;
        }

        // Mencari barang berdasarkan idBarang
        for (recordBarang barangObj : daftarBarang) {
            if (barangObj.getiIdBarang() == idBarang) {
                System.out.println("\n=== Konfirmasi Data Barang ===");
                System.out.println("ID Barang: " + barangObj.getiIdBarang());
                System.out.println("Nama Barang: " + barangObj.getsNamaBarang());
                System.out.println("Merek Barang: " + barangObj.getsMerek());
                System.out.println("Kategori Barang: " + barangObj.getsKategori());
                System.out.println("Harga Barang(Rp): " + barangObj.getdHarga());
                System.out.println("Stok Barang(pcs): " + barangObj.getiJumlahStok());
                System.out.println("Tanggal Kadaluarsa: " + barangObj.getsTanggalKadaluarsa());

                // Menanyakan konfirmasi (y/n) untuk menghapus data
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nBenarkah data barang ini yang ingin Anda hapus? (y/n): ");
                String konfirmasi = scanner.nextLine();

                if (konfirmasi.equalsIgnoreCase("y")) {
                    return true; // Admin setuju untuk menghapus
                } else {
                    return false; // Admin batal menghapus
                }
            }
        }

        System.out.println("Barang dengan ID " + idBarang + " tidak ditemukan.");
        return false; // Barang tidak ditemukan
    }

    // Prosedur untuk menghapus data
    public static boolean hapusData(int idBarang) {
        File barang = new File("barang.txt");
        List<recordBarang> daftarBarang = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(barang))) {
            String line;
            while ((line = br.readLine()) != null) {
                recordBarang barangObj = recordBarang.fromString(line);
                daftarBarang.add(barangObj);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
            return false;
        }

        boolean found = false;
        Iterator<recordBarang> iterator = daftarBarang.iterator();
        while (iterator.hasNext()) {
            recordBarang barangObj = iterator.next();
            if (barangObj.getiIdBarang() == idBarang) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Barang dengan ID " + idBarang + " tidak ditemukan.");
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(barang))) {
            for (recordBarang barangObj : daftarBarang) {
                bw.write(barangObj.toString());
                bw.newLine();
            }
            System.out.println("Data barang dengan ID " + idBarang + " berhasil dihapus.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat memperbarui file: " + e.getMessage());
            return false;
        }

        return true;
    }
}
