package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    public static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.browser = FIREFOX;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void formShoudBeCompleted() {
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
        $("#firstName").setValue(user.getName());
        $("#lastName").setValue(user.getLastName());
        $("#userEmail").setValue(user.getEmail());
        $("[for=gender-radio-1]").as("Radio Button Male").click();
        $("#userNumber").setValue(user.getPhoneNumber());
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(user.getBirthMonth());
        $(".react-datepicker__year-select").selectOption(user.getBirthYear());
        $(".react-datepicker__month").$(byText(user.getBirthDay())).click();
        $("#subjectsInput").setValue(user.getSubject()).pressEnter();
        $("[for=hobbies-checkbox-1]").as("Checkbox Sorts").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/token_1.png"));
        $("#currentAddress").setValue(user.getCurrentAddress());
        $(byText("Select State")).click();
        $(byText(user.getState())).click();
        $(byText("Select City")).click();
        $(byText(user.getCity())).click();
        $("#submit").click();

        $(".modal-body").shouldHave(
                text(user.getSubject()),
                text(user.getEmail()),
                text(user.getCity()),
                text(user.getCurrentAddress()),
                text(user.getLastName()),
                text(user.getName()),
                text(user.getState()),
                text(user.getPhoneNumber()),
                text(user.getBirthYear()),
                text(user.getBirthYear()));
    }
}
