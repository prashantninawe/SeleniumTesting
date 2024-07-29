package login;

import base.BaseTests;
import pages.LoginPage;
import pages.SecureArea;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test(timeOut = 30000)
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();

        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureArea secureArea = loginPage.clickLoginButton();

        assertTrue(secureArea.getAlertText().contains("You logged into a secure area!"));
        assertEquals(secureArea.getAlertText(), "You logged into a secure area!\n" +
                "×", "Incorrect alert text");
        secureArea.clickLogoutButton();

        assertTrue(loginPage.objectExists("//button[@type='submit']//i[contains(text(), ' Login')]").isEnabled());

    }
}