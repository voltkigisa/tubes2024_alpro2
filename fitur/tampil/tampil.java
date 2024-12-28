package fitur.tampil;

import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;
import java.util.Scanner;

public class tampil {
    public static void tampilkanData() {
        // Membaca file barang.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("barang.txt"))) {
            String line;
            System.out.println("=== Daftar Barang ===");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file.");
        }
    }
}
