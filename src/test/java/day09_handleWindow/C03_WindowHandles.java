package day09_handleWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandles {
      /*    ● Tests package’inda yeni bir class olusturun: WindowHandle2
            ● https://the-internet.herokuapp.com/windows adresine gidin.
            ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
            ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            ● Click Here butonuna basın.
            ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            ● Sayfadaki textin “New Window” olduğunu doğrulayın.
            ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
       */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
      // ● https://the-internet.herokuapp.com/windows adresine gidin.
      // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement textElementi= driver.findElement(By.xpath("//h3"));
        String expectedText="Opening a new window";
        String actualText=textElementi.getText();
        Assert.assertEquals(expectedText,actualText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedText,actualText);

        /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir.
        oncelikle 2.sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atayalim
         */
        String ilkSayfaWindowHandleD=driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleD);

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        Set<String>windowHandleDegerleri=driver.getWindowHandles();
        for (String each:windowHandleDegerleri
             ) {
            if (!each.equals(ilkSayfaWindowHandleD)){
                String ikinciSayfaWindowHandleDegeri=each;
            }
        }

         /*
          switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz
          yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz
            */
         /*
        yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
        bunun icin driver.getWindowHandles() method'unu kullanarak
        acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz.
        ilk sayfanin window handle degerini zaten biliyoruz
        Set'deki window handle degerlerini kontrol edip
        ilk sayfanin handle degerine esit olmayan
        ikinci sayfanin window handle degeridir deriz
         */
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedBaslik="New Window";
        String actualBaslik=driver.getTitle();
        Assert.assertEquals(expectedBaslik,actualBaslik);

        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement sayfaTextElementi= driver.findElement(By.xpath("//h3"));
        String expectedTexti="New Window";
        String actualTexti=sayfaTextElementi.getText();
        Assert.assertEquals(expectedTexti,actualTexti);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleD);
        expectedTitle="The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);










    }
}