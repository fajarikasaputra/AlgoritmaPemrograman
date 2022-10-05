package Pertemuan3;

import java.util.Scanner;

public class Percabangan {
    public static void main(String[] args) {
        String nama;
        int nilai;
        Scanner scan = new Scanner(System.in);

        System.out.println("Masukkan nama: ");
        nama = scan.nextLine();
        System.out.println("Masukkan nilai: ");
        nilai = scan.nextInt();

        if (nilai >= 60) {
            System.out.println("Selamat " + nama + " Anda Lulus");
        } else {
            System.out.println("Maaf " + nama + " Anda Tidak Lulus");
        }
    }
}
