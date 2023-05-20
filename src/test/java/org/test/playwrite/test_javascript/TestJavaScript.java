package org.test.playwrite.test_javascript;

import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestJavaScript extends Launch {

    // Scenario:
    // 1. navigate 'https://aquapark.wroc.pl/en'
    // 2. add text area by JS
    // 3. type text
    // 4. make a screenshot (TBD)
    @Test
    public void testJavaScript() {
        String url = "https://aquapark.wroc.pl/en";
        String jScript = "() => {" +
                "const textArea = document.createElement('textarea');" +
                "document.body.append(textArea);" +
                "textArea.focus();" +
                "}";
        String text = "Juliush Howanski!!!";

        page.navigate(url);
        page.evaluate(jScript);
        page.keyboard().type(text);

        System.out.println("Evaluation JavaScript: " + page.evaluate("document.location.href"));
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
