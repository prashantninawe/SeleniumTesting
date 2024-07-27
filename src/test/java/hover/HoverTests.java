package hover;

import base.BaseTests;
import pages.HoversPage;
import pages.HoversPage.FigureCaption;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {
    @Test
    public void testHover(){
        HoversPage hoversPage = homePage.clickHoversLink();

        int index = 3;
        FigureCaption caption = hoversPage.hoverOverFigure(index);

        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(), "name: user" + index, "Caption title incorrect");
        assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");
        assertTrue(caption.getLink().endsWith("/users/"+ index), "Link incorrect");
    }
}
