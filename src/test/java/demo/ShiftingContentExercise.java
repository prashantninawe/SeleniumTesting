package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ShiftingContentExercise {
    protected WebDriver driver;

    public void setUp() throws InterruptedException{
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(), 'Shifting Content')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[contains(text(), 'Example 1: Menu Element')]")).click();
        Thread.sleep(5000);

        List<WebElement> menuItems = driver.findElements(By.tagName("li"));
        System.out.println("Number of menu items: " + menuItems.size());

        driver.quit();
    }
    public static void main(String[] args) throws InterruptedException {
        ShiftingContentExercise tests = new ShiftingContentExercise();
        tests.setUp();
    }
}