package org.test.playwrite.testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class TestLaunchBrowser {

    public Playwright pw;
    public Browser browser;
    public Page page;

    private String url = "https://applitools.com/blog/top-playwright-questions-answered/";

    @BeforeClass
    public void prepare() {
        pw = Playwright.create();

        // through properties
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
//        browser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));

        BrowserContext bc = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = bc.newPage();

        // through dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        System.out.println(width + "---" + height);
    }

    @Test
    public void testLaunchBrowser() {
        page.navigate(url);
        System.out.println("The title is: <" + page.title() + ">");
    }

    @AfterClass
    public void tierDown() {
        page.close();
        pw.close();
    }
}
