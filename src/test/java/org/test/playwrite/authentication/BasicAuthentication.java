package org.test.playwrite.authentication;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicAuthentication extends Launch {
    String url = "http://the-internet.herokuapp.com/basic_auth";
    String username = "admin";
    String password = "admin";
    String pathToText = "//div[@id='content']/div/p";
    String text = "Congratulations! You must have the proper credentials";

    @Test
    public void testBasicAuthentication() {
        BrowserContext context = browser
                .newContext(new Browser.NewContextOptions()
                        .setHttpCredentials(username, password));

        page = context.newPage();
        page.navigate(url);

        boolean isContains = page.locator(pathToText).innerText().contains(text);
        System.out.println(isContains ? "You are logged!" : "You are NOT logged");
    }

    @BeforeClass
    public void set() {
        prepare();
    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
