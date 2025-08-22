package com.demoqa.pages.widgets;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends BasePage {

    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "toolTipButton")
    WebElement toolTipButton;

    public ToolTipsPage hoverMouseOnToolTips() {
        waitAndScroll(1000,0,200);

        actions.moveToElement(toolTipButton).perform();
        pause(1000);
        return this;
    }

    public ToolTipsPage verifyToolTips(String value) {
        Assertions.assertEquals(value,toolTipButton.getDomAttribute("aria-describedby"));
        return this;
    }
}
