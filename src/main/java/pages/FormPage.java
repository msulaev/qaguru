package pages;

import com.codeborne.selenide.Selenide;
import data.User;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormPage {
    User user;

    public FormPage(User user) {
        this.user = user;
    }

    public FormPage open() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public FormPage checkResultsForm() {
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
        return this;
    }

    public FormPage clickToSubmit() {
        $("#submit").click();
        return this;
    }

    public FormPage setAdress() {
        $("#currentAddress").setValue(user.getCurrentAddress());
        $(byText("Select State")).click();
        $(byText(user.getState())).click();
        $(byText("Select City")).click();
        $(byText(user.getCity())).click();
        return this;

    }

    public FormPage uploadPicture() {
        $("#uploadPicture").uploadFile(new File("src/test/resources/token_1.png"));
        return this;

    }

    public FormPage checkHobby() {
        $("[for=hobbies-checkbox-1]").as("Checkbox Sorts").click();
        return this;

    }

    public FormPage setSubject() {
        $("#subjectsInput").setValue(user.getSubject()).pressEnter();
        return this;

    }

    public FormPage setBirthday() {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(user.getBirthMonth());
        $(".react-datepicker__year-select").selectOption(user.getBirthYear());
        $(".react-datepicker__month").$(byText(user.getBirthDay())).click();
        return this;

    }

    public FormPage setPhoneNumber() {
        $("#userNumber").setValue(user.getPhoneNumber());
        return this;

    }

    public FormPage checkGender(String option) {
        $("[for=gender-radio-1]").as(option).click();
        return this;

    }

    public FormPage setEmail() {
        $("#userEmail").setValue(user.getEmail());
        return this;
    }

    public FormPage setLastName() {
        $("#lastName").setValue(user.getLastName());
        return this;

    }

    public FormPage setFirstName() {
        $("#firstName").setValue(user.getName());
        return this;

    }
}
