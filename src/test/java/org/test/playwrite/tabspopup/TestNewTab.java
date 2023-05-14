package org.test.playwrite.tabspopup;

import com.microsoft.playwright.Page;
import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNewTab extends Launch {
    @BeforeClass
    public void set() {
        prepare();
    }

    @Test
    public void testNewTab(){
        String URL = "https://demoqa.com/browser-windows";
        String buttonLocator = "//button[text()='New Tab']";

        page.navigate(URL);
        Page newPage = page.waitForPopup(() -> page.locator(buttonLocator).click());

        System.out.println("Text: '" + newPage.locator("//h1").innerText() + "'.");
    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
