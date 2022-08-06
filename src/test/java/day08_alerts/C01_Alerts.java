package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    /* herhangi bir web sitesine gidince veya
         bir websitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz
         Eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilanilabilir,
         bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islme yapmaya gerek yoktur
         tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz
         driver.get("https://www.facebook.com"); da cikan alert vb..
         Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir
         js alert'ler locate edilemez
         Selenium'da JS alert'ler icin ozel bir yontem gelistirmistir
       */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    static public void tearDown(){
        // driver.close();
    }
    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        // alert'te OK tusuna basin
        driver.switchTo().alert().accept();
        // result kisminda "You successfully clicked an alert" yazdigini test edin
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String expectedSonuc="You successfully clicked an alert";
        String actualSonuc=sonucYaziElementi.getText();
        Assert.assertEquals(expectedSonuc,actualSonuc);

    }
}
