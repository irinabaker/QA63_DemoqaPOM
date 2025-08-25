package com.demoqa.pages.interactions;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage dragMe() {
        waitAndScroll(1000,0,300);

        actions.dragAndDrop(dragMe,dropHere).perform();
        return this;
    }

    public DroppablePage verifyDropped(String text) {
        Assertions.assertTrue(shouldHaveText(dropHere,text,5));
        return this;
    }

    public DroppablePage dragMeBy() {
        waitAndScroll(1000,0,300);

        //get coordinates dragMe(from)
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffset1 -> " + xOffset1 + " *** " + "yOffset1 -> " + yOffset1);

        //get coordinates dropHere(to)
        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("xOffset -> " + xOffset + " *** " + "yOffset -> " + yOffset);

        //find difference offset and offset1
        xOffset = (xOffset - xOffset1) + 30;
        yOffset = (yOffset - yOffset1) + 60;
        actions.dragAndDropBy(dragMe,xOffset,yOffset).perform();
        return this;
    }
}
