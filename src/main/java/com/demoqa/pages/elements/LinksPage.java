package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public LinksPage getAllLinks() {
        System.out.println("Total links on the page: " + allLinks.size());

        String url = "";
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
            System.out.println("***********************************");
        }
        return this;
    }

    public LinksPage checkBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getDomAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public LinksPage checkBrokenImages() {
        System.out.println("Total images on the page: " + images.size());

        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageURL = image.getAttribute("src");
            verifyLinks(imageURL);
            //check display images using JavaScript executor
            try {
                boolean imageDisplayed = (Boolean) js.executeScript
                        ("return (typeof  arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                    System.out.println("**********************************");
                    softly.assertThat(imageDisplayed);
                } else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("***********************************");
                    softly.fail("Broken image is " + imageURL);
                }
            } catch (Exception e) {
                System.out.println("ERROR occurred");
            }
            softly.assertAll();
        }


        return this;
    }
}
