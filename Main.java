import java.util.Scanner;
import fitur.login.login;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static boolean isLoggedIn = false;

    public static void logout() {
        isLoggedIn = false;
        System.out.println("Anda berhasil logout.");
    }

    public static void main(String[] args) {

        // Proses Login
        do {
            System.out.println("=== Login Admin ===");
            if (login.loginuser()) {
                isLoggedIn = true;
                System.out.println("Login berhasil. Selamat datang!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
                System.out.print("Coba lagi? (y/n): ");
                String retry = input.nextLine();
                if (retry.equalsIgnoreCase("n")) {
                    System.out.println("Program selesai. Terima kasih!");
                    return; // Keluar dari program
                }
            }
            input.close();
        } while (!isLoggedIn);
    }
}
