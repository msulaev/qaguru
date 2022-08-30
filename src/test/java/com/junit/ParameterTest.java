package com.junit;

import com.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.FormPage;

import java.util.List;
import java.util.stream.Stream;

public class ParameterTest extends BaseTest {
    FormPage formPage = new FormPage();

    public static Stream<Arguments> dataProviderForAddress() {
        return Stream.of(
                Arguments.of("NCR", List.of("Delhi", "Gurgaon", "Noida")),
                Arguments.of("Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut")),
                Arguments.of("Haryana", List.of("Karnal", "Panipat")),
                Arguments.of("Rajasthan", List.of("Jaipur", "Jaiselmer"))
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
            " ,  testLastName, Male, 1234567890",
            "testName,  , Male, 1234567890",
            " ,  testLastName, Male, ",
            " ,  testLastName, , 1234567890",
            " , , , ,"
    })
    public void shouldNotSubmitForm(String name, String lastName, String gender, String phone) {
        formPage.open()
                .setFirstName(name)
                .setLastName(lastName)
                .checkGender(gender)
                .setPhoneNumber(phone)
                .clickToSubmit()
                .checkThatResultModalNotExist();
    }

    @MethodSource("dataProviderForAddress")
    @ParameterizedTest
    public void checkListOfCitiesAfterSelectedState(String state, List<String> cities) {
        formPage.open()
                .setState(state)
                .checkCities(cities);
    }

    @ValueSource(strings = {"+987654321", "o987654321", " 98765432", "!@#$%^&*()"})
    @ParameterizedTest
    public void shouldNotPassIncorrectPhoneNumber(String invalidPhone) {
        formPage.open()
                .setFirstName("ValidName")
                .setLastName("ValidLastName")
                .checkGender("Other")
                .setPhoneNumber(invalidPhone)
                .clickToSubmit()
                .checkThatResultModalNotExist();
    }
}
