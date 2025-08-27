package com.demoqa.tests.interactions;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.interactions.DroppablePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DragAndDropTests extends TestBase {

    DroppablePage droppable;

    @BeforeEach
    public void precondition() {
        droppable = new DroppablePage(driver);
        new HomePage(driver).getInteractions();
        new SidePanel(driver).clickOnDroppable();
    }

    @Test
    @Tag("demo")
    public void dragMeTest() {
        droppable.dragMe()
                .verifyDropped("Dropped!");
    }

    @Test
    public void dragMeByTest() {
        droppable.dragMeBy()
                .verifyDropped("Dropped!");
    }
}
