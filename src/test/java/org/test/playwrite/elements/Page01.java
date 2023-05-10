package org.test.playwrite.elements;

import com.microsoft.playwright.Locator;
import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Page01 extends Launch {

    @BeforeClass
    public void set() {
        prepare();
    }

    @Test
    public void testPage() throws InterruptedException {
        String pageCheckbox = "https://demoqa.com/checkbox/";
        page.navigate(pageCheckbox);
        System.out.println("Page title is <" + page.title() + ">");
        page.locator("//button[@aria-label='Expand all']").click();
        // checkbox with text "P"
        Locator listCheckboxes = page.locator("//*[contains(text(), 'P') and @class='rct-title']");

        int count = listCheckboxes.count();
        int i = 0;
        while (i < count) {
            listCheckboxes.nth(i).click();
            i++;
        }

        Thread.sleep(5000);
    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
