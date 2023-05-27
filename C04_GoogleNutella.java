package Day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_GoogleNutella {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com/");

        driver.findElement(By.xpath("//div[@class='a4bIc']")).click();

        String expectedIcerik="Google";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title test is PASSED");
        }else {
            System.out.println("Title test is FAILED");
        }

        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@name='q']"));
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        WebElement sonucYazisi= driver.findElement(By.id("result-stats"));
        System.out.println(sonucYazisi.getText());

        String sonucYazisiStr= sonucYazisi.getText();
        String[] sonucYaziKelimeleriArr=sonucYazisiStr.split(" ");
        String sonucSayiAdediStr=sonucYaziKelimeleriArr[1];//129.000.000
        sonucSayiAdediStr=sonucSayiAdediStr.replaceAll("\\D","");//129000000
        int sonucSayisiInt=Integer.parseInt(sonucSayiAdediStr);

        if (sonucSayisiInt>10000000){
            System.out.println("Sonuc sayisi testi PASSED");

        }else {
            System.out.println("Sonucsayisis testi FAILED");
        }



       Thread.sleep(2000);
       driver.close();


























    }



}
