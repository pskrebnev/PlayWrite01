package org.test.playwrite.elements;

import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Page01 extends Launch {
    private String page1 = "https://www.google.com/";

    @BeforeClass
    public void set() {
        prepare();
    }

    @Test
    public void testPage() {
        page.navigate(page1);
        System.out.println("Page title is <" + page.title() + ">");
    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
