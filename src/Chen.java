import java.util.Scanner;

public class Chen {

    public static void main(String[] args) {

        Scanner al = new Scanner(System.in);
        int sayi;

        do {

            System.out.println("Asal bir sayı girin: ");
            sayi = al.nextInt();

        } while (asalMi(sayi) != true);

        if (sayiChenAsaliMi(sayi) == true) {
            System.out.println(sayi + " sayısı bir Chen asalıdır.");
        } else {
            System.out.println(sayi + " sayısı bir Chen asalı değildir.");
        }

        if (asal2CarpaniVarMi(sayi + 2) == true) {

            for (int i = 2; i <= (sayi+2); i++) {

                if (asalMi(i) == true) {
                    if(((sayi+2) % i) == 0){
                        int kalan = ((sayi+2) / i);
                        if (asalMi(kalan) == true) {
                            System.out.println("\n" + (sayi+2) + " sayısı için Asal çarpanları --> " + i + " ve " + kalan + "\n\n");
                            break;
                        }
                    }
                }

            }
        }

        tumunuYazdir();

        al.close();

    }

    static boolean asalMi(int sayi) {

        if (sayi == 2) {
            return true;
        }
        if (sayi == 0 || sayi == 1) {
            return false;
        }

        for (int i = 2; i <= sayi / 2; i++) {

            if (sayi % i == 0) {
                return false;
            } 
        }
        return true;

        
    }

    static boolean asal2CarpaniVarMi(int sayi) {

        for (int i = 2; i <= sayi; i++) {

            if (asalMi(i) == true && sayi%i==0 && asalMi(sayi/i)) {
                return true;
            }
        }
        return false;
    }

    static boolean sayiChenAsaliMi(int sayi) {

        if (asalMi(sayi + 2) == true) {
            return true;
        } else if (asal2CarpaniVarMi(sayi + 2) == true) {
            return true;
        } else {
            return false;
        }
    }

    static void tumunuYazdir() {

        System.out.println("\n2 basamaklı tüm Chen asalları : ");
        for (int i = 10; i < 100; i++) {

            if(asalMi(i)==true){

                if (sayiChenAsaliMi(i) == true) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
