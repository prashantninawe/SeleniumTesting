package keyPresses;

import base.BaseTests;
import pages.KeyPressesPage;

import org.openqa.selenium.Keys;

import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.assertEquals;

public class KeyTests extends BaseTests {

    private KeyPressesPage keyPresses;

    @Test
    public void keyTest(){
        keyPresses = homePage.clickKeyPresses();
        keyPresses.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPresses.getResult(), "You entered: " + "BACK_SPACE");
    }

    @Test
    public void testPi() throws InterruptedException, AWTException {
        keyPresses.enterPi();
        System.out.println(keyPresses.getResult());
    }

}
