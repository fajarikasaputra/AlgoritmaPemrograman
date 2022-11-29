import java.util.Scanner;

public class Siakad {
    public static Scanner scan = new Scanner(System.in);
    static Mahasiswa[] mahasiswa = new Mahasiswa[10000];
    static int jumlahData = 0;

    public static void tambahData() {
        System.out.println("Silahkan tambah data \n");
        System.out.print("NIM = ");
        String nim = scan.next();
        scan.nextLine();
        System.out.print("Nama = ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData += 1;
    }

    public static void tampilData() {
        System.out.println("Berikut data anda: \n");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(mahasiswa[i].getNim() + " " + mahasiswa[i].getNama());
            i++;
        }
    }

    public static void urutkanData() {
        System.out.println("Pilih algoritma");
        System.out.println("1. Exchange Sort");
        System.out.print("\nAlgoritma = ");
        int algo;
        algo = scan.nextInt();
        switch (algo) {
            case 1:
                exchangeSort();
                break;
        }
    }

    public static void exchangeSort() {
        for (int x = 0; x < jumlahData; x++) {
            for (int y = x + 1; y < jumlahData; y++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim()) >= 1) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int option;
        Siakad siakad = new Siakad();

        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan data");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu = ");
            option = scan.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    urutkanData();
                    break;
                case 4:
                    System.out.println("Terimakasih sudah mengunjung siakad");
                    System.exit(0);
            }
            if (option > 3) {
                System.out.println("Input anda tidak sesuai, mohon ulangi lagi. \n");
            }
        } while (option > 0);

    }
}
