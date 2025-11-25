ADI-SOYADI: Sarya Su TOĞYILDIZ
SINIFI: 1/B
NUMARASI: 250542024

import java.util.Scanner;

public class RestoranSiparis {

    public static double getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;  
            case 2: return 120; 
            case 3: return 110; 
            case 4: return 65;   
            default: return 0;
        }
    }

    public static double getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25;  
            case 2: return 45; 
            case 3: return 55;  
            default: return 0;
        }
    }

    public static double getDrinkPrice(int secim) {
        switch (secim) {
            case 1: return 15;  
            case 2: return 12;  
            case 3: return 35; 
            case 4: return 25;  
            default: return 0;
        }
    }

    public static double getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65; 
            case 2: return 55;  
            case 3: return 35;  
            default: return 0;
        }
    }

    public static boolean isComboOrder(boolean ana, boolean icecek, boolean tatli) {
        return ana && icecek && tatli;
    }

    public static boolean isHappyHour(int saat) {
        return saat >= 14 && saat <= 17;
    }

    public static double calculateDiscount(double tutar, boolean combo, boolean ogrenci, int saat, int gun, double icecekFiyati) {
        double indirim = 0;

        if (combo) indirim += tutar * 0.15;

        if (isHappyHour(saat) && icecekFiyati > 0) {
            indirim += icecekFiyati * 0.20;
        }

        if (tutar > 200) indirim += tutar * 0.10;

        if (ogrenci && gun >= 1 && gun <= 5) {
            double araTutar = tutar - indirim;
            indirim += araTutar * 0.10;
        }

        return indirim;
    }

    public static double calculateServiceTip(double tutar) {
        return tutar * 0.10;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ana Yemek (1-4, 0 yok): ");
        int ana = sc.nextInt();
        System.out.print("Baslangic (0-3): ");
        int bas = sc.nextInt();
        System.out.print("Icecek (0-4): ");
        int icecek = sc.nextInt();
        System.out.print("Tatli (0-3): ");
        int tatli = sc.nextInt();

        System.out.print("Saat (8-23): ");
        int saat = sc.nextInt();

        System.out.print("Ogrenci misiniz? (E/H): ");
        boolean ogrenci = sc.next().equalsIgnoreCase("E");

        System.out.print("Gun (1-7): ");
        int gun = sc.nextInt();
      
        double anaF = getMainDishPrice(ana);
        double basF = getAppetizerPrice(bas);
        double icecekF = getDrinkPrice(icecek);
        double tatliF = getDessertPrice(tatli);

        double araToplam = anaF + basF + icecekF + tatliF;

        boolean combo = isComboOrder(anaF > 0, icecekF > 0, tatliF > 0);

        double toplamIndirim = calculateDiscount(araToplam, combo, ogrenci, saat, gun, icecekF);

        double toplam = araToplam - toplamIndirim;

        double bahsis = calculateServiceTip(toplam);

        System.out.println("\n===== HESAP ÖZETİ =====");
        System.out.println("Ara toplam: " + araToplam + " TL");
        System.out.println("Toplam indirim: " + String.format("%.2f", toplamIndirim) + " TL");
        System.out.println("Toplam: " + String.format("%.2f", toplam) + " TL");
        System.out.println("Bahsis önerisi (%10): " + String.format("%.2f", bahsis) + " TL");
    }
}

