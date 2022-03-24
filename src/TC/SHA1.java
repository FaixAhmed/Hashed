package TC;

import java.io.IOException;
import java.util.ArrayList;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.shaElements;
import services.constants;
import services.md5;
import services.rwtoexcel;

public class SHA1 {
    //object of rwexcel
    static rwtoexcel rwe = new rwtoexcel();
    //creating the file path
    static String excelFp = constants.data_path+constants.file;
    public static void main(String args[]) throws IOException, HeadlessException, UnsupportedFlavorException, InterruptedException  {
        //seting driver path
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Faiz.Patel\\Desktop\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(constants.url);
        //initialising excel
        rwtoexcel.setFile(excelFp,"Sheet1");
        for (int i=1;i<=rwtoexcel.rowcount();i++)
        {
            shaElements.Input(driver).sendKeys(rwtoexcel.cellData(i,0));
            shaElements.copytoclip(driver).click();
            String hash = md5.saveclip();
            //String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            System.out.println(hash);
            rwtoexcel.setcell(i,1,hash,excelFp);
            shaElements.Input(driver).clear();
        }
        System.out.println("success!moving to MD5 now");
        driver.findElement(By.xpath("/html/body/div/div[5]/div[3]")).click();
        
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        for (int j=1;j<=rwtoexcel.rowcount();j++)
        {
            shaElements.Input(driver).sendKeys(rwtoexcel.cellData(j,0));
            shaElements.copytoclip(driver).click();
            String hash2 = md5.saveclip(); 
            //String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            System.out.println(hash2);
            rwtoexcel.setcell(j,2,hash2,excelFp);
            shaElements.Input(driver).clear();
        }
   

        driver.quit();
        
    }
}

