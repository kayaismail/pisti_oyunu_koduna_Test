/*
 *java koduna test yazmak 
  İsmail kaya
 */
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

 /*
 * @author ismailkaya
 */
public class PistiJUnitTest {
    
    public PistiJUnitTest() {
    }    
    @BeforeClass
    public static void setUpClass() {
    }    
    @AfterClass
    public static void tearDownClass() {
    }    
    @Before
    public void setUp() {
    }    
    @After
    public void tearDown() {
        System.out.println("Bir metod test edildi otekine geciliyor \n:)\n:) ");
    }
ArrayList<String> Olmamasigereken = new ArrayList<>(Arrays.asList("A2","A3","A4","A5","A6","A7","A8","A9","A10","A11","A12","A13",
      "B2","B3","B4","B5","B6","B7","B8","B9","B10","B11","B12","B13",
      "C2","C3","C4","C5","C6","C7","C8","C9","C10","C11","C12","C13",
      "D2","D3","D4","D5","D6","D7","D8","D9","D10","D11","D12","D13"));
/*// Esit oldugu seneryasonu denemek icin
ArrayList<String> deneme = new ArrayList<>(Arrays.asList("A2","A3","A4","A5","A6","A7","A8","A9","A10","A11","A12","A13",
      "B2","B3","B4","B5","B6","B7","B8","B9","B10","B11","B12","B13",
      "C2","C3","C4","C5","C6","C7","C8","C9","C10","C11","C12","C13",
      "D2","D3","D4","D5","D6","D7","D8","D9","D10","D11","D12","D13"));*/
  @Test
  public void DesteyiOlusturVeKaristirTest()throws Exception{
    Pisti Olustur = new Pisti();
    Olustur.DesteyiOlusturVeKaristir();
    boolean isEqual = Olmamasigereken.equals(Olustur.Deste);    //false
   //boolean isEqual = Olmamasigereken.equals(deneme); //DIGER SENARYO True Yukaridaki deneme listesini ac
    System.out.println("Durum : "+isEqual+" ---false durumu ayni degiller, Deste karismis demek");
    System.out.println("farkli deger aliyormu gozlemlemek icin :"+Olustur.Deste.get(0)); // her seferinde farkli deger aliyormu gozlemlemek icin
    assertFalse(isEqual);
    //assertTrue(isEqual);// DIGER SENARYO
    System.out.println("DesteyiOlusturVeKaristir() metodu calisdi kart Karistirma islemi basarili... ");
    }
  @Test 
  public void RastgeleElVerTest()throws Exception{
   Pisti Elver =new Pisti(); 
   Elver.DesteyiOlusturVeKaristir(); //kartlari olusturup karistirdik
 
   Elver.RastgeleElVer(3);//yere kartlari dagittik 
   assertEquals(4,Elver.Yer.size()); // herkesin elinde 4 kart olmali 
   Elver.RastgeleElVer(2);  //oyuncuya kartlari dagittik 
   assertEquals(4,Elver.Sen.size());
   Elver.RastgeleElVer(1); //Bilgisayara kartlari dagittik 
   assertEquals(4,Elver.Bilgisayar.size());  
   // assertEquals(5,Elver.Bilgisayar.size()); // Testi gecemeyecek diger senaryo 5 kart
   System.out.println("Bu deger degisiyormu gorelim :"+ Elver.Bilgisayar.get(0));
   System.out.println("RasgeleElVer() metodu calisdi el verme islemi basarili... ");
  }
  @Test
  public void EliGosterTest()throws Exception{
  Pisti Goster=new Pisti();
  Goster.DesteyiOlusturVeKaristir();
  Goster.RastgeleElVer(3);//yere kartlari dagittik 
  Goster.RastgeleElVer(2);//oyuncuya kartlari dagittik
  Goster.RastgeleElVer(1);//Bilgisayara kartlari dagittik 
  Goster.EliGoster(3);
  Goster.EliGoster(2);
  Goster.EliGoster(1);
  System.out.println("EliGoster() metodu calisdi el gostreme islemi basarili... ");
  
  }
   @Test
  public void SeninPistiOyununTest()throws Exception{
  Pisti Senin=new Pisti();
  Senin.DesteyiOlusturVeKaristir();
  Senin.RastgeleElVer(3);
  Senin.RastgeleElVer(2);
  Senin.RastgeleElVer(1);
  Senin.SeninPistiOyunun("C6"); // metod calisıyor 
  Senin.SeninPistiOyunun("C5");
  System.out.println("Senin puanin :"+Senin.SeninPuanin); 
  assertNotNull(Senin.SeninPuanin);  //metodun asil amaci puanlama elin sansa denk gelmesi ile 0 dan farkli gozlemlenebiliyor sadece
  System.out.println("SeninPistiOyunun() metodu calisdi basarili... ");
  }
  
   @Test
  public void BilgisayarinPistiOyunu(){
  Pisti Pc=new Pisti();
  Pc.DesteyiOlusturVeKaristir();
  Pc.RastgeleElVer(3);
  Pc.RastgeleElVer(2);
  Pc.RastgeleElVer(1);
  Pc.BilgisayarinPistiOyunu("B5"); //metod calisiyor 
  Pc.BilgisayarinPistiOyunu("C6");
  System.out.println("Bilgisayarin puani :"+Pc.BilgisayarinPuani);
  assertNotNull(Pc.BilgisayarinPuani);//metodun asil amaci puanlama elin sansa denk gelmesi ile 0 dan farkli gozlemlenebiliyor sadece
  System.out.println("BilgisayarinPistiOyunu() metodu calisdi basarili... ");
  
  }
}
