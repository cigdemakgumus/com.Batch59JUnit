package day09_handleWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleWindow {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com.tr");
        // 2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        System.out.println(driver.getWindowHandle());//CDwindow-51A3EA6894C2415AB75DDFE1F700D9AE
        String ilkSayfaHandleDegeri= driver.getWindowHandle();
        /*
        CDwindow-4062F2D78BD37C7921FEBC32A9B51C74
        bu kod acilan sayfanin unique hash kodudur.
        Selenium sayfalar arasi geciste bu window handle degerini kullanir
        eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecemek istiyorsak
        driver.switchTo().window("CDwindow-4062F2D78BD37C7921FEBC32A9B51C74");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz.
         */
      //  3-ilk urunun resmini tıklayarak farklı bir tab olarak
        WebElement ilkUrunResmi= driver.findElement(By.xpath("(//div[@class=\"a-section aok-relative s-image-square-aspect\"])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
         /*
        Bu komutu kullandigimizda driver otomatik olarak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class=\"a-section aok-relative s-image-square-aspect\"])[1]")).click();


        // 4- yeni tab'da acilan urunun title'ini yazdirin
        WebElement baslıkElementi= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(baslıkElementi.getText());


        // ilk sayfaya gecip url'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());


    }
    /*
CDwindow-4062F2D78BD37C7921FEBC32A9B51C74
bu kod acilan sayfanin unique has kodudur.
Selenium sayfalar arasi geciste bu window handle degerini kullanir

eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
su anda bulundugumuz sayfaya gecmek istiyorsak
driver.switchTo().window("CDwindow-4062F2D78BD37C7921FEBC32A9B51C74");
bu sayfanin window handle degerini girerek bu sayfaya gecisi saglayabiliriz.
 */
}
