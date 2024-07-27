package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HorizontalSliderPage {
    private final WebDriver driver;
    private final By sliderValue = By.id("range");
    private final By slider = By.cssSelector(".sliderContainer input");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void setSliderValue(String value){
        while (!getSliderValue().equals(value) && Double.parseDouble(value) <= 5){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }
    public String getSliderValue(){
        return driver.findElement(sliderValue).getText();
    }
}
