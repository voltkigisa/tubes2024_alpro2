package fitur.ubah;

import java.util.Scanner;
import record.Barang;

public class ubah {
    // Fungsi utama untuk mengubah data barang
    public static boolean ubahBarang(Barang[] daftarBarang, int jumlahBarang) {
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
        double hargaBaru;
        try {
            hargaBaru = Double.parseDouble(sc.nextLine());
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
        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getiIdBarang() == idBarang) {
                daftarBarang[i].setsNamaBarang(namaBaru);
                daftarBarang[i].setsMerek(merkBaru);
                daftarBarang[i].setsKategori(kategoriBaru);
                daftarBarang[i].setdHarga(hargaBaru);
                daftarBarang[i].setiJumlahStok(stokBaru);
                daftarBarang[i].setsTanggalKadaluarsa(tanggalKadaluarsaBaru);
                return true;
            }
        }

        System.out.println("Data dengan ID " + idBarang + " tidak ditemukan.");

        return false;
    }
}