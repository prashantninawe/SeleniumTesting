package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTests {
    @Test
    public void testScrollToTable() throws InterruptedException {
        goHome();
        homePage.clickLargeAndDeepDom().scrollToTable();
        Thread.sleep(5000);
    }
    @Test
    public void testScrollToFifthParagraph(){
        goHome();
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}