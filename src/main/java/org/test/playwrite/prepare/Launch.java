package org.test.playwrite.prepare;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.ArrayList;

public class Launch {

    protected Playwright pw;
    protected Browser browser;
    protected Page page;

    public void prepare() {
        pw = Playwright.create();
        ArrayList<String> properties = new ArrayList<>();
        properties.add("--start-maximized");
        browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(properties));
        BrowserContext bc = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = bc.newPage();
    }

    public void tierDown() {
        page.close();
        pw.close();
    }
}
