package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
   /* Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
    */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void taarDown(){
      //  driver.close();
    }

    @Test
    public void test01() {
        driver.get("http://automationpractice.com/index.php");
    //Sign in butonuna basalim
        WebElement signButonu= driver.findElement(By.xpath("//a[@class='login']"));
        signButonu.click();
        //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        WebElement emailKutusu=driver.findElement(By.id("email"));
        emailKutusu.sendKeys("cigdem.akgumus7979gmail.com"+ Keys.ENTER);
        WebElement uyariYazisi=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyariYazisi.isDisplayed());



    }
}
