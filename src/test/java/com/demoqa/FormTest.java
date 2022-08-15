package com.demoqa;

import com.BaseTest;
import com.github.javafaker.Faker;
import data.User;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import static data.User.getDate;
import static utils.Constant.*;
import static utils.Utils.getRandom;

public class FormTest extends BaseTest {
    Faker faker = new Faker();

    User user = new User(
            faker.name().firstName(),
            faker.name().lastName(),
            faker.numerify("##########"),
            getRandom(subjects),
            faker.address().fullAddress(),
            "NCR",
            "Delhi",
            faker.internet().emailAddress(),
            getDate()[0],
            getDate()[2],
            getDate()[1],
            getRandom(genders),
            getRandom(hobbies)
    );
    FormPage formPage = new FormPage(user);

    @Test
    void formShoudBeCompleted() {
        formPage.open()
                .setFirstName()
                .setLastName()
                .setEmail()
                .checkGender()
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
