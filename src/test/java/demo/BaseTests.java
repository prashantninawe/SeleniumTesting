package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {
    protected WebDriver driver;

    public void setUp() throws InterruptedException{
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(412, 915));

        WebElement inputsLink = driver.findElement(By.xpath("//a[contains(text(), 'Input')]"));
        inputsLink.click();

        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }
    public static void main(String[] args) throws InterruptedException {
        BaseTests tests = new BaseTests();
        tests.setUp();
    }
}