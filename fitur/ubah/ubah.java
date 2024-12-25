package fitur.ubah;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import record.recordBarang; 

public class ubah {
     // Fungsi utama untuk mengubah data barang
    public static boolean ubahBarang() {
        Scanner sc = new Scanner(System.in);

        // Input data dari user
        System.out.print("Masukkan ID barang yang ingin diubah: ");
        int idBarang;
        try {
            idBarang = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID barang harus berupa angka. Proses dibatalkan.");
            return false;
        }

        System.out.print("Masukkan nama baru: ");
        String namaBaru = sc.nextLine();

        System.out.print("Masukkan merk baru: ");
        String merkBaru = sc.nextLine();

        System.out.print("Masukkan kategori baru: ");
        String kategoriBaru = sc.nextLine();

        System.out.print("Masukkan harga baru: ");
        int hargaBaru;
        try {
            hargaBaru = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Harga harus berupa angka. Proses dibatalkan.");
            return false;
        }

        System.out.print("Masukkan stok baru: ");
        int stokBaru;
        try {
            stokBaru = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Stok harus berupa angka. Proses dibatalkan.");
            return false;
        }

        System.out.print("Masukkan tanggal kadaluarsa baru (YYYY-MM-DD): ");
        String tanggalKadaluarsaBaru = sc.nextLine();

        // Proses perubahan data
        return prosesUbah(idBarang, namaBaru, merkBaru, kategoriBaru, hargaBaru, stokBaru, tanggalKadaluarsaBaru);
    }

    // Fungsi untuk membaca dan memperbarui file
    private static boolean prosesUbah(int idBarang, String namaBaru, String merkBaru, String kategoriBaru, int hargaBaru, int stokBaru, String tanggalKadaluarsaBaru) {
        File file = new File("barang.txt");
        File tempFile = new File("temp_barang.txt");
        boolean isUpdated = false;

        try (BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                recordBarang barang;
                try {
                    barang = recordBarang.fromString(line);
                } catch (Exception e) {
                    System.out.println("Error parsing line: " + line);
                    bw.write(line);
                    bw.newLine();
                    continue;
                }

                if (barang.getiIdBarang() == idBarang) {
                    // Perbarui data barang
                    barang.setsNamaBarang(namaBaru);
                    barang.setsMerek(merkBaru);
                    barang.setsKategori(kategoriBaru);
                    barang.setdHarga(hargaBaru);
                    barang.setiJumlahStok(stokBaru);
                    barang.setsTanggalKadaluarsa(tanggalKadaluarsaBaru);
                    isUpdated = true;
                }

                // Tulis ulang data (baik yang diubah maupun tidak)
                bw.write(barang.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error I/O saat memproses file: " + e.getMessage());
        }

        // Ganti file asli dengan file sementara
        if (isUpdated) {
            if (!file.delete()) {
                System.out.println("Gagal menghapus file asli.");
                return false;
            }
            if (!tempFile.renameTo(file)) {
                System.out.println("Gagal mengganti file sementara.");
                return false;
            }
            System.out.println("Data barang berhasil diubah.");
        } else {
            System.out.println("Data dengan ID " + idBarang + " tidak ditemukan.");
        }

        return isUpdated;
    }
}
