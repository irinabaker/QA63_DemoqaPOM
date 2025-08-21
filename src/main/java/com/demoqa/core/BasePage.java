package com.demoqa.core;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    JavascriptExecutor js;
    public static SoftAssertions softly;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        js = (JavascriptExecutor) driver;
        softly = new SoftAssertions();
    }

    public void scrollWithJS(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void clickWithJS(WebElement element, int x, int y) {
        scrollWithJS(x,y);
        click(element);
    }

    public void typeWithJS(WebElement element, String text, int x, int y) {
        scrollWithJS(x,y);
        type(element,text);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean containsText(String text, WebElement element) {
        return element.getText().contains(text);
    }

    public boolean isAlertPresent(int time) {
        Alert alert = getWait(time)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        }else {
            alert.accept();
            return true;
        }
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return getWait(time)
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public WebDriverWait getWait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

}
