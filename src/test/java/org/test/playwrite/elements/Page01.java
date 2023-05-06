package org.test.playwrite.elements;

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
        String page1 = "https://edition.cnn.com/";
        page.navigate(page1);
        System.out.println("Page title is <" + page.title() + ">");
//        page.locator("//input [@name = 'q']").type("Oshkosh");
//        page.keyboard().press("F");
        Thread.sleep(5000);
    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
