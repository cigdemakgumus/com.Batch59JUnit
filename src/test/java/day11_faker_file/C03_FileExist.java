package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.awt.SystemColor.text;

public class C03_FileExist {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        // bana icinde oldugum projenin dosy yoliunu(path) verir

        System.out.println(System.getProperty("user.home"));
        // C:\Users\Lenovo  yani benim bilgisayarimin bana ozel kismini verdi

        // "C:\Users\Lenovo\Downloads"
        // C:\Users\ilhan\Downloads
        // //Users/apple/Downloads
        //C:\Users\HP\Downloads
        // homePath + "/Downloads"
        // Masa ustumuzdeki text dosyasinin varligini test edin
        // C:\Users\zehra\Desktop

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        String farkliKisim=System.getProperty("user.home");
        // herkesin bilgisayarinda ortak olan kisim ise

        String ortakKisim="\\Desktop\\text.txt";
        // mac icin   "/Desktop/text"

          /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin
         her bilgisayarin birbirinden farkli olan yolunu bulmak icin
         */


        String masaustuDosyaYolu=farkliKisim+ortakKisim;


        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

    }
}
