// Java II Projesi 1 PiSTi OYUNU (BULENT SiYAH)081503030
public class MainPisti {

    public static void main(String[] args) {
        pisti bulentpisti = new pisti();
        System.out.println("<-- PiSTi OYUNU (BULENT SiYAH)-->");
        System.out.println("OYUN BASLADI..DESTE KARISTIRILIYOR..");
        bulentpisti.DesteyiOlusturVeKaristir();
        int dongu = 1;
        while (!(dongu == 7)) {
            System.out.println();
            System.out.println("**********  PiSTiNiN " + dongu + ".TUR'U  **********");
            if (dongu == 1) {
                bulentpisti.SiraylaElVer(3);//Yere Bir Bıraktı..
            }
            bulentpisti.SiraylaElVer(1);// Bilgisayar Bir El Verdi..
            bulentpisti.SiraylaElVer(2);//Sana Bir El dagıttı.
            int ElSayisi = 4;
            while (!(ElSayisi == 0)) {
                bulentpisti.EliGosterveOyna(3);
                bulentpisti.EliGosterveOyna(2);
                bulentpisti.EliGosterveOyna(3);
                bulentpisti.EliGosterveOyna(1);

                ElSayisi--;
            }
            bulentpisti.EliGosterveOyna(3);
            dongu++;
        }
        System.out.println();
        System.out.println("**********  PiSTi OYUNU TAMAMLANDI  **********");

        System.out.println("SENiN PUANIN:" + bulentpisti.SeninPuanin);
        System.out.println("BiLGiSAYARiN PUANI:" + bulentpisti.BilgisayarinPuani);
        if (bulentpisti.SeninPuanin > bulentpisti.BilgisayarinPuani) {
            System.out.println("TEBRiKLER *****SEN***** KAZANDIN");
        } else if (bulentpisti.SeninPuanin < bulentpisti.BilgisayarinPuani) {
            System.out.println("KAYBETTiN *****BiLGiSAYAR***** KAZANDI");
        } else {
            System.out.println("PUANLAR ESiT KAZANAN YOK");
        }
    }
}
