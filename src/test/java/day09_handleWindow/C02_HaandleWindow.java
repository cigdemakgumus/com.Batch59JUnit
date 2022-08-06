package day09_handleWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HaandleWindow {
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
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());
        //Url in amazon içerdiğini test edelim
        String istenenKelime="amazon";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));

        //yeni bir pencere acıp bestbuy anasayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com.tr");
       String ikinciSayfaWhandled=driver.getWindowHandle();
        //Title ın bastbuy içerdiğini test edelim
        String actualaTitle= driver.getTitle();//
        String expectedTitle= "bestbuy";
        Assert.assertTrue(actualaTitle.contains(expectedTitle));

        //İlk sayfaya dönüp sayfada java aratlım
        driver.switchTo().window(ilkSayfaHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);

        //Arama sonuclarının java içerdiğini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedSonucYazisi="java";
        String actuelSonucYazisi=sonucYaziElementi.getText();
        Assert.assertTrue(actualaTitle.contains(expectedSonucYazisi));

        //Yeniden bestbuy ın acık olduğu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWhandled);

        //logonun göründüğünü test edelim
        WebElement logoelementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoelementi.isDisplayed());


    }
}
