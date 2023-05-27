package Day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ZeroWebabb {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://zero.webappsecurity.com");

        driver.findElement(By.id("signin_button")).click();

        WebElement loginkuTusu=driver.findElement(By.id("user_login"));
        loginkuTusu.sendKeys("username");
        WebElement passwordKutusu= driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");

        driver.findElement(By.name("submit")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        WebElement amountKutusu=driver.findElement(By.id("sp_amount"));
        amountKutusu.sendKeys("200");

        WebElement tarihKutusu=driver.findElement(By.id("sp_date"));
        tarihKutusu.sendKeys("2020-09-10");

        driver.findElement(By.id("pay_saved_payess")).click();

        WebElement submittedYaziElementi=driver.findElement(By.id("alert_content"));

        if (submittedYaziElementi.isDisplayed()){
            System.out.println("Test PASSED");
        }else {System.out.println("Test FAILED");}
























        Thread.sleep(2000);
        driver.close();







    }
}
