import java.util.Scanner;
import fitur.login.login;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isLoggedIn = false;

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
