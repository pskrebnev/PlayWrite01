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

    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
