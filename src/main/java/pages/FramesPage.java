package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private final WebDriver driver;

    public FramesPage(WebDriver driver){
        this.driver = driver;
    }
    public NestedFramesPage clickNestedFrames() throws InterruptedException{
        driver.findElement(By.linkText("Nested Frames")).click();
        Thread.sleep(2000);
        return new NestedFramesPage(driver);
    }
}
