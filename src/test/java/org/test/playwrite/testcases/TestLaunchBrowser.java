package org.test.playwrite.testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;

public class TestLaunchBrowser {

    public Playwright pw;
    public Browser browser;

    private String url = "https://applitools.com/blog/top-playwright-questions-answered/";

    @BeforeClass
    public void prepare() {
        pw = Playwright.create();
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        System.out.println(width+"---"+height);
    }

    @Test
    public void testLaunchBrowser() {
        Page page = browser.newPage();
        page.navigate(url);
        System.out.println("The title is: <" + page.title() + ">");
    }

    @AfterClass
    public void tierDown() {
        pw.close();
    }
}
