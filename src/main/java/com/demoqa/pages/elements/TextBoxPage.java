package com.demoqa.pages.elements;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage autocomplete(String address) {
        typeWithJS(currentAddress,address,0,300);
        //select current address
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        //copy current address
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
        //press TAB to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past current address to permanent address
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();

        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public TextBoxPage clickOnSubmit() {
        click(submit);
        return this;
    }

    @FindBy(css = ".border>#currentAddress")
    WebElement currentAddressResult;
    @FindBy(css = ".border>#permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage verifyAddress() {
        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assertions.assertEquals(permanent[1],current[1]);
        return this;
    }

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    public TextBoxPage enterPersonalData(String name, String email, String address) {
        typeWithJS(userName,name,0,600);
        typeWithJS(userEmail,email,0,400);
        type(currentAddress,address);
        typeWithJS(permanentAddress,address,0,400);
        return this;
    }
}
