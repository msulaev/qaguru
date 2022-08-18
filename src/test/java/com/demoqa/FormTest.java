package com.demoqa;

import com.BaseTest;
import com.github.javafaker.Faker;
import data.User;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import static utils.Constant.*;
import static utils.Utils.getDate;
import static utils.Utils.getRandom;

public class FormTest extends BaseTest {
    Faker faker = new Faker();
    User user = User.builder()
            .name(faker.name().firstName())
            .lastName(faker.name().lastName())
            .phoneNumber(faker.numerify("##########"))
            .subject(getRandom(SUBJECTS))
            .currentAddress(faker.address().fullAddress())
            .email(faker.internet().emailAddress())
            .birthDay(getDate().get("day"))
            .birthMonth(getDate().get("month"))
            .birthYear(getDate().get("year"))
            .gender(getRandom(GENDERS))
            .hobby(getRandom(HOBBIES))
            .state("NCR")
            .city("Delhi")
            .build();

    FormPage formPage = new FormPage();

    @Test
    void formShoudBeCompleted() {
        formPage.open()
                .setFirstName(user.getName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .checkGender(user.getGender())
                .setPhoneNumber(user.getPhoneNumber())
                .setBirthday(user.getBirthDay(), user.getBirthYear(), user.getBirthMonth())
                .setSubject(user.getSubject())
                .checkHobby(user.getHobby())
                .uploadPicture()
                .setAddress(user.getCurrentAddress(), user.getState(), user.getCity())
                .clickToSubmit()
                .checkResultsForm(user);
    }
}
