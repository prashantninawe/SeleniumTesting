package contextMenu;

import base.BaseTests;
import pages.ContextMenuPage;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testRightClick(){
        ContextMenuPage menuPage = homePage.clickContextMenu();
        menuPage.rightClickBox();
        String message = menuPage.getPopUpText();
        assertEquals(message, "You selected a context menu");
        menuPage.acceptPopUp();
    }
}
