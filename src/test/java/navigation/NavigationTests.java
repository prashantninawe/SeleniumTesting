package navigation;

import base.BaseTests;

import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {
    @Test(priority = 1)
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com/");
    }
    @Test(priority = 2)
    public void testSwitchTab(){
        goHome();
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}