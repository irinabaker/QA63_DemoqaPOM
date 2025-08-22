package com.demoqa.tests.widgets;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.SliderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SliderTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).clickOnSlider();
    }

    @Test
    public void sliderTest() {
        new SliderPage(driver).moveSliderToHorizontalDirection()
                .verifySliderValue("100");
    }
}
