package org.test.playwrite.dialogalert;

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

        Locator button = alertButtons.nth(0);

        // click on first button
        button.hover();
        Thread.sleep(5000);
        button.click();
        Thread.sleep(9000);


        System.out.println("Text = " + button.innerText());

        page.onDialog(dialog -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dialog.accept();
            System.out.println("Text alert = '" + dialog.message() + "'");
        });
//        page.onDialog(Dialog::accept);
    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
