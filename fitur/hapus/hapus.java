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

    // Prosedur menampilkan hasilnya
    public static void tampilHasil(boolean berhasil) {
        if (berhasil) {
            System.out.println("Berhasil menghapus barang.");
        } else {
            System.out.println("Gagal menghapus barang.");
        }
    }
}
