package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.User;
import elements.CalendarElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormPage {
    private final SelenideElement resultModal = $(".modal-body"),
            submitBtn = $("#submit"),
            currentAddress = $("#currentAddress"),
            state = $(byText("Select State")),
            city = $(byText("Select City")),
            uploadPicture = $("#uploadPicture"),
            subject = $("#subjectsInput"),
            dateOfBirthInpt = $("#dateOfBirthInput"),
            userNumber = $("#userNumber"),
            userEmail = $("#userEmail"),
            lastName = $("#lastName"),
            firstName = $("#firstName");


    private final CalendarElement calendarElement = new CalendarElement();
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

    public void checkResultsForm() {
        resultModal.shouldHave(
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

    public FormPage clickToSubmit() {
        submitBtn.click();
        return this;
    }

    public FormPage setAdress() {
        currentAddress.setValue(user.getCurrentAddress());
        state.click();
        $(byText(user.getState())).click();
        city.click();
        $(byText(user.getCity())).click();
        return this;

    }

    public FormPage uploadPicture() {
        uploadPicture.uploadFile(new File("src/test/resources/token_1.png"));
        return this;

    }

    public FormPage checkHobby() {
        $("#hobbiesWrapper").$(byText(user.getHobby())).click();
        return this;

    }

    public FormPage setSubject() {
        subject.setValue(user.getSubject()).pressEnter();
        return this;

    }

    public FormPage setBirthday() {
        dateOfBirthInpt.click();
        calendarElement.setDate(user.getBirthDay(), user.getBirthYear(), user.getBirthMonth());
        return this;

    }

    public FormPage setPhoneNumber() {
        userNumber.setValue(user.getPhoneNumber());
        return this;

    }

    public FormPage checkGender() {
        $("#genterWrapper").$(byText(user.getGender())).click();
        return this;

    }

    public FormPage setEmail() {
        userEmail.setValue(user.getEmail());
        return this;
    }

    public FormPage setLastName() {
        lastName.setValue(user.getLastName());
        return this;

    }

    public FormPage setFirstName() {
        firstName.setValue(user.getName());
        return this;

    }
}
