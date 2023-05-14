package org.test.playwrite.mouseover;

import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMouseOver extends Launch {
    @BeforeClass
    public void set() {
        prepare();
    }

    @Test
    public void testMouseOver() {
        String url = "https://demoqa.com/menu";
        String menu1 = "//a[text()='Main Item 2']";
        String menu2 = "//a[text()='SUB SUB LIST »']";
        String menu3 = "//a[text()='Sub Sub Item 1']";

        page.navigate(url);
        page.locator(menu1).hover();
        page.locator(menu2).hover();
        page.locator(menu3).click();
    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
