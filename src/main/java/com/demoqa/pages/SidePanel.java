package com.demoqa.pages;

import com.demoqa.core.BasePage;
import com.demoqa.pages.aletsFrameWindows.AlertsPage;
import com.demoqa.pages.aletsFrameWindows.BrowserWindowsPage;
import com.demoqa.pages.bookstore.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Login']")
    WebElement login;

    public LoginPage clickOnLogin() {
        clickWithJS(login,0,300);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage clickOnAlert() {
        click(alerts);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BrowserWindowsPage clickOnBrowserWindows() {
        click(browserWindows);
        return new BrowserWindowsPage(driver);
    }
}
