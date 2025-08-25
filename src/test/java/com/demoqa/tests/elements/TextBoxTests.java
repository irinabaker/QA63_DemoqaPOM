package com.demoqa.tests.elements;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.TextBoxPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {

    TextBoxPage textBox;

    @BeforeEach
    public void precondition() {
        textBox = new TextBoxPage(driver);
        new HomePage(driver).getElements();
        new SidePanel(driver).clickOnTextBox();
    }

    @Test
    public void autocompleteTest() {
        textBox.autocomplete("Friedrichstr. 12, Berlin")
                .clickOnSubmit()
                .verifyAddress();
    }
}
