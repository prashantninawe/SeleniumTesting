package login;

import base.BaseTests;
import pages.LoginPage;
import pages.SecureArea;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = homePage.clickFormAuthentication();
        Thread.sleep(3000);

        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureArea secureArea = loginPage.clickLoginButton();
        Thread.sleep(3000);

        assertTrue(secureArea.getAlertText().contains("You logged into a secure area!"));
        assertEquals(secureArea.getAlertText(), "You logged into a secure area!\n" +
                "×", "Incorrect alert text");
        secureArea.clickLogoutButton();
        Thread.sleep(3000);

        assertTrue(loginPage.objectExists("//button[@type='submit']//i[contains(text(), ' Login')]").isEnabled());

    }
}