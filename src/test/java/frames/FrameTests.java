package frames;

import base.BaseTests;
import org.testng.asserts.SoftAssert;
import pages.NestedFramesPage;

import org.testng.annotations.Test;

public class FrameTests extends BaseTests {

    @Test
    public void testFrameText() throws InterruptedException{
        NestedFramesPage framesPage = homePage.clickFrames().clickNestedFrames();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(framesPage.getLeftFrameText(), "LEFT");
        softAssert.assertEquals(framesPage.getBottomFrameText(), "BOTTOM");
        softAssert.assertAll();
    }
}