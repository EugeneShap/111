import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTest {


    @Test
    public void testFirstSelenium() {
        System.setProperty("webdriver.chrome.driver","C:/Users/Eugene/IdeaProjects/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS );

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchButton.click();

        searchBox = driver.findElement(By.name("q"));

        Assert.assertEquals(searchBox.getAttribute("value"), "Selenium");

        driver.quit();

    }

    @Test
    public void Test_Wiki() {

        System.setProperty("webdriver.chrome.driver","C:/Users/Eugene/IdeaProjects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://wikipedia.org/");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Wikipedia");
        driver.findElement(By.id("js-link-box-en")).click();
        String logo = driver.findElement(By.xpath("//*[@id=\"Welcome_to_Wikipedia\"]")).getText();
        Assert.assertEquals(logo,"Welcome to Wikipedia");
        driver.quit();
       // driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS );
        //WebElement searchBox = driver.findElement(By.name("q"));
       // WebElement searchButton = driver.findElement(By.name("btnK"));
        //searchBox.sendKeys("Wikipedia");
        //searchButton.click();




    }
}
