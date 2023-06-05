package org.test.playwrite.uploadingfile;

import java.nio.file.Paths;

import com.microsoft.playwright.Download;
import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DownloadingFile extends Launch {
    String url = "https://eforms.state.gov/";
    String btnLocator = "//a[contains(@href, 'ds60')]";

    @Test
    public void downloadFile() {
        page.navigate(url);
        Download file = page.waitForDownload(() -> {
            page.locator(btnLocator).nth(1).click();
        });

        file.saveAs(Paths.get("./src/test/resources/files/ds60.pdf"));
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
