package com.demoqa;

import com.codeborne.selenide.Configuration;
import data.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import static com.codeborne.selenide.Browsers.FIREFOX;

public class FormTest {
    User user = new User("Mikhail",
            "Sulaev",
            "1234567890",
            "Maths",
            "Cyprus Pafos",
            "NCR",
            "Delhi",
            "test@gmail.com",
            "9",
            "1993",
            "September");
    FormPage formPage = new FormPage(user);


    @BeforeAll
    public static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.browser = FIREFOX;
    }

    @Test
    void formShoudBeCompleted() {
        formPage.open()
                .setFirstName()
                .setLastName()
                .setEmail()
                .checkGender("Radio Button Male")
                .setPhoneNumber()
                .setBirthday()
                .setSubject()
                .checkHobby()
                .uploadPicture()
                .setAdress()
                .clickToSubmit()
                .checkResultsForm();
    }

}
