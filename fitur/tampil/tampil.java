package fitur.tampil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import record.Barang;

public class tampil {
    public static void tampilkanData() {
        // Misalnya membaca data barang dari file
        File file = new File("barang.txt");
        if (!file.exists()) {
            System.out.println("File barang.txt tidak ditemukan.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Barang barang = Barang.fromString(line);
                    System.out.println(barang);
                } catch (IllegalArgumentException e) {
                    System.out.println("Data tidak valid: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }
}
