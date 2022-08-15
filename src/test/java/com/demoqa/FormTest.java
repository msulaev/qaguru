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
    User user_2 = User.builder()
            .name(faker.name().firstName())
            .lastName(faker.name().lastName())
            .phoneNumber(faker.numerify("##########"))
            .subject(getRandom(SUBJECTS))
            .currentAddress(faker.address().fullAddress())
            .email(faker.internet().emailAddress())
            .birthDay(getDate()[0])
            .birthMonth(getDate()[1])
            .birthYear(getDate()[2])
            .gender(getRandom(GENDERS))
            .hobby(getRandom(HOBBIES))
            .state("NCR")
            .city("Delhi")
            .build();

    FormPage formPage = new FormPage(user_2);

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
