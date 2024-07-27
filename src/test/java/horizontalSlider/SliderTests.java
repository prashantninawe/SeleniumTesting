package horizontalSlider;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class SliderTests extends BaseTests {

    @Test(timeOut = 5000)
    public void testSlideToNumber(){
        HorizontalSliderPage sliderPage = homePage.clickHorizontalSlider();
        String value = "4.5";
        sliderPage.setSliderValue(value);
        Assert.assertEquals(sliderPage.getSliderValue(), value, "Slider Value is incorrect");
    }
}
