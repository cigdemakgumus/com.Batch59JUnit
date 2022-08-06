package day10_action;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    @Test
    public void test01(){
      /* Yeni bir class olusturalim: MouseActions2
        1- https://demoqa.com/droppable adresine gidelim
        2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
       */
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragMe= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droped=driver.findElement(By.xpath("//*[text()='dropped!']"));
        String expectedYazi="Dropped!";
        String actualYazi=droped.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
