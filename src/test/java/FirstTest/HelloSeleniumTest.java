package FirstTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloSeleniumTest{
    @BeforeClass
    public static void setupClass(){
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }
    @Test
    public void firstTest(){
        WebDriver edgeDriver = new EdgeDriver();
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.saucedemo.com/");
        edgeDriver.get("https://www.saucedemo.com/");
    }
}
