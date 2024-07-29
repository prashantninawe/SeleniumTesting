package base;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import utils.EventListener;
import utils.WindowManager;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        EventListener listener = new EventListener();
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(listener);
        driver = decorator.decorate(new ChromeDriver(getChromeOptions()));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.manage().window().maximize();

        Reporter.log("launching internet herokuapp website");
        goHome();
    }

    @AfterClass
    public void tearDown(){
        Reporter.log("tearDown method - chromedriver shutdown");
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result);
        }
    }

    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    public void takeScreenshot(ITestResult result) {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd-MM-yyyy HHmmss");
        String formattedDateTime = currentTime.format(formatter);
        try {
            Files.move(screenshot, new File("C:/Users/ninaw/IdeaProjects/SeleniumTesting/resources/screenshots/" +
                    result.getName() +
                    formattedDateTime +
                    ".png"
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        options.addArguments("start-maximized");
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}