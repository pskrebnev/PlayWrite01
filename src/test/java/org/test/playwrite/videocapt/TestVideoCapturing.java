package org.test.playwrite.videocapt;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class TestVideoCapturing extends Launch {
    String videoFolder = "resources/videorec/";
    String url = "https://www.freecodecamp.org/news/";
    BrowserContext bc;

    @Test
    public void testVideoCapture() {
        bc = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get(videoFolder)));

        Page page = bc.newPage();
        page.navigate(url);
    }

    @BeforeClass
    public void set() {
        prepare();
    }

    @AfterClass
    public void down() {
        bc.close();
        tierDown();
    }

}
