package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.bookstore.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookStoreTests extends TestBase {

    @BeforeEach
    public void precondition() {
        new HomePage(driver).getBookStore();
        new SidePanel(driver).clickOnLogin();
    }

    @Test
    public void loginPositiveTest() {
        new LoginPage(driver).enterData("neuer","Neuer1234!")
                .clickOnLoginButton()
                .verifyUserName("neuer");
    }
}
