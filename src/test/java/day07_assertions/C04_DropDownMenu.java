package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /* amazona gidip Dropdowndan books seceneğini seçip arama kutusuna java yazdıralım
        ve arama sonuclarının java içerdiğini test edelim
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
        //driver.close();
    }

    @Test
    public void test01() {
         /*
        Amazon anasayfaya gidip
        dropdown menuden books'u secelim
        sectigimiz option'i yazdiralim
        dropdown'daki opsiyonlarin toplam sayisinin
        28 oldugunu test edin
     */

        driver.get("https://www.amazon.com");
        WebElement ddm= driver.findElement(By.xpath("//select[@name='url']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Books");
        WebElement arananElement=driver.findElement(By.id("twotabsearchtextbox"));
        arananElement.sendKeys("java"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananSonucYazisi="java"; ;
        String cikanSonucYazisi=sonucYazisi.getText();
        Assert.assertTrue(cikanSonucYazisi.contains(arananSonucYazisi));


    }
}
