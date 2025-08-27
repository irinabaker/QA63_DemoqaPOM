package com.demoqa.tests.elements;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.elements.TextBoxPage;
import com.demoqa.utils.MyArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    @ParameterizedTest
    @ArgumentsSource(MyArgumentsProvider.class)
    public void textBoxWithParameterTest(String name, String email, String address) {
        textBox.enterPersonalData(name,email,address)
                .clickOnSubmit()
                .verifyAddress();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void textBoxWithCsvFileTest(String name, String email, String address) {
        textBox.enterPersonalData(name,email,address)
                .clickOnSubmit()
                .verifyAddress();
    }
}
