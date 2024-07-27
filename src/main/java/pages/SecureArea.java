package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureArea {
    private WebDriver driver;
    private final By statusAlert = By.id("flash");
    private final By logoutButton = By.xpath("//a[@class='button secondary radius']/i[contains(text(), 'Logout')]");

    public SecureArea(WebDriver driver){
        this.driver = driver;
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }
}