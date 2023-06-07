package LocatingElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatingElementsTest {
    WebDriver driver;
    @Before
    public void setDriver(){
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        driver = new EdgeDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void elementsQuiz1() {
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        WebElement element;
        // tag name
        //element = driver.findElement(By.tagName("form_input"));
        // class name
        //element = driver.findElement(By.className("input_error form_input"));
        // xpath selector
        element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/article/div/div[1]/div/div[2]/div/div[1]/div[3]/div/div/div/a"));
        //lint text
        //element = driver.findElement(By.linkText("Click me using this link text!"));
        //css selector
        //element = driver.findElement(By.cssSelector("div.et_pb_blurb_description:nth-child(1) > a:nth-child(1)"));
        driver.get("https://www.google.com/");
    }
}
