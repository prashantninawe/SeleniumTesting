package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage {
    private final WebDriver driver;
    private final String editorIframeId = "mce_0_ifr";
    private final By textArea = By.id("tinymce");

    public WYSIWYGEditorPage(WebDriver driver){
        this.driver = driver;
    }

    private void clearTextArea(){
        switchToEditorArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    private void setTextArea(String text){
        switchToEditorArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    private String getTextFromEditor(){
        switchToEditorArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    private void switchToEditorArea(){
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea(){
        switchToEditorArea();
        driver.switchTo().parentFrame();
    }
}
