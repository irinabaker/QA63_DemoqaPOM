package com.demoqa.tests.widgets;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.MenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).clickOnMenu();
    }

    @Test
    public void hoverMouseOnMenuTest() {
        new MenuPage(driver).hoverMouseOnSubMenu()
                .verifySubMenu();
    }
}
