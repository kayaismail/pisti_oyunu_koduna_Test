// Java II Projesi 1 PiSTi OYUNU (BULENT SiYAH)081503030
import java.util.*;

public class pisti {

    String[] DesteOlustur = new String[52];
    ArrayList Deste = new ArrayList();
    ArrayList Bilgisayar = new ArrayList();
    ArrayList Yer = new ArrayList();
    String YerdekiKart = "";
    ArrayList Sen = new ArrayList();
    String[] JokerGrubu = new String[4];
    int SeninPuanin = 0, BilgisayarinPuani = 0;
    boolean BilgisayardaYerdekininAynisiVar = false;
    int BilgisayardaYerdekininAynisiindex = 0;
    boolean BilgisayardaJokerVar = false;
    int BilgisayardaJokerindex = 0;
    boolean BilgisayardaJokerOlmayanKart = false;
    int BilgisayardaJokerOlmayanKartindex = 0;
    String BilgisayarinKarti = "";
    Scanner KlavyedenDegerAl = new Scanner(System.in);
    int KlavyedenAlinanSayi;

    public void DesteyiOlusturVeKaristir() {
        for (int i = 0; i < 52; i++) {
            if (0 <= i && i < 13) {
                DesteOlustur[i] = ("A" + (i % 13 + 1));
            } else if (13 <= i && i < 26) {
                DesteOlustur[i] = ("B" + (i % 13 + 1));
            } else if (26 <= i && i < 39) {
                DesteOlustur[i] = ("C" + (i % 13 + 1));
            } else {
                DesteOlustur[i] = ("D" + (i % 13 + 1));
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

    public void SiraylaElVer(int KartlarinDagitilacagiKisi) {
        if (KartlarinDagitilacagiKisi == 3) {
            System.out.println("--YERE 4 KART BIRAKILDI.");
            for (int i = 0; i < 4; i++) {
                Yer.add(Deste.get(0));
                Deste.remove(0);
            }
        }
        if (KartlarinDagitilacagiKisi == 2) {
            System.out.println(">>>SANA 4 KART VERiLDi.");
            for (int i = 0; i < 4; i++) {
                Sen.add(Deste.get(0));
                Deste.remove(0);

            }
        }
        if (KartlarinDagitilacagiKisi == 1) {
            System.out.println("<<<BiLGiSAYAR KENDiNE 4 KART ALDI.");
            for (int i = 0; i < 4; i++) {
                Bilgisayar.add(Deste.get(0));
                Deste.remove(0);

            }
        }
    }

    public void EliGosterveOyna(int EliOynayacakKisi) {
        if (EliOynayacakKisi == 3) {
            if (Yer.isEmpty()) {
                System.out.println("--YER TEMiZLENDi.");
            } else {
                YerdekiKart = (String) Yer.get(Yer.size() - 1);
                System.out.println("--YERDE " + Yer.size() + " ADET KART VAR.EN USTTE:[" + YerdekiKart + "]");
            }
        }
        if (EliOynayacakKisi == 2) {
            if (Sen.size() == 1) {
                System.out.println(">>>ELiNDE TEK KART OTOMATiK OYNADIN KARTIN:[" + Sen.get(0).toString() + "]");
                KartAttimPuanimaBak(Sen.get(0).toString(), 2);
                Sen.removeAll(Sen);

            } else {
                System.out.print(">>>ELiNDEKi KARTLAR: ");
                for (int i = 0; i < Sen.size(); i++) {
                    System.out.print("[" + Sen.get(i) + "](" + (i + 1) + ") ");
                }
//
//                for (int i = 0; i < Sen.size(); i++) {
//                    System.out.print(" " + (i + 1) + " ");
//                }
                System.out.print("SECiNiZ-->:");
                try {
                    KlavyedenAlinanSayi = (KlavyedenDegerAl.nextInt());
                } catch (Exception exc) {
                    System.out.println("HATALI DEGER GiRDiN BOYLE BiR KART NUMARASI YOK.OYUN KAPATILDI.Hata:" + exc);
                    System.exit(0);
                }
                if (1 <= KlavyedenAlinanSayi && KlavyedenAlinanSayi <= Sen.size()) {
                    KartAttimPuanimaBak(Sen.get(KlavyedenAlinanSayi - 1).toString(), 2);
                    Sen.remove(KlavyedenAlinanSayi - 1);
                } else {
                    System.out.println("HATALI DEGER GiRDiN BOYLE BiR KART NUMARASI YOK.OYUN KAPATILDI.");
                    System.exit(0);
                }
                //burada kullanıcı otomayık elındekı ılk sayıyı otomatık atıyor programı hızlı hızlı denemek ıcın bunu yaptım.
//                System.out.println();
//                KartAttimPuanimaBak(Sen.get(0).toString(),2);
//                Sen.remove(0);
            }
        }
        if (EliOynayacakKisi == 1) {
            if (!(Yer.isEmpty())) {
                if (Bilgisayar.size() == 1) {
                    System.out.println("<<<BiLGiSAYAR SON KARTI OYNADI:[" + Bilgisayar.get(0) + "]");
                    KartAttimPuanimaBak(Bilgisayar.get(0).toString(), 1);
                    Bilgisayar.removeAll(Bilgisayar);
                } else {
                    System.out.print("<<<BiLGiSAYARIN KARTLARI: ");
                    for (int i = 0; i < Bilgisayar.size(); i++) {
//         Bilgisayarın elındekı kartların gorunmesını ıstersek
  //                  System.out.print("[" + Bilgisayar.get(i) + "](" + (i + 1) + ") ");
                        System.out.print("[*] ");
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
                        KartAttimPuanimaBak(Bilgisayar.get(BilgisayardaYerdekininAynisiindex).toString(), 1);
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
                            KartAttimPuanimaBak(Bilgisayar.get(BilgisayardaJokerindex).toString(), 1);
                            Bilgisayar.remove(BilgisayardaJokerindex);
                            BilgisayardaJokerVar = false;
                            BilgisayardaJokerindex = 0;
                        } else {
                            int rastgele = (int) (Math.random() * Bilgisayar.size());
                            System.out.println("OYNADIGI KART:[" + Bilgisayar.get(rastgele) + "]");
                            KartAttimPuanimaBak(Bilgisayar.get(rastgele).toString(), 1);
                            Bilgisayar.remove(rastgele);
                        }
                    }
                }
            } else {
                if (Bilgisayar.size() == 1) {
                    System.out.println("<<<BiLGiSAYAR ELiNDEKi SON KARTI OYNADI:[" + Bilgisayar.get(0) + "]");
                    KartAttimPuanimaBak(Bilgisayar.get(0).toString(), 1);
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
                        KartAttimPuanimaBak(Bilgisayar.get(BilgisayardaJokerOlmayanKartindex).toString(), 1);
                        Bilgisayar.remove(BilgisayardaJokerOlmayanKartindex);
                        BilgisayardaJokerOlmayanKart = false;
                        BilgisayardaJokerOlmayanKartindex = 0;
                    } else {
                        int rastgele = (int) (Math.random() * Bilgisayar.size());
                        System.out.println("OYNADIGI KART:[" + Bilgisayar.get(rastgele) + "]");
                        KartAttimPuanimaBak(Bilgisayar.get(rastgele).toString(), 1);
                        Bilgisayar.remove(rastgele);
                    }

                }
            }
        }
    }

    public void KartAttimPuanimaBak(String OynananKart, int EliOynayanKisi) {

        if (Yer.isEmpty()) {
            Yer.add(OynananKart);
        } else {
            YerdekiKart = (String) Yer.get(Yer.size() - 1);
            if (OynananKart.substring(1, OynananKart.length()).equals(YerdekiKart.substring(1, YerdekiKart.length()))) {
                if (Yer.size() == 1) {
                    if (EliOynayanKisi == 1) {
                        BilgisayarinPuani = BilgisayarinPuani + 12;
                        System.out.print("BiLGiSAYAR PiSTi YAPTI.BiLGiSAYARiN PUANI=" + BilgisayarinPuani);
                    } else {
                        SeninPuanin = SeninPuanin + 12;
                        System.out.print("SEN PiSTi YAPTIN.SUANKi PUANIN=" + SeninPuanin);
                    }

                    Yer.removeAll(Yer);
                } else {
                    if (EliOynayanKisi == 1) {
                        BilgisayarinPuani = BilgisayarinPuani + Yer.size() + 1;
                        System.out.print("BiLGiSAYARIN KARTI iLE YERDEKi KART AYNI.BiLGiSAYARIN PUANI:" + BilgisayarinPuani);
                    } else {
                        SeninPuanin = SeninPuanin + Yer.size() + 1;
                        System.out.print("SENiN KART iLE YERDEKi KART AYNI.SUANKi PUANIN=" + SeninPuanin);
                    }

                    Yer.removeAll(Yer);
                }
            } else if (OynananKart.equals(JokerGrubu[0]) || OynananKart.equals(JokerGrubu[1]) || OynananKart.equals(JokerGrubu[2]) || OynananKart.equals(JokerGrubu[3])) {
                if (EliOynayanKisi == 1) {
                    BilgisayarinPuani = BilgisayarinPuani + Yer.size() + 1;
                    System.out.print("BiLGiSAYAR JOKER ATTI.BiLGiSAYARiN PUANI:" + BilgisayarinPuani);
                } else {
                    SeninPuanin = SeninPuanin + Yer.size() + 1;
                    System.out.print("SEN JOKER ATTIN.SUANKi PUANIN=" + SeninPuanin);
                }

                Yer.removeAll(Yer);
            } else {
                Yer.add(OynananKart);
            }

        }
    }
}
