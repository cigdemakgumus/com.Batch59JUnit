package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Deneme {

    static WebDriver driver;

    @BeforeClass
    static public void setUp(){
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
        // 1-urlin amazon içerdiğini test edin
        driver.get("https://www.amazon.com");
        String arananKelime = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));
    }
    @Test
        public void test2(){
        // 2-Title ın facebook içermediğini test edin

        String aranmayanKelime="facebook";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(aranmayanKelime));
    }
    @Test
    public void test3(){
        //3- sol ust kösede amazon logosunun göründüğünü test edin
        driver.get("https://www.amazon.com");
        WebElement logoElementi=driver.findElement(By.id("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
    @Test
    public void test4(){
        //sayfa baslığının youTube olmadığını doğrulayınız
        driver.get("https://www.youTube.com");
        String sayfaTitle="YouTube";
        String actualTitle= driver.getTitle();
        //Assert.assertFalse();actualTitle.contains(sayfaTitle));
    }
    @Test
    public void test5(){
        driver.get("https://www.bestbuy.com");
        String expectedSayfaBaslik="Best";
        String actualSayfaBaslık=driver.getTitle();
        Assert.assertTrue(actualSayfaBaslık.contains(expectedSayfaBaslik));
        Assert.assertTrue(driver.getTitle().contains("Best"));
    }
}
