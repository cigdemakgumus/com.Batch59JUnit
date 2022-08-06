package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/upload");

        //1. adım : choose file butonunu locate edelim
        //Yuklemek istediginiz dosyayi secelim.
        /*
        bu islemi selnium ile yapma imkanimiz yok cunku web tabanli bir uygulama degil
        bu durumda sendKeys() imdadimiza yetisir
        eger chooseFile butonuna var olan bir dosyanin dosya yolunu yollarsaniz
        secme islemi otomatik olarak yapilmis olacaktir.
         */
         //2. adım : yuklenecek dosyanın dosya yolunu olusturalım
        WebElement dosyaSecElementi= driver.findElement(By.xpath("//input[@id='file-upload']"));
        String farkliKisim=System.getProperty("user.home");
        String ayniKisim="\\DownLoad\\text.txt";
        String yuklenecekDosyaYolu=farkliKisim+ayniKisim;

        //3. adım :  sendKeys ile dosya yolunu secme butonuna yollayalım
       dosyaSecElementi.sendKeys(yuklenecekDosyaYolu);

        //Uploaded botonuna basalım.
        WebElement uploadElementi= driver.findElement(By.xpath("//input[@class='button']"));
        uploadElementi.click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());
    }
}
