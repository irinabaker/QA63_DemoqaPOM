package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedIframesPage extends BasePage {

    public NestedIframesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "frame1")
    WebElement frame1;
    @FindBy(css = "body")
    WebElement body;
    @FindBy(css = "iframe")
    List<WebElement> iframes;

    public NestedIframesPage verifyNestedIframes() {
        //switch to parent iframe by ID
        driver.switchTo().frame(frame1);
        //assert by text and by total number of iframes
        softly.assertThat(containsText("Parent frame",body));
        softly.assertThat(iframes.size()).isEqualTo(1);
        //switch to child iframe by index
        driver.switchTo().frame(0);
        //assert by text
        softly.assertThat(containsText("Child Iframe",body));
        //return to parent iframe
        driver.switchTo().parentFrame();
        softly.assertThat(containsText("Parent frame",body));
        softly.assertAll();
        return this;
    }
}
