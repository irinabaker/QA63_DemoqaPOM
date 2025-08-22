package com.demoqa.pages;

import com.demoqa.core.BasePage;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.BrowserWindowsPage;
import com.demoqa.pages.alertsFrameWindows.IframePage;
import com.demoqa.pages.alertsFrameWindows.NestedIframesPage;
import com.demoqa.pages.bookstore.LoginPage;
import com.demoqa.pages.widgets.MenuPage;
import com.demoqa.pages.widgets.SelectMenuPage;
import com.demoqa.pages.widgets.SliderPage;
import com.demoqa.pages.widgets.ToolTipsPage;
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

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public IframePage clickOnFrame() {
        click(frames);
        return new IframePage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public NestedIframesPage clickOnNestedIframes() {
        clickWithJS(nestedFrames,0,200);
        return new NestedIframesPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage clickOnSelectMenu() {
        clickWithJS(selectMenu,0,600);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement menu;

    public MenuPage clickOnMenu() {
        clickWithJS(menu,0,600);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage clickOnSlider() {
        clickWithJS(slider,0,400);
        return new SliderPage(driver);
    }

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTips;

    public ToolTipsPage clickOnToolTips() {
        clickWithJS(toolTips,0,400);
        return new ToolTipsPage(driver);
    }
}
