ADI-SOYADI: Sarya Su TOĞYILDIZ
SINIFI: 1/B
NUMARASI: 250542024
    
public class SinemaBileti {

    public static boolean isWeekend(int gun) {
        return gun == 6 || gun == 7; 
    }

    public static boolean isMatinee(int saat) {
        return saat < 12;
    }

    public static double calculateBasePrice(int gun, int saat) {
        boolean weekend = isWeekend(gun);
        boolean matinee = isMatinee(saat);

        if (!weekend && matinee) return 45; 
        if (!weekend) return 65;      
        if (weekend && matinee) return 55; 
        return 85;                           
    }

    public static double calculateDiscount(int yas, int meslek, int gun) {
        double indirim = 0;

        if (yas >= 65) indirim = 0.30;
        else if (yas < 12) indirim = 0.25;
        else if (meslek == 1) {  
            if (gun >= 1 && gun <= 4) indirim = 0.20; 
            else indirim = 0.15;        
        }
        else if (meslek == 2 && gun == 3) indirim = 0.35; 

        return indirim;
    }

    public static int getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 1: return 0;   
            case 2: return 25; 
            case 3: return 35; 
            case 4: return 50;  
            default: return 0;
        }
    }

    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru) {
        double base = calculateBasePrice(gun, saat);
        double discountRate = calculateDiscount(yas, meslek, gun);

        double priceAfterDiscount = base - (base * discountRate);
        double finalPrice = priceAfterDiscount + getFormatExtra(filmTuru);

        return finalPrice;
    }

    public static String generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru) {
        double base = calculateBasePrice(gun, saat);
        double discountRate = calculateDiscount(yas, meslek, gun);
        double discounted = base - base * discountRate;
        int extra = getFormatExtra(filmTuru);
        double total = discounted + extra;

        return  "Temel Fiyat: " + base + " TL\n" +
                "İndirim Oranı: %" + (int)(discountRate * 100) + "\n" +
                "İndirimli Fiyat: " + discounted + " TL\n" +
                "Format Ücreti: +" + extra + " TL\n" +
                "-------------------\n" +
                "Toplam: " + total + " TL";
    }

    public static void main(String[] args) {

        int gun = 4;        
        int saat = 10;   
        int yas = 22;
        int meslek = 1;   
        int filmTuru = 2;  

        System.out.println(generateTicketInfo(gun, saat, yas, meslek, filmTuru));
    }
}

