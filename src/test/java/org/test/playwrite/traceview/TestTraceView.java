package org.test.playwrite.traceview;

import com.microsoft.playwright.Tracing;
import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class TestTraceView extends Launch {
    String url = "https://habr.com/ru/all/";

    @Test
    public void testTraceView() {
        page.navigate(url);


    }

    @BeforeClass
    public void set() {
        prepare();
        bc.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));
    }

    @AfterClass
    public void down() {
        bc.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        tierDown();
    }
}
