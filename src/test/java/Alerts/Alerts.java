package Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    WebDriver driver;
    WebElement element;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void alert() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello world, i passed the test!");
        alert.accept();
    }
}
