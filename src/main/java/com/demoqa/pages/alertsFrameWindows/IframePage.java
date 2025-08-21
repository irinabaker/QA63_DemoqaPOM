package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IframePage extends BasePage {

    public IframePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "iframe")
    List<WebElement> iframes;

    public IframePage returnListOfIframes() {
        System.out.println("The total number of iframes are " + iframes.size());
        return this;
    }

    public IframePage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public IframePage verifyByTitle(String title) {
        Assertions.assertTrue(containsText(title,sampleHeading));
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    public IframePage switchToIframeByID() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public IframePage switchToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(css = ".text-center")
    WebElement mainTitle;

    public IframePage verifyMainPageTitle(String title) {
        Assertions.assertTrue(containsText(title,mainTitle));
        return this;
    }
}
