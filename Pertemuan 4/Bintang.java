import java.util.Scanner;

public class Bintang {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i, j, k, n;

        System.out.println("Masukkan angka yang anda inginkan: ");
        n = scan.nextInt();

        // for (i = 0; i <= n; i++) {
        // System.out.println();
        // for (j = 0; j <= i; j++) {
        // System.out.print(" * ");
        // }
        // }

        for (i = 0; i <= n; i++) {
            for (j = n - 1; j >= i; j--) {
                System.out.print(" ");
            }

            for (k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}