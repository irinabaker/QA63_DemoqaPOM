package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {

    public SliderPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(css = ".range-slider")
    WebElement sliderInput;

    public SliderPage moveSliderToHorizontalDirection() {
        waitAndScroll(1000, 0, 300);

        actions.dragAndDropBy(sliderInput,260,0).perform();
        return this;
    }

    @FindBy(id = "sliderValue")
    WebElement sliderValue;

    public SliderPage verifySliderValue(String number) {
        Assertions.assertEquals(number,sliderValue.getDomAttribute("value"));
        return this;
    }
}
