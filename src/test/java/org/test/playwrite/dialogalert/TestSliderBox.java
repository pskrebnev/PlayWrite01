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


        System.out.println("Height = " + slBox.height + ". Width = " + slBox.width);




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
