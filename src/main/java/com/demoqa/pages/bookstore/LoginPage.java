package com.demoqa.pages.bookstore;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;

    public LoginPage enterData(String name, String password) {
        type(userNameInput,name);
        type(passwordInput,password);
        return this;
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage clickOnLoginButton() {
        clickWithJS(loginButton,0,100);
        return new ProfilePage(driver);
    }
}
