// Java II Projesi 1 (PİŞTİ OYUNU) 081503030 Bülent SİYAH
import java.util.*;

public class BulentPisti {

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
                //               9829=♥
                DesteOlustur[i] = ((char) (9829) + "" + (i % 13 + 1));

            } else if (13 <= i && i < 26) {
                DesteOlustur[i] = ((char) (9830) + "" + (i % 13 + 1));
                //               9830=♦
            } else if (26 <= i && i < 39) {

                DesteOlustur[i] = ((char) (9824) + "" + (i % 13 + 1));
                //               9824=♠

            } else {
                DesteOlustur[i] = ((char) (9827) + "" + (i % 13 + 1));
                //               9827=♣
            }
        }

        Collections.shuffle(Arrays.asList(DesteOlustur));
        for (int i = 0; i < 52; i++) {
            Deste.add(DesteOlustur[i]);
        }
        JokerGrubu[0] = ((char) (9829) + "11");
        JokerGrubu[1] = ((char) (9830) + "11");
        JokerGrubu[2] = ((char) (9824) + "11");
        JokerGrubu[3] = ((char) (9827) + "11");
    }

    public void RastgeleElVer(int DesteninKimeDagitilacaginiBul) {
        if (DesteninKimeDagitilacaginiBul == 3) {
            System.out.println("---Yere 4 Kart Bırakıldı.");
            for (int i = 0; i < 4; i++) {
                Yer.add(Deste.get(0));
                Deste.remove(0);
            }
        }
        if (DesteninKimeDagitilacaginiBul == 2) {
            System.out.println(">>>>>Sana 4 Kart Verildi.");
            for (int i = 0; i < 4; i++) {
                Sen.add(Deste.get(0));
                Deste.remove(0);

            }
        }
        if (DesteninKimeDagitilacaginiBul == 1) {
            System.out.println("<<<<<Bilgisayar Kendine 4 Kart Aldı.");
            for (int i = 0; i < 4; i++) {
                Bilgisayar.add(Deste.get(0));
                Deste.remove(0);

            }
        }
    }

    public void EliGoster(int Gelen) {
        if (Gelen == 3) {
            if (Yer.isEmpty()) {
                System.out.println("---Yer Temizlendi.");
            } else {
                YerdekiKart = (String) Yer.get(Yer.size() - 1);
                System.out.println("---Yerde " + Yer.size() + " adet Kağıt var.En üstte:" + YerdekiKart);
            }
        }
        if (Gelen == 2) {
            if (Sen.size() == 1) {
                System.out.println(">>>>>Elinde Tek Kart kaldı Otomatik oynadın Kartın:" + Sen.get(0).toString());
                SeninPistiOyunun(Sen.get(0).toString());
                Sen.removeAll(Sen);

            } else {
                System.out.print(">>>>>Elindeki Kartlar:");
                for (int i = 0; i < Sen.size(); i++) {
                    System.out.print(" " + Sen.get(i) + " ");
                }
                System.out.print("Seçmek için(");
                for (int i = 0; i < Sen.size(); i++) {
                    System.out.print(" " + (i + 1) + " ");
                }
                System.out.print(")Sırasıyla Seçiniz-->:");
                try {
                    KlavyedenAlinanSayi = (KlavyedenDegerAl.nextInt());
                } catch (Exception exc) {
                    System.out.println("Hatalı Deger Girdin Böyle bir kart sırası yok.Oyun Kapatıldı.Hata:" + exc);
                    System.exit(0);
                }
                if (1 <= KlavyedenAlinanSayi && KlavyedenAlinanSayi <= Sen.size()) {
                    SeninPistiOyunun(Sen.get(KlavyedenAlinanSayi - 1).toString());
                    Sen.remove(KlavyedenAlinanSayi - 1);
                } else {
                    System.out.println("Hatalı Deger Girdin Böyle bir kart sırası yok.Oyun Kapatıldı.");
                    System.exit(0);
                }
                //burada kullanıcı otomayık elındekı ılk sayıyı otomatık atıyor programı hızlı hızlı denemek ıcın bunu yaptım.
//                System.out.println();
//                SeninPistiOyunun(Sen.get(0).toString());
//                Sen.remove(0);
            }
        }
        if (Gelen == 1) {
            if (!(Yer.isEmpty())) {
                if (Bilgisayar.size() == 1) {
                    System.out.println("<<<<<Bilgisayarın Elindeki Son Kartı Oynadı:" + Bilgisayar.get(0));
                    BilgisayarinPistiOyunu(Bilgisayar.get(0).toString());
                    Bilgisayar.removeAll(Bilgisayar);
                } else {
                    System.out.print("<<<<<Bilgisayarın Elindeki Kartlar:");
                    for (int i = 0; i < Bilgisayar.size(); i++) {
//         Bilgisayarın elındekı kartların gorunmesını ıstersek
//                        System.out.print(Bilgisayar.get(i) + ",");
                        System.out.print(" * ");
                    }
                    System.out.print("Birini Oynadı.");
                    YerdekiKart = (String) Yer.get(Yer.size() - 1);

                    for (int i = 0; i < Bilgisayar.size(); i++) {
                        BilgisayarinKarti = Bilgisayar.get(i).toString();
                        if (BilgisayarinKarti.substring(1, BilgisayarinKarti.length()).equals(YerdekiKart.substring(1, YerdekiKart.length()))) {
                            BilgisayardaYerdekininAynisiVar = true;
                            BilgisayardaYerdekininAynisiindex = i;
                        }
                    }

                    if (BilgisayardaYerdekininAynisiVar) {
                        System.out.println("Oynadığı Kart:" + Bilgisayar.get(BilgisayardaYerdekininAynisiindex));
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
                            System.out.println("Oynadığı Kart:" + Bilgisayar.get(BilgisayardaJokerindex));
                            BilgisayarinPistiOyunu(Bilgisayar.get(BilgisayardaJokerindex).toString());
                            Bilgisayar.remove(BilgisayardaJokerindex);
                            BilgisayardaJokerVar = false;
                            BilgisayardaJokerindex = 0;
                        } else {
                            int rastgele = (int) (Math.random() * Bilgisayar.size());
                            System.out.println("Oynadığı Kart:" + Bilgisayar.get(rastgele));
                            BilgisayarinPistiOyunu(Bilgisayar.get(rastgele).toString());
                            Bilgisayar.remove(rastgele);
                        }
                    }
                }
            } else {
                if (Bilgisayar.size() == 1) {
                    System.out.println("<<<<<Bilgisayarın Elindeki Son Kartı Oynadı:" + Bilgisayar.get(0));
                    BilgisayarinPistiOyunu(Bilgisayar.get(0).toString());
                    Bilgisayar.removeAll(Bilgisayar);
                } else {
                    System.out.print("<<<<<Bilgisayarın Elindeki Kartlar:");
                    for (int i = 0; i < Bilgisayar.size(); i++) {
                        System.out.print(Bilgisayar.get(i) + ",");
//                        System.out.print("*,");
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
                        System.out.println("Oynadığı Kart:" + Bilgisayar.get(BilgisayardaJokerOlmayanKartindex));
                        BilgisayarinPistiOyunu(Bilgisayar.get(BilgisayardaJokerOlmayanKartindex).toString());
                        Bilgisayar.remove(BilgisayardaJokerOlmayanKartindex);
                        BilgisayardaJokerOlmayanKart = false;
                        BilgisayardaJokerOlmayanKartindex = 0;
                    } else {
                        int rastgele = (int) (Math.random() * Bilgisayar.size());
                        System.out.println("Oynadığı Kart:" + Bilgisayar.get(rastgele));
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
                    System.out.print("Sen Pişti Yaptın.Şuan ki Toplam Puanın:" + SeninPuanin);
                } else {
                    SeninPuanin = SeninPuanin + Yer.size() + 1;
                    System.out.print("Senin Attığın Kart ile Yerdeki Kart Aynı.Şuan ki Toplam Puanın:" + SeninPuanin);
                    Yer.removeAll(Yer);
                }
            } else if (GelenKart.equals(JokerGrubu[0]) || GelenKart.equals(JokerGrubu[1]) || GelenKart.equals(JokerGrubu[2]) || GelenKart.equals(JokerGrubu[3])) {
                SeninPuanin = SeninPuanin + Yer.size() + 1;
                System.out.print("Sen Joker attın.Şuan ki Toplam Puanın:" + SeninPuanin);
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
                    System.out.print("Bilgisayar Pişti Yaptı.Bilgisayarın Puanı:" + BilgisayarinPuani);
                } else {
                    BilgisayarinPuani = BilgisayarinPuani + Yer.size() + 1;
                    System.out.print("Bilgisayarın Attığı Kart ile Yerdeki Kart Aynı.Bilgisayarın Puanı:" + BilgisayarinPuani);
                    Yer.removeAll(Yer);
                }
            } else if (GelenKart.equals(JokerGrubu[0]) || GelenKart.equals(JokerGrubu[1]) || GelenKart.equals(JokerGrubu[2]) || GelenKart.equals(JokerGrubu[3])) {
                BilgisayarinPuani = BilgisayarinPuani + Yer.size() + 1;
                System.out.print("Bilgisayar Joker attı.Bilgisayarın Puanı:" + BilgisayarinPuani);
                Yer.removeAll(Yer);
            } else {
                Yer.add(GelenKart);
            }

        }

    }

    public static void main(String[] args) {
        BulentPisti bulentpisti = new BulentPisti();
        System.out.println("<-- PİŞTİ OYUNU (BÜLENT SİYAH)-->");
        System.out.println("Oyun Başladı..Deste Karıştırılıyor..");
        bulentpisti.DesteyiOlusturVeKaristir();
        int dongu = 1;
        while (!(dongu == 7)) {
            if (dongu == 1) {
                System.out.println();
                System.out.println("**********  Piştinin " + dongu + ".Tur'u  **********");
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
            } else {
                System.out.println();
                System.out.println("**********  Piştinin " + dongu + ".Tur'u  **********");
                bulentpisti.RastgeleElVer(1);// Bilgisayar Bir El Verdi..
                bulentpisti.RastgeleElVer(2);//Sana Bir El dagıttı.
                int ikinciElSayisi = 4;
                while (!(ikinciElSayisi == 0)) {
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
        System.out.println("**********  Pişti Oyunu Tamamlandı  **********");

        System.out.println("Senin Puanın:" + bulentpisti.SeninPuanin);
        System.out.println("Bilgisayarın Puanı:" + bulentpisti.BilgisayarinPuani);
        if (bulentpisti.SeninPuanin > bulentpisti.BilgisayarinPuani) {
            System.out.println("TEBRİKLER *****SEN***** KAZANDIN");
        } else if (bulentpisti.SeninPuanin < bulentpisti.BilgisayarinPuani) {
            System.out.println("KAYBETTİN *****BİLGİSAYAR***** KAZANDI");
        } else {
            System.out.println("PUANLAR EŞİT KAZANAN VE KAYBEDEN YOK");
        }
    }
}
