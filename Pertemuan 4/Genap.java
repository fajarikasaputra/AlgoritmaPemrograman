// package Pertemuan 4;

import java.util.Scanner;

public class Genap {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan nilai n = ");
        int n = scan.nextInt();
        int i = 1;
        while (i <= 2 * n) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            i = i + 1;
        }
        System.out.println("");
    }
}
