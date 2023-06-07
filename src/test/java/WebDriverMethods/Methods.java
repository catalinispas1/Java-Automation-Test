package WebDriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;


public class Methods {
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }
    WebDriver driver;
    WebElement element;
    @Test
    public void dropDown(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.id("dropdown"));
        WebElement option1 = element.findElement(By.cssSelector("#dropdown > option:nth-child(2)"));
        WebElement option2 = element.findElement(By.cssSelector("#dropdown > option:nth-child(3)"));
        option1.click();
        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());
    }
    @Test
    public void hover(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
        Assert.assertTrue(element.isDisplayed());
    }
    @Test
    public void clickAlert(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        element = driver.findElement(By.id("hot-spot"));
        actions.contextClick(element).perform();
        driver.switchTo().alert().accept();
    }
    @Test
    public void rightArrow(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");
        Actions actions = new Actions(driver);
        element = driver.findElement(By.id("target"));
        element.click();
        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        element = driver.findElement(By.id("result"));
        assertEquals("Clicked right arrow key", "You entered: RIGHT", element.getText());
    }
    @Test
    public void gethref(){
        driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        element = driver.findElement(By.linkText("Clickable Icon"));
        String link = element.getAttribute("href");
        assertEquals("https://ultimateqa.com/link-success/", link);
        assertEquals("padding-box", element.getCssValue("background-origin"));
    }
}
