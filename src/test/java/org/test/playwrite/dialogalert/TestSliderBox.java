package org.test.playwrite.dialogalert;

import com.microsoft.playwright.options.BoundingBox;
import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSliderBox extends Launch {

    @Test
    public void testSlider() {
        String url = "https://demoqa.com/slider";
        String sliderBox = "//input[@type='range']";
        String sliderPoint = "//div[contains(@class, 'range-slider__tooltip--bottom')]";
        String infoBox = "//input[@id='sliderValue']";

        page.navigate(url);
        BoundingBox slBox = page.locator(sliderBox).boundingBox();
        BoundingBox slPoint = page.locator(sliderPoint).boundingBox();

        System.out.println("Value before = '" + page.locator(infoBox).getAttribute("value") + "'");

        page.mouse().click(slBox.x + slBox.width/2, slBox.y + slBox.height/2);

        System.out.println("Height = " + slBox.height + ". Width = " + slBox.width);
        System.out.println("Height = " + slBox.x + ". Width = " + slBox.y);
        System.out.println("Value after = '" + page.locator(infoBox).getAttribute("value") + "'");
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
