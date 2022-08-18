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


    public FormPage open() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public void checkResultsForm(User user) {
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
                text(user.getBirthMonth()));
    }

    public FormPage clickToSubmit() {
        submitBtn.click();
        return this;
    }

    public FormPage setAddress(String currentAddress, String state, String city) {
        this.currentAddress.setValue(currentAddress);
        this.state.click();
        $(byText(state)).click();
        this.city.click();
        $(byText(city)).click();
        return this;

    }

    public FormPage uploadPicture() {
        uploadPicture.uploadFile(new File("src/test/resources/token_1.png"));
        return this;

    }

    public FormPage checkHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;

    }

    public FormPage setSubject(String subject) {
        this.subject.setValue(subject).pressEnter();
        return this;

    }

    public FormPage setBirthday(String birthDay, String birthYear, String birthMonth) {
        dateOfBirthInpt.click();
        calendarElement.setDate(birthDay, birthYear, birthMonth);
        return this;

    }

    public FormPage setPhoneNumber(String phoneNumber) {
        userNumber.setValue(phoneNumber);
        return this;

    }

    public FormPage checkGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;

    }

    public FormPage setEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public FormPage setLastName(String lastName) {
        this.lastName.setValue(lastName);
        return this;

    }

    public FormPage setFirstName(String name) {
        firstName.setValue(name);
        return this;

    }
}
