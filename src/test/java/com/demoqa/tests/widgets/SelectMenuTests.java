package com.demoqa.tests.widgets;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.widgets.SelectMenuPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SelectMenuTests extends TestBase {

    SelectMenuPage selectMenu;

    @BeforeEach
    public void precondition() {
        selectMenu = new SelectMenuPage(driver);
        new HomePage(driver).getWidgets();
        new SidePanel(driver).clickOnSelectMenu();
    }

    @Test
    public void oldStyleSelectMenuTest() {
        selectMenu.oldStyleSelect("Voilet")
                .verifyColor();
    }

    @Test
    public void multiSelectDropDownTest() {
        selectMenu.multiSelectDropDown(new String[]{"Green","Red"})
                .verifyMultiSelect(new String[]{"Green","Red"});
    }


}
