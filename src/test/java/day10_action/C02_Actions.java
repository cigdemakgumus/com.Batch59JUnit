package day10_action;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C02_Actions extends TestBase {

    @Test
    public void test01(){
        //amzona git account menusunden create a list lınkıne tıklayalım
        driver.get("https://www.amazon.com.tr");
        Actions actions=new Actions(driver);
        WebElement accountLinki= driver.findElement(By.xpath("//*[text()='Merhaba, Giriş yapın']"));
        actions.moveToElement(accountLinki).perform();
        driver.findElement(By.xpath("//*[text()='Liste Oluşturun']")).click();


    }

}
