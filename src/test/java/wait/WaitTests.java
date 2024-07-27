package wait;

import base.BaseTests;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test(priority = 1)
    public void testWaitUntilHidden(){
        DynamicLoadingExample1Page example1Page = homePage.clickDynamicLoading().clickExample1();
        example1Page.clickStart();
        assertEquals(example1Page.getLoadedText(),"Hello World!");
    }

    @Test(priority = 2)
    public void testWaitUntilVisible(){
        goHome();
        DynamicLoadingExample2Page example2Page = homePage.clickDynamicLoading().clickExample2();
        example2Page.clickStart();
        assertEquals(example2Page.getLoadedText(),"Hello World!");
    }
}