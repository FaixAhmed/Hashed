package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commonElements {
    private static WebElement element = null;
    public static WebElement Input(WebDriver driver) {
        element = driver.findElement(By.id("txt1"));
        return element;
        
    }
    public static WebElement Output( WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/textarea[2]"));
        return element;
    }
    public static WebElement copytoclip(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div/div[7]/p/a"));
        return element;
    }
}
