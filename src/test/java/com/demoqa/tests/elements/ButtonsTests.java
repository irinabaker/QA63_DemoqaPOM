package com.demoqa.tests.elements;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.ButtonsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ButtonsTests extends TestBase {

    ButtonsPage buttons;

    @BeforeEach
    public void precondition() {
        buttons = new ButtonsPage(driver);
        new HomePage(driver).getElements();
        new SidePanel(driver).clickOnButtons();
    }

    @Tag("demo")
    @Test
    public void doubleClickTest() {
        buttons.doubleClick()
                .verifyDoubleClick("double click");
    }

    @Test
    public void rightClickTest() {
        buttons.rightClick()
                .verifyRightClick("right click");
    }
}
