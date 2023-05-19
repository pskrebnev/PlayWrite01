package org.test.playwrite.shadowdom;

import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestShadowDom extends Launch {

    @Test
    public void testShadowDom() {
        String url = "https://books-pwakit.appspot.com/";
        String textField = "#input";

        page.navigate(url);
        page.locator(textField).type("any staff bla-bla");
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
