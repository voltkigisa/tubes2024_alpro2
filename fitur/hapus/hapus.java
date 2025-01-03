package fitur.hapus;

import java.util.Scanner;
import record.Barang;

public class hapus {
    // Prosedur untuk meminta idBarang yang akan dihapus
    public static int mintaIdBarang() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID barang yang akan dihapus: ");
        int idBarang = scanner.nextInt();
        return idBarang;
    }

    // Prosedur untuk menghapus data
    public static boolean hapusData(Barang[] daftarBarang, int jumlahBarang, int idBarang) {
        boolean found = false;
        for (int i = 0; i < jumlahBarang; i++) {
            if (daftarBarang[i].getiIdBarang() == idBarang) {
                // Geser elemen-elemen setelah elemen yang dihapus ke kiri
                for (int j = i; j < jumlahBarang - 1; j++) {
                    daftarBarang[j] = daftarBarang[j + 1];
                }
                daftarBarang[jumlahBarang - 1] = null; // Hapus elemen terakhir
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Barang dengan ID " + idBarang + " tidak ditemukan.");
            return false;
        }

        System.out.println("Data barang dengan ID " + idBarang + " berhasil dihapus.");
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