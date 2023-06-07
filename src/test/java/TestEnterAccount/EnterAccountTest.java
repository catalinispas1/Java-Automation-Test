package TestEnterAccount;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class EnterAccountTest {
    @Before
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("f");
        driver.findElement(By.id("last-name")).sendKeys("f");
        driver.findElement(By.id("postal-code")).sendKeys("f");
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();
        //driver.findElement(By.id("back-to-products")).click();
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }
}
