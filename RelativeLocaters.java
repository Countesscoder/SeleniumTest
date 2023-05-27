package Day05_relativeLocators_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class RelativeLocaters {
    public static void main(String[] args) throws InterruptedException {
     System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
     WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

     driver.findElement(By.xpath("//*[@id=\"pid7_thumb\"]")).click();

     //A-tag'i img,NYC'nin altinda
        WebElement Nyc=driver.findElement(By.id("pid3_price"));
        WebElement Berlin1=driver.findElement( RelativeLocator.with(By.tagName("img")).below(Nyc)   );
        //test etmek için berlin1 webelementinin id attributenun degerine bakalim-pid7_thumb olmali

        if (Berlin1.getAttribute("id").equals("pid3_price")){
            System.out.println("Berlin1 locate test is PASSED");
        }else {
            System.out.println("Berlin1 locate test is FAILED");
        }
        //B-tagı img,Bostonin sagında

        WebElement Boston1=driver.findElement(By.id("pid6_price"));
        WebElement Berlin2=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(Boston1));

        if (Berlin2.getAttribute("id").equals("pid6_price")){
            System.out.println("Berlin2 locate test is PASSED");
        }else {
            System.out.println("Berlin2 locate test is FAILED");
        }
        //C-tagı img,Sailorin ustunde

        WebElement Sailor=driver.findElement(By.id("pid11_price"));
        WebElement Berlin3=driver.findElement(RelativeLocator.with(By.className("ui-li-thumb")).above(Sailor));

        if (Berlin3.getAttribute("id").equals("pid11_price")){
            System.out.println("Berlin3 locate test is PASSED");
        }else {
            System.out.printf("Berlin3 locate test is FAILED");
        }













     Thread.sleep(2000);
     driver.close();













    }




}
