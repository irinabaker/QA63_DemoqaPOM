package com.demoqa.tests.widgets;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.ToolTipsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ToolTipsTest extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).clickOnToolTips();
    }

    @Test
    public void toolTipsTest() {
        new ToolTipsPage(driver).hoverMouseOnToolTips()
                .verifyToolTips("buttonToolTip");
    }
}
