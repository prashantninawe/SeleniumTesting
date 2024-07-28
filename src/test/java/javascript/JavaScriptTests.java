package javascript;

import base.BaseTests;
import pages.DropdownPage;

import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
    @Test
    public void testAddMultipleAttributeToDropdown(){
        goHome();
        DropdownPage dropdownPage = homePage.clickDropDown();
        dropdownPage.addMultipleAttribute();

        var optionsToSelect = List.of("Option 1","Option 2");
        optionsToSelect.forEach(dropdownPage::selectFromDropdown);

        var selectedOptions = dropdownPage.getSelectedOption();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(), optionsToSelect.size());
    }
}