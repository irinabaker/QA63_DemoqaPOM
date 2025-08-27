package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.alertsFrameWindows.AlertsPage;
import com.demoqa.pages.alertsFrameWindows.BrowserWindowsPage;
import com.demoqa.pages.alertsFrameWindows.IframePage;
import com.demoqa.pages.alertsFrameWindows.NestedIframesPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AlertsFrameWindowsTests extends TestBase {

    SidePanel sidePanel;
    AlertsPage alerts;
    IframePage iframe;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(driver);
        alerts = new AlertsPage(driver);
        iframe = new IframePage(driver);
        new HomePage(driver).getAlertsFrameWindows();
    }

    @Test
    @DisplayName("Verify to - Alert appears after 5 second waiting")
    public void waitAlertTest() {
        sidePanel.clickOnAlert();
        alerts.clickOnSecondButton()
                .verifyAlertWithTimer();
    }

    @Test
    @Tag("demo")
    public void selectResultTest() {
        sidePanel.clickOnAlert();
        alerts.clickOnThirdButton()
                .selectResult("Ok")
                .verifyResult("Ok");
    }

    @Test
    public void sendMessageToAlertTest() {
        sidePanel.clickOnAlert();
        alerts.clickOnFourthButton()
                .sendMessageToAlert("Hello world!!!")
                .verifyMessage("Hello world!!!");
    }

    @Test
    public void newTabTest() {
        sidePanel.clickOnBrowserWindows();
        new BrowserWindowsPage(driver).clickOnNewTabButton()
                .newTabHandle(1)
                .verifyNewTabTitle("This is a sample page");
    }

    @Test
    public void switchToNewIframeByIndexTest() {
        sidePanel.clickOnFrame();
        iframe.returnListOfIframes()
                .switchToIframeByIndex(1)
                .verifyByTitle("This is a sample page");
    }

    @Test
    public void switchToNewIframeByIDTest() {
        sidePanel.clickOnFrame();
        iframe.switchToIframeByID()
                .verifyByTitle("This is a sample page")
                .switchToMainPage()
                .verifyMainPageTitle("Frames");
    }

    @Test
    public void nestedIframesTest() {
        sidePanel.clickOnNestedIframes();
        new NestedIframesPage(driver).verifyNestedIframes();
    }
}
