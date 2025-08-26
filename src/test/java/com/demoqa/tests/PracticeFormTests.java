package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    PracticeFormPage practiceForm;

    @BeforeEach
    public void precondition() {
        practiceForm = new PracticeFormPage(driver);
        new HomePage(driver).getForms();
        new SidePanel(driver).clickOnForms();
    }

    @Test
    public void createStudentAccountTest() {
        practiceForm.enterPersonalData("Jamal","Musiala","jam@gm.com","1234567890")
                .selectGender("Male")
                .typeOfDate("16 Aug 1987")
                .addSubjects(new String[]{"Math","Chemistry"})
               .selectHobbies(new String[]{"Sports","Reading"})
               .uploadFile("C:/Tools/1.jpg")
                .inputState("NCR")
               .inputCity("Delhi")
               .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form");
    }

    @RepeatedTest(value = 3,failureThreshold = 2,name = "{displayName}{currentRepetition}/{totalRepetitions}")
    public void createStudentAccountWithSelectDateTest() {
        practiceForm.enterPersonalData("Jamal","Musiala","jam@gm.com","1234567890")
                .selectGender("Male")
                .selectDate("August","1987","16")
                .addSubjects(new String[]{"Math","Chemistry"})
               .selectHobbies(new String[]{"Sports","Reading"})
               .uploadFile("C:/Tools/1.jpg")
                .inputState("NCR")
               .inputCity("Delhi")
               .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form");
    }
}
