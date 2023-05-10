package org.test.playwrite.elements;

import com.microsoft.playwright.Locator;
import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingCheckboxes extends Launch {

    @BeforeClass
    public void set() {
        prepare();
    }

    @Test
    public void testCheckboxes() throws InterruptedException {
        String URL_PAGE1 = "http://www.tizag.com/htmlT/htmlcheckboxes.php";
        Locator setCheckboxes = page.locator("//h2[text() = 'HTML Checkbox Form:']/" +
                "following-sibling::div[1]/.//input[@type='checkbox']");

        page.navigate(URL_PAGE1);

        for (int i = 0; i < setCheckboxes.count(); i++) {
            setCheckboxes.nth(i).click();
        }
    }

    @AfterClass
    public void down() throws InterruptedException {
        tierDown();
        Thread.sleep(5000);
    }
}
