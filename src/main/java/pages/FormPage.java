package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.User;
import elements.CalendarElement;
import io.qameta.allure.Step;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
    ElementsCollection cities = $$(".css-11unzgr div");

    @Step("Open URL:https://demoqa.com/automation-practice-form")
    public FormPage open() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    @Step("Check Result from with our User: {0}")
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

    @Step("Check that result modal not exist")
    public void checkThatResultModalNotExist() {
        resultModal.shouldNot(exist);
    }

    @Step("Click to submit")
    public FormPage clickToSubmit() {
        submitBtn.click();
        return this;
    }

    @Step("Upload image from resources")
    public FormPage uploadPicture() {
        uploadPicture.uploadFile(new File("src/test/resources/token_1.png"));
        return this;

    }

    @Step("Click hobby")
    public FormPage checkHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;

    }

    @Step("Set subjects: {0}")
    public FormPage setSubject(String subj) {
        subject.setValue(subj).pressEnter();
        return this;

    }

    @Step("Set date: {0}/{1}/{3}")
    public FormPage setBirthday(String birthDay, String birthYear, String birthMonth) {
        dateOfBirthInpt.click();
        calendarElement.setDate(birthDay, birthYear, birthMonth);
        return this;

    }

    @Step("Set number")
    public FormPage setPhoneNumber(String phoneNumber) {
        userNumber.setValue(phoneNumber);
        return this;

    }

    @Step("Set gender: {0}")
    public FormPage checkGender(String gender) {
        if (gender == null) {
            return this;
        } else {
            $("#genterWrapper").$(byText(gender)).click();
        }
        return this;

    }

    @Step("Set email: {0}")
    public FormPage setEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    @Step("Set lastname: {0}")
    public FormPage setLastName(String surname) {
        lastName.setValue(surname);
        return this;
    }

    @Step("Set firstname: {0}")
    public FormPage setFirstName(String name) {
        firstName.setValue(name);
        return this;

    }

    @Step("Set state: {0}")
    public FormPage setState(String stateName) {
        state.click();
        $(byText(stateName)).click();
        return this;
    }

    @Step("Set current adress: {0}")
    public FormPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    @Step("Set city: {0}")
    public FormPage setCity(String cityName) {
        city.click();
        $(byText(cityName)).click();
        return this;

    }

    public FormPage checkCities(List<String> stateName) {
        city.click();
        cities.shouldHave(texts(stateName));
        return this;
    }
}
