package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.aletsFrameWindows.AlertsPage;
import com.demoqa.pages.aletsFrameWindows.BrowserWindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlertsFrameWindowsTests extends TestBase {

    SidePanel sidePanel;
    AlertsPage alerts;

    @BeforeEach
    public void precondition() {
        sidePanel = new SidePanel(driver);
        alerts = new AlertsPage(driver);
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

}
