package day10_action;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
            public void test01(){
        // 1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(cizgiliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String expectedYazi="You selected a context menu";
        String actualYazi= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        ////6- Elemental Selenium linkine tiklayalim
        String ilksayfaHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String>sayfalarınHandleDegerleri=driver.getWindowHandles();
        String ikinciSayfaHandleDegeri="";
        for (String each:sayfalarınHandleDegerleri
             ) {
           if (!each.equals(ilksayfaHandleDegeri)){
               ikinciSayfaHandleDegeri=each;
           }
        }
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        WebElement h1TagElementi= driver.findElement(By.xpath("//h1"));
        String expectedTag="Elemental Selenium";
        String actualTag=h1TagElementi.getText();
        Assert.assertEquals(expectedTag,actualTag);


    }
}
