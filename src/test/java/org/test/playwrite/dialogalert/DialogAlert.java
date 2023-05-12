package org.test.playwrite.dialogalert;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DialogAlert extends Launch {

    public static final String URL = "https://demoqa.com/alerts";

    @BeforeClass
    public void set() {
        prepare();
    }

    @Test
    public void testAlerts() throws InterruptedException {
        page.navigate(URL);
        System.out.println("Page title is <" + page.title() + ">");
        Locator alertButtons = page.locator("//button[contains(text(), 'Click me')]");

        // click on first button
        alertButtons.nth(0).click();
//        Thread.sleep(3000);
        System.out.println("Text = " + alertButtons.nth(0).innerText());

        page.onDialog(dialog -> {
            System.out.println("Text alert = '" + dialog.message() + "'");
            dialog.accept();
        });

//        page.onDialog(Dialog::accept);
    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
