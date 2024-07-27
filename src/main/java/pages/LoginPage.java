package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{

    private final WebDriver driver;
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.xpath("//button[@type='submit']//i[contains(text(), ' Login')]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String userName){
        driver.findElement(usernameField).sendKeys(userName);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureArea clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureArea(driver);
    }

    public WebElement objectExists(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
}
