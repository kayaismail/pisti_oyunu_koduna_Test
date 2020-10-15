import java.util.*; // Java II Projesi 1 PiSTi OYUNU (BULENT SiYAH)081503030
public class Pisti {
    String[] DesteOlustur = new String[52];
    ArrayList Deste = new ArrayList();
    ArrayList Bilgisayar = new ArrayList();
    ArrayList Yer = new ArrayList();
    ArrayList Sen = new ArrayList();
    String[] JokerGrubu = new String[4];
    int SeninPuanin = 0, BilgisayarinPuani = 0;
    boolean BilgisayardaYerdekininAynisiVar = false;
    int BilgisayardaYerdekininAynisiindex = 0;
    boolean BilgisayardaJokerVar = false;
    int BilgisayardaJokerindex = 0;
    boolean BilgisayardaJokerOlmayanKart = false;
    int BilgisayardaJokerOlmayanKartindex = 0;
    String YerdekiKart = "";
    String BilgisayarinKarti = "";
    Scanner KlavyedenDegerAl = new Scanner(System.in);
    int KlavyedenAlinanSayi;
    public void DesteyiOlusturVeKaristir() {
        for (int i = 0; i < 52; i++) {
            if (0 <= i && i < 13) {
                DesteOlustur[i] = ("A" + (i % 13 + 1));//Kupa (♥)
            } else if (13 <= i && i < 26) {
                DesteOlustur[i] = ("B" + (i % 13 + 1));//Karo (♦)
            } else if (26 <= i && i < 39) {
                DesteOlustur[i] = ("C" + (i % 13 + 1));//Maça (♠)
            } else {
                DesteOlustur[i] = ("D" + (i % 13 + 1));//Sinek (♣)
            }
        }
        Collections.shuffle(Arrays.asList(DesteOlustur));
        for (int i = 0; i < 52; i++) {
            Deste.add(DesteOlustur[i]);
        }
        JokerGrubu[0] = ("A11");
        JokerGrubu[1] = ("B11");
        JokerGrubu[2] = ("C11");
        JokerGrubu[3] = ("D11");
    }
    public void RastgeleElVer(int DesteninKimeDagitilacaginiBul) {
        if (DesteninKimeDagitilacaginiBul == 3) {
            System.out.println("--YERE 4 KART BIRAKILDI.");
            for (int i = 0; i < 4; i++) {
                Yer.add(Deste.get(0));
                Deste.remove(0);
            }
        }
        if (DesteninKimeDagitilacaginiBul == 2) {
            System.out.println(">>>SANA 4 KART VERiLDi.");
            for (int i = 0; i < 4; i++) {
                Sen.add(Deste.get(0));
                Deste.remove(0);
            }
        }
        if (DesteninKimeDagitilacaginiBul == 1) {
            System.out.println("<<<BiLGiSAYAR KENDiNE 4 KART ALDI.");
            for (int i = 0; i < 4; i++) {
                Bilgisayar.add(Deste.get(0));
                Deste.remove(0);
            }
        }
    }
    public void EliGoster(int Gelen) {
        if (Gelen == 3) {
            if (Yer.isEmpty()) {
                System.out.println("--YER TEMiZLENDi.");
            } else {
                YerdekiKart = (String) Yer.get(Yer.size() - 1);
                System.out.println("--YERDE " + Yer.size() + " ADET KAGIT VAR.EN USTTE:[" + YerdekiKart + "]");
            }
        }
        if (Gelen == 2) {
            if (Sen.size() == 1) {
                System.out.println(">>>ELiNDE TEK KART OTOMATiK OYNADIN KARTIN:[" + Sen.get(0).toString() + "]");
                SeninPistiOyunun(Sen.get(0).toString());
                Sen.removeAll(Sen);
            } else {
                System.out.print(">>>ELiNDEKi KARTLAR: ");
                for (int i = 0; i < Sen.size(); i++) {
                    System.out.print("[" + Sen.get(i) + "](" + (i + 1) + ") ");
                }
                System.out.print("SECiNiZ-->:");
                try {
                   // KlavyedenAlinanSayi = (KlavyedenDegerAl.nextInt());
                } catch (Exception exc) {
                    System.out.println("HATALI DEGER GiRDiN BOYLE BiR KART NUMARASI YOK.OYUN KAPATILDI.Hata:" + exc);
                    System.exit(0);
                }
                if (1 <= 2 && 2 <= Sen.size()) {
                    SeninPistiOyunun(Sen.get(2 - 1).toString());// KlavyedenAlinanSayi
                    Sen.remove(2- 1);
                } else {
                    System.out.println("HATALI DEGER GiRDiN BOYLE BiR KART NUMARASI YOK.OYUN KAPATILDI.");
                    System.exit(0);
                }//burada kullanıcı otomayık elındekı ılk sayıyı otomatık atıyor programı hızlı hızlı denemek ıcın bunu yaptım.
            }
        }
        if (Gelen == 1) {
            if (!(Yer.isEmpty())) {
                if (Bilgisayar.size() == 1) {
                    System.out.println("<<<BiLGiSAYAR SON KARTI OYNADI:[" + Bilgisayar.get(0) + "]");
                    BilgisayarinPistiOyunu(Bilgisayar.get(0).toString());
                    Bilgisayar.removeAll(Bilgisayar);
                } else {
                    System.out.print("<<<BiLGiSAYARIN KARTLARI: ");
                    for (int i = 0; i < Bilgisayar.size(); i++) {//Bilgisayarın elındekı kartların gorunmesını ıstersek
                        System.out.print("[*] ");//System.out.print(Bilgisayar.get(i) + ",");
                    }
                    YerdekiKart = (String) Yer.get(Yer.size() - 1);

                    for (int i = 0; i < Bilgisayar.size(); i++) {
                        BilgisayarinKarti = Bilgisayar.get(i).toString();
                        if (BilgisayarinKarti.substring(1, BilgisayarinKarti.length()).equals(YerdekiKart.substring(1, YerdekiKart.length()))) {
                            BilgisayardaYerdekininAynisiVar = true;
                            BilgisayardaYerdekininAynisiindex = i;
                        }
                    }
                    if (BilgisayardaYerdekininAynisiVar) {
                        System.out.println("OYNADIGI KART:[" + Bilgisayar.get(BilgisayardaYerdekininAynisiindex) + "]");
                        BilgisayarinPistiOyunu(Bilgisayar.get(BilgisayardaYerdekininAynisiindex).toString());
                        Bilgisayar.remove(BilgisayardaYerdekininAynisiindex);
                        BilgisayardaYerdekininAynisiVar = false;
                        BilgisayardaYerdekininAynisiindex = 0;
                    } else {
                        for (int j = 0; j < Bilgisayar.size(); j++) {
                            if (Bilgisayar.get(j).toString().equals(JokerGrubu[0])) {
                                BilgisayardaJokerVar = true;
                                BilgisayardaJokerindex = j;
                            }
                            if (Bilgisayar.get(j).toString().equals(JokerGrubu[1])) {
                                BilgisayardaJokerVar = true;
                                BilgisayardaJokerindex = j;
                            }
                            if (Bilgisayar.get(j).toString().equals(JokerGrubu[2])) {
                                BilgisayardaJokerVar = true;
                                BilgisayardaJokerindex = j;
                            }
                            if (Bilgisayar.get(j).toString().equals(JokerGrubu[3])) {
                                BilgisayardaJokerVar = true;
                                BilgisayardaJokerindex = j;
                            }
                        }
                        if (BilgisayardaJokerVar) {
                            System.out.println("OYNADIGI KART:[" + Bilgisayar.get(BilgisayardaJokerindex) + "]");
                            BilgisayarinPistiOyunu(Bilgisayar.get(BilgisayardaJokerindex).toString());
                            Bilgisayar.remove(BilgisayardaJokerindex);
                            BilgisayardaJokerVar = false;
                            BilgisayardaJokerindex = 0;
                        } else {
                            int rastgele = (int) (Math.random() * Bilgisayar.size());
                            System.out.println("OYNADIGI KART:[" + Bilgisayar.get(rastgele) + "]");
                            BilgisayarinPistiOyunu(Bilgisayar.get(rastgele).toString());
                            Bilgisayar.remove(rastgele);
                        }
                    }
                }
            } else {
                if (Bilgisayar.size() == 1) {
                    System.out.println("<<<BiLGiSAYAR ELiNDEKi SON KARTI OYNADI:[" + Bilgisayar.get(0) + "]");
                    BilgisayarinPistiOyunu(Bilgisayar.get(0).toString());
                    Bilgisayar.removeAll(Bilgisayar);
                } else {
                    System.out.print("<<<BiLGiSAYARIN KARTLARI: ");
                    for (int i = 0; i < Bilgisayar.size(); i++) {
                        System.out.print("[*] ");
                    }
                    for (int k = 0; k < Bilgisayar.size(); k++) {
                        if (!(Bilgisayar.get(k).toString().equals(JokerGrubu[0]))) {
                            BilgisayardaJokerOlmayanKart = true;
                            BilgisayardaJokerOlmayanKartindex = k;
                        }
                        if (!(Bilgisayar.get(k).toString().equals(JokerGrubu[1]))) {
                            BilgisayardaJokerOlmayanKart = true;
                            BilgisayardaJokerOlmayanKartindex = k;
                        }
                        if (!(Bilgisayar.get(k).toString().equals(JokerGrubu[2]))) {
                            BilgisayardaJokerOlmayanKart = true;
                            BilgisayardaJokerOlmayanKartindex = k;
                        }
                        if (!(Bilgisayar.get(k).toString().equals(JokerGrubu[3]))) {
                            BilgisayardaJokerOlmayanKart = true;
                            BilgisayardaJokerOlmayanKartindex = k;
                        }
                    }
                    if (BilgisayardaJokerOlmayanKart) {
                        System.out.println("OYNADIGI KART:[" + Bilgisayar.get(BilgisayardaJokerOlmayanKartindex) + "]");
                        BilgisayarinPistiOyunu(Bilgisayar.get(BilgisayardaJokerOlmayanKartindex).toString());
                        Bilgisayar.remove(BilgisayardaJokerOlmayanKartindex);
                        BilgisayardaJokerOlmayanKart = false;
                        BilgisayardaJokerOlmayanKartindex = 0;
                    } else {
                        int rastgele = (int) (Math.random() * Bilgisayar.size());
                        System.out.println("OYNADIGI KART:[" + Bilgisayar.get(rastgele) + "]");
                        BilgisayarinPistiOyunu(Bilgisayar.get(rastgele).toString());
                        Bilgisayar.remove(rastgele);
                    }
                }
            }
        }
    }
    public void SeninPistiOyunun(String GelenKart) {
        if (Yer.isEmpty()) {
            Yer.add(GelenKart);
        } else {
            YerdekiKart = (String) Yer.get(Yer.size() - 1);
            if (GelenKart.substring(1, GelenKart.length()).equals(YerdekiKart.substring(1, YerdekiKart.length()))) {
                if (Yer.size() == 1) {
                    SeninPuanin = SeninPuanin + 12;
                    Yer.removeAll(Yer);
                    System.out.print("SEN PiSTi YAPTIN.SUANKi PUANIN=" + SeninPuanin);
                } else {
                    SeninPuanin = SeninPuanin + Yer.size() + 1;
                    System.out.print("SENiN KART iLE YERDEKi KART AYNI.SUANKi PUANIN=" + SeninPuanin);
                    Yer.removeAll(Yer);
                }
            } else if (GelenKart.equals(JokerGrubu[0]) || GelenKart.equals(JokerGrubu[1]) || GelenKart.equals(JokerGrubu[2]) || GelenKart.equals(JokerGrubu[3])) {
                SeninPuanin = SeninPuanin + Yer.size() + 1;
                System.out.print("SEN JOKER ATTIN.SUANKi PUANIN=" + SeninPuanin);
                Yer.removeAll(Yer);
            } else {
                Yer.add(GelenKart);
            }
        }
    }
    public void BilgisayarinPistiOyunu(String GelenKart) {
        if (Yer.isEmpty()) {
            Yer.add(GelenKart);
        } else {
            YerdekiKart = (String) Yer.get(Yer.size() - 1);
            if (GelenKart.substring(1, GelenKart.length()).equals(YerdekiKart.substring(1, YerdekiKart.length()))) {
                if (Yer.size() == 1) {
                    BilgisayarinPuani = BilgisayarinPuani + 12;
                    Yer.removeAll(Yer);
                    System.out.print("BiLGiSAYAR PiSTi YAPTI.BiLGiSAYARiN PUANI=" + BilgisayarinPuani);
                } else {
                    BilgisayarinPuani = BilgisayarinPuani + Yer.size() + 1;
                    System.out.print("BiLGiSAYARIN KARTI iLE YERDEKi KART AYNI.BiLGiSAYARIN PUANI:" + BilgisayarinPuani);
                    Yer.removeAll(Yer);
                }
            } else if (GelenKart.equals(JokerGrubu[0]) || GelenKart.equals(JokerGrubu[1]) || GelenKart.equals(JokerGrubu[2]) || GelenKart.equals(JokerGrubu[3])) {
                BilgisayarinPuani = BilgisayarinPuani + Yer.size() + 1;
                System.out.print("BiLGiSAYAR JOKER ATTI.BiLGiSAYARiN PUANI:" + BilgisayarinPuani);
                Yer.removeAll(Yer);
            } else {
                Yer.add(GelenKart);
            }
        }
    }
    public static void main(String[] args) {
        Pisti bulentpisti = new Pisti();
        System.out.println("<-- PiSTi OYUNU (BULENT SiYAH)-->");
        System.out.println("OYUN BASLADI..DESTE KARISTIRILIYOR..");
        bulentpisti.DesteyiOlusturVeKaristir();
        int dongu = 1;
        while (!(dongu == 7))
        {
            if (dongu == 1) {
                System.out.println();
                System.out.println("**********  PiSTiNiN " + dongu + ".TUR'U  **********");
                bulentpisti.RastgeleElVer(3);//Yere Bir Bıraktı..
                bulentpisti.RastgeleElVer(1);// Bilgisayar Bir El Verdi..
                bulentpisti.RastgeleElVer(2);//Sana Bir El dagıttı.
                int Elsayisi = 4;
                while (!(Elsayisi == 0)) {
                    bulentpisti.EliGoster(3);
                    bulentpisti.EliGoster(2);
                    bulentpisti.EliGoster(3);
                    bulentpisti.EliGoster(1);
                    Elsayisi--;
                }
                bulentpisti.EliGoster(3);
            }
            else{
                System.out.println();
                System.out.println("**********  PiSTiNiN " + dongu + ".TUR'U  **********");
                bulentpisti.RastgeleElVer(1);// Bilgisayar Bir El Verdi..
                bulentpisti.RastgeleElVer(2);//Sana Bir El dagıttı.
                int ikinciElSayisi = 4;
                while (!(ikinciElSayisi == 0)) 
                {
                    bulentpisti.EliGoster(3);
                    bulentpisti.EliGoster(2);
                    bulentpisti.EliGoster(3);
                    bulentpisti.EliGoster(1);
                    ikinciElSayisi--;
                }
                bulentpisti.EliGoster(3);
            }
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
