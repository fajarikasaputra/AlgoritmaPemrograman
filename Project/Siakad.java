import java.util.Scanner;
import java.io.*;

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

    public static void cariData() {
        System.out.println("Pilih Pencarian");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("\n Masukkan Pencarian: ");
        int cardat;
        cardat = scan.nextInt();
        switch (cardat) {
            case 1:
                linearSearch();
                break;
            case 2:
                System.out.print("Masukan Nim = ");
                String filterValue = scan.next();
                Integer indexFound = binarySearch(mahasiswa, filterValue, 0, jumlahData - 1);
                if (indexFound != null) {
                    System.out.println("Data yang anda cari :");
                    System.out.println(mahasiswa[indexFound].getNama() + " " + mahasiswa[indexFound].getNim());
                } else if (indexFound == null) {
                    System.out.println("Data tidak ditemukan");
                }
                break;
            // binarySearch(search);
            // break;
        }
    }

    public static void urutkanData() {
        System.out.println("Pilih algoritma");
        System.out.println("1. Exchange Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Bubble Sort");
        System.out.println("4. Quick Sort");
        System.out.println("5. Shell Sort");
        System.out.print("\nAlgoritma = ");
        int algo;
        algo = scan.nextInt();
        switch (algo) {
            case 1:
                exchangeSort();
                break;
            case 2:
                selectionSort();
                break;
            case 3:
                bubbleSort(mahasiswa);
                break;
            case 4:
                quickSort(mahasiswa, 0, jumlahData - 1);
                break;
            case 5:
                shellSort();
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

    // public static void shellSort(Mahasiswa[] arr) {
    // int n = arr.length();
    // for(int i = 0; i > n; i++) {

    // }

    // }

    public static void shellSort() {
        int juml = jumlahData - 1;
        int gap = juml / 2;
        boolean swap = true;
        Mahasiswa temp;
        while (gap > 0) {
            swap = true;
            while (swap == true) {
                swap = false;
                for (int i = 0; i <= (juml - gap); i++) {
                    int temp2 = Integer.parseInt(mahasiswa[i].getNim());
                    int temp3 = Integer.parseInt(mahasiswa[i + gap].getNim());
                    ;
                    if (temp2 > temp3) {
                        temp = mahasiswa[i];
                        mahasiswa[i] = mahasiswa[i + gap];
                        mahasiswa[i + gap] = temp;
                        swap = true;
                    }
                }
            }
            gap = gap / 2;
        }
    }

    public static void selectionSort() {
        int i, j;
        int n = mahasiswa.length;

        for (i = 0; i < n - 1; i++) {

            int minItem = i;

            for (j = i + 1; j < n; j++) {
                if (mahasiswa[j] == null) {
                    continue;
                }
                if (mahasiswa[j].getNim().compareTo(mahasiswa[minItem].getNim()) <= -1)
                    minItem = j;

                Mahasiswa temp = mahasiswa[minItem];
                mahasiswa[minItem] = mahasiswa[i];
                mahasiswa[i] = temp;

            }
        }
    }

    public static void bubbleSort(Mahasiswa[] arr) {
        int i, j;
        int n = mahasiswa.length;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - 1; j++) {
                if (mahasiswa[j] == null) {
                    continue;
                }
                if (mahasiswa[j + 1] == null) {
                    continue;
                }
                if (mahasiswa[j].getNim().compareTo(mahasiswa[j + 1].getNim()) >= 1) {

                    Mahasiswa temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j + 1];
                    mahasiswa[j + 1] = temp;
                }
            }
            if (swapped == false)
                break;
        }
    }

    public static void quickSort(Mahasiswa arr[], int low, int high) {
        boolean sorted = false;
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        sorted = true;
    }

    public static int partition(Mahasiswa arr[], int low, int high) {
        int parsing = Integer.parseInt(arr[high].getNim());
        int pivot = parsing;
        int i = (low - 1);
        Mahasiswa temp;
        for (int j = low; j <= high - 1; j++) {
            int temp2 = Integer.parseInt(mahasiswa[j].getNim());
            if (temp2 < pivot) {
                i++;
                temp = mahasiswa[j];
                mahasiswa[j] = mahasiswa[i];
                mahasiswa[i] = temp;

            }
        }
        temp = mahasiswa[i + 1];
        mahasiswa[i + 1] = mahasiswa[high];
        mahasiswa[high] = temp;
        return (i + 1);
    }

    public static void linearSearch() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Nama/NIM = ");
        String xdata = scan.nextLine();
        for (int i = 0; i < jumlahData; i++) {
            String temp = mahasiswa[i].getNama();
            String temp2 = mahasiswa[i].getNim();
            if (xdata.equals(temp)) {
                System.out.println("Data yang anda cari ditemukan4");
                System.out.println(mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim());
                System.out.println(" ");
            } else if (xdata.equals(temp2)) {
                System.out.println("Data yang anda cari ditemukan");
                System.out.println(mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim());
                System.out.println(" ");
            } else {
                System.out.println("Data yang anda cari tidak ditemukan");
            }

        }
    }

    public static Integer binarySearch(Mahasiswa[] arr, String filterValue, int low, int high) {

        quickSort(mahasiswa, 0, jumlahData - 1);
        if (low > high) {
            return null;
        }

        else {
            int mid = (low + high) / 2;
            int temp2 = Integer.parseInt(arr[mid].getNim());
            if (Integer.valueOf(filterValue) == temp2) {

                return mid;
            } else if (Integer.valueOf(filterValue) > temp2) {
                return binarySearch(mahasiswa, filterValue, mid + 1, high);

            } else {
                return binarySearch(mahasiswa, filterValue, low, mid - 1);
            }
        }
    }

    public static void editData() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (i < jumlahData) {
            System.out.print(i + 1 + ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Masukan Nomer Yang Akan Diubah = ");
        int xdata = scan.nextInt() - 1;
        System.out.print("Masukan Nama Baru = ");
        String nama = scan.next();
        System.out.print("Masukan NIM Baru = ");
        String nim = scan.next();

        mahasiswa[xdata].setNama(nama);
        mahasiswa[xdata].setNim(nim);

    }

    public static void hapusData() {

        Scanner scan = new Scanner(System.in);
        int i = 0;
        int j;
        while (i < jumlahData) {
            System.out.print(i + 1 + ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Masukan Nomer Yang Akan Dihapus = ");
        int xdata = scan.nextInt() - 1;

        System.out.println("Nama : " + mahasiswa[xdata].getNama());
        System.out.println("Nim : " + mahasiswa[xdata].getNim());
        System.out.println("Hapus Data ini? y/n");
        String pil = scan.next();
        if (pil.equalsIgnoreCase("y")) {
            mahasiswa[xdata] = null;
            for (i = 0; i < jumlahData - 1; i++) {
                Mahasiswa temp;
                if (mahasiswa[i] == null) {
                    temp = mahasiswa[i + 1];
                    mahasiswa[i] = mahasiswa[i + 1];
                    mahasiswa[i + 1] = null;

                }
            }
            jumlahData = jumlahData - 1;

            System.out.println("Data Terhapus!");
        } else {

        }
    }

    public static String uas() {
        int jarak = jumlahData;
        int susut = 13;
        int urut = 0;
        Mahasiswa temp;

        if (jumlahData != 0) {
            do {
                jarak = (jarak * 10) / susut;

                if (jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                }

                for (int i = 0; (i + jarak) < jumlahData; i++) {
                    if (mahasiswa[i].getNim().compareTo(mahasiswa[i + jarak].getNim()) >= 1) {
                        temp = mahasiswa[i];
                        mahasiswa[i] = mahasiswa[i + jarak];
                        mahasiswa[i + jarak] = temp;
                        urut = 0;
                    }
                }
            } while (urut == 0);
        } else {
            return "Tidak Ada Data";
        }

        return "Data telah diurutkan, silakan tampilkan data!";

    }

    public static void main(String[] args) {
        int option;
        Siakad siakad = new Siakad();

        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Hapus Data");
            System.out.println("6. Edit Data");
            System.out.println("7. UAS");
            System.out.println("8. Keluar");
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
                    cariData();
                    break;
                case 5:
                    hapusData();
                    break;
                case 6:
                    editData();
                    break;
                case 7:
                    String pesan = uas();
                    System.out.println("\n" + pesan);
                    break;
                case 8:
                    System.out.println("Terimakasih sudah mengunjung siakad");
                    System.exit(0);
                    break;
            }
            if (option >= 9) {
                System.out.println("Input anda tidak sesuai, mohon ulangi lagi. \n");
                // return main();
            }
        } while (option > 0);

    }
}
