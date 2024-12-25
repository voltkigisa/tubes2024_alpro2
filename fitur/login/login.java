package fitur.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class login {

    // Fungsi untuk membaca file dan memeriksa username dan password
    static public boolean bacaFile(String usernameInput, String passwordInput) {
        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:\\Users\\Lenov\\Documents\\Kuliah Unpas\\semester3\\Alpro II\\tubes2024_alpro2\\fitur\\login\\users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) { // Membaca file baris per baris
                if (prosesBaris(line, usernameInput, passwordInput)) {
                    return true; // Login berhasil
                }
            }
        } catch (IOException e) {
            System.out.println("Error I/O saat membaca file: " + e.getMessage());
        }

        return false; // Login gagal
    }

    // Fungsi untuk memproses setiap baris dalam file
    private static boolean prosesBaris(String line, String usernameInput, String passwordInput) {
        String[] parts = line.split(",");
        return parts.length == 2 && parts[0].equals(usernameInput) && parts[1].equals(passwordInput);
    }

    // Fungsi utama login
    public static boolean loginuser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String username = sc.nextLine();
        System.out.print("Masukkan password: ");
        String password = sc.nextLine();

        sc.close();
        // Cek login
        return bacaFile(username, password); // Baca file dan cek login
    }
}
