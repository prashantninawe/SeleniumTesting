package alerts;

import base.BaseTests;
import pages.JavaScriptAlertsPage;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.testng.asserts.SoftAssert;

public class AlertTests extends BaseTests {
    private JavaScriptAlertsPage alertsPage;

    @Test
    public void testAcceptAlert(){
        alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alertsPage.getResult(), "You successfully clicked an alert");
        softAssert.assertAll();
    }

    @Test
    public void testGetTextFromAlert(){
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm");
    }

    @Test
    public void testSetInputInAlert(){
        alertsPage.triggerPrompt();
        String text = "test automation";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + text);
    }
}
