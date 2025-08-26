package com.demoqa.tests.elements;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.LinksPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokenLinkImagesTests extends TestBase{

    LinksPage links;

    @BeforeEach
    public void precondition() {
        links = new LinksPage(driver);
        new HomePage(driver).getElements();
        new SidePanel(driver).clickOnBrokenLinksImages();
    }

    @Test
    public void getAllLinksTest() {
        links.getAllLinks();
    }

    @Test
    public void checkBrokenLinksTest() {
        links.checkBrokenLinks();
    }

    @Test
    public void checkBrokenImages() {
        links.checkBrokenImages();
    }
}
